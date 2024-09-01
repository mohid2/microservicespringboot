package app.vercel.mohammedelyousfi.notification_service.model;

import app.vercel.mohammedelyousfi.notification_service.util.enums.FuelType;
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
