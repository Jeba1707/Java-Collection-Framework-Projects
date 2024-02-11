package TaskManager;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

    Task t1 = new Task("task1","hahahha","22 feb");
    Task t2 = new Task("task2","hahahha","24 feb");
    Task t3 = new Task("task3","hahahha","23 feb");


    taskManager.addTask(t1);
    taskManager.addTask(t2);
    taskManager.addTask(t3);
 //   taskManager.viewTasks();
    taskManager.completeTask("TAsk3");
    taskManager.viewTasks();
    taskManager.completeTask("TAsk5");
    taskManager.viewTasks();
    taskManager.deleteTask("task4");
    taskManager.viewTasks();

    }
}
