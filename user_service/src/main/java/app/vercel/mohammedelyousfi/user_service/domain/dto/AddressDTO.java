package app.vercel.mohammedelyousfi.user_service.domain.dto;

import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
