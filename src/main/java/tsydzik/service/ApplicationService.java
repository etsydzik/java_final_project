package tsydzik.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tsydzik.data.Application;
import tsydzik.data.Car;
import tsydzik.repository.ApplicationRepository;
import tsydzik.repository.CarRepository;

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

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CarRepository carRepository;

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
                                         String exploitationTime) {

        String stringStartTime = "2016-11-14";
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

//        application.setUser(user);
//        return applicationRepository.save(application);
        return null;
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
}