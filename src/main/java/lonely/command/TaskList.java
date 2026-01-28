package lonely.command;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> lst;
    TaskList() {
        this.lst = new ArrayList<>();
    }


    /**
     * Unmarks a Task from TaskList, based on its index
     * index param is indexed from 1
     *
     * @param index index of elements
     * @return String denoting which element has been unmarked
     */
    public String unmark(int index) {
        index = index -1;
        this.lst.get(index).unmark();
        String str = this.lst.get(index).toString();
        return "OK, I've marked this task as not done yet:\n" +
                "  " + str;
    }

    /**
     * Marks a Task from TaskList, based on its index
     * index param is indexed from 1
     *
     * @param index index of elements
     * @return String denoting which element has been marked
     */
    public String mark(int index) {
        index = index -1;
        this.lst.get(index).mark();
        String str = this.lst.get(index).toString();
        return "Nice! I've marked this task as done:\n" +
                "  " + str;
    }

    /**
     * Adds a Task from TaskList
     *
     * @param task task object to be added to Tasklist arraylist
     * @return String denoting which element has been added
     *      and current size
     */
    public String add(Task task) {
        this.lst.add(task);
        return "Got it. I've added this task:\n" +
                "  " + task.toString() + "\n" +
                "Now you have " + (this.lst.size()) + " tasks in the list.";
    }

    /**
     * Deletes a Task from TaskList, based on its index
     * index param is indexed from 1
     *
     * @param index index of elements
     * @return String denoting which element has been removed
     */
    public String remove(int index) {
        Task task = this.lst.get(index-1);
        this.lst.remove(index - 1);
        return "Noted. I've removed this task:\n" +
                "  " + task.toString() + "\n" +
                "Now you have " + (this.lst.size()) + " tasks in the list.";
    }

    /**
     * Prints out all elements stored in the Arraylist of Tasks
     * also numbers the elements
     *
     */
    public void display() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < this.lst.size(); i++) {
            System.out.println((i+1)+"."+ this.lst.get(i).toString());
        }
    }

    public ArrayList<Task> getList() {return this.lst;}

}



