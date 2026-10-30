import java.util.*;

interface Chargeable {
    void bookCharging();
}

class Vehicle {
    String type;
    String passNumber;
    String owner;
    int fee;

    Vehicle(String type, String passNumber, String owner) {
        this.type = type;
        this.passNumber = passNumber;
        this.owner = owner;

        if (type.equals("Bike") || type.equals("EBike")) {
            fee = 300;
        } else {
            fee = 1000;
        }
    }
}

class ElectricVehicle extends Vehicle implements Chargeable {
    ElectricVehicle(String type, String passNumber, String owner) {
        super(type, passNumber, owner);
    }

    public void bookCharging() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

public class CampusVehicleSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        while (sc.hasNext()) {
            String operation = sc.next();

            if (operation.equals("PASS")) {
                String type = sc.next();
                String pass = sc.next();
                String owner = sc.next();

                Vehicle v;

                if (type.equals("EBike") || type.equals("ECar")) {
                    v = new ElectricVehicle(type, pass, owner);
                } else {
                    v = new Vehicle(type, pass, owner);
                }

                vehicles.add(v);
                System.out.println(pass + " (" + type + ") pass fee " + v.fee);
            } else if (operation.equals("CHARGE")) {
                String pass = sc.next();
                boolean found = false;

                for (Vehicle v : vehicles) {
                    if (v.passNumber.equals(pass)) {
                        found = true;

                        if (v instanceof Chargeable) {
                            ((Chargeable) v).bookCharging();
                        } else {
                            System.out.println(pass + " rejected: charging unsupported");
                        }

                        break;
                    }
                }

                if (!found) {
                    System.out.println("Vehicle not found");
                }
            }
        }

        sc.close();
    }
}
