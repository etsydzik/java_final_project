package tsydzik.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Eugene Tsydzik
 * @since 12.11.16.
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue  //автогенерация
    private Long id;

    private String name;

}
