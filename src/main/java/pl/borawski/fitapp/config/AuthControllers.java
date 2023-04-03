package pl.borawski.fitapp.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthControllers {
    @GetMapping("/login")
    String loginForm(){
        return "login-form";
    }
    @GetMapping("/")
    String home(){
        return "index";
    }
}
