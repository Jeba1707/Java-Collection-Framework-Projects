package TaskManager;

import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        TaskManager taskManager = new TaskManager();
        String file = "E:\\\\Study\\\\JavaProjects\\\\Java Collection Framework Projects\\\\src\\\\TaskManager\\\\tasks.txt";
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        Formatter formatter = new Formatter(file);

//        bufferedWriter.write("Tasks List");
//        bufferedWriter.close();

        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
//        System.out.println(bufferedReader.readLine());


        System.out.println("**Welcome to My Task Manager**");

        int count = 1;
        while(count==1){
            System.out.println("1.Add Task \n2.View Tasks \n3.Mark as complete \n4.Delete a Task \n0.Exit");

            int option = 10;
            try {
                Scanner sc = new Scanner(System.in);
            System.out.print("Enter your Option:");
           option = sc.nextInt();

            }
            catch (Exception e){
                e.getMessage();
                System.out.println("Please enter an integer");
                count =1;
                continue;
            }

       switch (option){
           case 1:{
               Task task = new Task();
               Scanner sc = new Scanner(System.in);
               System.out.print("Enter task: ");
               task.setName(sc.nextLine());
               System.out.print("Enter task description: ");
               task.setDescription(sc.nextLine());
               System.out.print("Enter due date :");
               task.setDueDate(sc.nextLine());
               formatter.format(taskManager.addTask(task));
               formatter.close();

               // got error need to fix here

               System.out.println("Task added Successfull");
               count = 1;
               break;
           }case 2:{
               System.out.println(bufferedReader.readLine());

               count = 1;
               break;
           }case 3:{
               break;
           }case 4:{
               break;
           }case 0:{
               count = 0;
               break;
           } default:{
               System.out.println("Entered wrong option , please try again.");
               count = 1;
               break;
           }
       }
        }

    }
}
