package pl.robertojavadev.dtoexceptionexercise.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String productionYear;
    String productionCountry;
    boolean available;
}
