
interface MembershipPlan {
    int months();
    double discount();
}

class Monthly implements MembershipPlan {
    public int months() { return 1; }
    public double discount() { return 0; }
}

class Quarterly implements MembershipPlan {
    public int months() { return 3; }
    public double discount() { return 0.10; }
}

class Annual implements MembershipPlan {
    public int months() { return 12; }
    public double discount() { return 0.25; }
}

class Membership {
    String member;
    private String status = "Active";
    double fee;

    Membership(String member, MembershipPlan plan) {
        this.member = member;
        fee = 1000 * plan.months() * (1 - plan.discount());

        System.out.println(plan.getClass().getSimpleName()
                + " membership created for " + member);
        System.out.printf("Fee: Rs. %.2f%n", fee);
        System.out.println("Status: " + status);
    }

    void checkIn() {
        if (status.equals("Active"))
            System.out.println(member + " checked in successfully.");
        else
            System.out.println("Check-in denied: " + member
                    + "'s membership is " + status);
    }

    void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            System.out.println(member + "'s membership frozen.");
        } else {
            System.out.println("Cannot freeze a " + status + " membership.");
        }
    }

    void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member + "'s membership unfrozen.");
        } else {
            System.out.println("Cannot unfreeze a " + status + " membership.");
        }
    }

    void expire() {
        status = "Expired";
        System.out.println(member + "'s membership expired.");
    }
}

public class FitZoneMembershipDesk {
    public static void main(String[] args) {
        Membership a = new Membership("Asha", new Quarterly());
        Membership r = new Membership("Ravi", new Monthly());

        a.checkIn();
        a.freeze();
        a.checkIn();

        r.expire();
        r.freeze();
    }
}
