import java.util.*;

public class StudentClub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> students = new HashMap<>();

        while (sc.hasNext()) {
            String operation = sc.next();

            if (operation.equals("ADD")) {
                String roll = sc.next();
                String name = sc.next();

                if (students.containsKey(roll)) {
                    System.out.println("duplicate rejected");
                } else {
                    students.put(roll, name);
                    System.out.println("Added");
                }
            } else if (operation.equals("CONTAINS")) {
                String roll = sc.next();
                String name = sc.next();

                System.out.println("contains: " + students.containsKey(roll));
            }
        }

        System.out.println("member count " + students.size());
        sc.close();
    }
}
