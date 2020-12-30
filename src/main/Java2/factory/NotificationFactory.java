package main.Java2.factory;
/**
 * Created by byang on 2018-12-30.
 */
public class NotificationFactory {
    public Notification createNotification(String channel) {
        switch (channel) {
            case "SMS":
                return new SMSNotification();
            case "EMAIL":
                return new EmailNotification();
            case "PUSH":
                return new PushNotification();
            default:
                return null;
        }
    }
}
