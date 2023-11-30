package spring.io.restaurantmanagement.user;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class UserController {
    
    private final UserRepository userRepository;
    
    @GetMapping("/users")
    public ModelAndView getUsers(Model model) {
        // Redirect to home page if user does not have admin role
        Object temp = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = temp instanceof User ? (User) temp : null;
        if (currentUser == null || currentUser.getRole() != Role.ROLE_ADMIN) {
            return new ModelAndView("redirect:/");
        }

        model.addAttribute("usersWrapper", new UserWrapper(userRepository.findAll()));
        model.addAttribute("roles", Role.getRoles());
        return new ModelAndView("users");
    }
}
