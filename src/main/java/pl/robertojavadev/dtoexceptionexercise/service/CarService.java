package pl.robertojavadev.dtoexceptionexercise.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.robertojavadev.dtoexceptionexercise.domain.model.Car;
import pl.robertojavadev.dtoexceptionexercise.domain.respository.CarRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCar(Long id) {
        return carRepository.getById(id);
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
