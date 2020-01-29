import java.util.Scanner;

/**
 * Handles user commands.
 */
public class Parser {
    private Scanner sc;
    private Ui ui;
    private TaskList taskList;
    private Storage storage;

    /**
     * Constructor for Parser.
     * @param ui ui instance.
     * @param taskList tasklist instance.
     * @param storage storage instance.
     */
    public Parser(Ui ui, TaskList taskList, Storage storage) {
        sc = new Scanner(System.in);
        this.ui = ui;
        this.taskList = taskList;
        this.storage = storage;
    }

    /**
     * Runs actions invoked by user input.
     * @throws DukeException  If invalid command such as empty command.
     */

    public void run() {
        while (sc.hasNextLine()) {
            String instr = sc.next();

            if (instr.toLowerCase().contains("bye")) {
                //exit when "bye"
                ui.sayBye();
                storage.writeToFile(taskList.tasksToString());
                break;

            } else if (instr.equalsIgnoreCase("list")) {
                //loop through tasks array to list
                ui.list();
                taskList.list();
            } else if (instr.contains("delete")) {
                int eventNum = sc.nextInt();
                taskList.delete(eventNum);

            } else if (instr.contains("done")) {
                //get task number and change isDone to true
                int eventNum = sc.nextInt();
                taskList.done(eventNum);

            } else if (instr.contains("find")) {
                String[] arr = instr.split(" ");
                String keyword = sc.nextLine();
                taskList.find(keyword);

            } else {
                try {
                    String input = sc.nextLine();
                    //add items to tasks array
                    if (instr.equalsIgnoreCase("todo")) {
                        if (!input.isEmpty()) {
                            taskList.addTodo(input);
                        } else {
                            throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
                        }

                    } else if (instr.equalsIgnoreCase("deadline")) {
                        if (!input.isEmpty()) {
                            taskList.addDeadline(input);
                        } else {
                            throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
                        }

                    } else if (instr.equalsIgnoreCase("event")) {
                        if (!input.isEmpty()) {
                            taskList.addEvent(input);
                        } else {
                            throw new DukeException("OOPS!!! The description of a event cannot be empty.");
                        }

                    } else {
                        //instruction does not exist
                        throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                    System.out.printf("Now you have %d tasks in the list.\n", taskList.getSize());
                } catch (DukeException ex) {
                    //catch exceptions thrown and print out message for user
                    System.out.println(ex);
                }
            }
        }
    }
}
