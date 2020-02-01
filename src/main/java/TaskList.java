import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents tasklist that contains list of tasks and actions to modify list.
 */
public class TaskList {
    private ArrayList<Task> tasks;
    private Ui ui;

    public TaskList(ArrayList<Task> tasks, Ui ui) {
        this.tasks = tasks;
        this.ui = ui;
    }

    public TaskList(Ui ui) {
        this.ui = ui;
    }
    /**
     * Lists all tasks in chronological order.
     */
    public void list() {
        for (int i = 0; i < tasks.size(); i++) {
            //print out everything one by one
            Task curr = (Task) tasks.get(i);
            System.out.println(i + 1 + ". " + curr);
        }
    }

    /**
     * Deletes specified task.
     * @param index specifies the task to be deleted.
     */
    public void delete(int index) {
        //get task number and delete task from arraylist
        Task deleted = (Task) tasks.remove(index - 1);
        ui.delete(deleted, tasks.size());
    }

    /**
     * Concatenates all tasks in string format.
     */
    public String tasksToString() {
        String taskStr = "";
        for (Task task: tasks) {
            taskStr += task.saveFormat() + "\n";
        }
        return taskStr;
    }

    /**
     * Checks the task specified and marks it as completed.
     * @param eventNum specified task that has been completed.
     */
    public void done(int eventNum) {
        Task curr = (Task) tasks.get(eventNum - 1);
        curr.markAsDone();
        ui.done(curr);
    }

    /**
     * Adds atodo task to the tasklist.
     * @param input description of task.
     */
    public void addTodo(String input) {
        Task newTodo = new Todo(input);
        tasks.add(newTodo);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTodo);
    }

    /**
     * Adds a deadline task to the tasklist.
     * @param input description of task including date.
     */
    public void addDeadline(String input) {
        String[] inputArr = input.split(" /by ");
        Task newDeadline = new Deadline(inputArr[0], LocalDate.parse(inputArr[1])); //catch indexoutofboundserror
        tasks.add(newDeadline);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newDeadline);
    }

    /**
     * Adds an event task to the tasklist.
     * @param input description of task including date.
     */
    public void addEvent(String input) {
        String[] inputArr = input.split(" /at ");
        Task newEvent = new Event(inputArr[0], inputArr[1]);
        tasks.add(newEvent);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newEvent);
    }

    /**
     * Returns number of items in the task list.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Finds tasks with matching keyword and lists them.
     * @param keyword to match.
     */
    public void find(String keyword) {
        ArrayList<Task> foundList = new ArrayList<Task>();
        for (Task t: tasks) {
            if (t.getDescription().contains(keyword)) {
                foundList.add(t);
            }
        }
        ui.found(foundList);
        for (int i = 0; i < foundList.size(); i++) {
            Task t = foundList.get(i);
            System.out.println(i + 1 + ". " + t);
        }
    }

}
