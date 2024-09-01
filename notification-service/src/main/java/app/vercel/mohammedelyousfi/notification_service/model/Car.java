package app.vercel.mohammedelyousfi.notification_service.model;

import app.vercel.mohammedelyousfi.notification_service.util.enums.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String chassisSerialNumber;

    private Motor motor;

    private CarBrand carBrand;

    private Double price;

    private Long km;

    private String description;

    private String model;

    private LocalDate modelYear;

    private String color;

    private Integer numberDoors;

    private TransmissionType transmission;

    private Long weight;

    private Integer numberSeats;

    private TractionType traction;

    private SteeringType steering;

    private Category category;

    private List<Image> imagePaths;

    private boolean available;
}
