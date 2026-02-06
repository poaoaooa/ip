package lonely.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Storage {

    private TaskList lst;
    Storage(TaskList lst) {
        this.lst = lst;
    }

    /**
     * Saves TaskList object in the form of a txt file to be used later
     *
     */
    protected void save() {
        List<String> lines = this.lst.getList().stream().map(Task::saveString).toList();
        Path filePath = Paths.get("Lonely.txt");
        try {
            Files.write(filePath, lines);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }

    }

    /*
    * Retrives TaskList object from txt file, if it exsits,
    * i.e if there was a previous conversatino with Lonely
    *
    */
    protected void recover() {
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
            Parser.logic(str.substring(3), this.lst, false);
        } else if (str.startsWith("[X]")) {
            Parser.logic(str.substring(3), this.lst, false);
            Parser.logic("mark " + this.lst.getList().size(), this.lst, false);
        }
    }
}
