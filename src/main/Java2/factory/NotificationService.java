package main.Java2.factory;
/**
 * Created by byang on 2018-12-30.
 */
public class NotificationService {
    public static void main(String[] args)
    {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");//so for factory use interface as instance type only,
        // because you not know which exact class you will use untill you see the paramter passed to factory
        notification.notifyUser();
        Notification notification1 = notificationFactory.createNotification("EMAIL");//remember use interface as type
        notification1.notifyUser();
        Notification notification2 = notificationFactory.createNotification("PUSH");//remember use interface as type
        notification2.notifyUser();
    }
}
