package main.Java2;

/**
 * The Model View Controller (MVC) design pattern specifies that an application consist of a data model, presentation
 * information, and control information. The pattern requires that each of these be separated into different objects.
 * MVC is more of an architectural pattern, but not for complete application. MVC mostly relates to the UI /
 * interaction layer of an application. You’re still going to need business logic layer, maybe some service
 * layer and data access layer.
 */
class StudentMVC
{
    private String rollNo;
    private String name;

    public String getRollNo()
    {
        return rollNo;
    }

    public void setRollNo(String rollNo)
    {
        this.rollNo = rollNo;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

class StudentView
{
    public void printStudentDetails(String studentName, String studentRollNo)
    {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No: " + studentRollNo);
    }
}

class StudentController
{
    private StudentMVC model;
    private StudentView view;

    public StudentController(StudentMVC model, StudentView view)
    {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name)
    {
        model.setName(name);
    }

    public String getStudentName()
    {
        return model.getName();
    }

    public void setStudentRollNo(String rollNo)
    {
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo()
    {
        return model.getRollNo();
    }

    public void updateView()
    {
        view.printStudentDetails(model.getName(), model.getRollNo());
    }
}

//class MVCPattern
public class MVCPattern
{
    public static void main(String[] args)
    {
        StudentMVC model  = retriveStudentFromDatabase();

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName("Vikram Sharma");

        controller.updateView();
    }

    private static StudentMVC retriveStudentFromDatabase()
    {
        StudentMVC student = new StudentMVC();
        student.setName("Lokesh Sharma");
        student.setRollNo("15UCS157");
        return student;
    }

}