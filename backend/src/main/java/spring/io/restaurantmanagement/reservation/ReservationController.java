package spring.io.restaurantmanagement.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.io.restaurantmanagement.user.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequiredArgsConstructor
public class ReservationController {
    
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    
    @GetMapping("/reservations")
    public String getReservations(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservations";
    }
    
    @GetMapping("/reservation")
    public String getReservation(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        model.addAttribute("reservation", new Reservation("", "", "", "", LocalDate.now(), LocalTime.now(), 0, false, ""));
        return "reservation";
    }
    
    @PostMapping("/make-reservation")
    public String makeReservation(Model model, @ModelAttribute Reservation reservation) {
        reservationRepository.save(reservation);
        return "make-reservation";
    }
}
