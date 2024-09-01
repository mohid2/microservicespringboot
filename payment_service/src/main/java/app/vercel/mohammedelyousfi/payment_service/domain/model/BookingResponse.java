package app.vercel.mohammedelyousfi.payment_service.domain.model;

import app.vercel.mohammedelyousfi.payment_service.util.enums.PaymentMethod;
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
    private User user;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private BigDecimal amount;
    private Long totalBookingDuration;
    private PaymentMethod paymentMethod;
}
