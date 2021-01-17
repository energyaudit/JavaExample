package Spring;


import java.time.LocalDate;
import java.util.Date;

public class TaskBuilderTest {

    public static void main(String[] args) {
        Date start = new Date();
        Task task = new TaskBuilder(5,"Hello","Hello",true,start).setSummary("Test").build();
        System.out.println(task.getDueDate());
    }

}