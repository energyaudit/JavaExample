package src.main.Java3;

/**
 Why do we use interface ?
 It is used to achieve total abstraction.
 Since java does not support multiple inheritance in case of class, but by using interface it can achieve multiple inheritance .
 It is also used to achieve loose coupling.
 Interfaces are used to implement abstraction. So the question arises why use interfaces when we have abstract classes?
 The reason is, abstract classes may contain non-final variables, whereas variables in interface are final, public and static.
 */
interface Age
{
    int x = 21;
    void getAge();
}
class AnonymousDemo
{
    public static void main(String[] args)
    {
        // Myclass is implementation class of Age interface
        MyClass obj=new MyClass();
        // calling getage() method implemented at Myclass
        obj.getAge();
    }
}
// Myclass implement the methods of Age Interface, this can be placed after main still works
class MyClass implements Age//Myclass IS required to override
{
    @Override
    public void getAge()
    {
        // printing the age
        System.out.print("Age is "+x);
    }
}