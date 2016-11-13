package tsydzik.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * описание авто
 *
 * @author Eugene Tsydzik
 * @since 12.11.16.
 */
@Entity
@Data
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    private String model;

    private Integer manufactureDate;

    private String carNumber;

    private Double enginePower;

}
