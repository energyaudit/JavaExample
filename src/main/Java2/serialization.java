package main.Java2;

/**
 * Created by byang on 2018-06-08.
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


class StudentSer implements Serializable {
    //Serial Version UID.
    private static final long serialVersionUID = 1L;
    String name;
    String className;
    String rollNo;

    //Constructor.
    StudentSer(String name, String className, String rollNo) {
        this.name = name;
        this.className = className;
        this.rollNo = rollNo;
    }
}

class TestSe {
    //Write serialized object into objectoutputstream.
    public void objectSerialization(StudentSer stu) {
        try {
            //Creating FileOutputStream object.
            FileOutputStream fos =
                    new FileOutputStream("src/main/TESTRESULT/student.ser");

            //Creating ObjectOutputStream object.
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            //write object.
            oos.writeObject(stu);

            //close streams.
            oos.close();
            fos.close();

            System.out.println("Serialized data is saved in " +
                    "src/main/TESTRESULT/student.ser");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}


class TestDse {
    //Deserialize a serialize object.
    public void objectDeSerialization() {
        try {
            StudentSer stu = null;
            //Creating FileOutputStream object.
            FileInputStream fis =
                    new FileInputStream("src/main/TESTRESULT/student.ser");

            //Creating ObjectOutputStream object.
            ObjectInputStream ois = new ObjectInputStream(fis);

            //write object.
            stu = (StudentSer) ois.readObject();

            //close streams.
            ois.close();
            fis.close();

            System.out.println("Name = " + stu.name);
            System.out.println("Class Name = " + stu.className);
            System.out.println("RollNo = " + stu.rollNo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class serialization {
    public static void main(String args[]) {
        //Creating Student object.
        StudentSer stu =
                new StudentSer("Parmander", "MCA", "MCA/07/27");
        //Creating Test object.
        TestSe obj = new TestSe();
        //Method call.
        obj.objectSerialization(stu);


        TestDse obj1 = new TestDse();
        //Method call.
        obj1.objectDeSerialization();
    }
}