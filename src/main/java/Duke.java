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
            String input = sc.nextLine();

            if(input.toLowerCase().contains("bye")) {
                //exit when "bye"
                System.out.println("  " + "Bye. Hope to see you again soon!");
                break;

            } else if(input.equalsIgnoreCase("list")) {
                //loop through tasks array to list
                for (int i = 0; i < tasks.size(); i++) {
                    //print out everything one by one
                    Task curr = tasks.get(i);
                    System.out.println(i + 1 + ". [" + curr.getStatusIcon() + "] " + curr.getDescription());
                }
            }else if(input.contains("done")) {
                //task number and change isDone to true
                String[] arr = input.split(" ");
                int eventNum = Integer.parseInt(arr[1]);
                Task curr = tasks.get(eventNum-1);
                curr.markAsDone();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println("  " + "[" + curr.getStatusIcon() + "] " + curr.getDescription());

            }else{
                //add item if not goodbye
                tasks.add(new Task(input));
                System.out.println("  added: " + input);
            }

        }
    }
}
