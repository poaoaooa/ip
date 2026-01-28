package lonely.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    protected LocalDate from;
    protected LocalDate to;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy");

    public Event(String description, String from, String to) {
        super(description);
        this.from = LocalDate.parse(from);
        this.to = LocalDate.parse(to);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (from: " +
                this.from.format(FORMATTER) + " to: " + this.to.format(FORMATTER) + ")";
    }

    public String saveString() {
        String doner = "[ ]";
        if (super.isDone) {
            doner = "[X]";
        }
        return doner + "event " + super.description +
                " /from "+this.from.format(FORMATTER) + " /to "
                + this.to.format(FORMATTER);
    }

}
