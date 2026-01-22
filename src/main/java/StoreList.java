public class StoreList {
    private Task[] lst;
    private int index;
    StoreList() {
        this.lst = new Task[101];
        this.index = 1;
    }

    public String unmark(int index) {
        this.lst[index].unmark();
        return this.lst[index].getStatusMessage();
    }

    public String mark(int index) {
        this.lst[index].mark();
        return this.lst[index].getStatusMessage();
    }

    public void add(String str) {
        this.lst[index] = new Task(str);
        this.index++;
    }

    public void display() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i < 101; i++) {
            if (this.lst[i] == null) {
                break;
            }
            System.out.println(i+"."+lst[i].getStatusMessage());
        }
    }


}
