package lonely.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private static final DateTimeFormatter REFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");
    protected LocalDate by;

    Deadline(String description, String by) {
        super(description);
        this.by = LocalDate.parse(by);
    }

    /**
     * Returns a formatted string representation of this task.
     *
     * @return formatted task string
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by.format(FORMATTER) + ")";
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
        return doner + "deadline " + super.description
                + " /by " + this.by.format(REFORMATTER);
    }
}
