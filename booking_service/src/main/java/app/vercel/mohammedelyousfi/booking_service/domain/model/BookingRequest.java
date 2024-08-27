package app.vercel.mohammedelyousfi.booking_service.domain.model;

import app.vercel.mohammedelyousfi.booking_service.util.enums.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    @NotBlank
    private String carId;
    @NotNull
    private Long userId;
    @NotNull
    private LocalDate pickupDate;
    @NotNull
    private LocalDate returnDate;
    private BigDecimal amount;
    @NotNull
    private PaymentMethod paymentMethod;

}
