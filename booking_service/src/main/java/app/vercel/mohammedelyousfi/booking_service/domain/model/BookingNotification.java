package app.vercel.mohammedelyousfi.booking_service.domain.model;

import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingNotification {
    private BookingResponse bookingResponse;
    private String message;
}
