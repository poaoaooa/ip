package lonely.command;

import lonely.ui.*;
import java.util.Scanner;

public class Lonely {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList lst = new TaskList();
        Storage store = new Storage(lst);
        store.recover();
        UI.greet();
        String str;
        do {
            str = scanner.nextLine();
            if (str.equals("bye")) {break;}
            Parser.logic(str, lst,true);
        } while (true);
        store.save();
        UI.goodbye();
    }
}
