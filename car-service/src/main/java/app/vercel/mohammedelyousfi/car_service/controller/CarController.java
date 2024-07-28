package app.vercel.mohammedelyousfi.car_service.controller;


import app.vercel.mohammedelyousfi.car_service.domain.dto.CarDTO;
import app.vercel.mohammedelyousfi.car_service.domain.service.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final ICarService carService;


    @GetMapping("/all")
    public ResponseEntity<Iterable<CarDTO>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable String id) {
        System.out.println(carService.getCarById(id));
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PostMapping("/create/one")
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO) {
        return ResponseEntity.ok(carService.createCar(carDTO));
    }
    @PostMapping("/create/all")
    public ResponseEntity<Iterable<CarDTO>> getAllCars(@RequestBody List<CarDTO> carDTOList) {
        return ResponseEntity.ok(carService.createAllCars(carDTOList));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable String id, @RequestBody CarDTO carDTO) {
        return ResponseEntity.ok(carService.updateCar(id,carDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable String id) {
        carService.deleteCarById(id);
        return ResponseEntity.ok().build();
    }

}
