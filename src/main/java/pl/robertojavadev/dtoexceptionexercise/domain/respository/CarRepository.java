package pl.robertojavadev.dtoexceptionexercise.domain.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.robertojavadev.dtoexceptionexercise.domain.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
