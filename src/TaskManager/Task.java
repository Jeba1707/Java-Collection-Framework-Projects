package TaskManager;

public class Task {
   private String name;
   private String description;
   private String dueDate;
   private  boolean completionStatus;

   private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(boolean completionStatus) {
        if(isCompletionStatus()==false){
            this.status = "Pending";
        }else
            this.status = "Completed";
    }

    public Task(String name, String description, String dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
       setCompletionStatus(false);
       setStatus(false);
    }

    public Task() {
        setCompletionStatus(false);
        setStatus(false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
        setStatus(completionStatus);
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", completionStatus=" + completionStatus +
                '}';
    }

}
