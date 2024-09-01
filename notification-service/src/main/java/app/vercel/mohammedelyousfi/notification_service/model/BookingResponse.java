package app.vercel.mohammedelyousfi.notification_service.model;

import app.vercel.mohammedelyousfi.notification_service.util.enums.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private Long id;
    private Car car;
    private UserResponse user;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private BigDecimal amount;
    private Long totalBookingDuration;
    private PaymentMethod paymentMethod;
}
