<<<<<<< HEAD
/**
 * Deals with interactions with the user.
 */
=======
import java.util.ArrayList;

>>>>>>> branch-Level-9
public class Ui {
    private String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    public Ui() {
        
    }

    /**
     * Greets user.
     */
    public void sayHi() {
        System.out.println("Hello I'm \n" + logo + "\nWhat can I do for you?");
    }

    /**
     * Greets user and ends session.
     */
    public void sayBye() {
        System.out.println("  " + "Bye. Hope to see you again soon!");
    }

    /**
     * Introduces list.
     */
    public void list() {
        System.out.println("Here are the tasks in your list:");
    }

    /**
     * Informs user of deleted task.
     * @param deleted task that has been deleted from list.
     * @param size total number of tasks.
     */
    public void delete(Task deleted, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + deleted);
        System.out.printf("Now you have %d tasks in the list.\n", size);
    }

    /**
     * Marks current task as done.
     * @param curr task to be marked as done.
     */
    public void done(Task curr) {
        System.out.println("Nice! I've marked this task as done: ");
        System.out.println("  " + curr);
    }

    public void found(ArrayList list) {
        if (!list.isEmpty()) {
            System.out.println("Here are the matching tasks in your list:");
        } else {
            System.out.println("There are no matching tasks in your list :(");
        }
    }
}
