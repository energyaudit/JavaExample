package main.Java2.factory;
/**
 * Created by byang on 2018-12-30.
 */
public class PushNotification implements Notification {

    @Override
    public void notifyUser()
    {
         System.out.println("Sending a push notification");
    }
}
