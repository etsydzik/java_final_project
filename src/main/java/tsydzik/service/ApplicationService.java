package tsydzik.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsydzik.data.Application;
import tsydzik.data.Car;
import tsydzik.repository.ApplicationRepository;
import tsydzik.repository.CarRepository;
import tsydzik.repository.UserRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Eugene Tsydzik
 * @since 13.11.16.
 */
@Service
public class ApplicationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationService.class);

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository, UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
    }

    /**
     * @param modelAuto
     * @param manufactureDate
     * @param enginePower
     * @param exploitationTime
     * @return
     */
    public Application createApplication(String modelAuto,
                                         Integer manufactureDate,
                                         Double enginePower,
                                         String exploitationTime,
                                         String username) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String stringStartTime = dateFormat.format(date);

        Date startTime = parseDate(stringStartTime);
        Date endTime = parseDate(exploitationTime);
        Application application = new Application();

        Car car = new Car();
        car.setModel(modelAuto);
        car.setManufactureDate(manufactureDate);
        car.setEnginePower(enginePower);
        car = carRepository.save(car);

        application.setCar(car);
        application.setStartTime(startTime);
        application.setEndTime(endTime);

        application.setUser(userRepository.findByLogin(username));
        return applicationRepository.save(application);
    }

    public Date parseDate(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            LOGGER.error("Fail to parse date. Date {}", dateString, e);
        }
        return null;
    }

    public Iterable<Application> findAll() {
        Iterable<Application> applications = applicationRepository.findAll();
        return applications;
    }
}
