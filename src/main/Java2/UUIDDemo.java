package main.Java2;

import java.util.*;

public class UUIDDemo {
    public static void main(String[] args) {
        // creating UUID
        UUID uid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        // checking UUID value
        System.out.println("UUID value is: "+uid);
        String uid1="ed5eba9e-8f16-4082-8f5f-a8e8adb854a7";
        System.out.println("UUID value1 is: "+UUID.fromString(uid1));
        System.out.println(uid1.length());
    }
}
