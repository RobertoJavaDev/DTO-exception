package pl.robertojavadev.dtoexceptionexercise.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.robertojavadev.dtoexceptionexercise.domain.model.Car;
import pl.robertojavadev.dtoexceptionexercise.domain.respository.CarRepository;
import pl.robertojavadev.dtoexceptionexercise.dto.CarDTO;
import pl.robertojavadev.dtoexceptionexercise.dto.GetCarDTO;
import pl.robertojavadev.dtoexceptionexercise.dto.CarMapper;
import pl.robertojavadev.dtoexceptionexercise.exception.EmptyInputException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    private final CarMapper carMapper;


    @Override
    public List<GetCarDTO> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(carMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public GetCarDTO getCar(Long id) {
        Car car = carRepository.findById(id).get();
        return carMapper.map(car);
    }

    @Override
    public CarDTO createCar(CarDTO carDTORequest) {

        String name = carDTORequest.getName();
        String production = carDTORequest.getProductionYear();
        String country = carDTORequest.getProductionCountry();
        Boolean available = carDTORequest.isAvailable();
        Car car = new Car(name, production, country, available);
        if (car.getName().isEmpty() || car.getName().length() == 0){
            throw new EmptyInputException("601", "Input Fields are empty");
        }
        Car savedCar = carRepository.save(car);

        return carMapper.mapping(savedCar);
    }

    @Override
    public CarDTO updateCar(Long id, CarDTO carDTORequest) {
        CarDTO carDTO = carMapper.mapping(carRepository.getById(id));

        carDTO.setName(carDTORequest.getName());
        carDTO.setProductionYear(carDTORequest.getProductionYear());
        carDTO.setProductionCountry(carDTORequest.getProductionCountry());
        carDTO.setAvailable(carDTORequest.isAvailable());

        Car car = carMapper.mapping(carDTO);
        carRepository.save(car);

        return carDTO;
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
