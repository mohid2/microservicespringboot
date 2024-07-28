package app.vercel.mohammedelyousfi.booking_service.controller;

import app.vercel.mohammedelyousfi.booking_service.domain.dto.BookingDTO;
import app.vercel.mohammedelyousfi.booking_service.domain.service.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final IBookingService bookingService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<BookingDTO>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long bookingId) {
        return ResponseEntity.ok(bookingService.getBookingById(bookingId));
    }

    @PostMapping("/create/one")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }
}
