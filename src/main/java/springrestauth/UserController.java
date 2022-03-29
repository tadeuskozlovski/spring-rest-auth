package springrestauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(SpringrestauthApplication.class);

    @Autowired
    UsersService usersService;

    @GetMapping("/getuser")
    public Response user(@RequestParam(value = "value") String value) {
        User user;

        try {
            return new Response(usersService.getById((Integer.parseInt(value))));
        } catch (NumberFormatException e) {
        }

        user = usersService.getAll().stream()
                .filter(u -> u.getName().toLowerCase().equals(value.toLowerCase()))
                .findAny()
                .orElse(null);

        if (user == null)
            return new Response(new User(-1, ""));

        return new Response(user);
    }
}
