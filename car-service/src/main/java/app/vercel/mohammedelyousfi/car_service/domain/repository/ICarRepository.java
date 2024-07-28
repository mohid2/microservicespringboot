package app.vercel.mohammedelyousfi.car_service.domain.repository;

import app.vercel.mohammedelyousfi.car_service.domain.dto.CarDTO;

import java.util.List;

public interface ICarRepository {

    List<CarDTO> getAllCars();

    CarDTO getCarById(String id);

    void deleteCarById(String id);

    CarDTO updateCar(String id, CarDTO carDTO);

    CarDTO createCar(CarDTO carDTO);

    List<CarDTO> createAllCars(List<CarDTO> carDTOList);
}
