package app.vercel.mohammedelyousfi.car_service.controller.rest;


import app.vercel.mohammedelyousfi.car_service.domain.model.CarResponse;
import app.vercel.mohammedelyousfi.car_service.domain.model.CarRequest;
import app.vercel.mohammedelyousfi.car_service.domain.service.ICarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
@RefreshScope
public class CarController {

    private final ICarService carService;


    @GetMapping("/all")
    public ResponseEntity<Iterable<CarResponse>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> getCarById(@PathVariable String id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<CarResponse>> getCarAllByCategory(@PathVariable String category) {
        return ResponseEntity.ok(carService.getCarByCategory(category));
    }

    @PostMapping("/create/one")
    public ResponseEntity<CarResponse> createCar(@RequestBody @Valid CarRequest CarRequest) {
        return ResponseEntity.ok(carService.createCar(CarRequest));
    }
    @PostMapping("/create/all")
    public ResponseEntity<Iterable<CarResponse>> getAllCars(@RequestBody List<CarRequest> carRequests) {
        return ResponseEntity.ok(carService.createAllCars(carRequests));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CarResponse> updateCar(@PathVariable String id, @RequestBody CarRequest carResponse) {
        return ResponseEntity.ok(carService.updateCar(id, carResponse));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/setAvailable/{id}")
    public ResponseEntity<Boolean> setAvailableByChassisSerialNumber (@PathVariable String id) {
        return ResponseEntity.ok(carService.setAvailableCarById(id));
    }
}
