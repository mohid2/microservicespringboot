package app.vercel.mohammedelyousfi.booking_service.client;


import app.vercel.mohammedelyousfi.booking_service.client.model.Car;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "car-service")
public interface CarClient {

    @GetMapping("/api/v1/cars/{id}")
    Optional<Car> getCarById(@PathVariable String id);

    @GetMapping("/api/v1/cars/setAvailable/{id}")
    Optional<Boolean> setAvailableCar(@PathVariable String id);
}
