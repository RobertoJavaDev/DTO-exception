package pl.robertojavadev.dtoexceptionexercise.dto;

import lombok.Data;

@Data
public class CarDTO {

    private Long id;
    private String name;
    private boolean available;
}
