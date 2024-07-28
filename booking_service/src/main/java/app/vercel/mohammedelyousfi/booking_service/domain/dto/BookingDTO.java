package app.vercel.mohammedelyousfi.booking_service.domain.dto;


import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    private Long id;

    private CarDTO car;

    private UserDTO user;

    private String pickupDate;

    private String pickupTime;

}
