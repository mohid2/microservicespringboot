package app.vercel.mohammedelyousfi.car_service.domain.dto;

import app.vercel.mohammedelyousfi.car_service.util.enums.FuelType;
import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MotorDTO {
    private String id;

    private Long horsepower;

    private Long torque;

    private double engineCc;

    private String description;

    private Double engineVolume;

    private FuelType fuelType;
}
