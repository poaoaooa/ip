package lonely.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DoWithinPeriod extends Task {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");
    private static final DateTimeFormatter REFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    protected LocalDate between;
    protected LocalDate and;
    DoWithinPeriod(String description, String between, String and) {
        super(description);
        this.between = LocalDate.parse(between);
        this.and = LocalDate.parse(and);
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
        return "[W]" + super.toString() + " (between: "
                + this.between.format(FORMATTER) + " and: " + this.and.format(FORMATTER) + ")";
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
        return doner + "dowithin " + super.description
                + " /between " + this.between.format(FORMATTER) + " /and "
                + this.and.format(REFORMATTER);
    }

}
