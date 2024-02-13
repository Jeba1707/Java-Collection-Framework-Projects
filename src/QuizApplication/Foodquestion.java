package QuizApplication;

public class Foodquestion extends Question{
    public Foodquestion(String question, String option1, String option2, String option3, String correctAns) {
        super(question, option1, option2, option3, correctAns);
    }

    public Foodquestion(String question, String correctAns) {
        super(question, correctAns);
    }

    public Foodquestion() {
    }
}
