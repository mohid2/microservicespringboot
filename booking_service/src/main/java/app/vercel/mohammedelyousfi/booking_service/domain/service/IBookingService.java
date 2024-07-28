package app.vercel.mohammedelyousfi.booking_service.domain.service;

import app.vercel.mohammedelyousfi.booking_service.domain.dto.BookingDTO;

public interface IBookingService {
    BookingDTO getBookingById(Long bookingId);

    Iterable<BookingDTO> getAllBookings();

    BookingDTO createBooking(BookingDTO booking);

    void deleteBooking(Long bookingId);

    BookingDTO updateBooking( Long bookingId,BookingDTO bookingDTO);

}
