package lonely.command;
import java.util.Scanner;

import lonely.ui.UI;


public class Lonely {
    /**
     * Main method, loops through scanner inputs and passes
     * it to its logic, till it reached a "bye".
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList lst = new TaskList();
        Storage store = new Storage(lst);
        store.recover();
        UI.greet();
        String str;
        do {
            str = scanner.nextLine();
            if (str.equals("bye")) {
                break;
            }
            Parser.logic(str, lst, true);
        } while (true);
        store.save();
        UI.goodbye();
    }
}
