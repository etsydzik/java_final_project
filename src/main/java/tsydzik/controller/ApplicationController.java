package tsydzik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tsydzik.service.ApplicationService;


/**
 * @author Eugene Tsydzik
 * @since 13.11.16.
 */
@Controller
public class ApplicationController {


    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(value = "/application", method = RequestMethod.GET)
    public String showApplicationForm() {
        return "application";
    }

    @RequestMapping(value = "/application", method = RequestMethod.POST)
    public String createApplication(@RequestParam String modelAuto,
                                    @RequestParam Integer manufactureDate,
                                    @RequestParam Double enginePower,
                                    @RequestParam String exploitationTime) {

        applicationService.createApplication(modelAuto, manufactureDate, enginePower, exploitationTime);
        return "redirect:/application?created";
    }

    @RequestMapping(value = "/application", method = RequestMethod.GET, params = "created")
    public String showApplicationCreated() {
        return "application_created";
    }

}