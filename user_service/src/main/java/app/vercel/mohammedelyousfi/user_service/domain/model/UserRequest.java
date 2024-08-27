package app.vercel.mohammedelyousfi.user_service.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotBlank
    @Email
    private String email;

    private List<Address> address;
    @NotBlank
    private String dateOfBirth;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String password;
}
