package app.vercel.mohammedelyousfi.car_service.domain.service;


import app.vercel.mohammedelyousfi.car_service.domain.model.CarRequest;
import app.vercel.mohammedelyousfi.car_service.domain.repository.ICarRepository;

import app.vercel.mohammedelyousfi.car_service.domain.model.CarResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements ICarService {
    private final ICarRepository carRepository;


    @Override
    public List<CarResponse> getAllCars() {
        return carRepository.getAllCars();
    }

    @Override
    public CarResponse getCarById(String id) {
        return carRepository.getCarById(id);
    }
    @Override
    public void deleteCarById(String id) {
        carRepository.deleteCarById(id);
    }

    @Override
    public CarResponse updateCar(String id, CarRequest carRequest) {
        return carRepository.updateCar(id, carRequest);
    }
    @Override
    public CarResponse createCar(CarRequest carRequest) {
        return carRepository.createCar(carRequest);
    }

    @Override
    public List<CarResponse> createAllCars(List<CarRequest> carRequests) {
        return carRepository.createAllCars(carRequests);
    }

    @Override
    public Boolean setAvailableCarById(String id) {
       CarResponse carResponse = carRepository.getCarById(id);
       if (carResponse == null || !carResponse.isAvailable()) {
           return false;
       }
        carResponse.setAvailable(false);
        carRepository.updateCar(carResponse.getChassisSerialNumber(), convertToRequest(carResponse));
        return true;
    }

    @Override
    public List<CarResponse> getCarByCategory(String category) {
        return carRepository.findByCategory(category);
    }

    private CarRequest convertToRequest(CarResponse carResponse) {
        return CarRequest.builder()
                .chassisSerialNumber(carResponse.getChassisSerialNumber())
                .motor(carResponse.getMotor())
                .carBrand(carResponse.getCarBrand())
                .price(carResponse.getPrice())
                .km(carResponse.getKm())
                .description(carResponse.getDescription())
                .model(carResponse.getModel())
                .modelYear(carResponse.getModelYear())
                .color(carResponse.getColor())
                .numberDoors(carResponse.getNumberDoors())
                .transmission(carResponse.getTransmission())
                .weight(carResponse.getWeight())
                .numberSeats(carResponse.getNumberSeats())
                .traction(carResponse.getTraction())
                .steering(carResponse.getSteering())
                .category(carResponse.getCategory())
                .imagePaths(carResponse.getImagePaths())
                .available(carResponse.isAvailable())
                .build();
    }
}
