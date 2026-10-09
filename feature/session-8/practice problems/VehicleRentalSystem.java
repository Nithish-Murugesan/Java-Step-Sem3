
abstract class Vehicle {
    String name;
    boolean available = true;

    Vehicle(String name) {
        this.name = name;
    }

    abstract double charge(int days);
}

class Sedan extends Vehicle {
    Sedan(String name) {
        super(name);
    }

    double charge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {
    SUV(String name) {
        super(name);
    }

    double charge(int days) {
        return days * 80;
    }
}

public class VehicleRentalSystem {
    static void rent(String customer, Vehicle v, int days) {
        if (v.available) {
            v.available = false;
            System.out.println(v.name + " rented by " + customer);
            System.out.println("Charge: $" + v.charge(days));
        } else {
            System.out.println(v.name + " is currently unavailable");
        }
    }

    static void returnVehicle(String customer, Vehicle v) {
        v.available = true;
        System.out.println(v.name + " returned by " + customer);
    }

    public static void main(String[] args) {
        Vehicle sedan = new Sedan("Sedan A");
        Vehicle suv = new SUV("SUV B");

        rent("Customer 1", sedan, 3);
        rent("Customer 2", sedan, 2);
        returnVehicle("Customer 1", sedan);
        rent("Customer 3", suv, 5);
    }
}
