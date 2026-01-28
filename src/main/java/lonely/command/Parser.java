package lonely.command;

import lonely.ui.UI;
import lonely.error.*;
import java.time.format.DateTimeParseException;
import java.util.regex.PatternSyntaxException;

public class Parser {
    /**
     * Parses through the String, and checks if it contains certain keywords,
     * if it does performs corresponding action.
     *
     * @param str String that is inputted, to be saved in list
     * @param lst Object of the Tasklist, that will be used by Lonely throughout
     * @param display boolean variable, to denote whether logic prints anything
     * @return nothing
     * @throws LonelyDontunderstandException() if formatting does not fit
     * @throws LonelyWantsinfoException() if formatting fits, but some details are empty
     */
    protected static void logic(String str, TaskList lst, boolean display) {
        String printer = "";
        if (str.equals("list")) {
            UI.displayList(lst);
        } else if(str.startsWith("delete")) {
            int index = Integer.parseInt(str.replaceAll("\\D+", ""));
            printer = lst.remove(index);
        } else if (str.startsWith("find ")) {
            str = str.replaceFirst("find ", "");
            UI.displayList(lst.find(str));
        } else if(str.startsWith("todo")) {
            try {
                String temp = str.replaceFirst("todo ", "");
                if (temp.equals("")|| str.length() < 5) {
                    UI.handle(new LonelyWantsinfoException("todo"));
                    return;
                }
                String msg = lst.add(new ToDo(temp));
                printer = msg;
            }  catch (PatternSyntaxException e) {
                UI.handle(new LonelyDontunderstandException());
            }  catch (ArrayIndexOutOfBoundsException e) {
                UI.handle(new LonelyWantsinfoException("todo"));
            }
        } else if(str.startsWith("deadline")) {
            try {
                str = str.replaceFirst("deadline ", "");
                String[] temp = str.split(" /by ");
                String msg = lst.add(new Deadline(temp[0], temp[1]));
                printer = msg;
            } catch (DateTimeParseException | PatternSyntaxException e) {
                UI.handle(new LonelyDontunderstandException());
            } catch (ArrayIndexOutOfBoundsException e) {
                UI.handle(new LonelyWantsinfoException("deadline"));
            }
        } else if (str.startsWith("event")) {
            try {
                str = str.replaceFirst("event ", "");
                String[] temp = str.split(" /");
                String msg = lst.add(new Event(temp[0],
                        temp[1].replaceFirst("from ", ""),
                        temp[2].replaceFirst("to ","")));
                if (temp[1].equals("from")|| temp[2].equals("to") ||
                        temp[1].equals(" ") || temp[2].equals(" ")) {
                    UI.handle(new LonelyWantsinfoException("todo"));
                    return;
                }
                printer = msg;
            }  catch (DateTimeParseException | PatternSyntaxException e) {
                UI.handle(new LonelyDontunderstandException());
            }  catch (ArrayIndexOutOfBoundsException e) {
                UI.handle(new LonelyWantsinfoException("event"));
            }
        } else if (str.startsWith("mark")) {
            int index = Integer.parseInt(str.replaceAll("\\D+", ""));
            printer = lst.mark(index);
        } else if (str.startsWith("unmark")) {
            int index = Integer.parseInt(str.replaceAll("\\D+", ""));
            printer = lst.unmark(index);
        } else {
            UI.handle(new LonelyDontunderstandException());
        }
        if (!display || printer.isEmpty()) {
            // do nothing
        } else {
            UI.outpt(printer);
        }
    }

}
