package src.main.Java1;

/** Why do we use interface ?
 It is used to achieve total abstraction.
 Since java does not support multiple inheritance in case of class, but by using interface it can achieve multiple inheritance .
 It is also used to achieve loose coupling.
 Interfaces are used to implement abstraction. So the question arises why use interfaces when we have abstract classes?
 The reason is, abstract classes may contain non-final variables, whereas variables in interface are final, public and static.. */
//Since Java 8, we can have method body in interface. But we need to make it default method. Let's see an example:


interface Drawable{
    void draw();//All interface methods are public by default (even if you don't specify it explicitly in the interface definition)
    default void msg(){System.out.println("Since Java 8, we can have  default method body in interface.object can call default method" +
            ":default method");}//Since Java 8, we can have  default method body in interface.
}
class Rectangle2 implements Drawable{
    public void draw(){System.out.println("class Rectangle2 implements Drawable: drawing rectangle");}//
}
class TestInterfaceDefault{
    public static void main(String args[]){
        Drawable d=new Rectangle2();
        d.draw();
        d.msg();
    }}
