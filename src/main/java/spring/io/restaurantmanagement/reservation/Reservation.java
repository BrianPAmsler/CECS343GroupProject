package spring.io.restaurantmanagement.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import spring.io.restaurantmanagement.common.BaseEntity;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation extends BaseEntity {
    
    private String firstName;
    
    private String lastName;
    
    private String emailAddress;
    
    private String phoneNumber;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;
    
    private int guestNumber;
    
    private boolean is_served;
    
    private String message;
    
}
