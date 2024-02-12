package TaskManager;

import java.util.*;

public class TaskManager {

    public HashMap<String,Task> taskMap = new HashMap<>();

    public String addTask(Task task){
    taskMap.put(task.getName(),task);
     return "Task:"+task.getName()+" Description:"+task.getDescription()+" Due Date:"+task.getDueDate()+" Status:"+task.getStatus();
    }

    public void viewTasks(){
        taskMap.forEach((key,val)->{
            System.out.print("Task:"+key+" Description:"+val.getDescription()+" Due Date:"+val.getDueDate()+" Status:"+val.getStatus());
            System.out.println();
        });
    }

    public String completeTask(String taskName){

        for(Map.Entry<String,Task> entry:taskMap.entrySet()){
            if (taskName.equalsIgnoreCase(entry.getKey())) {
                entry.getValue().setCompletionStatus(true);
                return entry.getKey();
            }
        }
        return " ";
    }

    public String deleteTask(String taskName) {

        for (Map.Entry<String, Task> entry : taskMap.entrySet()) {
            if (taskName.equalsIgnoreCase(entry.getKey())) {
                taskMap.remove(entry.getKey());
                return entry.getKey();
            }
        }
        return " ";
    }

}
