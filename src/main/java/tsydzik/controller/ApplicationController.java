package tsydzik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eugene Tsydzik
 * @since 13.11.16.
 */
@Controller
public class ApplicationController {

    @RequestMapping("/application")
    public String application() {
        return "application";
    }

}