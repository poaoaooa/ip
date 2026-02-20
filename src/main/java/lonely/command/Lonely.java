package lonely.command;


import lonely.ui.UI;


public class Lonely {
    private static Storage store;
    private static TaskList lst;

    /**
     * Initializes the task list and loads stored tasks.
     */
    public static void prep() {
        Lonely.lst = new TaskList();
        Lonely.store = new Storage(Lonely.lst);
        store.recover();
    }

    /**
     * Processes user input and returns the corresponding response.
     *
     * @param input user input string
     * @return response message
     */
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
