package app.vercel.mohammedelyousfi.car_service.persistence.entity;



import app.vercel.mohammedelyousfi.car_service.util.enums.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cars")
public class Car implements Serializable {
    @Serial
    private static final long serialVersionUID = 1671320768031045626L;

    @Id
    private String chassisSerialNumber;

    private CarBrand carBrand;

    private Double price;

    private Long km;

    private String description;

    private String model;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate modelYear;

    private String color;

    private Integer numberDoors;

    private TransmissionType transmission;

    private Long weight;

    private Integer numberSeats;

    private TractionType traction;

    private SteeringType steering;

    private Category category;

    private boolean available;

    @DBRef
    private List<Image> imagePaths;
    @DBRef
    private Motor motor;
}

