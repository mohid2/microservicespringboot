package app.vercel.mohammedelyousfi.booking_service.domain.service;

import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingRequest;
import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingResponse;

import java.util.List;

public interface IBookingService {


    BookingResponse getBookingById(Long bookingId);
    BookingResponse createBooking(BookingRequest booking);

    void deleteBooking(Long bookingId);

    BookingResponse updateBooking(Long bookingId, BookingRequest bookingRequest);

    List<BookingResponse> getBookingsByUserId(Long userId);

}
