package com.cecs.restaurantautomation;

import java.sql.Timestamp;

public class Reservation implements Cloneable {
    public String customerName;
    public Timestamp time;
    public int groupSize;

    public Reservation (String customerName, Timestamp time, int groupSize) {
        this.customerName = customerName;
        this.time = time;
        this.groupSize = groupSize;
    }

    public Reservation clone() {
        return new Reservation(customerName, time, groupSize);
    }
}
