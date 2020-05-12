package src.main.Java1;

/**
 Why do we use interface ?
 It is used to achieve total abstraction.
 Since java does not support multiple inheritance in case of class, but by using interface it can achieve multiple inheritance .
 It is also used to achieve loose coupling.
 Interfaces are used to implement abstraction. So the question arises why use interfaces when we have abstract classes?
 The reason is, abstract classes may contain non-final variables, whereas variables in interface are final, public and static.
 */
interface DrawableStatic{
    void draw();//abstract method
    static int cube(int x){return x*x*x;}//Since Java 8, we can have static method in interface.
}
class RectangleStatic implements DrawableStatic{
    public void draw(){System.out.println("casting class type to interface implemented,drawing rectangle:" +
            "One reason is that you want to ensure that no methods that aren't part of the contract are called on the object.");}//give details of interface method
}

class TestInterfaceStatic{
    public static void main(String args[]){
        DrawableStatic d=new RectangleStatic();
      //  RectangleStatic d=new RectangleStatic();
        d.draw();
        System.out.println(DrawableStatic.cube(3));//interface method
    }}
