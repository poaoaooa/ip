package lonely.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DoWithinPeriod extends Task {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");
    private static final DateTimeFormatter REFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    protected LocalDate between;
    // Use Chatgpt to find and a back variable name
    protected LocalDate to;

    DoWithinPeriod(String description, String between, String to) {
        super(description);
        this.between = LocalDate.parse(between);
        this.to = LocalDate.parse(to);
    }

    /**
     * Returns a formatted string representation of this task.
     *
     * @return formatted task string
     */
    @Override
    public String toString() {
        return "[W]" + super.toString() + " (between: "
                + this.between.format(FORMATTER) + " and: " + this.to.format(FORMATTER) + ")";
    }

    /**
     * Returns custom string notation of object to be
     * saved in txt file
     *
     * @return Custom string representation of object
     */
    @Override
    public String saveString() {
        String doner = "[ ]";
        if (super.isDone) {
            doner = "[X]";
        }
        // Chatgpt caught a bug with me using
        // FORMATTER INSTEAD OF REFORMATTER FOR SAVING
        return doner + "dowithin " + super.description
                + " /between " + this.between.format(REFORMATTER) + " /and "
                + this.to.format(REFORMATTER);
    }

}
