package app.vercel.mohammedelyousfi.car_service.domain.service;


import app.vercel.mohammedelyousfi.car_service.domain.repository.ICarRepository;

import app.vercel.mohammedelyousfi.car_service.domain.dto.CarDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements ICarService {
    private final ICarRepository carRepository;
    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.getAllCars();
    }



    @Override
    public CarDTO getCarById(String id) {
        return carRepository.getCarById(id);
    }
    @Override
    public void deleteCarById(String id) {
        carRepository.deleteCarById(id);
    }

    @Override
    public CarDTO updateCar(String id, CarDTO  carDTO) {
        return carRepository.updateCar(id,carDTO);
    }
    @Override
    public CarDTO createCar(CarDTO carDTO) {
        return carRepository.createCar(carDTO);
    }

    @Override
    public List<CarDTO> createAllCars(List<CarDTO> carDTOList) {
        return carRepository.createAllCars(carDTOList);
    }
}
