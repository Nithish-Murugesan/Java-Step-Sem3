
import java.util.*;

interface NotificationChannel {
    void send(String student, String message);
}

class EmailChannel implements NotificationChannel {
    public void send(String student, String message) {
        System.out.println("[Email -> " + student + "] " + message);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String student, String message) {
        System.out.println("[SMS -> " + student + "] " + message);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String student, String message) {
        System.out.println("[App -> " + student + "] " + message);
    }
}

class Student {
    String name, department;
    List<NotificationChannel> channels = new ArrayList<>();

    Student(String name, String department) {
        this.name = name;
        this.department = department;
    }
}

class Notice {
    String title;
    Set<String> departments;

    Notice(String title, String... departments) {
        this.title = title;
        this.departments = new HashSet<>(Arrays.asList(departments));
    }
}

class NoticeBoard {
    List<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
    }

    void post(Notice n) {
        if (n.title == null || n.title.trim().isEmpty()) {
            System.out.println("Cannot post notice without a title.");
            return;
        }

        if (n.departments.isEmpty()) {
            System.out.println(
                    "Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.println("Notice '" + n.title + "' posted to "
                + String.join(", ", n.departments) + ".");

        for (Student s : students) {
            if (n.departments.contains(s.department)) {
                for (NotificationChannel c : s.channels) {
                    c.send(s.name, n.title);
                }
            }
        }
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        Student a = new Student("Asha", "CSE");
        a.channels.add(new EmailChannel());
        a.channels.add(new AppChannel());

        Student r = new Student("Ravi", "ECE");
        r.channels.add(new SmsChannel());

        board.addStudent(a);
        board.addStudent(r);

        board.post(new Notice("Lab Closed Tomorrow", "CSE"));
        board.post(new Notice("Fee Deadline Extended", "CSE", "ECE"));
        board.post(new Notice("Sports Day"));
    }
}
