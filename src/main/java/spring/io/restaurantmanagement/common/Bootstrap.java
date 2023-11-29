package spring.io.restaurantmanagement.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import spring.io.restaurantmanagement.item.Item;
import spring.io.restaurantmanagement.item.ItemRepository;
import spring.io.restaurantmanagement.order.Order;
import spring.io.restaurantmanagement.order.OrderRepository;
import spring.io.restaurantmanagement.payment.Payment;
import spring.io.restaurantmanagement.payment.PaymentRepository;
import spring.io.restaurantmanagement.reservation.Reservation;
import spring.io.restaurantmanagement.reservation.ReservationRepository;
import spring.io.restaurantmanagement.user.User;
import spring.io.restaurantmanagement.user.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {
    
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final ReservationRepository reservationRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        List<User> userList = new ArrayList<>();
        User adminUser = new User("admin@email.com", passwordEncoder.encode("123456"), "Admin", "User", "", new ArrayList<>(), "ROLE_ADMIN");
        User user = new User("a@email.com", passwordEncoder.encode("123456"), "a", "b", "123456", new ArrayList<>(), "ROLE_USER");
        
        User user1 = new User("an1lee1@email.com", passwordEncoder.encode("123456"), "An", "Lee1", "123-456", new ArrayList<>(), "ROLE_USER");
        User user2 = new User("an2lee2@email.com", passwordEncoder.encode("123456"),"Bn", "Lee2", "456-234", new ArrayList<>(), "ROLE_USER");
        User user3 = new User("an3lee3@email.com", passwordEncoder.encode("123456"),"Cn", "Lee3", "678-890", new ArrayList<>(), "ROLE_USER");
        User user4 = new User("an4lee4@email.com", passwordEncoder.encode("123456"),"Dn", "Lee4", "345-567", new ArrayList<>(), "ROLE_USER");
        User user5 = new User("an5lee5@email.com", passwordEncoder.encode("123456"),"En", "Lee5", "234-890", new ArrayList<>(), "ROLE_USER");
        User user6 = new User("an6lee6@email.com", passwordEncoder.encode("123456"),"Fn", "Lee6", "764-678", new ArrayList<>(), "ROLE_USER");
        userList.add(adminUser);
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userRepository.saveAll(userList);
        
        List<Item> itemList = new ArrayList<>();
        Item item1 = new Item("Traditional Vietnamese Egg Rolls", 
                              "Crispy Rice Paper rolls with Shrimp, Crab Meat, Pork, Mushroom.", 
                              10.5, true, 
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700609677/restaurant-management/egg-rolls.jpg", 
                              new ArrayList<>());
        Item item2 = new Item("Pho - Rice Noodle Soup", 
                              "Rice Noodle Soup with sliced Filet Mignon Steak.", 
                              15.0, false, 
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700609920/restaurant-management/pho.jpg",
                              new ArrayList<>());
        Item item3 = new Item("Beef with Garlic Noodle", 
                              "Beef with Onions, Mushrooms, Bell Peppers in Garlic Sauce and Noodle.", 
                              16.5, true, 
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700614149/restaurant-management/beef-garlic-noodle.jpg", 
                              new ArrayList<>());
        Item item4 = new Item("Four Cheese Pasta", 
                              "Penne Pasta, Mozzarella, Ricotta, Romano and Parmesan Cheese, Marinara Sauce.", 
                              7.5, true, 
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700613167/restaurant-management/four-cheese-pasta.jpg", 
                              new ArrayList<>());
        Item item5 = new Item("Spaghetti and Meatballs", 
                              "Meatballs made with beef, Italian sausage and parmesan with tomato sauce.", 
                              12.75, true, 
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700613067/restaurant-management/spaghetti-meatballs.jpg", 
                              new ArrayList<>());
        Item item6 = new Item("Grilled Salmon",
                              "Fresh salmon with mashed potatoes and broccoli.",
                              12.75, true,
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700612535/restaurant-management/grilled-salmon.jpg",
                              new ArrayList<>());
        Item item7 = new Item("Chicken Pasta",
                              "Parmesan crusted chicken with pasta, mushrooms, peppers, tomatoes, spinach and onions.",
                              12.75, true,
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700612350/restaurant-management/chicken-pasta.jpg",
                              new ArrayList<>());
        Item item8 = new Item("Chicken Tacos",
                              "Soft corn tortillas filled with spicy chicken, avocado, tomato, onions, cilantro and chipotle.",
                              12.75, true,
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700612269/restaurant-management/chicken-tacos.jpg",
                              new ArrayList<>());
        Item item9 = new Item("Fish Tacos",
                              "Soft corn tortillas filled with grilled fish, avocado, tomato, onions, cilantro and vegetable salad.",
                              12.75, true,
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700612204/restaurant-management/fish-tacos.jpg",
                              new ArrayList<>());
        Item item10 = new Item("Grilled Steak Tacos",
                              "Soft corn tortillas filled with steak, avocado, tomato, onions, cilantro and chipotle sauce.",
                              12.75, true,
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700612133/restaurant-management/steak-tacos.jpg",
                              new ArrayList<>());
        Item item11 = new Item("Spicy Crispy Chicken Burger",
                              "Crispy chicken breast with melted cheese, spicy buffalo sauce, and a Brioche bun",
                              15.0, true,
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700612056/restaurant-management/chicken-burger.webp",
                              new ArrayList<>());
        Item item12 = new Item("Spring Rolls",
                              "Steamed shrimp and pork wrapped in rice paper, mint, lettuce, and bean sprouts. Served with plum sauce.",
                              12.75, true,
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700611783/restaurant-management/spring-rolls.jpg",
                              new ArrayList<>());
        Item item13 = new Item("Orange Chicken",
                              "Deep fried chicken covered in a sweet and spicy orange sauce. Served with white rice.",
                              12.75, true,
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700611335/restaurant-management/orange-chicken.jpg",
                              new ArrayList<>());
        Item item14 = new Item("Caesar Salad",
                              "Crouton, Parmesan cheese and Caesar dressing.",
                              12.75, true,
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700611217/restaurant-management/caesar-salad.jpg",
                              new ArrayList<>());
        Item item15 = new Item("Lotus Stem Salad",
                              "Shrimp and pork over lotus stems, celery, daikon, carrots, and onions. Served with fish sauce and shrimp pastes.",
                              12.75, true,
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700611117/restaurant-management/lotus-stem-salad.jpg",
                              new ArrayList<>());
        Item item16 = new Item("Beef Stew",
                              "Tender beef, onions and carrots in a beef stew. Served with French baguette.",
                              12.75, true,
                              "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700610836/restaurant-management/beef-stew.png",
                              new ArrayList<>());
        Item item17 = new Item("Cheese Burger",
                               "Cheddar cheese, lecture, tomato, grilled onions, pickles and sauce.",
                               12.75, true,
                               "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700619649/restaurant-management/cheese-burger.jpg",
                               new ArrayList<>());
        Item item18 = new Item("Fried Chicken",
                               "Chicken tenderloins breaded and fried crisp. Served with mashed potatoes and fresh butter corn.",
                               12.75, true,
                               "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700617764/restaurant-management/fried-chicken.jpg",
                               new ArrayList<>());
        Item item19 = new Item("Grilled Steak",
                               "Served with grilled potatoes and butter.",
                               12.75, true,
                               "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700610243/restaurant-management/beef-steak.jpg",
                               new ArrayList<>());
        Item item20 = new Item("Cafe Latte",
                               "Double Espresso, extra steamed milk.",
                               12.75, true,
                               "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700620884/restaurant-management/cafe-latte.jpg",
                               new ArrayList<>());
        Item item21 = new Item("Strawberry Cheesecake",
                               "Creamy cheesecake with sour cream and glazed fresh strawberry.",
                               12.75, true,
                               "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700612968/restaurant-management/strawberry-cheesecake.jpg",
                               new ArrayList<>());
        Item item22 = new Item("Chocolate Cheesecake",
                               "Chocolate cake topped with white chocolate and chocolate mousse.",
                               12.75, true,
                               "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700612681/restaurant-management/chocolate-cheesecake.jpg",
                               new ArrayList<>());
        Item item23 = new Item("Cafe Mocha",
                               "Espresso, chocolate, steamed milk, whipped cream.",
                               12.75, true,
                               "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700611679/restaurant-management/cafe-mocha.jpg",
                               new ArrayList<>());
        Item item24 = new Item("Fruit Smoothie",
                               "Mango, passion fruit, strawberries, pineapple, and coconut blended with ice.",
                               12.75, true,
                               "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700611610/restaurant-management/fruit-smoothie.jpg",
                               new ArrayList<>());
        Item item25 = new Item("Iced Tea",
                               "Organic black tea with sliced lemon and ice.",
                               12.75, true,
                               "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700611485/restaurant-management/iced-tea.jpg",
                               new ArrayList<>());
        Item item26 = new Item("Soft Drinks",
                               "Coke, pepsi, Sprite, Dr pepper, Sunkist",
                               12.75, true,
                               "https://res.cloudinary.com/dou1ijs1t/image/upload/v1700621555/restaurant-management/cit3r1moijfnbsmhdrmg.jpg",
                               new ArrayList<>());
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);
        itemList.add(item7);
        itemList.add(item8);
        itemList.add(item9);
        itemList.add(item10);
        itemList.add(item11);
        itemList.add(item12);
        itemList.add(item13);
        itemList.add(item14);
        itemList.add(item15);
        itemList.add(item16);
        itemList.add(item17);
        itemList.add(item18);
        itemList.add(item19);
        itemList.add(item20);
        itemList.add(item21);
        itemList.add(item22);
        itemList.add(item23);
        itemList.add(item24);
        itemList.add(item25);
        itemList.add(item26);
        itemRepository.saveAll(itemList);
        
        List<Reservation> reservationList = new ArrayList<>();
        Reservation reservation1 = new Reservation("An1", "lee1", "an1lee1@email.com", "123456", LocalDate.of(2023, 11, 20), LocalTime.of(18, 15), 2, false, "");
        Reservation reservation2 = new Reservation("An2", "lee2", "an2lee2@email.com", "456789", LocalDate.of(2023, 11, 25), LocalTime.of(20, 15), 1, false, "");
        Reservation reservation3 = new Reservation("An3", "lee3", "an3lee3@email.com", "258369", LocalDate.of(2023, 11, 30), LocalTime.of(18, 15), 4, false, "");
        Reservation reservation4 = new Reservation("An4", "lee4", "an4lee4@email.com", "753869", LocalDate.of(2023, 11, 21), LocalTime.of(19, 00), 5, false, "");
        Reservation reservation5 = new Reservation("An5", "lee5", "an5lee5@email.com", "159487", LocalDate.of(2023, 11, 20), LocalTime.of(18, 30), 4, false, "");
        Reservation reservation6 = new Reservation("An6", "lee6", "an6lee6@email.com", "236548", LocalDate.of(2023, 11, 26), LocalTime.of(17, 45), 3, false, "");
        reservationList.add(reservation1);
        reservationList.add(reservation2);
        reservationList.add(reservation3);
        reservationList.add(reservation4);
        reservationList.add(reservation5);
        reservationList.add(reservation6);
        reservationRepository.saveAll(reservationList);
        
