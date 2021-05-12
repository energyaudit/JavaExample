package main.Java3.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ToDoBusinessMock {
// Create a mock class named ToDoBusinessMock for testing purposes. Here, we have declared an ArgumentCaptor that
// captures the argument of this (todoService) mock when deleteTodos() method is called.
    @Test
    public void deleteTodosusing_BDD_usingArgumentCaptor() {
        //Declare an Argument Captor
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        //Given
        ToDoService todoService = mock(ToDoService.class);
        List<String> combinedlist = Arrays.asList("Use Hibernate Java",
                "Use Hibernate Core", "Use Hibernate", "Use Spring MVC");
        given(todoService.getTodos("dummy")).willReturn(combinedlist);

        ToDoBusiness business = new ToDoBusiness(todoService);
        //When
        business.deleteTodosNotRelatedToHibernate("dummy");

        //Then
        then(todoService).should().deleteTodos(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(),is("Use Spring MVC"));
       // In the above code, we have captured the argument and checked whether the argument passed
      //  is "Use Spring MVC" or not, by using the getValue() method.
    }
}