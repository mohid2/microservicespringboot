package app.vercel.mohammedelyousfi.notification_service.model;

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