//        List<Order> orderList = new ArrayList<>();
        Order order1 = new Order(LocalDate.of(2023, 11, 20), LocalTime.of(18, 15), 1, user1, item1, null);
        Order order11 = new Order(LocalDate.of(2023, 11, 20), LocalTime.of(18, 15), 2, user1, item2, null);
        Order order2 = new Order(LocalDate.of(2023, 11, 25), LocalTime.of(20, 15), 1, user2, item1, null);
        Order order21 = new Order(LocalDate.of(2023, 11, 25), LocalTime.of(20, 15), 1, user2, item2, null);
        Order order3 = new Order(LocalDate.of(2023, 11, 30), LocalTime.of(18, 15), 1, user3, item1, null);
        Order order31 = new Order(LocalDate.of(2023, 11, 30), LocalTime.of(18, 15), 2, user3, item2, null);
        Order order32 = new Order(LocalDate.of(2023, 11, 30), LocalTime.of(18, 15), 1, user3, item3, null);
        Order order33 = new Order(LocalDate.of(2023, 11, 30), LocalTime.of(18, 15), 1, user3, item4, null);
        Order order4 = new Order(LocalDate.of(2023, 11, 21), LocalTime.of(19, 0), 1, user4, item1, null);
        Order order41 = new Order(LocalDate.of(2023, 11, 21), LocalTime.of(19, 0), 1, user4, item2, null);
        Order order42 = new Order(LocalDate.of(2023, 11, 21), LocalTime.of(19, 0), 1, user4, item3, null);
        Order order43 = new Order(LocalDate.of(2023, 11, 21), LocalTime.of(19, 0), 2, user4, item4, null);
        Order order44 = new Order(LocalDate.of(2023, 11, 21), LocalTime.of(19, 0), 1, user4, item5, null);
        Order order5 = new Order(LocalDate.of(2023, 11, 20), LocalTime.of(18, 30), 2, user5, item1, null);
        Order order51 = new Order(LocalDate.of(2023, 11, 20), LocalTime.of(18, 30), 1, user5, item2, null);
        Order order52 = new Order(LocalDate.of(2023, 11, 20), LocalTime.of(18, 30), 1, user5, item4, null);
        Order order6 = new Order(LocalDate.of(2023, 11, 26), LocalTime.of(17, 45), 1, user6, item1, null);
        Order order61 = new Order(LocalDate.of(2023, 11, 26), LocalTime.of(17, 45), 2, user6, item2, null);
