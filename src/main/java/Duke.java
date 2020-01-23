import java.util.ArrayList;
import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
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
            }else if(instr.contains("done")) {
                //task number and change isDone to true
                int eventNum = sc.nextInt();
                Task curr = tasks.get(eventNum-1);
                curr.markAsDone();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println("  " + curr);

            }else{
                String input = sc.nextLine();
                //add items to tasks array
                if(instr.equalsIgnoreCase("todo")){
                    Task newTodo = new Todo(input);
                    tasks.add(newTodo);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + newTodo);

                }else if(instr.equalsIgnoreCase("deadline")) {
                    String[] inputArr = input.split(" /by ");
                    Task newDeadline = new Deadline(inputArr[0],inputArr[1]);
                    tasks.add(newDeadline);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + newDeadline);

                }else if(instr.equalsIgnoreCase("event")) {
                    String[] inputArr = input.split(" /at ");
                    Task newEvent = new Event(inputArr[0],inputArr[1]);
                    tasks.add(newEvent);
                    System.out.println("Got it. I've added this task:");
                    System.out.println("  " + newEvent);

                }else{
                    //instruction does not exist
                    break;
                }
                System.out.printf("Now you have %d tasks in the list.\n",tasks.size());

            }

        }
    }
}
