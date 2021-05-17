package main.Java3.mockito;


import org.junit.Assert;
        import org.junit.Test;
        import org.mockito.Mockito;

public class MockitoMutilpleCallDemo {

    @Test
    public void processTest() {
        MyService myService = Mockito.mock(MyService.class);
        Mockito.when(myService.doSomething()).thenReturn(10, 20);
//        or write as following then then
//           Mockito.when(myService.doSomething()).thenReturn(10).thenReturn(20);
        MyProcessor myProcessor = new MyProcessor(myService);
        String returnedValue = myProcessor.process();
        System.out.println(returnedValue);//First time call to use mockito mock returned data:10
        Assert.assertEquals(returnedValue, "My Integer is: 10");
        returnedValue = myProcessor.process();//Second time call to use mockito mock returned data:20
        System.out.println(returnedValue);
        Assert.assertEquals(returnedValue, "My Integer is: 20");
    }
}