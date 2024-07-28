package app.vercel.mohammedelyousfi.booking_service.presistance.repository;

import app.vercel.mohammedelyousfi.booking_service.presistance.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
