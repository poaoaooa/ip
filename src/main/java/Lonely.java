import java.util.Scanner;
public class Lonely {
    public static final String barrier = "____________________________________________________________";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StoreList lst = new StoreList();
        greet();
        String str;
        do {
            str = scanner.nextLine();
            if (str.equals("bye")) {break;}
            logic(str, lst);
        } while (true);
        goodbye();
    }

    private static void logic(String str, StoreList lst) {
        if (str.equals("list")) {
            System.out.println(barrier);
            lst.display();
            System.out.println(barrier);
        } else if (str.startsWith("mark")) {
            int index = Integer.parseInt(str.replaceAll("\\D+", ""));
            outpt(lst.mark(index));
        } else if (str.startsWith("unmark")) {
            int index = Integer.parseInt(str.replaceAll("\\D+", ""));
            outpt(lst.unmark(index));
        } else {
            lst.add(str);
            echo("added: " + str);
        }
    }

    private static void greet(){
        outpt("Hello! I'm Lonely \nWhat can I do for you?");
    }

    private static void echo(String inpt) {
        outpt(inpt);
    }

    private static void goodbye(){
        outpt("Bye. Hope to see you again soon!");
    }

    private static void outpt(String msg){
        System.out.println(barrier);
        System.out.println(msg);
        System.out.println(barrier);
    }
}
