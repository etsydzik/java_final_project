package tsydzik.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tsydzik.data.User;

/**
 * @author Eugene Tsydzik
 * @since 12.11.16.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM User u WHERE u.login = ?1")
    Boolean loginExists(String login);

    User findByLoginAndPassword(String login, String password);
}
