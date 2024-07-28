package app.vercel.mohammedelyousfi.car_service.persistence.mapper;


import app.vercel.mohammedelyousfi.car_service.domain.dto.CarDTO;
import app.vercel.mohammedelyousfi.car_service.persistence.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICarMapper {
    @Mapping(source = "motor.id", target = "motorId")
    Car toCarEntity(CarDTO carDTO);

    CarDTO toCarDTO(Car car);

    List<CarDTO> toCarDTOList(List<Car> cars);

    List<Car> toCarList(List<CarDTO> carDTOS);

}
