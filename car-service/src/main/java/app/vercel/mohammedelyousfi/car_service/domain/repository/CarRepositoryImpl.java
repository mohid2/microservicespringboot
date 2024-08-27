package app.vercel.mohammedelyousfi.car_service.domain.repository;

import app.vercel.mohammedelyousfi.car_service.domain.model.CarResponse;
import app.vercel.mohammedelyousfi.car_service.domain.model.CarRequest;
import app.vercel.mohammedelyousfi.car_service.domain.exception.CarNotFoundException;
import app.vercel.mohammedelyousfi.car_service.persistence.entity.Car;
import app.vercel.mohammedelyousfi.car_service.persistence.entity.Image;
import app.vercel.mohammedelyousfi.car_service.persistence.entity.Motor;
import app.vercel.mohammedelyousfi.car_service.persistence.mapper.ICarMapper;
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

    @Override
    public List<CarResponse> getAllCars() {
        return carMapper.toCarResponses(carRepository.findAll());
    }

    @Override
    public CarResponse getCarById(String id) {

        return carMapper.toCarResponse(carRepository.findByChassisSerialNumber(id).orElseThrow(() -> new CarNotFoundException( "Car with id " + id + " not found")));
    }

    @Override
    public void deleteCarById(String id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarResponse updateCar(String id, CarRequest carRequest) {
        if(carRepository.findByChassisSerialNumber(id).isEmpty()){
            throw new CarNotFoundException( "Car with id " + id + " not found");
        }
        return carMapper.toCarResponse(carRepository.save(carMapper.toCar(carRequest)));
    }
    @Override
    public CarResponse createCar(CarRequest carRequest) {
        Car car = carMapper.toCar(carRequest);
        Motor savedMotor = motorRepository.save(car.getMotor());
        List<Image> savedImages = imageRepository.saveAll(car.getImagePaths());
        car.setMotor(savedMotor);  // Asociar el motor al coche
        car.setImagePaths(savedImages);  // Asociar las imágenes al coche
        Car savedCar = carRepository.save(car);

        return carMapper.toCarResponse(savedCar);
    }

    @Override
    public List<CarResponse> createAllCars(List<CarRequest> carRequestList) {

        //Asigna motores e imágenes a los carros
        List<Car> cars = carMapper.toCars(carRequestList);
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            Motor motor = car.getMotor();
            motorRepository.save(motor);
            List<Image> carImages = cars.get(i).getImagePaths();
            imageRepository.saveAll(carImages);
            // Asigna el motor al carro
            car.setMotor(motor);
            //Asigna las imágenes al carro
            car.setImagePaths(carImages);
        }
        // Guarda los carros con sus relaciones correctamente establecidas
        List<Car> savedCars = carRepository.saveAll(cars);
        // Convierte a CarResponse y retorna
        return carMapper.toCarResponses(savedCars);

    }

    @Override
    public List<CarResponse> findByCategory(String category) {
        return carMapper.toCarResponses(carRepository.findByCategory(category));
    }
}
