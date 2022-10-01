package pl.robertojavadev.dtoexceptionexercise.service;

import pl.robertojavadev.dtoexceptionexercise.dto.CarDTO;

public interface CarService {

    CarDTO createCar (CarDTO carDTO);

    CarDTO updateCar (Long id, CarDTO carDTO);
}
