package app.vercel.mohammedelyousfi.car_service.domain.repository;

import app.vercel.mohammedelyousfi.car_service.domain.model.CarResponse;
import app.vercel.mohammedelyousfi.car_service.domain.model.CarRequest;

import java.util.List;

public interface ICarRepository {

    List<CarResponse> getAllCars();

    CarResponse getCarById(String id);

    void deleteCarById(String id);

    CarResponse updateCar(String id, CarRequest carRequest);

    CarResponse createCar(CarRequest carRequest);

    List<CarResponse> createAllCars(List<CarRequest> carRequestList);

    List<CarResponse> findByCategory(String category);
}

