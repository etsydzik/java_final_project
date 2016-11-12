package tsydzik.repository;

import org.springframework.data.repository.CrudRepository;
import tsydzik.data.Application;

/**
 * @author Eugene Tsydzik
 * @since 12.11.16.
 */
public interface ApplicationRepository extends CrudRepository<Application, Long> {
}
