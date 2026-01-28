public class Deadline extends Task{
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by + ")";
    }

    public String saveString() {
        String doner = "[ ]";
        if (super.isDone) {
            doner = "[X]";
        }
        return doner + "deadline " + super.description +
                " /by " + this.by;
    }
}
