package pl.robertojavadev.dtoexceptionexercise.dto;

import lombok.Data;

@Data
public class CarDTO {

    private Long id;
    String name;
    String productionYear;
    String productionCountry;
    private boolean available;
}
