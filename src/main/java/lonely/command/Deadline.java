package lonely.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected LocalDate by;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy");

    Deadline(String description, String by) {
        super(description);
        this.by = LocalDate.parse(by);
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
        return "[D]" + super.toString() + " (by: " + this.by.format(FORMATTER) + ")";
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
        return doner + "deadline " + super.description +
                " /by " + this.by.format(FORMATTER);
    }
}
