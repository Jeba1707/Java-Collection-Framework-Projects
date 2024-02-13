package QuizApplication;


import java.util.ArrayList;
import java.util.List;

public class QuizApp {

    private List<Question> gKquestions;
    private List<Question> historyquestions;
    private List<Question> mathquetions;
    private List<Question> foodquestions;

    public QuizApp() {
        this.gKquestions = new ArrayList<>();
        this.historyquestions = new ArrayList<>();
        this.mathquetions = new ArrayList<>();
        this.foodquestions = new ArrayList<>();
    }

    public void addQuestion(Question question){

        if(question instanceof GKquestion){
            gKquestions.add(question);
        } else if (question instanceof Historyquestion) {
            historyquestions.add(question);
        }else if (question instanceof Mathquetion) {
            mathquetions.add(question);
        }else if (question instanceof Foodquestion) {
            foodquestions.add(question);
        }

    }


}
