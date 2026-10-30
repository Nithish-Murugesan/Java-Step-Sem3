import java.util.*;

public class ClassMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<int[]> marksList = new ArrayList<>();

        while (sc.hasNext()) {
            String name = sc.next();

            int[] marks = new int[3];
            marks[0] = sc.nextInt();
            marks[1] = sc.nextInt();
            marks[2] = sc.nextInt();

            names.add(name);
            marksList.add(marks);
        }

        int[] subjectTotals = new int[3];
        int topperIndex = 0;
        int highestTotal = -1;

        for (int i = 0; i < names.size(); i++) {
            int[] marks = marksList.get(i);
            int total = marks[0] + marks[1] + marks[2];

            System.out.println("Total " + names.get(i) + " " + total);

            for (int j = 0; j < 3; j++) {
                subjectTotals[j] += marks[j];
            }

            if (total > highestTotal) {
                highestTotal = total;
                topperIndex = i;
            }
        }

        if (!names.isEmpty()) {
            for (int i = 0; i < 3; i++) {
                double average = (double) subjectTotals[i] / names.size();
                System.out.printf("Average Subject%d %.2f%n", i + 1, average);
            }

            System.out.println("topper " + names.get(topperIndex)
                    + " (" + highestTotal + ")");
        }

        sc.close();
    }
}
