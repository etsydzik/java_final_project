package tsydzik.repository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Eugene Tsydzik
 * @since 12.11.16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void testHasAuto() {
        Assertions.assertThat(carRepository.findAll()).isNotEmpty();
    }

}