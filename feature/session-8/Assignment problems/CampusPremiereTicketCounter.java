
import java.util.*;

interface Seat {
    double price();
}

class Regular implements Seat {
    public double price() { return 150; }
}

class Premium implements Seat {
    public double price() { return 250; }
}

class Recliner implements Seat {
    public double price() { return 400; }
}

class Booking {
    String customer;
    Map<String, Seat> seats = new LinkedHashMap<>();
    boolean cancelled = false;

    Booking(String customer) {
        this.customer = customer;
    }
}

class Show {
    Set<String> booked = new HashSet<>();

    Booking book(String customer, String[] ids, Seat[] types) {
        if (ids.length == 0 || ids.length > 6) {
            System.out.println("Booking must have 1 to 6 seats.");
            return null;
        }

        Set<String> requested = new HashSet<>(Arrays.asList(ids));
        if (requested.size() != ids.length) {
            System.out.println("Duplicate seats are not allowed.");
            return null;
        }

        for (String id : ids) {
            if (booked.contains(id)) {
                System.out.println("Seat " + id + " is already booked.");
                return null;
            }
        }

        Booking b = new Booking(customer);
        double total = 0;

        for (int i = 0; i < ids.length; i++) {
            b.seats.put(ids[i], types[i]);
            booked.add(ids[i]);
            total += types[i].price();
        }

        System.out.println("Booking confirmed for " + customer
                + ": " + String.join(", ", ids));
        System.out.printf("Total: Rs. %.2f%n", total);
        return b;
    }

    void cancel(Booking b, boolean showStarted) {
        if (b != null && !b.cancelled && !showStarted) {
            booked.removeAll(b.seats.keySet());
            b.cancelled = true;
            System.out.println(b.customer + "'s booking cancelled.");
        } else {
            System.out.println("Cancellation not allowed.");
        }
    }
}

public class CampusPremiereTicketCounter {
    public static void main(String[] args) {
        Show show = new Show();

        Booking a = show.book("Asha",
                new String[]{"A1", "A2", "F5"},
                new Seat[]{new Regular(), new Regular(), new Premium()});

        show.book("Ravi", new String[]{"A2"},
                new Seat[]{new Regular()});

        show.book("Ravi", new String[]{"R1"},
                new Seat[]{new Recliner()});

        show.cancel(a, false);

        show.book("Neha", new String[]{"A2"},
                new Seat[]{new Regular()});
    }
}
