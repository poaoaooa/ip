package lonely.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");
    private static final DateTimeFormatter REFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    protected LocalDate from;
    protected LocalDate to;
    Event(String description, String from, String to) {
        super(description);
        this.from = LocalDate.parse(from);
        this.to = LocalDate.parse(to);
    }

    /**
     * Returns a formatted string representation of this task.
     *
     * @return formatted task string
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: "
                + this.from.format(FORMATTER) + " to: " + this.to.format(FORMATTER) + ")";
    }

    /**
     * Returns custom string notation of object to be
     * saved in txt file
     *
     * @return Custom string representation of object
     */
    @Override
    protected String saveString() {
        String doner = "[ ]";
        if (super.isDone) {
            doner = "[X]";
        }
        // Chatgpt caught a bug with me using
        // FORMATTER INSTEAD OF REFORMATTER FOR SAVING
        return doner + "event " + super.description
                + " /from " + this.from.format(REFORMATTER) + " /to "
                + this.to.format(REFORMATTER);
    }

}
