package lonely.ui;
import lonely.command.TaskList;

/**
 * Class that handles UI
 */
public class UI {
    /*
    private static final String barrier = "____________________________________________________________";

    public static void greet() {
        outpt("Hello! I'm Lonely\nWhat can I do for you?");
    }

    public static void goodbye() {
        outpt("Bye. Hope to see you again soon!");
    }
    */
    public static String handle(Exception exp) {
        return exp.toString();
    }

    public static String displayList(TaskList lst) {
        return lst.display();
    }
    /*
    public static void outpt(String msg) {
        System.out.println(barrier);
        System.out.println(msg);
        System.out.println(barrier);
    }*/
}

