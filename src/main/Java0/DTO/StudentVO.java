package main.Java0.DTO;
//POJO example,POJO stands for Plain Old Java Object. It is an ordinary Java objectA POJO should not:
//
//Extend prespecified classes, Ex: public class GFG extends javax.servlet.http.HttpServlet { … } is not a POJO class.
//Implement prespecified interfaces, Ex: public class Bar implements javax.ejb.EntityBean { … } is not a POJO class.
//Contain prespecified annotations, Ex: @javax.persistence.Entity public class Baz { … } is not a POJO class.
public class StudentVO {
    private String name;
    private int rollNo;

    StudentVO(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
