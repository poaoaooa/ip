package lonely.command;

/**
 * Represents a generic task with a description and completion status.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    private String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }

    protected void unmark() {
        this.isDone = false;
    }

    protected void mark() {
        this.isDone = true;
    }

    /**
     * Returns a string representation of the task for storage.
     *
     * @return storage-formatted string
     */
    protected abstract String saveString();
}
