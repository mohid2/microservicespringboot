package app.vercel.mohammedelyousfi.car_service.persistence.repository;

import app.vercel.mohammedelyousfi.car_service.persistence.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IImageRepositoryMongo extends MongoRepository<Image, String> {
}
