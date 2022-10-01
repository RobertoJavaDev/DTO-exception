package pl.robertojavadev.dtoexceptionexercise.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.robertojavadev.dtoexceptionexercise.domain.model.Car;
import pl.robertojavadev.dtoexceptionexercise.dto.CarDTO;
import pl.robertojavadev.dtoexceptionexercise.dto.GetCarDTO;
import pl.robertojavadev.dtoexceptionexercise.service.CarServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("cars")
public class CarController {

    private final CarServiceImpl carService;

    @GetMapping
    public List<GetCarDTO> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("{id}")
    public Optional<GetCarDTO> getCar(@PathVariable Long id) {
        return carService.getCar(id);
    }

    @PostMapping
    public CarDTO creatCar(@RequestBody CarDTO carDTO) {
        return carService.createCar(carDTO);
    }

    @PutMapping("{id}")
    public CarDTO updateCar(@PathVariable Long id, @RequestBody CarDTO carDTO) {
        return carService.updateCar(id, carDTO);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
    }
}
