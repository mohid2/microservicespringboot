package app.vercel.mohammedelyousfi.car_service.persistence.mapper;

import app.vercel.mohammedelyousfi.car_service.domain.dto.ImageDTO;
import app.vercel.mohammedelyousfi.car_service.persistence.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IImageMapper {

    Image toImageEntity(ImageDTO imageDTO);

    ImageDTO toImageId(Image image);

    List<ImageDTO> toImageDTOList(List<Image> images);

    List<Image> toImageList(List<ImageDTO> imageDTOS);

}
