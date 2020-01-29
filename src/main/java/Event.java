public class Event extends Task {
    String by;

    public Event(String description, String time) {
        super(description);
        this.by = time;
    }

    @Override
    public String saveFormat() {
        return "E" + super.saveFormat() + "," + by;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (Sat: " + by + ")";
    }


}
