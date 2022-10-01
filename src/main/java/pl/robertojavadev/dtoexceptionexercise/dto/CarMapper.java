package pl.robertojavadev.dtoexceptionexercise.dto;

import org.mapstruct.Mapper;
import pl.robertojavadev.dtoexceptionexercise.domain.model.Car;

@Mapper(componentModel = "spring")
public interface CarMapper {

    Car map(GetCarDTO getCarDTO);
    GetCarDTO map(Car car);

    Car mapping(CarDTO carDTO);

    CarDTO mapping(Car car);
}
