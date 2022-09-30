package pl.robertojavadev.dtoexceptionexercise.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.robertojavadev.dtoexceptionexercise.domain.model.Car;
import pl.robertojavadev.dtoexceptionexercise.domain.respository.CarRepository;
import pl.robertojavadev.dtoexceptionexercise.dto.CarDTO;
import pl.robertojavadev.dtoexceptionexercise.dto.CarMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    private final CarMapper carMapper;

    public List<CarDTO> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::map)
                .collect(Collectors.toList());
    }

<<<<<<< HEAD
    public Optional<CarDTO> getCar(Long id) {
        return carRepository.findById(id).map(carMapper::map);
=======
<<<<<<< HEAD
    public Car getCar(Long id) {
        return carRepository.getById(id);
=======
    public Optional<CarDTO> getCar(Long id) {
        return carRepository.findById(id).map(carMapper::map);
>>>>>>> 955a673 (implemented DTO mapStructure to getCarById)
>>>>>>> DTO
    }

    public Car createCar(Car carRequest) {
        Car car = new Car();
        car.setName(carRequest.getName());
        car.setProductionYear(carRequest.getProductionYear());
        car.setProductionCountry(carRequest.getProductionCountry());
        car.setAvailable(carRequest.isAvailable());
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car carRequest) {
        Car car =carRepository.getById(id);
        car.setName(carRequest.getName());
        car.setProductionYear(carRequest.getProductionYear());
        car.setProductionCountry(carRequest.getProductionCountry());
        car.setAvailable(carRequest.isAvailable());
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
