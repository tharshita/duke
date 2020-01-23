public class Deadline extends Task {
    String by;

    public Deadline(String description, String time) {
        super(description);
        this.by = time;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }


}
