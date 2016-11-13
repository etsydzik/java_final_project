package tsydzik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eugene Tsydzik
 * @since 13.11.16.
 */
@Controller
public class RegisterController {

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

}