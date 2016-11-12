package tsydzik.repository;

import org.springframework.data.repository.CrudRepository;
import tsydzik.data.Auto;

/**
 * @author Eugene Tsydzik
 * @since 12.11.16.
 */
public interface AutoRepository extends CrudRepository<Auto, Long> {
}
