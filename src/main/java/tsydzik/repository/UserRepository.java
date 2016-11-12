package tsydzik.repository;

import org.springframework.data.repository.CrudRepository;
import tsydzik.data.User;

/**
 * @author Eugene Tsydzik
 * @since 12.11.16.
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
