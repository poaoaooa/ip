package lonely.command;


import lonely.ui.UI;


public class Lonely {
    private static Storage store;
    private static TaskList lst;
    /**
     * Main method, loops through scanner inputs and passes
     * it to its logic, till it reached a "bye".
     *
     */
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
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

         */


    }
    /**
     * Prepare a static Tasklist and
     * recover the tasks stored
     */
    public static void prep() {
        Lonely.lst = new TaskList();
        Lonely.store = new Storage(Lonely.lst);
        store.recover();
    }

    public String getResponse(String input) {
        if (input.equals("list")) {
            return UI.displayList(Lonely.lst);
        }
        if (input.equals("bye")) {
            Lonely.store.save();
            return "bye. Hope to see you again soon!";
        }
        String message = Parser.logic(input, Lonely.lst);

        return message;
    }
}
