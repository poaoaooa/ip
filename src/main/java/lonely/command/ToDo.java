package lonely.command;

public class ToDo extends Task {
    ToDo(String description) {
        super(description);
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
        return "[T]" + super.toString();
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
        return doner + "todo " + super.description;
    }
}
