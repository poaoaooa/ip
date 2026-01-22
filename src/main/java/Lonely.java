import java.util.Scanner;
public class Lonely {
    public static final String barrier = "____________________________________________________________";
    public static void main(String[] args) {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

         */
        Scanner scanner = new Scanner(System.in);
        greet();
        String str;
        do {
            str = scanner.nextLine();
            echo(str);
        } while (!str.equals("bye"));
        goodbye();
    }

    public static void greet(){
        System.out.println(barrier);
        System.out.println("Hello! I'm Lonely \nWhat can I do for you?");
        System.out.println(barrier);
    }

    private static void echo(String inpt) {
        System.out.println(barrier);
        System.out.println(inpt);
        System.out.println(barrier);
    }

    public static void goodbye(){
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(barrier);
    }
}
