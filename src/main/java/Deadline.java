public class Deadline extends Task {
    String by;

    public Deadline(String description, String time) {
        super(description);
        this.by = time;
    }

    @Override
    public String saveFormat() {
        return "D" + super.saveFormat() + "," + by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }


}
