package spring.io.restaurantmanagement.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.io.restaurantmanagement.common.BaseEntity;
import spring.io.restaurantmanagement.item.Item;
import spring.io.restaurantmanagement.payment.Payment;
import spring.io.restaurantmanagement.user.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity {
    
    private LocalDate date;
    
    private LocalTime time;
    
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
    
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
