package app.vercel.mohammedelyousfi.car_service.domain.service;

import app.vercel.mohammedelyousfi.car_service.domain.dto.CarDTO;

import java.util.List;

public interface ICarService {
    List<CarDTO> getAllCars();
    CarDTO createCar(CarDTO carDTO);
    CarDTO getCarById(String id);
    void deleteCarById(String id);
    CarDTO updateCar(String id, CarDTO  carDTO);
    List<CarDTO> createAllCars(List<CarDTO> carDTOList);
}
