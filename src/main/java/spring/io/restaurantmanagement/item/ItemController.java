package spring.io.restaurantmanagement.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {
    
    private final ItemRepository itemRepository;
    
    @GetMapping("/items")
    public String getItems(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "items";
    }

    @GetMapping("/menu")
    public String getMenu(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "menu";
    }


}
