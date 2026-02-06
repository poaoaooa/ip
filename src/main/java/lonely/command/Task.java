package lonely.command;

/**
 * Abstract class of Task
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
     * Abstract method, ensures every Task can be saved in text files
     *
     */
    protected abstract String saveString();
}
