package tsydzik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tsydzik.data.Application;
import tsydzik.service.ApplicationService;


/**
 * @author Eugene Tsydzik
 * @since 13.11.16.
 */
@Controller
@RequestMapping("/applications")
public class ApplicationController {


    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showForm() {
        return "application";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestParam String modelAuto,
                         @RequestParam Integer manufactureDate,
                         @RequestParam Double enginePower,
                         @RequestParam String exploitationTime,
                         @AuthenticationPrincipal String username) {

        applicationService.createApplication(modelAuto, manufactureDate, enginePower, exploitationTime, username);
        return "redirect:/applications?created";
    }

    @RequestMapping(method = RequestMethod.GET, params = "created")
    public String showCreated() {
        return "application_created";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAll() {
        Iterable<Application> applications = applicationService.findAll();
        ModelAndView modelAndView = new ModelAndView("list_applications");
        return modelAndView.addObject("applications", applications);
    }
}