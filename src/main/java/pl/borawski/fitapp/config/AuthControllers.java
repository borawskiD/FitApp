package pl.borawski.fitapp.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.borawski.fitapp.user.UserRegisterDTO;
import pl.borawski.fitapp.user.UserService;
@Controller
public class AuthControllers {
    private UserService userService;
    @GetMapping("/login")
    String loginForm(){
        return "login-form";
    }

    public AuthControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    String home(){
        return "index";
    }
    @GetMapping("/register")
    String register(Model model){
        UserRegisterDTO user = new UserRegisterDTO();
        model.addAttribute("user", user);
        return "register-form";
    }
    @PostMapping("/register")
    String register(UserRegisterDTO userRegisterDTO) {
        userService.register(userRegisterDTO);
        return "redirect:/login";
    }
}
