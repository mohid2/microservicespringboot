package app.vercel.mohammedelyousfi.booking_service.domain.model;

import app.vercel.mohammedelyousfi.booking_service.client.model.Car;
import app.vercel.mohammedelyousfi.booking_service.client.model.User;

import app.vercel.mohammedelyousfi.booking_service.util.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    @JsonIgnore
    private String carId;
    @JsonIgnore
    private Long userId;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private BigDecimal amount;
    private Long totalBookingDuration;
    private PaymentMethod paymentMethod;
}
