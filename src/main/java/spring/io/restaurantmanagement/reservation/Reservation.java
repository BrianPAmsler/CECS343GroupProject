package spring.io.restaurantmanagement.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    
    private LocalDate date;
    
    private LocalTime time;
    
    private int guestNumber;
    
    private boolean is_served;
    
    private String message;
    
}
