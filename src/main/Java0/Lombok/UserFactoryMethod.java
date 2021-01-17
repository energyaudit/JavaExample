package main.Java0.Lombok;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserFactoryMethod {

    private static volatile UserFactoryMethod instance = null;
    private static final Logger LOGGER = Logger.getLogger(UserFactoryMethod.class.getName());
    private final String name;
    private final String email;
    private final String country;

    /**
     *if we use constructor,What if we want that all the User instances get a default value for the country field?
     If we initialize the field with a default value, we'd have to refactor the constructor too,
     */
    public static UserFactoryMethod createWithDefaultCountry(String name, String email) {
        return new UserFactoryMethod(name, email, "Argentina");
    }

    /**
     *Moving Logic out of Constructors.If we just put this logic into the constructor, we'd be breaking the
     * Single Responsibility Principle.We can keep our design clean with a static factory method:
     */
    public static UserFactoryMethod createWithLoggedInstantiationTime(String name, String email, String country) {
        LOGGER.log(Level.INFO, "Creating User instance at : {0}", LocalTime.now());

        return new UserFactoryMethod(name, email, country);
    }

    /**
     * suppose we want to make our User class a Singleton. We can achieve this by implementing an
     * instance-controlled static factory method:the getSingletonInstance() method is thread-safe, with a small performance
     * penalty, due to the synchronized block.In this case, we used lazy initialization to demonstrate the implementation
     * of an instance-controlled static factory method.It's worth mentioning, however, that the best way to implement
     * a Singleton is with a Java enum type, as it's both serialization-safe and thread-safe
     */
    public static UserFactoryMethod getSingletonInstance(String name, String email, String country) {
        if (instance == null) {
            synchronized (UserFactoryMethod.class) {
                if (instance == null) {
                    instance = new UserFactoryMethod(name, email, country);
                }
            }
        }
        return instance;

    }

    private UserFactoryMethod(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }
}
