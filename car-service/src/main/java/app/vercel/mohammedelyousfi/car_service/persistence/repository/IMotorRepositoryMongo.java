package app.vercel.mohammedelyousfi.car_service.persistence.repository;

import app.vercel.mohammedelyousfi.car_service.persistence.entity.Motor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMotorRepositoryMongo extends MongoRepository<Motor, String> {

}
