import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Creates an instance of storage, ui, tasklist and parser in the main.
 * Starts running the program.
 */

public class Duke extends Application {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    /**
     * Initialises variables and loads data.
     */
    public Duke() {
        ui = new Ui();
        storage = new Storage();
        try {
            tasks = new TaskList(storage.readFile(), ui);
            parser = new Parser(ui, tasks, storage);
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList(ui);
        }
    }

    /**
     * Runs duke programme.
     */
    public void run() {
        ui.sayHi();
        parser.run();
    }

    /**
     * Overrides the Application#start() method and provide a concrete implementation.
     * @param stage primary stage that JavaFX provides.
     */
    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
    }

    /**
     * Runs main programme.
     * @param args args passed by command line.
     */
    public static void main(String[] args) {
        new Duke().run();

    }


}
