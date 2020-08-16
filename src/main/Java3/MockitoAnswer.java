//package main.Java3;
//
//
//
//import org.mockito.Mockito;
//import org.testng.annotations.Test;
//
//import java.util.Calendar;
//import java.util.concurrent.TimeUnit;
// class User {
//    public String getTime() {
//        return this.time;
//    }
//}
//
//public class MockitoAnswer {
//
//    private String now() {
//        Calendar now = Calendar.getInstance();
//        return now.get(Calendar.MINUTE) + " : " + now.get(Calendar.SECOND);
//    }
//    private String dummyGetTime() {
//        System.out.println(" #getTime called");
//        return now();
//    }
//
//    @Test
//    public void thenReturnTest() throws Exception {
//        Tester mock = Mockito.mock(User.class);
//
//        System.out.println("------ Using: thenReturn------ ");
//        Mockito.when(mock.getTime()).thenReturn(dummyGetTime());
//
//        System.out.println(" -- method calls");
//        System.out.println("Call.1> " + mock.getTime()+ " called at - " +now);
//
//        TimeUnit.SECONDS.sleep(5);
//        System.out.println("Call.2> " + mock.getTime()+ " called at - " +now);
//    }
//
//    @Test
//    public void thenAnswerTest() throws Exception {
//        Tester mock = Mockito.mock(User.class);
//
//        System.out.println("------ Using: thenAnswer------ ");
//        Mockito.when(mock.getTime()).thenAnswer(i -> dummyGetTime());
//
//        System.out.println(" -- method calls");
//        System.out.println("Call.1> " + mock.getTime()+ " called at : " +now);
//
//        TimeUnit.SECONDS.sleep(5);
//        System.out.println("Call.2> " + mock.getTime()+ " called at : " +now);
//    }
//}