import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Storage {
    private final ArrayList<Task> lst;
    Storage() {
        this.lst = new ArrayList<>();
    }

    public String unmark(int index) {
        index = index -1;
        this.lst.get(index).unmark();
        String str = this.lst.get(index).toString();
        return "OK, I've marked this task as not done yet:\n" +
                "  " + str;
    }

    public String mark(int index) {
        index = index -1;
        this.lst.get(index).mark();
        String str = this.lst.get(index).toString();
        return "Nice! I've marked this task as done:\n" +
                "  " + str;
    }

    public String add(Task task) {
        this.lst.add(task);
        return "Got it. I've added this task:\n" +
                "  " + task.toString() + "\n" +
                "Now you have " + (this.lst.size()) + " tasks in the list.";
    }

    public String remove(int index) {
        Task task = this.lst.get(index-1);
        this.lst.remove(index - 1);
        return "Noted. I've removed this task:\n" +
                "  " + task.toString() + "\n" +
                "Now you have " + (this.lst.size()) + " tasks in the list.";
    }

    public void display() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < this.lst.size(); i++) {
            System.out.println((i+1)+"."+ this.lst.get(i).toString());
        }
    }

    public void save() {
        List<String> lines = this.lst.stream().map(Task::saveString).toList();
        Path filePath = Paths.get("Lonely.txt");
        try {
            Files.write(filePath, lines);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }

    }

    public void recover() {
        File file = new File("Lonely.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                retrievelogic(line);
            }
        } catch (FileNotFoundException e) {
            // do nothing
        }
    }

    private void retrievelogic(String str) {
        if (str.startsWith("[ ]")) {
            Logic.logic(str.substring(3),this,false);
        } else if (str.startsWith("[X]")){
            Logic.logic(str.substring(3),this, false);
            Logic.logic("mark "+this.lst.size(),this, false);
        }
    }

}



