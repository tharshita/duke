import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //initialize item array
        ArrayList<String> items = new ArrayList<String>();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello I'm \n" + logo + "\nWhat can I do for you?");
        while(sc.hasNext()) {
            String input = sc.next();

            if(input.toLowerCase().contains("bye")) {
                //exit when "bye"
                System.out.println("  " + "Bye. Hope to see you again soon!");
                break;

            } else if(input.equalsIgnoreCase("list")) {
                for(int i=0; i < items.size(); i++) {
                    //print out everything one by one
                    System.out.println(i+1 + ". " + items.get(i));
                }

            } else{
                //add item if not goodbye
                items.add(input);
                System.out.println("  added: " + input);
            }

        }
    }
}
