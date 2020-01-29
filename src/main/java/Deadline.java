import java.time.LocalDate;

public class Deadline extends Task {
    LocalDate by;

    public Deadline(String description, LocalDate time) {
        super(description);
        this.by = time;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.getMonth() + " " + by.getDayOfMonth() + " " + by.getYear() + ")";
    }


}
