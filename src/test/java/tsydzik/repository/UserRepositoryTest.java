package tsydzik.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tsydzik.data.User;

/**
 * @author Eugene Tsydzik
 * @since 12.11.16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testHasUsers() {
        Assertions.assertThat(userRepository.findAll()).isNotEmpty();
    }

    @Test
    public void testHasUser() {
        User user = userRepository.findOne(1L);
        User expectedUser = new User();
        expectedUser.setId(1L);
        expectedUser.setName("eugene");
        expectedUser.setLogin("eugene");
        expectedUser.setPassword("1111");
        Assertions.assertThat(user).isEqualTo(expectedUser);
    }

    @Test
    public void testIfUserExist() {
        Assertions.assertThat(userRepository.loginExists("eugene")).isTrue();
    }

    @Test
    public void testIfUserNotExist() {
        Assertions.assertThat(userRepository.loginExists("asdf")).isFalse();
    }

    @Test
    public void testFindByLoginAndPassword() {
        User user = userRepository.findByLoginAndPassword("eugene", "1111");
        User expectedUser = new User();
        expectedUser.setId(1L);
        expectedUser.setName("eugene");
        expectedUser.setLogin("eugene");
        expectedUser.setPassword("1111");
        Assertions.assertThat(user).isEqualTo(expectedUser);
    }

    @Test
    public void testNotFindByLoginAndPassword() {
        User user = userRepository.findByLoginAndPassword("aaaaa", "aaaaa");
        Assertions.assertThat(user).isNull();
    }
}

