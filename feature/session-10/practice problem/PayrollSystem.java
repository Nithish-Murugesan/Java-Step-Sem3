import java.util.*;

class Staff {
    String name;
    String type;
    int pay;

    Staff(String name, String type, int pay) {
        this.name = name;
        this.type = type;
        this.pay = pay;
    }

    void display() {
        System.out.println("Payslip[name=" + name + ", type=" + type
                + ", pay=" + pay + "]");
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Staff> staffList = new ArrayList<>();

        while (sc.hasNext()) {
            String type = sc.next();
            String name = sc.next();
            int pay;

            if (type.equals("FullTime")) {
                pay = sc.nextInt();
            } else if (type.equals("PartTime")) {
                int hours = sc.nextInt();
                int rate = sc.nextInt();
                pay = hours * rate;
            } else if (type.equals("Intern")) {
                pay = sc.nextInt();
            } else {
                continue;
            }

            staffList.add(new Staff(name, type, pay));
        }

        int total = 0;
        int highestPay = -1;
        String topEarner = "";

        for (Staff s : staffList) {
            s.display();
            total += s.pay;

            if (s.pay > highestPay) {
                highestPay = s.pay;
                topEarner = s.name;
            }
        }

        System.out.println("Total " + total);
        System.out.println("top earner " + topEarner);

        sc.close();
    }
}
