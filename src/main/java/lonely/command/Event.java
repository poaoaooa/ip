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
     * Returns custom string notation of Object.
     * Overrides Task toString method, which has details of
     * task description and whether it is unmarked or not
     *
     * @return Custom string representation of object
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (from: "
                + this.from.format(FORMATTER) + " to: " + this.to.format(FORMATTER) + ")";
    }

    /**
     * Returns custom string notation of Object to be
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
        return doner + "event " + super.description
                + " /from " + this.from.format(FORMATTER) + " /to "
                + this.to.format(REFORMATTER);
    }

}
