package main.Java0;

/**
 * Created by byang on 1/19/2018.
 */
public class Employee
{
    int id;
    String name;
    float salary;
    void insert(int i, String n, float s) {
        id=i;
        name=n;
        salary=s;
    }
    void display(){System.out.println(id+" "+name+" "+salary);}
    public void display2(){System.out.println("public method can be accessed outside");}
}
