package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Customer extends User{
    HashMap<Integer,Booking> bookings;

    public Customer(String name) {
        super(name,UserType.CUSTOMER);
        this.bookings =  new HashMap<>();
    }

    public HashMap<Integer,Booking> getBookings() {
        return bookings;
    }

    public void setBookings(HashMap<Integer,Booking> bookings) {
        this.bookings = bookings;
    }
}
