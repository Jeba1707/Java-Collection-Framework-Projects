package QuizApplication;

public class Historyquestion extends Question{
    public Historyquestion(String question, String option1, String option2, String option3, String correctAns) {
        super(question, option1, option2, option3, correctAns);
    }

    public Historyquestion(String question, String correctAns) {
        super(question, correctAns);
    }

    public Historyquestion() {
    }
}
