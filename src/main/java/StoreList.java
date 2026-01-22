public class StoreList {
    private String[] lst;
    private int index;
    StoreList() {
        this.lst = new String[100];
        this.index = 0;
    }

    public void add(String str) {
        this.lst[index] = (index+1) + ". " + str;
        this.index++;
    }

    public void display() {
        for (int i = 0; i < 100; i++) {
            if (this.lst[i] == null) {
                break;
            }
            System.out.println(lst[i]);
        }
    }
}
