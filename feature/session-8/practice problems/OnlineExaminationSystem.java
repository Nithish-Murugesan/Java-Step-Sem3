
import java.util.*;

abstract class Question {
    String answer;
    int marks;

    Question(String answer, int marks) {
        this.answer = answer;
        this.marks = marks;
    }

    abstract boolean check(String response);
}

class MCQ extends Question {
    MCQ(String answer, int marks) {
        super(answer, marks);
    }

    boolean check(String response) {
        return answer.equalsIgnoreCase(response);
    }
}

class TrueFalse extends Question {
    TrueFalse(String answer, int marks) {
        super(answer, marks);
    }

    boolean check(String response) {
        return answer.equalsIgnoreCase(response);
    }
}

class Attempt {
    Map<Integer, String> answers = new HashMap<>();
    boolean submitted = false;

    void answer(int number, String response) {
        if (!submitted) {
            answers.put(number, response);
            System.out.println("Answer recorded for Question " + number);
        } else {
            System.out.println("Cannot change answers for a submitted examination");
        }
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Question q1 = new MCQ("C", 5);
        Question q2 = new TrueFalse("False", 5);

        Attempt a = new Attempt();
        a.answer(1, "C");
        a.answer(2, "True");

        a.submitted = true;
        System.out.println("Examination submitted");

        int score = 0;
        if (q1.check(a.answers.get(1))) score += 5;
        if (q2.check(a.answers.get(2))) score += 5;

        System.out.println("Total score: " + score + "/10");
        a.answer(1, "A");
    }
}
