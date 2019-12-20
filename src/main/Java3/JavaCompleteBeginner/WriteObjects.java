package main.Java3.JavaCompleteBeginner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
 
 
 
public class WriteObjects {
 
    public static void main(String[] args) {
        System.out.println("Writing objects...");
 
        PersonSeria mike = new PersonSeria(543, "Mike");
        PersonSeria sue = new PersonSeria(123, "Sue");
         
        System.out.println(mike);
        System.out.println(sue);
         
        try(FileOutputStream fs = new FileOutputStream("people.bin")) {
             
            ObjectOutputStream os = new ObjectOutputStream(fs);
             
            os.writeObject(mike);
            os.writeObject(sue);
             
            os.close();
             
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     
    }
 
}