package app.vercel.mohammedelyousfi.payment_service.domain.model;

import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentNotification {
    private String message;
    private PaymentRequest paymentRequest;
}
