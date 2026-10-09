
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Assignment {
    String title;
    int maxMarks;
    LocalDate dueDate;

    Assignment(String title, int maxMarks, LocalDate dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    abstract double penaltyPerDay();
}

class CodingAssignment extends Assignment {
    CodingAssignment(String t, int m, LocalDate d) {
        super(t, m, d);
    }

    double penaltyPerDay() { return 0.10; }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String t, int m, LocalDate d) {
        super(t, m, d);
    }

    double penaltyPerDay() { return 0.20; }
}

class Submission {
    String student;
    Assignment assignment;
    LocalDate date;
    private String status = "Submitted";

    Submission(String student, Assignment a, LocalDate date) {
        this.student = student;
        assignment = a;
        this.date = date;
        long late = Math.max(0, ChronoUnit.DAYS.between(a.dueDate, date));
        System.out.println(student + "'s submission for '" + a.title
                + "' received (" + late + " days late).");
    }

    void grade(int marks) {
        if (!status.equals("Submitted")) {
            System.out.println("Cannot grade again.");
            return;
        }

        long late = Math.max(0, ChronoUnit.DAYS.between(
                assignment.dueDate, date));
        double penalty = Math.min(1.0, late * assignment.penaltyPerDay());
        double result = Math.max(0, marks * (1 - penalty));

        status = "Graded";
        System.out.printf("%s graded: %.0f/%d%n",
                student, result, assignment.maxMarks);
        System.out.println("Status: " + status);
    }

    void resubmit() {
        if (status.equals("Graded"))
            System.out.println("Cannot resubmit: '" + assignment.title
                    + "' has already been graded.");
        else
            System.out.println("Submission updated.");
    }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        Assignment a1 = new CodingAssignment("Linked List Lab", 50,
                LocalDate.of(2026, 3, 10));
        Assignment a2 = new WrittenAssignment("Design Essay", 50,
                LocalDate.of(2026, 3, 12));

        Submission s1 = new Submission("Asha", a1,
                LocalDate.of(2026, 3, 10));
        Submission s2 = new Submission("Ravi", a2,
                LocalDate.of(2026, 3, 14));

        s1.grade(45);
        s2.grade(40);
        s1.resubmit();
    }
}
