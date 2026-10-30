import java.util.Scanner;

class Node {
    String name;
    Node prev;
    Node next;

    Node(String name) {
        this.name = name;
        prev = null;
        next = null;
    }
}

public class TrainCoaches {
    Node head = null;
    Node tail = null;

    void addLast(String name) {
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void remove(String name) {
        Node temp = head;

        while (temp != null) {
            if (temp.name.equals(name)) {

                if (temp == head) {
                    head = temp.next;
                } else {
                    temp.prev.next = temp.next;
                }

                if (temp == tail) {
                    tail = temp.prev;
                } else {
                    temp.next.prev = temp.prev;
                }

                return;
            }

            temp = temp.next;
        }
    }

    void printForward() {
        Node temp = head;

        System.out.print("Forward: ");

        while (temp != null) {
            System.out.print(temp.name);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }

        System.out.println();
    }

    void printBackward() {
        Node temp = tail;

        System.out.print("Backward: ");

        while (temp != null) {
            System.out.print(temp.name);
            if (temp.prev != null) {
                System.out.print(" <-> ");
            }
            temp = temp.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TrainCoaches train = new TrainCoaches();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            train.addLast(sc.next());
        }

        String removeName = sc.next();

        train.remove(removeName);

        train.printForward();
        train.printBackward();

        sc.close();
    }
}
