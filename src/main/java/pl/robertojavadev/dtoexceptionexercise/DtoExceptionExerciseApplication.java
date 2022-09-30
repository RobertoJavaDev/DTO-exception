package pl.robertojavadev.dtoexceptionexercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.robertojavadev.dtoexceptionexercise.domain.model.Car;
import pl.robertojavadev.dtoexceptionexercise.domain.respository.CarRepository;

@SpringBootApplication
public class DtoExceptionExerciseApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DtoExceptionExerciseApplication.class, args);
    }

    @Autowired
    private CarRepository carRepository;


    @Override
    public void run(String... args) throws Exception {

        Car car = new Car();
        car.setName("Honda");
        car.setProductionYear("2000");
        car.setProductionCountry("Japan");
        car.setAvailable(true);
        carRepository.save(car);

        Car car1 = new Car();
        car1.setName("BMW");
        car1.setProductionYear("2022");
        car1.setProductionCountry("Germany");
        car1.setAvailable(true);
        carRepository.save(car1);

        Car car2 = new Car();
        car2.setName("Ferrari");
        car2.setProductionYear("2022");
        car2.setProductionCountry("Italy");
        car2.setAvailable(false);
        carRepository.save(car2);
    }
}
