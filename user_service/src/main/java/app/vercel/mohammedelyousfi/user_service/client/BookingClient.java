package app.vercel.mohammedelyousfi.user_service.client;


import app.vercel.mohammedelyousfi.user_service.client.model.Booking;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "booking-service")
public interface BookingClient {

    @GetMapping("/api/v1/bookings/user/{userId}")
    List<Booking> getBookingByUserId(@PathVariable Long userId);

}
