package pl.robertojavadev.dtoexceptionexercise.dto;

import org.mapstruct.Mapper;
import pl.robertojavadev.dtoexceptionexercise.domain.model.Car;

@Mapper(componentModel = "spring")
public interface CarMapper {

    Car map(CarDTO carDTO);
    CarDTO map(Car car);
}
