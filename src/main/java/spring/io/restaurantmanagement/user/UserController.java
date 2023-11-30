package spring.io.restaurantmanagement.user;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @PostMapping("/users")
    public ModelAndView postUsers(Model model, @RequestParam Map<String,String> allParams) {
        // Redirect to home page if user does not have admin role
        Object userObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userObject instanceof User ? (User) userObject : null;
        if (currentUser == null || currentUser.getRole() != Role.ROLE_ADMIN) {
            return new ModelAndView("redirect:/");
        }

        // Update all changed roles
        for (var entry : allParams.entrySet()) {
            if (entry.getKey().startsWith("user-id-")) {
                int id = Integer.parseInt(entry.getKey().substring(8));

                Optional<User> user = userRepository.findById(id);

                if (user.isPresent()) {
                    user.get().setRole(Role.valueOf(entry.getValue()));

                    userRepository.save(user.get());
                }
            }
        }

        UserWrapper wrapper = new UserWrapper(userRepository.findAll());
        model.addAttribute("usersWrapper", wrapper);
        model.addAttribute("roles", Role.getRoles());

        return new ModelAndView("users");
    }
}
