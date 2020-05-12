package src.main.Java1;
/**
 Why do we use interface ?
 It is used to achieve total abstraction.
 Since java does not support multiple inheritance in case of class, but by using interface it can achieve multiple inheritance .
 It is also used to achieve loose coupling.
 Interfaces are used to implement abstraction. So the question arises why use interfaces when we have abstract classes?
 The reason is, abstract classes may contain non-final variables, whereas variables in interface are final, public and static.
 */
interface Printable1{
    void print();
}
interface Showable1{
    void print2();//method same as interface printable1
}

class TestInterface3 implements Printable1, Showable1{//Multiple inheritance is not supported through class in java but it is possible by interface,
    public void print(){System.out.println("Multiple inheritance is not supported through class in java but it is possible by interface," +
            "Printable Method:Hello1");}//because one class can have multiple functions,
    public void print2(){System.out.println("Multiple inheritance is not supported through class in java but it is possible by interface," +
            "Printable Method:Hello2");}
    public static void main(String args[]){
        TestInterface3 obj = new TestInterface3();//
        obj.print();//
        obj.print2();//
    }
}
