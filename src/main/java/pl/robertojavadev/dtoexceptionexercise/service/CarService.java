package pl.robertojavadev.dtoexceptionexercise.service;

import pl.robertojavadev.dtoexceptionexercise.dto.CarDTO;
import pl.robertojavadev.dtoexceptionexercise.dto.GetCarDTO;

import java.util.List;

public interface CarService {

    List<GetCarDTO> getAllCars();

    GetCarDTO getCar(Long id);

    CarDTO createCar (CarDTO carDTO);

    CarDTO updateCar (Long id, CarDTO carDTO);

    void deleteCar(Long id);

}
