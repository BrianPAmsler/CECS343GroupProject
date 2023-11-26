package spring.io.restaurantmanagement.user;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    
    User findByEmailAddress(String emailAddress);
    
    boolean existsByEmailAddress(String emailAddress);
}
