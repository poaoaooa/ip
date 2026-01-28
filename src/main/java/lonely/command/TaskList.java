package lonely.command;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> lst;
    TaskList() {
        this.lst = new ArrayList<>();
    }

    public String unmark(int index) {
        index = index -1;
        this.lst.get(index).unmark();
        String str = this.lst.get(index).toString();
        return "OK, I've marked this task as not done yet:\n" +
                "  " + str;
    }

    public String mark(int index) {
        index = index -1;
        this.lst.get(index).mark();
        String str = this.lst.get(index).toString();
        return "Nice! I've marked this task as done:\n" +
                "  " + str;
    }

    public String add(Task task) {
        this.lst.add(task);
        return "Got it. I've added this task:\n" +
                "  " + task.toString() + "\n" +
                "Now you have " + (this.lst.size()) + " tasks in the list.";
    }

    public String remove(int index) {
        Task task = this.lst.get(index-1);
        this.lst.remove(index - 1);
        return "Noted. I've removed this task:\n" +
                "  " + task.toString() + "\n" +
                "Now you have " + (this.lst.size()) + " tasks in the list.";
    }

    public void display() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < this.lst.size(); i++) {
            System.out.println((i+1)+"."+ this.lst.get(i).toString());
        }
    }

    public ArrayList<Task> getList() {return this.lst;}

}



