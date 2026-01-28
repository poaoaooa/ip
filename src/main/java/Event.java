public class Event extends Task{
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (from: " + this.from + " to: " + this.to + ")";
    }

    public String saveString() {
        String doner = "[ ]";
        if (super.isDone) {
            doner = "[X]";
        }
        return doner + "event " + super.description +
                " /from "+this.from+ " /to "+this.to;
    }

}
