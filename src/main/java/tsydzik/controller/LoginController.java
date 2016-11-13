package tsydzik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tsydzik.exceptions.UserNotFoundException;
import tsydzik.service.UserService;

/**
 * @author Eugene Tsydzik
 * @since 13.11.16.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login,
                        @RequestParam String password) {
        try {
            userService.findUser(login, password);
            return "redirect:application";
        } catch (UserNotFoundException e) {
            return "redirect:login";
        }
    }
}