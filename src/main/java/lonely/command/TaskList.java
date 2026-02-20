package lonely.command;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class TaskList {
    private final ArrayList<Task> lst;
    TaskList() {
        this.lst = new ArrayList<>();
    }

    TaskList(ArrayList<Task> tasks) {
        this.lst = tasks;
    }


    /**
     * Unmarks a Task from TaskList, based on its index
     *
     * @param index 1-based index of the task
     * @return String denoting which element has been unmarked
     */
    protected String unmark(int index) {
        assert index >= 1 : "Index should be positive after parsing";
        index = index - 1;
        this.lst.get(index).unmark();
        String str = this.lst.get(index).toString();
        return "OK, I've marked this task as not done yet:\n"
                + "  " + str;
    }

    /**
     * Marks a Task from TaskList, based on its index
     *
     * @param index 1-based index of the task
     * @return String denoting which element has been marked
     */
    protected String mark(int index) {
        assert index >= 1 : "Index should be positive after parsing";
        index = index - 1;
        this.lst.get(index).mark();
        String str = this.lst.get(index).toString();
        return "Nice! I've marked this task as done:\n"
                + "  " + str;
    }

    /**
     * Adds a Task from TaskList
     *
     * @param task task object to be added to Tasklist arraylist
     * @return String denoting which element has been added
     *      and current size
     */
    protected String add(Task task) {
        this.lst.add(task);
        return "Got it. I've added this task:\n"
                + "  " + task.toString() + "\n"
                + "Now you have " + (this.lst.size()) + " tasks in the list.";
    }

    /**
     * Deletes a Task from TaskList, based on its index
     *
     * @param index 1-based index of the task
     * @return String denoting which element has been removed
     */
    protected String remove(int index) {
        assert index >= 1 : "Index should be positive after parsing";
        if (index <= 0 || index > lst.size()) {
            return "Invalid task number.";
        }
        Task removed = this.lst.remove(index - 1);
        return "Noted. I've removed this task:\n"
                + "  " + removed.toString() + "\n"
                + "Now you have " + (this.lst.size()) + " tasks in the list.";
    }

    /**
     * Returns a formatted list of all tasks.
     *
     * @return string containing all tasks
     */
    public String display() {
        StringBuilder lstString = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 0; i < this.lst.size(); i++) {
            lstString.append((i + 1) + "." + this.lst.get(i).toString() + "\n");
        }
        return lstString.toString();
    }

    /**
     * Returns a list of tasks that contain all given keywords.
     *
     * @param str keywords to search for
     * @return filtered task list
     */
    protected TaskList find(String str) {
        String[] keywords = str.toLowerCase().split(" ");
        // used chatgpt to suggest improve here so find, works
        // with finding 2 words
        return new TaskList(this.lst.stream()
                .filter(task -> {
                    String text = task.toString().toLowerCase();
                    return Arrays.stream(keywords).allMatch(text::contains);
                })
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    protected ArrayList<Task> getList() {
        return this.lst;
    }

}



