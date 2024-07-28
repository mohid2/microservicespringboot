package app.vercel.mohammedelyousfi.booking_service.domain.dto;

import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {
    private String imageId;
    private String imagePath;
}
