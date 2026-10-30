import java.util.Scanner;

class Node {
    String name;
    Node next;

    Node(String name) {
        this.name = name;
        next = null;
    }
}

public class RoundRobinGame {
    Node tail = null;

    void addLast(String name) {
        Node newNode = new Node(name);

        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    void printTurns(int turns) {
        if (tail == null) {
            return;
        }

        Node current = tail.next;

        for (int i = 0; i < turns; i++) {
            System.out.print(current.name);

            if (i < turns - 1) {
                System.out.print(" ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RoundRobinGame game = new RoundRobinGame();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            game.addLast(name);
        }

        int turns = sc.nextInt();

        game.printTurns(turns);

        sc.close();
    }
}
