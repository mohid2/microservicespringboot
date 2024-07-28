package app.vercel.mohammedelyousfi.car_service.persistence.mapper;

import app.vercel.mohammedelyousfi.car_service.domain.dto.MotorDTO;
import app.vercel.mohammedelyousfi.car_service.persistence.entity.Motor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IMotorMapper {

    Motor toMotorEntity(MotorDTO motorDTO);

    MotorDTO toMotorDTO(Motor motor);

    List<MotorDTO> toMotorDTOList(List<Motor> motors);

    List<Motor> toMotorList(List<MotorDTO> motorDTOS);
}
