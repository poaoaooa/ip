package lonely.command;
import java.time.format.DateTimeParseException;
import java.util.regex.PatternSyntaxException;

import lonely.error.LonelyDontunderstandException;
import lonely.error.LonelyWantsinfoException;
import lonely.ui.UI;


public class Parser {
    // Used Chatgpt to tell me to get rid of magic strings
    public static final String CMD_DELETE = "delete ";
    public static final String CMD_FIND = "find ";
    public static final String CMD_TODO = "todo ";
    public static final String CMD_DEADLINE = "deadline ";
    public static final String CMD_EVENT = "event ";
    public static final String CMD_DOWITHIN = "dowithin ";
    public static final String CMD_MARK = "mark";
    public static final String CMD_UNMARK = "unmark";

    /**
     * Parses user input and executes the corresponding command.
     *
     * @param str user input string
     * @param lst tasklist to operate on
     * @return Response message to be shown to the user.
     */
    protected static String logic(String str, TaskList lst) {
        assert str != null : "str should not be null";
        assert lst != null : "list should not be null";
        String printer = "";
        if (str.startsWith(CMD_DELETE)) {
            printer = logicDelete(str, lst);
        } else if (str.startsWith(CMD_FIND)) {
            printer = logicFind(str, lst);
        } else if (str.startsWith(CMD_TODO)) {
            printer = logicTodo(str, lst);
        } else if (str.startsWith(CMD_DEADLINE)) {
            printer = logicDeadline(str, lst);
        } else if (str.startsWith(CMD_EVENT)) {
            printer = logicEvent(str, lst);
        } else if (str.startsWith(CMD_DOWITHIN)) {
            printer = logicDowithin(str, lst);
        } else if (str.startsWith(CMD_MARK)) {
            printer = logicMark(str, lst);
        } else if (str.startsWith(CMD_UNMARK)) {
            printer = logicUnmark(str, lst);
        } else {
            printer = UI.handle(new LonelyDontunderstandException());
        }
        return printer;
    }

    // used chatgpt to tell me to avoid repeating
    // extract index logic in methods
    private static int extractIndex(String str) {
        return Integer.parseInt(str.replaceAll("\\D+", ""));
    }

    private static String logicUnmark(String str, TaskList lst) {
        int index = extractIndex(str);
        if (index <= 0 || index > lst.getList().size()) {
            return "Invalid task number.";
        }
        return lst.unmark(index);
    }

    private static String logicMark(String str, TaskList lst) {
        int index = extractIndex(str);
        if (index <= 0 || index > lst.getList().size()) {
            return "Invalid task number.";
        }
        return lst.mark(index);
    }

    private static String logicDelete(String str, TaskList lst) {
        int index = extractIndex(str);
        if (index <= 0 || index > lst.getList().size()) {
            return "Invalid task number.";
        }
        return lst.remove(index);
    }

    private static String logicFind(String str, TaskList lst) {
        str = str.replaceFirst(CMD_FIND, "");
        if (str.trim().isEmpty()) {
            return "Please provide a keyword to search.";
        }
        return UI.displayList(lst.find(str));
    }

    private static String logicEvent(String str, TaskList lst) {
        String printer;
        try {
            str = str.replaceFirst(CMD_EVENT, "");
            String[] temp = str.split(" /");
            if (temp.length < 3 ||
                    temp[0].isEmpty() ||
                    temp[1].isEmpty() ||
                    temp[2].isEmpty()) {
                return UI.handle(new LonelyWantsinfoException("event"));
            }
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
            str = str.replaceFirst(CMD_DOWITHIN, "");
            String[] temp = str.split(" /");
            if (temp.length < 3 ||
                    temp[0].isEmpty() ||
                    temp[1].isEmpty() ||
                    temp[2].isEmpty()) {
                return UI.handle(new LonelyWantsinfoException("dowithin"));
            }
            String msg = lst.add(new DoWithinPeriod(temp[0],
                    temp[1].replaceFirst("between ", ""),
                    temp[2].replaceFirst("and ", "")));
            printer = msg;
        } catch (DateTimeParseException | PatternSyntaxException e) {
            printer = UI.handle(new LonelyDontunderstandException());
        } catch (ArrayIndexOutOfBoundsException e) {
            printer = UI.handle(new LonelyWantsinfoException("dowithin"));
        }
        return printer;
    }

    private static String logicDeadline(String str, TaskList lst) {
        String printer;
        try {
            str = str.replaceFirst(CMD_DEADLINE, "");
            String[] temp = str.split(" /by ");
            if (temp.length < 2 || temp[0].isEmpty() || temp[1].isEmpty()) {
                return UI.handle(new LonelyWantsinfoException("deadline"));
            }
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
            String temp = str.replaceFirst(CMD_TODO, "");
            if (temp.trim().isEmpty()) {
                return UI.handle(new LonelyWantsinfoException("todo"));
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
}
