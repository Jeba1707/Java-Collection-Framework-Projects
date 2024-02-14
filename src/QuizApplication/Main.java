package QuizApplication;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private static String mathfile = "E:\\Study\\JavaProjects\\Java Collection Framework Projects\\src\\QuizApplication\\math.ser";
    private static String gkfile = "E:\\Study\\JavaProjects\\Java Collection Framework Projects\\src\\QuizApplication\\gk.ser";
    private static String foodfile = "E:\\Study\\JavaProjects\\Java Collection Framework Projects\\src\\QuizApplication\\food.ser";
    private static String historyfile = "E:\\Study\\JavaProjects\\Java Collection Framework Projects\\src\\QuizApplication\\history.ser";
   private static QuizApp quizApp = new QuizApp(mathfile,gkfile,foodfile,historyfile);

    public static void main(String[] args) {

//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("Time is out.");
//             //   this.cancel();
//            }
//        };

//        Scanner scanner = new Scanner(System.in);
//        Timer timer = new Timer();
//        QuestionTask questionTask = new QuestionTask(scanner);
         Scanner sc = new Scanner(System.in);
        System.out.println("********Welcome to my Mini Quiz game**********");

        int count = 1;
        while (count ==1){


               System.out.println("You will get 40 second to answer 5 questions from any of these topic .");
            System.out.println("Choose a Topic to play :");
            System.out.println("1.GK \t2.Math \t3.History \t4.Food");
           System.out.print("Choose an option :");
            String option = sc.nextLine();
            switch (option) {

                case "1": {
                  //  timer.schedule(task,40000);
                    int score = quizApp.startTest("GK");
                    //timer.cancel();
                    System.out.println("Your Final Score is :" + score);
                    count = 0;
                    break;
                }
                case "2": {
                   // timer.schedule(task,40000);
                    int score = quizApp.startTest("Math");

                    System.out.println("Your Final Score is :" + score);
                    //timer.cancel();
                    count = 0;
                     break;
                }
                case "3": {
                  //  timer.schedule(task,40000);
                    int score = quizApp.startTest("History");
                    System.out.println("Your Final Score is :" + score);
                   // timer.cancel();
                    count = 0;
                     break;
                }
                case "4": {
                 //   timer.schedule(task,40000);
                    int score = quizApp.startTest("Food");
                    System.out.println("Your Final Score is :" + score);
                   // timer.cancel();
                    count = 0;
                     break;
                }
                default: {
                    System.out.println("Entered wrong option .Try again");


                }


            }

          /// count = 2;
//          count = 2;
        }

    }

    public static void timer(){


    }
    // TimerTask to handle timing out questions
//    static class QuestionTask extends TimerTask {
//        private final Scanner scanner;
//
//        public QuestionTask(Scanner scanner) {
//            this.scanner = scanner;
//        }
//
//        @Override
//        public void run() {
//            System.out.println("Time's up!");
//            System.out.println("Please answer the question.");
//            // Here you could handle what happens when time is up, e.g., showing correct answer, etc.
//            // Then stop waiting for input and move to the next question
//            this.cancel();
//        }
//    }
    //got issues with the timer

}
