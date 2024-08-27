package app.vercel.mohammedelyousfi.user_service.domain.model;

import lombok.*;

import java.util.List;
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private List<Address> address;
    private String dateOfBirth;
    private String phoneNumber;
}
