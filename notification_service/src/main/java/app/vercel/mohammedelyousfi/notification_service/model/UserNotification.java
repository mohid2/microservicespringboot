package app.vercel.mohammedelyousfi.notification_service.model;

import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserNotification {
    private UserResponse userResponse;
    private String message;
}
