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

    //Use Chatgpt to make a better Junit Test
    @Test
    public void parseTodo_validInput() {
        TaskList list = new TaskList();

        String result = Parser.logic("todo homework", list);

        assertEquals(1, list.getList().size());
        assertTrue(result.contains("homework"));
    }

    /**
     * Use Chatgpt to make a better Junit Test
     */
    @Test
    public void addTask_success() {
        TaskList list = new TaskList();
        Task task = new ToDo("study");

        String result = list.add(task);

        assertEquals(1, list.getList().size());
        assertTrue(result.contains("study"));
    }



}



