package app.vercel.mohammedelyousfi.booking_service.client.model;

import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
