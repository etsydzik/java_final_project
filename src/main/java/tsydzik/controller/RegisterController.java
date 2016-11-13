package tsydzik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import tsydzik.exceptions.UserExistsException;
import tsydzik.service.UserService;

/**
 * @author Eugene Tsydzik
 * @since 13.11.16.
 */
@Controller
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String name,
                           @RequestParam String login,
                           @RequestParam String password) {
        try {
            userService.createUser(name, login, password);
            return "redirect:login";
        } catch (UserExistsException e) {
            return "redirect:register";
        }
    }
}