import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

            }
            System.out.println("  " + input);
        }
    }
}
