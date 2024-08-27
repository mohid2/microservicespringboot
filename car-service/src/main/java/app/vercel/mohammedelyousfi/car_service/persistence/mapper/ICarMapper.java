package app.vercel.mohammedelyousfi.car_service.persistence.mapper;


import app.vercel.mohammedelyousfi.car_service.domain.model.CarRequest;
import app.vercel.mohammedelyousfi.car_service.domain.model.CarResponse;
import app.vercel.mohammedelyousfi.car_service.persistence.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICarMapper {

    Car toCar(CarRequest carRequest);


    CarResponse toCarResponse(Car car);

    List<CarResponse> toCarResponses(List<Car> cars);

    List<Car> toCars(List<CarRequest> carRequests);

}
