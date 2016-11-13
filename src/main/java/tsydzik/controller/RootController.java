package tsydzik.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Eugene Tsydzik
 * @since 13.11.16.
 */
@Controller
public class RootController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirect(@AuthenticationPrincipal String user) {
        if (user.equals("admin")) {
            return "redirect:/applications";
        }
        return "redirect:/applications/new";
    }
}
