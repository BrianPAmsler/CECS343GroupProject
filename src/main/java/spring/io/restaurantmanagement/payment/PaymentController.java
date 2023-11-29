package spring.io.restaurantmanagement.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.io.restaurantmanagement.order.Order;
import spring.io.restaurantmanagement.order.OrderRepository;
import spring.io.restaurantmanagement.user.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PaymentController {
    
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    
    @GetMapping("/payments")
    public String getPayments(Model model) {
        model.addAttribute("payments", paymentRepository.findAll());
        return "payments";
    }
    
    @PostMapping("/place-order")
    public String placeOrder(Model model) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Order> orderList = orderRepository.findAllByUser_EmailAddressAndPaymentIsNull(currentUser.getEmailAddress());
        double total = 0.0;
        for (Order order : orderList) {
            total = total + order.getItem().getPrice() * order.getQuantity();
        }
        
        Payment payment = new Payment(total, LocalDate.now(), LocalTime.now(), orderList);

        for (Order order : orderList) {
            order.setPayment(payment);
        }
        paymentRepository.save(payment);
        return "place-order";
    }
}
