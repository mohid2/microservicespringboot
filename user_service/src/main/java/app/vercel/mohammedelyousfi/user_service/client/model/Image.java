package app.vercel.mohammedelyousfi.user_service.client.model;

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
