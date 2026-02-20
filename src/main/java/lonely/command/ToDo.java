package lonely.command;

/**
 * Class of Type task that represents Todo task
 */
public class ToDo extends Task {
    ToDo(String description) {
        super(description);
    }

    /**
     * Returns a formatted string representation of this task.
     *
     * @return formatted task string
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
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
        return doner + "todo " + super.description;
    }
}
