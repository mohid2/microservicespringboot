package app.vercel.mohammedelyousfi.booking_service.domain.service;

import app.vercel.mohammedelyousfi.booking_service.domain.dto.BookingDTO;

import app.vercel.mohammedelyousfi.booking_service.presistance.mapper.BookingMapper;
import app.vercel.mohammedelyousfi.booking_service.presistance.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements IBookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    public BookingDTO getBookingById(Long bookingId) {
        return bookingMapper.toBookingDTO(bookingRepository.findById(bookingId).orElse(null));
    }

    @Override
    public Iterable<BookingDTO> getAllBookings() {
        return bookingMapper.toBookingDTOList(bookingRepository.findAll());
    }
    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        return bookingMapper.toBookingDTO(bookingRepository.save(bookingMapper.toBooking(bookingDTO)));
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public BookingDTO updateBooking(  Long bookingId,BookingDTO bookingDTO) {
        return bookingMapper.toBookingDTO(bookingRepository.save(bookingMapper.toBooking(bookingDTO)));
    }


}
