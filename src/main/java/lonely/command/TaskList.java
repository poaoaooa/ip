package lonely.command;

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
     * index param is indexed from 1
     *
     * @param index index of elements
     * @return String denoting which element has been unmarked
     */
    protected String unmark(int index) {
        index = index - 1;
        this.lst.get(index).unmark();
        String str = this.lst.get(index).toString();
        return "OK, I've marked this task as not done yet:\n"
                + "  " + str;
    }

    /**
     * Marks a Task from TaskList, based on its index
     * index param is indexed from 1
     *
     * @param index index of elements
     * @return String denoting which element has been marked
     */
    protected String mark(int index) {
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
     * index param is indexed from 1
     *
     * @param index index of elements
     * @return String denoting which element has been removed
     */
    protected String remove(int index) {
        Task task = this.lst.get(index - 1);
        this.lst.remove(index - 1);
        return "Noted. I've removed this task:\n"
                + "  " + task.toString() + "\n"
                + "Now you have " + (this.lst.size()) + " tasks in the list.";
    }

    /**
     * Prints out all elements stored in the Arraylist of Tasks
     * also numbers the elements
     *
     */
    public String display() {
        StringBuilder lstString = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 0; i < this.lst.size(); i++) {
            lstString.append((i + 1) + "." + this.lst.get(i).toString() + "\n");
        }
        return lstString.toString();
    }

    protected TaskList find(String str) {
        return new TaskList(this.lst.stream()
                .filter(task -> task.toString()
                                .toLowerCase().contains(str.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    protected ArrayList<Task> getList() {
        return this.lst;
    }

}



