package pl.robertojavadev.dtoexceptionexercise.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.robertojavadev.dtoexceptionexercise.domain.model.Car;
import pl.robertojavadev.dtoexceptionexercise.service.CarService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.getCar(id);
    }

    @PostMapping
    public Car creatCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    @PutMapping("{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }
}