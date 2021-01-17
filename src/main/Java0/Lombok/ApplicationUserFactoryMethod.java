package main.Java0.Lombok;

/**
 * Java Constructors vs Static Factory Methods,imposed by the language. Static factory methods can have meaningful names,
 * hence explicitly conveying what they do
 *  Static factory methods can encapsulate all the logic required for pre-constructing fully initialized instances,
 *  so they can be used for moving this additional logic out of constructors. This prevents constructors from
 *  performing further tasks, others than just initializing fields
 * Static factory methods can be controlled-instanced methods, with the Singleton pattern being the most
 * glaring example of this feature,Static Factory Methods in the JDK:String value1 = String.valueOf(1);
 * String value2 = String.valueOf(1.0L); String value3 = String.valueOf(true);Quite possibly the most representative example of
 * static factory methods in the JDK is the Collections class.Collection syncedCollection =
 * Collections.synchronizedCollection(originalCollection);//Set syncedSet = Collections.synchronizedSet(new HashSet());
 */


public class ApplicationUserFactoryMethod {

    public static void main(String[] args) {
        UserFactoryMethod user1 = UserFactoryMethod.createWithDefaultCountry("John", "john@domain.com");
        UserFactoryMethod user2 = UserFactoryMethod.createWithLoggedInstantiationTime("John", "john@domain.com", "Argentina");
        UserFactoryMethod user3 = UserFactoryMethod.getSingletonInstance("John", "john@domain.com", "Argentina");
    }
}