import java.util.regex.PatternSyntaxException;

public class Logic {

    public static final String barrier = "____________________________________________________________";

    public static void handle(Exception exp) {
        outpt(exp.toString());
    }

    public static void outpt(String msg){
        System.out.println(barrier);
        System.out.println(msg);
        System.out.println(barrier);
    }
    public static void logic(String str, Storage lst, boolean display) {
        String printer = "";
        if (str.equals("list")) {
            System.out.println(barrier);
            lst.display();
            System.out.println(barrier);
        } else if(str.startsWith("delete")) {
            int index = Integer.parseInt(str.replaceAll("\\D+", ""));
            printer = lst.remove(index);
        } else if(str.startsWith("todo")) {
            try {
                String temp = str.replaceFirst("todo ", "");
                if (temp.equals("")|| str.length() < 5) {
                    handle(new LonelyWantsinfoException("todo"));
                    return;
                }
                String msg = lst.add(new ToDo(temp));
                printer = msg;
            }  catch (PatternSyntaxException e) {
                handle(new LonelyDontunderstandException());
            }  catch (ArrayIndexOutOfBoundsException e) {
                handle(new LonelyWantsinfoException("todo"));
            }
        } else if(str.startsWith("deadline")) {
            try {
                str = str.replaceFirst("deadline ", "");
                String[] temp = str.split(" /by ");
                String msg = lst.add(new Deadline(temp[0], temp[1]));
                printer = msg;
            }  catch (PatternSyntaxException e) {
                handle(new LonelyDontunderstandException());
            }  catch (ArrayIndexOutOfBoundsException e) {
                handle(new LonelyWantsinfoException("deadline"));
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
                    handle(new LonelyWantsinfoException("todo"));
                    return;
                }
                printer = msg;
            }  catch (PatternSyntaxException e) {
                handle(new LonelyDontunderstandException());
            }  catch (ArrayIndexOutOfBoundsException e) {
                handle(new LonelyWantsinfoException("event"));
            }
        } else if (str.startsWith("mark")) {
            int index = Integer.parseInt(str.replaceAll("\\D+", ""));
            printer = lst.mark(index);
        } else if (str.startsWith("unmark")) {
            int index = Integer.parseInt(str.replaceAll("\\D+", ""));
            printer = lst.unmark(index);
        } else {
            System.out.println(str);
            handle(new LonelyDontunderstandException());
        }
        if (!display || printer.isEmpty()) {
            // do nothing
        } else {
            outpt(printer);
        }
    }

}
