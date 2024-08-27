package app.vercel.mohammedelyousfi.user_service.domain.model;

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
