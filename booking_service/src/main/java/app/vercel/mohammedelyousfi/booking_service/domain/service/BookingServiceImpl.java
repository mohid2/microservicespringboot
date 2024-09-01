package app.vercel.mohammedelyousfi.booking_service.domain.service;

import app.vercel.mohammedelyousfi.booking_service.client.CarClient;
import app.vercel.mohammedelyousfi.booking_service.client.UserClient;

import app.vercel.mohammedelyousfi.booking_service.client.model.Car;
import app.vercel.mohammedelyousfi.booking_service.client.model.User;
import app.vercel.mohammedelyousfi.booking_service.domain.exception.BookingNotFoundException;
import app.vercel.mohammedelyousfi.booking_service.domain.exception.BusinessException;
import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingNotification;
import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingRequest;
import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingResponse;
import app.vercel.mohammedelyousfi.booking_service.domain.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements IBookingService {

    private final BookingRepository bookingRepository;
    private final CarClient carClient;
    private final UserClient userClient;
    private final KafkaTemplate<String, BookingNotification> kafkaTemplate;

    @Override
    public BookingResponse getBookingById(Long bookingId) {
        BookingResponse bookingResponse = bookingRepository.findBookingById(bookingId);
        if (bookingResponse == null) {
            throw new BookingNotFoundException("Booking not found");
        }
        return getBookingResponse(bookingResponse);
    }

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest) {
        Car car = carClient.getCarById(bookingRequest.getCarId()).orElseThrow(() -> new BusinessException("Booking failed. Car with id " + bookingRequest.getCarId() + " not found"));
        User user = userClient.getUserById(bookingRequest.getUserId()).orElseThrow(() -> new BusinessException("Booking failed. User with id " + bookingRequest.getUserId() + " not found"));
            if(car.isAvailable()) {
                carClient.setAvailableCar(bookingRequest.getCarId());
            bookingRequest.setAmount(BigDecimal.valueOf(car.getPrice()*(
                            bookingRequest.getPickupDate().until(bookingRequest.getReturnDate(), ChronoUnit.DAYS)+1)));
            // Crear la reserva
            BookingResponse bookingResponse = bookingRepository.createBooking(bookingRequest);
            bookingResponse.setCar(car);
            bookingResponse.setUser(user);
            // Enviar notificación
                Message<BookingNotification> message = MessageBuilder.withPayload(BookingNotification.builder()
                                .bookingResponse(bookingResponse)
                                .message("Reserva creada correctamente")
                                .build())
                        .setHeader(KafkaHeaders.TOPIC,"booking-created")
                        .build();
            kafkaTemplate.send(message );
            return getBookingResponse(bookingResponse);
            }
            throw new BusinessException("Booking failed. Car not available");
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteBooking(bookingId);
    }

    @Override
    public BookingResponse updateBooking(Long bookingId, BookingRequest bookingRequest) {
        BookingResponse bookingResponse = bookingRepository.updateBooking(bookingId, bookingRequest);
        if(bookingResponse == null) {
            throw new BookingNotFoundException("Booking not found");
        }
        return getBookingResponse(bookingResponse);
    }




    @Override
    public List<BookingResponse> getBookingsByUserId(Long userId) {
        List<BookingResponse> bookingResponses = bookingRepository.findAllBookingsByUserId(userId);
        return bookingResponses.stream()
                .peek(this::getBookingResponse)
                .toList();
    }

    private BookingResponse getBookingResponse(BookingResponse bookingResponse) {
        Car car = carClient.getCarById(bookingResponse.getCarId()).orElseThrow(() -> new BusinessException("Booking failed. Car with id " + bookingResponse.getCarId() + " not found"));
        User user = userClient.getUserById(bookingResponse.getUserId()).orElseThrow(() -> new BusinessException("Booking failed. User with id " + bookingResponse.getUserId() + " not found"));
        bookingResponse.setCar(car);
        bookingResponse.setUser(user);
        return bookingResponse;
    }

}
