import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Duke {
    public static void main(String[] args) throws DukeException {
        Scanner sc = new Scanner(System.in);
        //initialize item array
        ArrayList<Task> tasks = new ArrayList<Task>();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello I'm \n" + logo + "\nWhat can I do for you?");
        while(sc.hasNextLine()) {
            String instr = sc.next();

            if(instr.toLowerCase().contains("bye")) {
                //exit when "bye"
                System.out.println("  " + "Bye. Hope to see you again soon!");
                break;

            } else if(instr.equalsIgnoreCase("list")) {
                //loop through tasks array to list
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < tasks.size(); i++) {
                    //print out everything one by one
                    Task curr = tasks.get(i);
                    System.out.println(i + 1 + ". " + curr);
                }
            }else if(instr.contains("delete")) {
                //get task number and delete task frokm arraylist
                int eventNum = sc.nextInt();
                Task deleted = tasks.remove(eventNum-1);
                System.out.println("Noted. I've removed this task:");
                System.out.println("  " + deleted);
                System.out.printf("Now you have %d tasks in the list.\n", tasks.size());

            }else if(instr.contains("done")) {
                //get task number and change isDone to true
                int eventNum = sc.nextInt();
                Task curr = tasks.get(eventNum-1);
                curr.markAsDone();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println("  " + curr);

            }else{
                try {
                    String input = sc.nextLine();
                    //add items to tasks array
                    if (instr.equalsIgnoreCase("todo")) {
                        if (!input.isEmpty()) {
                                Task newTodo = new Todo(input);
                                tasks.add(newTodo);
                                System.out.println("Got it. I've added this task:");
                                System.out.println("  " + newTodo);
                        } else {
                            throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
                        }


                    } else if (instr.equalsIgnoreCase("deadline")) {
                        if(!input.isEmpty()) {
                            String[] inputArr = input.split(" /by ");
                            Task newDeadline = new Deadline(inputArr[0], LocalDate.parse(inputArr[1])); //catch indexoutofboundserror
                            tasks.add(newDeadline);
                            System.out.println("Got it. I've added this task:");
                            System.out.println("  " + newDeadline);
                        }else{
                            throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
                        }

                    } else if (instr.equalsIgnoreCase("event")) {
                        if(!input.isEmpty()) {
                            String[] inputArr = input.split(" /at ");
                            Task newEvent = new Event(inputArr[0], inputArr[1]);
                            tasks.add(newEvent);
                            System.out.println("Got it. I've added this task:");
                            System.out.println("  " + newEvent);
                        }else{
                            throw new DukeException("OOPS!!! The description of a event cannot be empty.");
                        }

                    } else {
                        //instruction does not exist
                        throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                    System.out.printf("Now you have %d tasks in the list.\n", tasks.size());
                }catch(DukeException ex) {
                    //catch exceptions thrown and print out message for user
                    System.out.println(ex);
                }
            }

        }
    }
}
