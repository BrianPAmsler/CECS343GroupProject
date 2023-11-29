package spring.io.restaurantmanagement.payment;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentRepository extends PagingAndSortingRepository<Payment, Integer> {
}
