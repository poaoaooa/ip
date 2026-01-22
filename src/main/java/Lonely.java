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
        greet();
        goodbye();
    }

    public static void greet(){
        System.out.println(barrier);
        System.out.println("Hello! I'm Lonely \nWhat can I do for you?");
    }

    public static void goodbye(){
        System.out.println(barrier);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(barrier);
    }
}
