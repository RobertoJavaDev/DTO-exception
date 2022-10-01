package pl.robertojavadev.dtoexceptionexercise.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.robertojavadev.dtoexceptionexercise.dto.CarDTO;
import pl.robertojavadev.dtoexceptionexercise.dto.GetCarDTO;
import pl.robertojavadev.dtoexceptionexercise.service.CarService;
import pl.robertojavadev.dtoexceptionexercise.service.CarServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("cars")
public class CarController {

    private final CarService carService;
    private final CarServiceImpl carServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<GetCarDTO>> getAllCars() {
        return new ResponseEntity<>(carServiceImpl.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<GetCarDTO> getCar(@PathVariable Long id) {
        return new ResponseEntity<>(carServiceImpl.getCar(id),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<CarDTO> creatCar(@RequestBody CarDTO carDTO) {
        return new ResponseEntity<>(carService.createCar(carDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable Long id, @RequestBody CarDTO carDTO) {
        return new ResponseEntity<>(carService.updateCar(id, carDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
