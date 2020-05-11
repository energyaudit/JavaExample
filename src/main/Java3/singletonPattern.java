package main.Java3;

/**
 * It means only one  and only one instance of JavaHungry class we  can have at any point of execution in the application code
 * *   We  should create a static variable so that it can hold one single instance of our class .
 * private static JavaHungrySingleton  uniqueInstance ;
 * *   We should declare the constructor private so that  only Class itself can instantiate the object .
 */
public class singletonPattern {
    private static singletonPattern   uniqueInstance;
    private singletonPattern (){}
    public static  synchronized  singletonPattern   getInstance()
    {
        if (uniqueInstance ==null )
        {
            uniqueInstance=new singletonPattern ();
        }
        return uniqueInstance ;
    }
}
/**
 * The return type should be of the class object . But there is possibility that two threads simultaneously try to
 *   access the method and we might end up with two different class objects , thats why method is     synchronized . In other words , By adding synchronized keyword to the method , we force every thread
 *   to wait for its turn before it can enter the method
 */