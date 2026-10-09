
interface WashType {
    int duration();
    double charge();
}

class QuickWash implements WashType {
    public int duration() { return 30; }
    public double charge() { return 20; }
}

class NormalWash implements WashType {
    public int duration() { return 45; }
    public double charge() { return 30; }
}

class HeavyWash implements WashType {
    public int duration() { return 60; }
    public double charge() { return 45; }
}

class WashingMachine {
    String name;
    private boolean busy = false;

    WashingMachine(String name) {
        this.name = name;
    }

    boolean start(String student, WashType wash) {
        if (busy) {
            System.out.println(name + " is currently busy.");
            return false;
        }

        busy = true;
        System.out.println(wash.getClass().getSimpleName()
                + " started on " + name + " for " + student
                + " (" + wash.duration() + " min).");
        System.out.printf("Charge: Rs. %.2f%n", wash.charge());
        return true;
    }

    void complete() {
        if (busy) {
            busy = false;
            System.out.println(name + " cycle completed. Machine is now free.");
        }
    }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        m1.start("Asha", new QuickWash());
        m1.start("Ravi", new HeavyWash());
        m2.start("Ravi", new HeavyWash());

        m1.complete();
        m1.start("Neha", new NormalWash());
    }
}
