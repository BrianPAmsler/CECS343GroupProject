package spring.io.restaurantmanagement.common;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.io.restaurantmanagement.user.User;
import spring.io.restaurantmanagement.user.UserRepository;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class CommonController {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @GetMapping("/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping("/signin")
    public String getSignin() {
        return "signin";
    }

    @GetMapping("/signin-error")
    public String getSignInError(Model model) {
        model.addAttribute("signinError", true);
        return "signin";
    }

    @GetMapping("/signup")
    public String getSignUp() {
        return "signup";
    }

    @PostMapping("/signup")
    public String getSignUp(Model model,
                            @RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String phoneNumber,
                            @RequestParam String emailAddress,
                            @RequestParam String password,
                            @RequestParam String confirmedPassword) throws Exception {
        if (userRepository.existsByEmailAddress(emailAddress)) {
            model.addAttribute("signUpError", "Email address is already registered!");
            return "/signup";
        } else if (!password.equals(confirmedPassword)) {
            model.addAttribute("signUpError", "Confirmed password does not match!");
            return "/signup";
        }
        
        User user = new User(emailAddress, passwordEncoder.encode(password), firstName, lastName, phoneNumber, new ArrayList<>(), "ROLE_USER");
        userRepository.save(user);
        model.addAttribute("signUpSuccess", true);
        return "signin";
    }
    
}
