package app.vercel.mohammedelyousfi.payment_service.domain.model;


import app.vercel.mohammedelyousfi.payment_service.util.enums.FuelType;
import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Motor {
    private String id;

    private Long horsepower;

    private Long torque;

    private double engineCc;

    private String description;

    private Double engineVolume;

    private FuelType fuelType;
}
