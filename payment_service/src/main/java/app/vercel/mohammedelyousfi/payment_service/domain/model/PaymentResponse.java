package app.vercel.mohammedelyousfi.payment_service.domain.model;

import app.vercel.mohammedelyousfi.payment_service.util.enums.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PaymentResponse {
    private Long id;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Long bookingId;
    private BookingResponse bookingResponse;
}
