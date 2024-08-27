package app.vercel.mohammedelyousfi.car_service.domain.service;

import app.vercel.mohammedelyousfi.car_service.domain.model.CarResponse;
import app.vercel.mohammedelyousfi.car_service.domain.model.CarRequest;

import java.util.List;

public interface ICarService {
    List<CarResponse> getAllCars();
    CarResponse createCar(CarRequest CarRequest);
    CarResponse getCarById(String id);
    void deleteCarById(String id);
    CarResponse updateCar(String id, CarRequest carRequest);
    List<CarResponse> createAllCars(List<CarRequest> carRequests);
    Boolean setAvailableCarById(String id);

    List<CarResponse> getCarByCategory(String category);
}
