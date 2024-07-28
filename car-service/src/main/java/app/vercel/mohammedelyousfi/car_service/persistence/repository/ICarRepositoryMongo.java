package app.vercel.mohammedelyousfi.car_service.persistence.repository;

import app.vercel.mohammedelyousfi.car_service.persistence.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ICarRepositoryMongo extends MongoRepository<Car, String> {
    Optional<Car> findByChassisSerialNumber(String chassisSerialNumber);
}
