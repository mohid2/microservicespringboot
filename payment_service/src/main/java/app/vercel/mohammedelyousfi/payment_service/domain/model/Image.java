package app.vercel.mohammedelyousfi.payment_service.domain.model;

import lombok.*;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private String imageId;
    private String imagePath;
}
