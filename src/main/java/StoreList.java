public class StoreList {
    private Task[] lst;
    private int index;
    StoreList() {
        this.lst = new Task[101];
        this.index = 1;
    }

    public String unmark(int index) {
        this.lst[index].unmark();
        String str = this.lst[index].toString();
        return "OK, I've marked this task as not done yet:\n" +
                "  " + str;
    }

    public String mark(int index) {
        this.lst[index].mark();
        String str = this.lst[index].toString();
        return "Nice! I've marked this task as done:\n" +
                "  " + str;
    }

    public String add(Task task) {
        this.lst[index] = task;
        this.index++;
        return "Got it. I've added this task:\n" +
                "  " + task.toString() + "\n" +
                "Now you have " + (this.index - 1) + " tasks in the list.";
    }

    public void display() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i < 101; i++) {
            if (this.lst[i] == null) {
                break;
            }
            System.out.println(i+"."+lst[i].toString());
        }
    }


}
