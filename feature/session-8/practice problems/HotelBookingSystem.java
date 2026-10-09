
import java.util.*;

class Room {
    int number;
    double price;
    boolean booked = false;

    Room(int number, double price) {
        this.number = number;
        this.price = price;
    }
}

class Reservation {
    Room room;
    String customer;
    int start, end;
    boolean active = true;

    Reservation(Room room, String customer, int start, int end) {
        this.room = room;
        this.customer = customer;
        this.start = start;
        this.end = end;
    }

    boolean overlaps(int s, int e) {
        return active && s < end && e > start;
    }
}

public class HotelBookingSystem {
    static ArrayList<Reservation> bookings = new ArrayList<>();

    static void book(Room room, String customer, int start, int end) {
        for (Reservation r : bookings) {
            if (r.room == room && r.overlaps(start, end)) {
                System.out.println("Room " + room.number + " is not available");
                return;
            }
        }

        if (start >= end) {
            System.out.println("Invalid dates");
            return;
        }

        Reservation r = new Reservation(room, customer, start, end);
        bookings.add(r);
        System.out.println("Booking confirmed for " + customer);
        System.out.println("Price: $" + (room.price * (end - start)));
    }

    static void cancel(Reservation r) {
        if (r.active) {
            r.active = false;
            System.out.println("Reservation cancelled successfully");
        }
    }

    public static void main(String[] args) {
        Room standard = new Room(101, 100);
        Room deluxe = new Room(201, 200);

        book(standard, "Customer A", 1, 5);
        book(standard, "Customer B", 3, 7);

        Reservation first = bookings.get(0);
        cancel(first);

        book(deluxe, "Customer C", 10, 12);
    }
}
