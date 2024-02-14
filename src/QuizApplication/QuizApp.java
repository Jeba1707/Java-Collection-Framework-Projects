package QuizApplication;

import ContactManagementSystem.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class QuizApp {
  //  private  List<Question> allQuestion ;
    private List<Question> gKquestions;
    private List<Question> historyquestions;
    private List<Question> mathquetions;
    private List<Question> foodquestions;
    private  static Scanner sc = new Scanner(System.in);
    private String mathfile ;   private String gkfile ;   private String foodfile ;   private String historyfile ;


    public QuizApp(String mathfile,String gkfile,String foodfile,String historyfile) {

        this.gKquestions = new ArrayList<>();
        this.historyquestions = new ArrayList<>();
        this.mathquetions = new ArrayList<>();
        this.foodquestions = new ArrayList<>();
        this.mathfile=mathfile;
        this.gkfile=gkfile;
        this.foodfile=foodfile;
        this.historyfile=historyfile;

    }

    public void addinList(Question question){
      //  allQuestion.add(question);
        if(question instanceof GKquestion){
            gKquestions.add(question);
            saveGKQuesToFile();
        } else if (question instanceof Historyquestion) {
            historyquestions.add(question);
            saveHistoryQuesToFile();
        }else if (question instanceof Mathquetion) {
            mathquetions.add(question);
            saveMathQuesToFile();
        }else if (question instanceof Foodquestion) {
            foodquestions.add(question);
            saveFoodQuesToFile();
        }

       System.out.println("Question added successfully.");

    }

    public int generateQuetions(List<Question> list) {
        int score = 0;
        int count = 0;
        if (list.isEmpty()) {
            System.out.println("No question available.");
        } else {
            System.out.println("Questions:");
            for (Question question : list) {
                if(question.getTypeOfQues().equalsIgnoreCase("mcq")){
                count++;
                System.out.println(count + "." + question.getQuestion());
                System.out.println(question.getOption1() + "\t" + question.getOption2() + "\t" + question.getOption3());
                System.out.print("Ans :");
                String ans = sc.nextLine();

                if (ans.equalsIgnoreCase(question.getCorrectAns())) {
                    System.out.println("Correct answer");
                    System.out.println();
                    score++;
                } else {
                    System.out.println("Wrong Answer.Correct Option is " + question.getCorrectAns());
                    System.out.println();
                }} else if (question.getTypeOfQues().equalsIgnoreCase("boolean")) {
                    count++;
                    System.out.println(count + "." + question.getQuestion());
                    System.out.print("Ans :");
                    String ans = sc.nextLine();

                    if (ans.equalsIgnoreCase(question.getCorrectAns())) {
                        System.out.println("Correct answer");
                        System.out.println();
                        score++;
                    } else {
                        System.out.println("Wrong Answer.Correct Option is " + question.getCorrectAns());
                        System.out.println();
                    }
                }
            }
        }
        return score;
    }

    public int startTest(String topic){
        int score = 0;
      if(topic.equalsIgnoreCase("GK")){
          loadGKQuesFromFile();
          score  = generateQuetions(gKquestions);
      } else if (topic.equalsIgnoreCase("Math")) {
          loadMathQuesFromFile();
        score =   generateQuetions(mathquetions);
      }else if (topic.equalsIgnoreCase("History")) {
         loadHistoryQuesFromFile();
         score =  generateQuetions(historyquestions);
      }else if (topic.equalsIgnoreCase("Food")) {
          loadFoodQuesFromFile();
         score =  generateQuetions(foodquestions);
      }
      return score;
    }
    public void viewFoodQuetions() {
        System.out.println("FoodQues");
       loadFoodQuesFromFile();

        if (foodquestions.isEmpty()) {
            System.out.println("No question available.");
        } else {
            System.out.println("Questions:");
            for (Question question : foodquestions) {
                System.out.println(question.getQuestion());
            }
        }
    }public void viewMathQuetions() {
        System.out.println("MathQues");
        loadMathQuesFromFile();

        if (mathquetions.isEmpty()) {
            System.out.println("No question available.");
        } else {
            System.out.println("Questions:");
            for (Question question : mathquetions) {
                System.out.println(question.getQuestion());
            }
        }
    }public void viewHistoryQuetions() {
        System.out.println("HisQues");
       loadHistoryQuesFromFile();

        if (historyquestions.isEmpty()) {
            System.out.println("No question available.");
        } else {
            System.out.println("Questions:");
            for (Question question : historyquestions) {
                System.out.println(question.getQuestion());
            }
        }
    }

    private void saveMathQuesToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(mathfile))) {
            outputStream.writeObject(mathquetions);
        } catch (IOException e) {
            System.out.println("Error saving questions to file: " + e.getMessage());
        }
    }
    private void saveGKQuesToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(gkfile))) {
            outputStream.writeObject(gKquestions);
        } catch (IOException e) {
            System.out.println("Error saving questions to file: " + e.getMessage());
        }
    }
    private void saveFoodQuesToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(foodfile))) {
            outputStream.writeObject(foodquestions);
        } catch (IOException e) {
            System.out.println("Error saving questions to file: " + e.getMessage());
        }
    }
    private void saveHistoryQuesToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(historyfile))) {
            outputStream.writeObject(historyquestions);
        } catch (IOException e) {
            System.out.println("Error saving questions to file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadGKQuesFromFile() {
        File file = new File(gkfile);
        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(gkfile))) {
                gKquestions = (List<Question>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading Question from file: " + e.getMessage());
            }
        }
    }

    private void loadMathQuesFromFile() {
        File file = new File(mathfile);
        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(mathfile))) {
                mathquetions = (List<Question>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading Question from file: " + e.getMessage());
            }
        }
    }
    private void loadFoodQuesFromFile() {
        File file = new File(foodfile);
        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(foodfile))) {
                foodquestions = (List<Question>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading Question from file: " + e.getMessage());
            }
        }
    }
    private void loadHistoryQuesFromFile() {
        File file = new File(historyfile);
        if (file.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(historyfile))) {
                historyquestions = (List<Question>) inputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading Question from file: " + e.getMessage());
            }
        }
    }
}


