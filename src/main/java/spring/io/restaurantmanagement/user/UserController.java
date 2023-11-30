package spring.io.restaurantmanagement.user;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    
    private final UserRepository userRepository;
    
    @GetMapping("/users")
    public String getUsers(Model model) {
        try {
            User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (currentUser.getRole() != Role.ROLE_ADMIN)
                return "index";
        } catch (Exception e) {
            return "index";
        }

        model.addAttribute("usersWrapper", new UserWrapper(userRepository.findAll()));
        model.addAttribute("roles", Role.getRoles());
        return "users";
    }
}
