package app.vercel.mohammedelyousfi.booking_service.client.model;


import app.vercel.mohammedelyousfi.booking_service.domain.model.BookingResponse;
import app.vercel.mohammedelyousfi.booking_service.util.enums.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PaymentRequest {
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private BookingResponse bookingResponse;
}
