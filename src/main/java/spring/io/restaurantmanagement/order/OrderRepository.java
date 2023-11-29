package spring.io.restaurantmanagement.order;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {
    
    List<Order> findAllByUser_EmailAddressAndPaymentIsNull(String emailAddress);
    
    Optional<Order> findByUser_IdAndItem_IdAndPaymentIsNull(Integer userId, Integer itemId);
}
