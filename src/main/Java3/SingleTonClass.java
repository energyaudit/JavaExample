package src.main.Java3;

/**
 * Created by byang on 4/5/2018.Suppose we are creating a singleton class JavaHungry . It means only one  and only one instance of JavaHungry class we  can have at any point of execution in the application code
 * *   We  should create a static variable so that it can hold one single instance of our class .
 *          private static JavaHungrySingleton  uniqueInstance ;
 * *   We should declare the constructor private so that  only Class itself can instantiate the object .
 */
public class SingleTonClass {
    //Static Class Reference
    private static SingleTonClass obj=null;
    private SingleTonClass(){
      /*Private Constructor will prevent
       * the instantiation of this class directly*/
    }
    public static SingleTonClass objectCreationMethod(){
	/*This logic will ensure that no more than
	 * one object can be created at a time */
        if(obj==null){
            obj= new SingleTonClass();
        }
        return obj;
    }
    public void display(){
        System.out.println("Singleton class Example");
    }
    public static void main(String args[]){
        //Object cannot be created directly due to private constructor
        //This way it is forced to create object via our method where
        //we have logic for only one object creation
        SingleTonClass myobject= SingleTonClass.objectCreationMethod();
        myobject.display();
    }
}
