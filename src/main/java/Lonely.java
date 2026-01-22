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
        } else {
            lst.add(str);
            echo("added: " + str);
        }
    }

    private static void greet(){
        System.out.println(barrier);
        System.out.println("Hello! I'm Lonely \nWhat can I do for you?");
        System.out.println(barrier);
    }

    private static void echo(String inpt) {
        System.out.println(barrier);
        System.out.println(inpt);
        System.out.println(barrier);
    }

    private static void goodbye(){
        System.out.println(barrier);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(barrier);
    }
}
