package lonely.ui;
import lonely.command.TaskList;

/**
 * Class that handles UI
 */
public class UI {

    public static String handle(Exception exp) {
        return exp.toString();
    }

    public static String displayList(TaskList lst) {
        return lst.display();
    }

}

