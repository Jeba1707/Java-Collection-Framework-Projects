package TaskManager;

import java.util.*;

public class TaskManager {
   public HashMap<String,Task> taskMap = new HashMap<>();

    public void addTask(Task task){
    taskMap.put(task.getName(),task);
    }

    public void viewTasks(){
        taskMap.forEach((key,val)->{
            String status ;
            if(val.isCompletionStatus()==false){
                status = "Pending";
            }else
                status = "Completed";

            System.out.print("Task:"+key+" Description:"+val.getDescription()+" Due Date:"+val.getDueDate()+" Status:"+status);
            System.out.println();
        });
    }

    public void completeTask(String taskName){
        int count = 1;
        for(Map.Entry<String,Task> entry:taskMap.entrySet()){
            if (taskName.equalsIgnoreCase(entry.getKey())) {
                entry.getValue().setCompletionStatus(true);
                count++;
                break;
            }
        }
        if(count>1){
            System.out.println("Congrats! Your given task is completed");
        }else
            System.out.println("No task found , Entered wrong task name.");
    }

    public void deleteTask(String taskName) {
        int count = 1;
        for (Map.Entry<String, Task> entry : taskMap.entrySet()) {
            if (taskName.equalsIgnoreCase(entry.getKey())) {
                taskMap.remove(entry.getKey());
                count++;
                break;
            }
        }
            if (count > 1) {
                System.out.println("Your given task is deleted");
            } else
                System.out.println("No task found , Entered wrong task name.");
        }


}
