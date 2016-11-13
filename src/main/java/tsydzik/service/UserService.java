package tsydzik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsydzik.data.User;
import tsydzik.exceptions.UserExistsException;
import tsydzik.repository.UserRepository;

/**
 * @author Eugene Tsydzik
 * @since 13.11.16.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, String login, String password) {
        if (userRepository.loginExists(login)) {
            throw new UserExistsException();
        }
        User user = new User();
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
