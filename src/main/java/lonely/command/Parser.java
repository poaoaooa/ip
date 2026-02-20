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
        assert str != null : "str should not be null";
        assert lst != null : "list should not be null";
        String printer = "";
        if (str.startsWith("delete")) {
            printer = logicDelete(str, lst);
        } else if (str.startsWith("find ")) {
            printer = logicFind(str,lst);
        } else if (str.startsWith("todo")) {
            printer = logicTodo(str, lst);
        } else if (str.startsWith("deadline")) {
            printer = logicDeadline(str, lst);
        } else if (str.startsWith("event")) {
            printer = logicEvent(str, lst);
        } else if (str.startsWith("dowithin")) {
            printer = logicDowithin(str, lst);
        } else if (str.startsWith("mark")) {
            printer = logicMark(str, lst);
        } else if (str.startsWith("unmark")) {
            printer = logicUnmark(str, lst);
        } else {
            printer = UI.handle(new LonelyDontunderstandException());
        }
        return printer;
    }

    private static String logicUnmark(String str, TaskList lst) {
        int index = Integer.parseInt(str.replaceAll("\\D+", ""));
        assert index != 0 : "index must not be 0";
        return lst.unmark(index);
    }

    private static String logicMark(String str, TaskList lst) {
        int index = Integer.parseInt(str.replaceAll("\\D+", ""));
        assert index != 0 : "index must not be 0";
        return lst.mark(index);
    }

    private static String logicEvent(String str, TaskList lst) {
        String printer;
        try {
            str = str.replaceFirst("event ", "");
            String[] temp = str.split(" /");
            assert !temp[0].equals("") : "string must not be empty";
            assert !temp[1].equals("") : "string must not be empty";
            assert !temp[2].equals("") : "string must not be empty";
            String msg = lst.add(new Event(temp[0],
                    temp[1].replaceFirst("from ", ""),
                    temp[2].replaceFirst("to ", "")));
            printer = msg;
        } catch (DateTimeParseException | PatternSyntaxException e) {
            printer = UI.handle(new LonelyDontunderstandException());
        } catch (ArrayIndexOutOfBoundsException e) {
            printer = UI.handle(new LonelyWantsinfoException("event"));
        }
        return printer;
    }

    private static String logicDowithin(String str, TaskList lst) {
        String printer;
        try {
            str = str.replaceFirst("dowithin ", "");
            String[] temp = str.split(" /");
            assert !temp[0].equals("") : "string must not be empty";
            assert !temp[1].equals("") : "string must not be empty";
            assert !temp[2].equals("") : "string must not be empty";
            String msg = lst.add(new DoWithinPeriod(temp[0],
                    temp[1].replaceFirst("between ", ""),
                    temp[2].replaceFirst("and ", "")));
            printer = msg;
        } catch (DateTimeParseException | PatternSyntaxException e) {
            printer = UI.handle(new LonelyDontunderstandException());
        } catch (ArrayIndexOutOfBoundsException e) {
            printer = UI.handle(new LonelyWantsinfoException("event"));
        }
        return printer;
    }

    private static String logicDeadline(String str, TaskList lst) {
        String printer;
        try {
            str = str.replaceFirst("deadline ", "");
            String[] temp = str.split(" /by ");
            assert !temp[0].equals("") : "string must not be empty";
            assert !temp[1].equals("") : "string must not be empty";
            String msg = lst.add(new Deadline(temp[0], temp[1]));
            printer = msg;
        } catch (DateTimeParseException | PatternSyntaxException e) {
            printer = UI.handle(new LonelyDontunderstandException());
        } catch (ArrayIndexOutOfBoundsException e) {
            printer = UI.handle(new LonelyWantsinfoException("deadline"));
        }
        return printer;
    }

    private static String logicTodo(String str, TaskList lst) {
        String printer;
        try {
            String temp = str.replaceFirst("todo ", "");
            assert str.length() < 5 : "string must have a subject";
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
        return printer;
    }

    private static String logicDelete(String str, TaskList lst) {
        int index = Integer.parseInt(str.replaceAll("\\D+", ""));
        assert index != 0 : "index must not be 0";
        return lst.remove(index);
    }

    private static String logicFind(String str, TaskList lst) {
        str = str.replaceFirst("find ", "");
        assert  !str.equals("") : "string must not be empty";
        return UI.displayList(lst.find(str));
    }



}
