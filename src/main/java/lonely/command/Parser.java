package lonely.command;
import java.time.format.DateTimeParseException;
import java.util.regex.PatternSyntaxException;

import lonely.error.LonelyDontunderstandException;
import lonely.error.LonelyWantsinfoException;
import lonely.ui.UI;


public class Parser {
    /**
     * Parses through the String, and checks if it contains certain keywords,
     * if it does performs corresponding action.
     *
     * @param str String that is inputted, to be saved in list
     * @param lst Object of the Tasklist, that will be used by Lonely throughout
     * @return nothing
     * @throws LonelyDontunderstandException() if formatting does not match)
     * @throws LonelyWantsinfoException() if formatting fits, but some details are empty
     */
    protected static String logic(String str, TaskList lst) {
        String printer = "";
        if (str.startsWith("delete")) {
            int index = Integer.parseInt(str.replaceAll("\\D+", ""));
            printer = lst.remove(index);
        } else if (str.startsWith("find ")) {
            str = str.replaceFirst("find ", "");
            printer = UI.displayList(lst.find(str));
        } else if (str.startsWith("todo")) {
            try {
                String temp = str.replaceFirst("todo ", "");
                if (temp.equals("") || str.length() < 5) {
                    printer = UI.handle(new LonelyWantsinfoException("todo"));
                }
                String msg = lst.add(new ToDo(temp));
                printer = msg;
            } catch (PatternSyntaxException e) {
                printer = UI.handle(new LonelyDontunderstandException());
            } catch (ArrayIndexOutOfBoundsException e) {
                printer = UI.handle(new LonelyWantsinfoException("todo"));
            }
        } else if (str.startsWith("deadline")) {
            try {
                str = str.replaceFirst("deadline ", "");
                String[] temp = str.split(" /by ");
                String msg = lst.add(new Deadline(temp[0], temp[1]));
                printer = msg;
            } catch (DateTimeParseException | PatternSyntaxException e) {
                printer = UI.handle(new LonelyDontunderstandException());
            } catch (ArrayIndexOutOfBoundsException e) {
                printer = UI.handle(new LonelyWantsinfoException("deadline"));
            }
        } else if (str.startsWith("event")) {
            try {
                str = str.replaceFirst("event ", "");
                String[] temp = str.split(" /");
                String msg = lst.add(new Event(temp[0],
                        temp[1].replaceFirst("from ", ""),
                        temp[2].replaceFirst("to ", "")));
                printer = msg;
            } catch (DateTimeParseException | PatternSyntaxException e) {
                printer = UI.handle(new LonelyDontunderstandException());
            } catch (ArrayIndexOutOfBoundsException e) {
                printer = UI.handle(new LonelyWantsinfoException("event"));
            }
        } else if (str.startsWith("mark")) {
            int index = Integer.parseInt(str.replaceAll("\\D+", ""));
            printer = lst.mark(index);
        } else if (str.startsWith("unmark")) {
            int index = Integer.parseInt(str.replaceAll("\\D+", ""));
            printer = lst.unmark(index);
        } else {
            printer = UI.handle(new LonelyDontunderstandException());
        }
        return printer;
    }

}
