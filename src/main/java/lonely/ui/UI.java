package lonely.ui;
import lonely.command.TaskList;

public class UI {

    private static final String barrier = "____________________________________________________________";

    public static void greet() {
        outpt("Hello! I'm Lonely\nWhat can I do for you?");
    }

    public static void goodbye() {
        outpt("Bye. Hope to see you again soon!");
    }

    public static void handle(Exception exp) {
        outpt(exp.toString());
    }

    public static void displayList(TaskList lst) {
        System.out.println(barrier);
        lst.display();
        System.out.println(barrier);
    }

    public static void outpt(String msg) {
        System.out.println(barrier);
        System.out.println(msg);
        System.out.println(barrier);
    }
}
