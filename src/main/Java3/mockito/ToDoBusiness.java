package main.Java3.mockito;

import java.util.List;

public class ToDoBusiness {

    public ToDoService doService;
//Create the implementation class of the ToDoService interface named ToDoBusiness
    public ToDoBusiness(ToDoService doService) {
        this.doService = doService;
    }

    public void deleteTodosNotRelatedToHibernate(String user) {

        List<String> Combinedlist = doService.getTodos(user);

        for(String todos:Combinedlist) {
            if(!todos.contains("Hibernate")) {
                doService.deleteTodos(todos);
            }
        }
    }
}
