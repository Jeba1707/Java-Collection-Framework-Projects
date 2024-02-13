package QuizApplication;

import java.util.Scanner;

public class Main {
    private static String mathfile = "E:\\Study\\JavaProjects\\Java Collection Framework Projects\\src\\QuizApplication\\math.ser";
    private static String gkfile = "E:\\Study\\JavaProjects\\Java Collection Framework Projects\\src\\QuizApplication\\gk.ser";
    private static String foodfile = "E:\\Study\\JavaProjects\\Java Collection Framework Projects\\src\\QuizApplication\\food.ser";
    private static String historyfile = "E:\\Study\\JavaProjects\\Java Collection Framework Projects\\src\\QuizApplication\\history.ser";
   private static QuizApp quizApp = new QuizApp(mathfile,gkfile,foodfile,historyfile);
   private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {



        //creating and Adding GkQues
        Question gk1 = new GKquestion("What is the capital of France?","A.London", "B. Paris", "C.Rome","B");
        Question gk2 = new GKquestion(  "What is the largest planet in our solar system?","A. Jupiter", "B. Saturn", "C. Earth","A");
        Question gk3 = new GKquestion("Who wrote 'Romeo and Juliet'?","A. Charles Dickens", "B. Jane Austen", "C. William Shakespeare","C");
        Question gk4 = new GKquestion("True or False: The Earth is flat.","False");
        Question gk5 = new GKquestion(  "What is the chemical symbol for water?","A. H2O", "B. CO2", "C. O2","A" );

       // quizApp.addinList(gk1); quizApp.addinList(gk2); quizApp.addinList(gk3); quizApp.addinList(gk4); quizApp.addinList(gk5);


        Question food1 = new Foodquestion("What is the most consumed fruit in the world?","A.Banana", "B. Mango", "C.Orange","A");
        Question food2 = new Foodquestion(  "Which country is responsible for creating hot sauce?","A. China", "B. Mexico", "C. Japan","B");
        Question food3 = new Foodquestion("Orange is a rich source of which vitamin?","A. Vitamin A", "B. Vitamin B", "C. Vitamin C","C");
        Question food4 = new Foodquestion("True or False: Gelatin is the base ingredient of gummy bears.","True");
        Question food5 = new Foodquestion(  "Rice is mainly composed of which nutrient?","A. Fat", "B. carbohydrate", "C. protein","B" );

       // quizApp.addinList(food1); quizApp.addinList(food2); quizApp.addinList(food3); quizApp.addinList(food4); quizApp.addinList(food5);

        Question his1 = new Historyquestion("What year did Bangladesh gain independence from Pakistan?","A.1965", "B. 1971", "C.1952","B");
        Question his2 = new Historyquestion(  "Who is known as the Father of the Nation in Bangladesh?","A.  Sheikh Mujibur Rahman", "B. Ziaur Rahman", "C.  A. K. Fazlul Huq","A");
        Question his3 = new Historyquestion("Who was the first President of Bangladesh?","A. Sheikh Mujibur Rahman", "B.  Ziaur Rahman", "C. Abdus Sattar","A");
        Question his4 = new Historyquestion("True or False: Bangladesh was formerly known as East Pakistan.","True");
        Question his5 = new Historyquestion(  "True or False: The capital of Bangladesh, Dhaka, was indeed known as Jahangir Nagar during the Mughal period.","True" );

      // quizApp.addinList(his1); quizApp.addinList(his2); quizApp.addinList(his3); quizApp.addinList(his4); quizApp.addinList(his5);

        //creating and Adding Mathques
        Question math1 = new Mathquetion("What is the sum of 130+125+191?","A. 335", "B. 456", "C. 446","C");
        Question math2 = new Mathquetion(  "5: 20+(90÷2) is equal to:","A. 50", "B. 55", "C. 65","C");
        Question math3 = new Mathquetion(" The product of 82 and 5 is:","A. 400", "B. 410", "C. 420","B");
        Question math4 = new Mathquetion("True or False: The product of 121 x 0 x 200 x 25 is 0","True");
        Question math5 = new Mathquetion(  "True or False: -10 is a whole number.","False" );

       // quizApp.addinList(math1); quizApp.addinList(math2); quizApp.addinList(math3); quizApp.addinList(math4); quizApp.addinList(math5);

//        //quizApp.viewQuetions();
//        quizApp.viewGKQuetions();
//        quizApp.viewMathQuetions();
   // quizApp.viewGKQuetions();

        quizApp.viewHistoryQuetions();
        quizApp.viewMathQuetions();
        quizApp.viewFoodQuetions();
        quizApp.viewGKQuetions();



    }
}
