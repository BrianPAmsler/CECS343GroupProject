package com.cecs.restaurantautomation;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    private static String MOTD = "Hello World!";
    private AtomicInteger counter = new AtomicInteger(0);

	@GetMapping("/motd")
	public MotD motd(@RequestParam(value = "name", defaultValue = "User") String name) {
		return new MotD(counter.incrementAndGet(), "Message to " + name + ": " + MOTD);
	}

	@PostMapping("/add-reservation")
	public Reservation addReservation(@RequestBody Reservation reservation) {
		RestaurantManager manager = RestaurantManager.getInstance();

		manager.addReservation(reservation);

		return reservation;
	}
	
	@GetMapping("/get-reservations")
	public Reservation[] getReservations() {
		RestaurantManager manager = RestaurantManager.getInstance();

		return manager.getReservations();
	} 
}