package app.vercel.mohammedelyousfi.booking_service.controller.rest;

import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingRequest;
import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingResponse;
import app.vercel.mohammedelyousfi.booking_service.domain.service.IBookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final IBookingService bookingService;

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable Long bookingId) {
        return ResponseEntity.ok(bookingService.getBookingById(bookingId));
    }

    @PostMapping("/create/one")
    public ResponseEntity<BookingResponse> createBooking(@RequestBody @Valid BookingRequest booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @DeleteMapping("/delete/{bookingId}")
    public void deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingResponse>> getBookingsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUserId(userId));
    }
}
