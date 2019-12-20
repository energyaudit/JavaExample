package main.Java3.JavaCompleteBeginner;

import java.io.Serializable;
 
public class PersonSeria implements Serializable {
     
    private static final long serialVersionUID = 4801633306273802062L;
     
    private int id;
    private String name;
     
    public PersonSeria(int id, String name) {
        this.id = id;
        this.name = name;
    }
 
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }
}
 
// www.caveofprogramming.com