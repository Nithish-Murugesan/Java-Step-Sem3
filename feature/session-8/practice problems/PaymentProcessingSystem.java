
interface PaymentMethod {
    boolean processPayment();
}

class CreditCardPayment implements PaymentMethod {
    public boolean processPayment() {
        return true;
    }
}

class PayPalPayment implements PaymentMethod {
    public boolean processPayment() {
        return false;
    }
}

class Order {
    String customer;
    int items;
    double amount;
    String status = "Pending";

    Order(String customer, int items, double amount) {
        this.customer = customer;
        this.items = items;
        this.amount = amount;
        System.out.println("Order created for " + customer);
    }

    void pay(PaymentMethod method) {
        if (items <= 0) {
            System.out.println("Cannot process payment for an empty order");
            return;
        }

        if (method.processPayment()) {
            status = "Paid";
            System.out.println("Payment successful");
        } else {
            System.out.println("Payment failed");
        }

        System.out.println("Order status: " + status);
    }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        Order a = new Order("Customer X", 2, 500);
        a.pay(new CreditCardPayment());

        Order b = new Order("Customer Y", 0, 0);
        b.pay(new CreditCardPayment());

        Order c = new Order("Customer Z", 1, 300);
        c.pay(new PayPalPayment());
    }
}
