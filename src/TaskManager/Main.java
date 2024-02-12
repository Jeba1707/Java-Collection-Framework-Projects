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

        //added tasks as demo
       Task t1 = new Task("Complete HomeWork","Homework","20 Feb 2024");
       Task t2 = new Task("Buy groceries","bread, butter","17 feb 2024");
       Task t3 = new Task("Clean the house","cleaning","17 feb 2024");
       taskManager.addTask(t1);
       taskManager.addTask(t2);
       taskManager.addTask(t3);

//        FileWriter writer1 = new FileWriter(file,true);
//        BufferedWriter bufferedWriter1 = new BufferedWriter(writer1);
//        bufferedWriter1.append(taskManager.addTask(t1));
//        bufferedWriter1.newLine();
//        bufferedWriter1.append(taskManager.addTask(t2));
//       bufferedWriter1.newLine();
//        bufferedWriter1.append(taskManager.addTask(t3));
//        bufferedWriter1.newLine();
//        bufferedWriter1.close();

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
               FileWriter writer = new FileWriter(file,true);
               BufferedWriter bufferedWriter = new BufferedWriter(writer);
               Task task = new Task();
               Scanner sc = new Scanner(System.in);
               System.out.print("Enter task: ");
               task.setName(sc.nextLine());
               System.out.print("Enter task description: ");
               task.setDescription(sc.nextLine());
               System.out.print("Enter due date :");
               task.setDueDate(sc.nextLine());

               bufferedWriter.append(taskManager.addTask(task));
               bufferedWriter.newLine();
               bufferedWriter.close();
               // got error need to fix here

               System.out.println("Task added Successfull");
               count = 1;
               break;
           }case 2:{
               FileReader reader = new FileReader(file);
               BufferedReader bufferedReader = new BufferedReader(reader);
               String line;
               // Read lines until there are no more lines left
               while ((line = bufferedReader.readLine()) != null) {
                   System.out.println(line); // Print each line
               }

               bufferedReader.close();
               count = 1;
               break;
           }case 3:{
               Scanner sc = new Scanner(System.in);
               System.out.print("Enter Task name to mark complete : ");

               String key  = taskManager.completeTask(sc.nextLine());
                 if(key!=" ") {
                     System.out.println("Congrats! Your given task is completed");
                     BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                     StringBuilder stringBuilder = new StringBuilder();
                     String line;

                     while ((line = bufferedReader.readLine()) != null) {
                         // If it's the line to change, replace it with the new content
                         if (line.contains(key)) {
                             line = line.replace("Pending", "Completed");
                             stringBuilder.append(line).append("\n");
                         } else {
                             // Otherwise, keep the existing line
                             stringBuilder.append(line).append("\n");
                         }
                     }
                     bufferedReader.close();
                     // Write the modified content back to the file
                     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                     bufferedWriter.write(stringBuilder.toString());
                     bufferedWriter.close();
                 }else
                 {
                     System.out.println("No task found , Entered wrong task name.");
                 }
               // Write the modified content back to the file

               count = 1;
               break;
           }case 4:{
               Scanner sc = new Scanner(System.in);
               System.out.print("Enter Task name to Delete : ");

               String key  = taskManager.deleteTask(sc.nextLine());
               if(key!=" ") {
                   System.out.println("Your given task is deleted");
                   BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                   StringBuilder stringBuilder = new StringBuilder();
                   String line;

                   while ((line = bufferedReader.readLine()) != null) {
                       // If it's the line to change, replace it with the new content
                       if (line.contains(key)) {
                          line= line.replace(line,"");
                           stringBuilder.append(line).append("\n");
                       } else {
                           // Otherwise, keep the existing line
                           stringBuilder.append(line).append("\n");
                       }

                   }
                   bufferedReader.close();

                   // Write the modified content back to the file
                   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                   bufferedWriter.write(stringBuilder.toString());
                   bufferedWriter.close();
               }else
               {
                   System.out.println("No task found , Entered wrong task name.");
               }
               count = 1;
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
