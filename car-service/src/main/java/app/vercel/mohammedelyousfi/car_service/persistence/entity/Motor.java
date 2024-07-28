package app.vercel.mohammedelyousfi.car_service.persistence.entity;

import app.vercel.mohammedelyousfi.car_service.util.enums.FuelType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "motors")
public class Motor {
    @Id
    private String id;

    private Long horsepower;

    private Long torque;

    private double engineCc;

    private String description;

    private Double engineVolume;

    private FuelType fuelType;
}
