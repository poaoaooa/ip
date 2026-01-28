package lonely.command;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    private ArrayList<Task> lst;

    TaskListTest() {
        this.lst = new ArrayList<>();
    }

    @Test
    public void unmark() {
        Task task = new Deadline("return book", "2019-10-15");
        TaskList taskList = new TaskList();
        taskList.add(task);
        assertEquals("OK, I've marked this task as not done yet:\n  [D][ ] return book (by: Oct 15 2019)",
                taskList.unmark(1));

    }

    @Test
    public void mark() {
        Task task = new Deadline("return book", "2019-10-15");
        TaskList taskList = new TaskList();
        taskList.add(task);
        assertEquals("Nice! I've marked this task as done:\n  [D][X] return book (by: Oct 15 2019)",
                taskList.mark(1));

    }



}



