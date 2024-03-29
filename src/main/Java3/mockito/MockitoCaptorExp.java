package main.Java3.mockito;


import static org.junit.Assert.assertEquals;
        import static org.mockito.Mockito.times;

        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.List;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.mockito.ArgumentCaptor;
        import org.mockito.Captor;
        import org.mockito.Mock;
        import org.mockito.Mockito;
        import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoCaptorExp
{
    @Mock
    HashMap<String, Integer> hashMap;

    @Captor
    ArgumentCaptor<String> keyCaptor;
//Every ArgumentCaptor has two methods getValue() and getAllValues().
// The getValue() can be used when we have captured an argument from a single method call.
// If the method was called multiple times getValue() will return the latest captured value.
    @Captor
    ArgumentCaptor<Integer> valueCaptor;

    @Test
    public void saveTest()
    {
        hashMap.put("A", 10);
        hashMap.put("B", 20);

        //1. Verify method was invoked N times
        Mockito.verify(hashMap, times(2)).put(keyCaptor.capture(), valueCaptor.capture());
        List<String> keys = keyCaptor.getAllValues();
        List<Integer> values = valueCaptor.getAllValues();

        //2. Verify method argument values as list
        assertEquals(Arrays.asList("A", "B"), keys);
        assertEquals(Arrays.asList(Integer.valueOf(10), Integer.valueOf(20)), values);

        //3. Verify method arguments separately
        assertEquals("A", keys.get(0));
        assertEquals("B", keys.get(1));

        assertEquals(Integer.valueOf(10), values.get(0));
        assertEquals(Integer.valueOf(20), values.get(1));
    }
}