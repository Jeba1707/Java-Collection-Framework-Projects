package QuizApplication;

import java.io.Serializable;

public class Question implements Serializable {
    private String question ;
    private String option1;
    private String option2;
    private String option3;
    private String correctAns;
    private  String typeOfQues ;
    public Question(String question, String option1, String option2, String option3, String correctAns) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctAns = correctAns;
        this.typeOfQues= "mcq";
    }

    public Question(String question,String correctAns) {
        this.question = question;
        this.correctAns=correctAns;
        this.typeOfQues="boolean";
    }

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public String getTypeOfQues() {
        return typeOfQues;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", correctAns='" + correctAns + '\'' +
                ", typeOfQues='" + typeOfQues + '\'' +
                '}';
    }
}
