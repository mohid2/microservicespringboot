package app.vercel.mohammedelyousfi.booking_service.domain.repository;

import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingRequest;
import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingResponse;

import java.util.List;

public interface BookingRepository {
    BookingResponse findBookingById(Long bookingId);
    List<BookingResponse> findAllBookings();

    BookingResponse createBooking(BookingRequest booking);

    void deleteBooking(Long bookingId);

    BookingResponse updateBooking(Long bookingId, BookingRequest bookingDTO);

    List<BookingResponse> findAllBookingsByUserId(Long userId);

}
