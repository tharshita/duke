public class Event extends Task {
    String by;

    public Event(String description, String time) {
        super(description);
        this.by = time;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + by + ")";
    }


}
