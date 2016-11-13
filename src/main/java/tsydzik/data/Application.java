package tsydzik.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * заявка на аренду
 *
 * @author Eugene Tsydzik
 * @since 12.11.16.
 */
@Entity
@Data
public class Application {

    @Id
    @GeneratedValue
    private Long id;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private User user;

    @ManyToOne
    private Car car;

}
