import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ArrayList;
import java.nio.charset.Charset;


public class Storage {
    private String directory = System.getProperty("user.home");
    private String fileName = "tasks.txt";
    private Path path = Paths.get(directory, "Desktop", "duke", "data", fileName);

    private ArrayList<Task> tasks;

    public Storage() {
        tasks = new ArrayList<>();
    }

    public void writeToFile(String content) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(path);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            // exception handling
            System.out.println(e);
        }
    }
    
    public ArrayList<Task> readFile() {
        try {
            List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
            System.out.println(lines);
//            lines.forEach(System.out::println);

            for (int i = 0; i < lines.size(); i++) {
                System.out.println("here");
                String curr = lines.get(i);
                String[] data = curr.split(",");

                if (data[0].equals("T")) {
                    Task ntodo = new Todo(data[2]);
                    if(data[1].equals("true")) {
                        ntodo.markAsDone();
                    }
                    tasks.add(ntodo);
                } else if (data[0].equals("D")) {
                    Task deadline = new Deadline(data[2], data[3]);
                    if(data[1].equals("true")) {
                        deadline.markAsDone();
                    }
                    tasks.add(deadline);
                } else if (data[0].equals("E")) {
                    Task event = new Event(data[2], data[3]);
                    if (data[1].equals("true")) {
                        event.markAsDone();
                    }
                    tasks.add(event);
                } else {
                    continue;
                }
            }
            System.out.println(tasks);
        } catch (IOException e) {
            System.out.println(e);
        }
        return tasks;
    }
}
