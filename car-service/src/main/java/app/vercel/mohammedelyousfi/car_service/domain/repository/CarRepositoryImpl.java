package app.vercel.mohammedelyousfi.car_service.domain.repository;

import app.vercel.mohammedelyousfi.car_service.domain.dto.CarDTO;
import app.vercel.mohammedelyousfi.car_service.domain.dto.ImageDTO;
import app.vercel.mohammedelyousfi.car_service.persistence.mapper.ICarMapper;
import app.vercel.mohammedelyousfi.car_service.persistence.mapper.IImageMapper;
import app.vercel.mohammedelyousfi.car_service.persistence.mapper.IMotorMapper;
import app.vercel.mohammedelyousfi.car_service.persistence.repository.ICarRepositoryMongo;
import app.vercel.mohammedelyousfi.car_service.persistence.repository.IImageRepositoryMongo;
import app.vercel.mohammedelyousfi.car_service.persistence.repository.IMotorRepositoryMongo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CarRepositoryImpl implements ICarRepository {

    private final ICarRepositoryMongo carRepository;
    private final IImageRepositoryMongo imageRepository;
    private final IMotorRepositoryMongo motorRepository;
    private final ICarMapper carMapper;
    private final IMotorMapper motorMapper;
    private final IImageMapper imageMapper;

    @Override
    public List<CarDTO> getAllCars() {
        return carMapper.toCarDTOList(carRepository.findAll());
    }



    @Override
    public CarDTO getCarById(String id) {
        return carMapper.toCarDTO(carRepository.findByChassisSerialNumber(id).orElse(null));
    }

    @Override
    public void deleteCarById(String id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarDTO updateCar(String id, CarDTO  carDTO) {
        return carMapper.toCarDTO(carRepository.save(carMapper.toCarEntity(carDTO)));
    }
    @Override
    public CarDTO createCar(CarDTO carDTO) {
        motorRepository.save(motorMapper.toMotorEntity(carDTO.getMotor()));
        imageRepository.saveAll(imageMapper.toImageList(carDTO.getImagePaths()));
        return carMapper.toCarDTO(carRepository.save(carMapper.toCarEntity(carDTO)));
    }

    @Override
    public List<CarDTO> createAllCars(List<CarDTO> carDTOList) {
        motorRepository.saveAll(motorMapper.toMotorList(carDTOList.stream().map(CarDTO::getMotor).toList()));
        List<List<ImageDTO>> list = carDTOList.stream().map(CarDTO::getImagePaths).toList();
        imageRepository.saveAll(imageMapper.toImageList(list.stream().flatMap(List::stream).toList()));
        return carMapper.toCarDTOList(carRepository.saveAll(carMapper.toCarList(carDTOList)));
    }
}
