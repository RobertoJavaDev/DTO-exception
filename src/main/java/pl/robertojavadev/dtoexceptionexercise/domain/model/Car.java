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

    public Car(String name, String production, String country, Boolean available) {
        this.name = name;
        this.productionYear = production;
        this.productionCountry = country;
        this.available = available;
    }

    public Car() {
    }
}
