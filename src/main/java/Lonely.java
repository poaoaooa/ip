import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Lonely {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Storage lst = new Storage();
        lst.recover();
        greet();
        String str;
        do {
            str = scanner.nextLine();
            if (str.equals("bye")) {break;}
            Logic.logic(str, lst,true);
        } while (true);
        lst.save();
        goodbye();
    }

    private static void greet(){
        Logic.outpt("Hello! I'm Lonely\nWhat can I do for you?");
    }

    private static void goodbye(){
        Logic.outpt("Bye. Hope to see you again soon!");
    }


}
