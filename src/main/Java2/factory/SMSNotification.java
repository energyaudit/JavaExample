package main.Java2.factory;
/**
 * Created by byang on 2018-12-30.
 */
public class SMSNotification implements Notification {

    @Override
    public void notifyUser()
    {
         System.out.println("Sending an SMS notification");
    }
}
