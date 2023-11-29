package spring.io.restaurantmanagement.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String makeReservation(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String emailAddress, @RequestParam String phoneNumber,
            @RequestParam String date, @RequestParam String time, @RequestParam Integer guestNumber, @RequestParam String message) {
        
        Reservation reservation = new Reservation(firstName,
                                                  lastName,
                                                  emailAddress,
                                                  phoneNumber,
                                                  LocalDate.parse(date),
                                                  LocalTime.parse(time),
                                                  guestNumber,
                                                  false,
                                                  message);

        reservationRepository.save(reservation);
        return "make-reservation";
    }
}
