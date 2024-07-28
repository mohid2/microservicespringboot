package app.vercel.mohammedelyousfi.car_service.persistence.entity;



import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Document(collection = "images")
public class Image implements Serializable {

    @Serial
    private static final long serialVersionUID = 1671320768031045626L;

    @Id
    private String imageId;
    private String imagePath;
}
