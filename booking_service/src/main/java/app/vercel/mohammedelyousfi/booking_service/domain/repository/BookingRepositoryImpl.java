package app.vercel.mohammedelyousfi.booking_service.domain.repository;

import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingRequest;
import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingResponse;
import app.vercel.mohammedelyousfi.booking_service.presistance.mapper.BookingMapper;
import app.vercel.mohammedelyousfi.booking_service.presistance.repository.BookingPostgresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class BookingRepositoryImpl implements BookingRepository{

    private final BookingPostgresRepository bookingPostgresRepository;
    private final BookingMapper bookingMapper;
    @Override
    public BookingResponse findBookingById(Long bookingId) {
        return bookingMapper.toBookingResponse(bookingPostgresRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("booking not found")));
    }

    @Override
    public List<BookingResponse> findAllBookings() {
        return bookingMapper.toBookingResponses(bookingPostgresRepository.findAll());
    }

    @Override
    public BookingResponse createBooking(BookingRequest booking) {
        return bookingMapper.toBookingResponse(bookingPostgresRepository.save(bookingMapper.toBooking(booking)));
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingPostgresRepository.deleteById(bookingId);
    }

    @Override
    public BookingResponse updateBooking(Long bookingId, BookingRequest bookingDTO) {
        if (bookingPostgresRepository.findById(bookingId).isEmpty()) {
            throw new RuntimeException("booking not found");
        }
        return bookingMapper.toBookingResponse(bookingPostgresRepository.save(bookingMapper.toBooking(bookingDTO)));
    }

    @Override
    public List<BookingResponse> findAllBookingsByUserId(Long userId) {
        return bookingMapper.toBookingResponses(bookingPostgresRepository.findByUserId(userId));
    }
}
