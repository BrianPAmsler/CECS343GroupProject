package spring.io.restaurantmanagement.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.io.restaurantmanagement.common.BaseEntity;
import spring.io.restaurantmanagement.order.Order;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseEntity {
    
    private String name;
    
    private String description;
    
    private double price;
    
    private boolean available;
    
    private String image;
    
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;
}
