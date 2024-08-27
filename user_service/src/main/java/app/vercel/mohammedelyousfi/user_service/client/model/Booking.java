package app.vercel.mohammedelyousfi.user_service.client.model;

import app.vercel.mohammedelyousfi.user_service.util.enums.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private Long id;
    private Car car;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private BigDecimal amount;
    private Long totalBookingDuration;
    private PaymentMethod paymentMethod;
}
