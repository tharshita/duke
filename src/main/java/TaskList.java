import java.time.LocalDate;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    private Ui ui;

    public TaskList(ArrayList<Task> tasks, Ui ui) {
        this.tasks = tasks;
        this.ui = ui;
    }

    public TaskList(Ui ui) {
        this.tasks = new ArrayList<Task>();
        this.ui = ui;
    }

    public void list() {
        for (int i = 0; i < tasks.size(); i++) {
            //print out everything one by one
            Task curr = (Task) tasks.get(i);
            System.out.println(i + 1 + ". " + curr);
        }
    }
    public void delete(int index) {
        //get task number and delete task from arraylist
        Task deleted = (Task) tasks.remove(index-1);
        ui.delete(deleted, tasks.size());
    }

    public String tasksToString() {
        String taskStr = "";
        for(Task task: tasks) {
            taskStr += task.saveFormat() + "\n";
        }
        return taskStr;
    }

    public void done(int eventNum) {
        Task curr = (Task) tasks.get(eventNum-1);
        curr.markAsDone();
        ui.done(curr);
    }

    public void addTodo(String input) {
        Task newTodo = new Todo(input);
        tasks.add(newTodo);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTodo);
    }

    public void addDeadline(String input) {
        String[] inputArr = input.split(" /by ");
        Task newDeadline = new Deadline(inputArr[0], LocalDate.parse(inputArr[1])); //catch indexoutofboundserror
        tasks.add(newDeadline);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newDeadline);
    }

    public void addEvent(String input) {
        String[] inputArr = input.split(" /at ");
        Task newEvent = new Event(inputArr[0], inputArr[1]);
        tasks.add(newEvent);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newEvent);
    }

    public int getSize() {
        return tasks.size();
    }


}
