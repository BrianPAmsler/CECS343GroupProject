package spring.io.restaurantmanagement.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.io.restaurantmanagement.item.Item;
import spring.io.restaurantmanagement.item.ItemRepository;
import spring.io.restaurantmanagement.user.User;
import spring.io.restaurantmanagement.user.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    
    @GetMapping("/orders")
    public String getOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }

    @GetMapping("/order")
    public String getOrder(Model model) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("items", itemRepository.findAll());
        List<Order> orderList = orderRepository.findAllByUser_EmailAddressAndPaymentIsNull(currentUser.getEmailAddress());
        model.addAttribute("orders", orderList);
        double total = 0.0;
        for (Order order : orderList) {
            total = total + order.getItem().getPrice() * order.getQuantity();
        }
        model.addAttribute("total", total);
        return "order";
    }
    
    @PostMapping("/add-to-cart")
    public String addToCart(Model model, @RequestParam Integer itemId) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmailAddress(currentUser.getEmailAddress());
        Item item = itemRepository.findById(itemId).orElse(null);
        Order order = orderRepository.findByUser_IdAndItem_IdAndPaymentIsNull(user.getId(), itemId).orElse(null);
        if (order == null) {
            order = new Order(LocalDate.now(), LocalTime.now(), 1, user, item, null);
        } else {
            order.setQuantity(order.getQuantity() + 1);
        }
        
        orderRepository.save(order);
        getOrder(model);
        return "redirect:/order";
    }

    @PostMapping("/remove-cart-item")
    public String removeCartItem(Model model, @RequestParam Integer orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            orderRepository.delete(order);
        }

        getOrder(model);
        return "redirect:/order";
    }

    @PostMapping("/change-quantity")
    public String changeQuantity(Model model, @RequestParam Integer orderId, @RequestParam Integer quantity) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setQuantity(quantity);
            orderRepository.save(order);
        }

        getOrder(model);
        return "redirect:/order";
    }
}
