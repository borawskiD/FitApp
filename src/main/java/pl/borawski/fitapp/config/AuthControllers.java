package pl.borawski.fitapp.config;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.borawski.fitapp.user.UserRegisterDTO;
import pl.borawski.fitapp.user.UserService;

import java.util.List;

@Controller
public class AuthControllers {
    private final UserService userService;
    @GetMapping("/login")
    String loginForm(){
        return "login-form";
    }

    public AuthControllers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    String register(Model model){
        UserRegisterDTO user = new UserRegisterDTO();
        model.addAttribute("user", user);
        return "register-form";
    }

    @PostMapping( "/register")
    public String registerSend(@Valid @ModelAttribute("user") UserRegisterDTO userRegisterDTO, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error);
            }
            return "register-form";
        }else{
            userService.register(userRegisterDTO);
            model.addAttribute("registerSuccess", "Successfully registered new user. Let's log in!");
        }

        return "login-form";
    }


}
