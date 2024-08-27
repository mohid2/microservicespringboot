package app.vercel.mohammedelyousfi.car_service.domain.model;

import app.vercel.mohammedelyousfi.car_service.util.enums.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarRequest {

    @NotBlank
    private String chassisSerialNumber;

    @NotNull
    private Motor motor;

    private CarBrand carBrand;

    @NotNull
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
