package app.vercel.mohammedelyousfi.booking_service.presistance.entity;

import app.vercel.mohammedelyousfi.booking_service.client.model.Car;
import app.vercel.mohammedelyousfi.booking_service.client.model.User;
import app.vercel.mohammedelyousfi.booking_service.util.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Persistent;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    @Column(nullable = false)
    private String carId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate pickupDate;

    @Temporal(TemporalType.DATE)
    private LocalDate returnDate;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Transient
    private Car car;

    @Transient
    private User user;


}
