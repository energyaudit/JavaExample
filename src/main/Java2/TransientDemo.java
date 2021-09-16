package main.Java2;
/**
 * In the code below, we have created a Member class object with a transient int id and a simple String name.
 * Since the id is transient,​ it cannot be written in the file, so ​0 is stored instead.transient
 * keyword plays an important role to meet security constraints. There are various real-life examples where
 * we don’t want to save private data in file
 */

import java.io.Serializable;
        import java.io.*;

class TransientDemo {

    public static class  Member implements Serializable{
        transient int id; // This will not serialized.
        String name;
        // constructor
        public Member(int i, String k) {
            this.id = i;
            this.name = k;
        }
    }

    public static void main(String args[]) throws Exception {
        Member temp =new Member( 2, "Clausia");//creating object
        //writing temp object into file
        FileOutputStream fread=new FileOutputStream("src/main/TESTRESULT/member.txt");
        ObjectOutputStream fout=new ObjectOutputStream(fread);
        fout.writeObject(temp);
        fout.flush();

        fout.close();
        fread.close();
        System.out.println("Data successfully saved in a file");

        // retrieving the data from file.
        ObjectInputStream fin=new ObjectInputStream(new FileInputStream("src/main/TESTRESULT/member.txt"));
        Member membr=(Member)fin.readObject();
        System.out.println(membr.id+" "+membr.name+" ");
        fin.close();
    }
}