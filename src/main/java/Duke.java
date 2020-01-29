import java.util.Scanner;

/**
 * Creates an instance of storage, ui, tasklist and parser in the main.
 * Starts running the program.
 */

public class Duke {
    public static void main(String[] args) {
        //initialize
        Storage storage = new Storage();
        Ui userInterface = new Ui();

        TaskList taskList = new TaskList(storage.readFile(), userInterface);
        Parser parser = new Parser(userInterface, taskList, storage);

        userInterface.sayHi();

        parser.run();
    }


}
