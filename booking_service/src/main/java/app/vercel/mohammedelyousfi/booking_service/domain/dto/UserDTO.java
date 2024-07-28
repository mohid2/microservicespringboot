package app.vercel.mohammedelyousfi.booking_service.domain.dto;

import lombok.*;

import java.util.List;
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private List<AddressDTO> address;
    private String dateOfBirth;
    private String phoneNumber;
    private String password;
}
