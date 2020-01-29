import java.util.Scanner;

public class Duke {
    public static void main(String[] args) throws DukeException {
        //initialize
        Storage storage = new Storage();
        Ui userInterface = new Ui();

        TaskList taskList = new TaskList(storage.readFile(), userInterface);
        Parser parser = new Parser(userInterface, taskList, storage);

        userInterface.sayHi();

        parser.run();
    }


}
