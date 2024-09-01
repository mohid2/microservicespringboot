package app.vercel.mohammedelyousfi.payment_service.domain.model;

import lombok.*;

import java.util.List;
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private List<Address> address;
    private String dateOfBirth;
    private String phoneNumber;
}
