package src.main.Java1;

/**
 Why do we use interface ?
 It is used to achieve total abstraction.
 Since java does not support multiple inheritance in case of class, but by using interface it can achieve multiple inheritance .
 It is also used to achieve loose coupling.
 Interfaces are used to implement abstraction. So the question arises why use interfaces when we have abstract classes?
 The reason is, abstract classes may contain non-final variables, whereas variables in interface are final, public and static.
 */
interface A2{
    void a();
    void b();
    void c();
    void d();
}

abstract class B implements A2{//has little collar at left top corner of logo to show it is abstract
    public void c(){System.out.println("Abstract class B implement Interface A2: I am c");}
}

class M extends B{//few classes can in same class file
    public void a(){System.out.println("I am a");}
    public void b(){System.out.println("I am b");}
    public void d(){System.out.println("I am d");}
}

class Test5{//class with main has a triangle in logo to show it is runnable.
    public static void main(String args[]){
        A2 a=new M();
        a.a();
        a.b();
        a.c();
        a.d();
    }}
