package app.vercel.mohammedelyousfi.booking_service.presistance.entity;

import app.vercel.mohammedelyousfi.booking_service.domain.dto.CarDTO;
import app.vercel.mohammedelyousfi.booking_service.domain.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking implements Serializable {

    @Serial
    private static final long serialVersionUID = -1234567890123456789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_id", nullable = false)
    private String carId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "pickup_date", nullable = false)
    private String pickupDate;

    @Column(name = "pickup_time", nullable = false)
    private String pickupTime;

    @Transient
    private CarDTO car;

    @Transient
    private UserDTO user;
}