//        orderList.add(order1);
//        orderList.add(order11);
//        orderList.add(order2);
//        orderList.add(order21);
//        orderList.add(order3);
//        orderList.add(order31);
//        orderList.add(order32);
//        orderList.add(order33);
//        orderList.add(order4);
//        orderList.add(order41);
//        orderList.add(order42);
//        orderList.add(order43);
//        orderList.add(order44);
//        orderList.add(order5);
//        orderList.add(order51);
//        orderList.add(order52);
//        orderList.add(order6);
//        orderList.add(order61);
//        orderRepository.saveAll(orderList);
        
        List<Payment> paymentList = new ArrayList<>();
        List<Order> user1OrderList = List.of(order1, order11);
        List<Order> user2OrderList = List.of(order2, order21);
        List<Order> user3OrderList = List.of(order3, order31, order32, order33);
        List<Order> user4OrderList = List.of(order4, order41, order42,order43, order44);
        List<Order> user5OrderList = List.of(order5, order51, order52);
        List<Order> user6OrderList = List.of(order6, order61);
        
        Payment payment1 = creatPayment(LocalDate.of(2023, 11, 20), LocalTime.of(18, 15), user1OrderList);
        Payment payment2 = creatPayment(LocalDate.of(2023, 11, 25), LocalTime.of(20, 15), user2OrderList);
        Payment payment3 = creatPayment(LocalDate.of(2023, 11, 30), LocalTime.of(18, 15), user3OrderList);
        Payment payment4 = creatPayment(LocalDate.of(2023, 11, 21), LocalTime.of(19, 0), user4OrderList);
        Payment payment5 = creatPayment(LocalDate.of(2023, 11, 20), LocalTime.of(18, 30), user5OrderList);
        Payment payment6 = creatPayment(LocalDate.of(2023, 11, 26), LocalTime.of(17, 45), user6OrderList);
        paymentList.add(payment1);
        paymentList.add(payment2);
        paymentList.add(payment3);
        paymentList.add(payment4);
        paymentList.add(payment5);
        paymentList.add(payment6);
        paymentRepository.saveAll(paymentList);
        
        
    }
    
    public Payment creatPayment(LocalDate localDate, LocalTime localTime, List<Order> orderList) {
        double sum = 0;

        for (int i = 0; i < orderList.size(); i++) {
            sum = sum + orderList.get(i).getQuantity() * orderList.get(i).getItem().getPrice();
        }

        Payment payment = new Payment(sum, localDate, localTime, orderList);
        
        for (int i = 0; i < orderList.size(); i++) {
            orderList.get(i).setPayment(payment);
        }
        
        return payment;
    }
}
