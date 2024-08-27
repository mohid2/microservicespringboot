package app.vercel.mohammedelyousfi.booking_service.presistance.repository;

import app.vercel.mohammedelyousfi.booking_service.presistance.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingPostgresRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
}
