package tsydzik.repository;

import org.springframework.data.repository.CrudRepository;
import tsydzik.data.Car;

/**
 * @author Eugene Tsydzik
 * @since 12.11.16.
 */
public interface CarRepository extends CrudRepository<Car, Long> {
}
