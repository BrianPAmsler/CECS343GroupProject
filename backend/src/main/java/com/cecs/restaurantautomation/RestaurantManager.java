package com.cecs.restaurantautomation;

import java.util.ArrayList;

public class RestaurantManager {
    private static RestaurantManager instance = null;

    private ArrayList<Reservation> reservations;

    public RestaurantManager () {
        reservations = new ArrayList<Reservation>();
    }

    public synchronized void addReservation(Reservation reservation) {
        reservations.add(reservation.clone());
    }

    public synchronized Reservation[] getReservations() {
        Reservation[] copy = new Reservation[reservations.size()];

        // Copy Reservation objects to avoid unwanted modification
        for (int i = 0; i < reservations.size(); i++)
            copy[i] = reservations.get(i);

        return copy;
    }

    public static RestaurantManager getInstance() {
        if (instance == null)
            instance = new RestaurantManager();

        return instance;
    }
}
