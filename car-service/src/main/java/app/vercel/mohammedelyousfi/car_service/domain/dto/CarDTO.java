package app.vercel.mohammedelyousfi.car_service.domain.dto;


import app.vercel.mohammedelyousfi.car_service.util.enums.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private String chassisSerialNumber;

    private MotorDTO motor;

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

    private List<ImageDTO> imagePaths;

    private boolean available;
}
