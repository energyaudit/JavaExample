package main.Java2.JsonExp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

public class JacksonAnnotationUnitTest {
    @Test
    public void whenUsingJsonProperty_thenCorrect()
            throws IOException {
        final BeanWithGetter bean = new BeanWithGetter(1, "My bean");

        final String result = new ObjectMapper().writeValueAsString(bean);
     assertThat(result, containsString("My bean"));
        assertThat  (result, containsString("1"));

        final BeanWithGetter resultBean = new ObjectMapper().readerFor(BeanWithGetter.class)
                .readValue(result);
       assertEquals("My bean", resultBean.getTheName());
        }
}
