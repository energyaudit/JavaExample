package main.Java3.JavaCompleteBeginner;


class Machine {
    public void start() {
        System.out.println("Machine started.");
    }
}

class Camera extends Machine5 {
    public void start() {
        System.out.println("Camera started.");
    }

    public void snap() {
        System.out.println("Photo taken.");
    }
}


public class UpDownCasting  {
    public static void main(String[] args) {

        Machine5 machine1 = new Machine5();
        Camera camera1 = new Camera();

        machine1.start();
        camera1.start();
        camera1.snap();

        // Upcasting
        Machine5 machine2 = camera1;//because camera is machine of course ,so no need () for upcast
        machine2.start();//method called depend on the actual object not the type you casting to
        // error: machine2.snap();//type of variable determine what object you can call ,and actual object determine parent or son method to call

        // Downcasting
        Machine5 machine3 = new Camera();
        Camera camera2 = (Camera)machine3;
        camera2.start();
        camera2.snap();

        // Doesn't work --- runtime error.
        Machine5 machine4 = new Machine5();
        // Camera camera3 = (Camera)machine4;//not every machine is camera so this cast is wrong.
        // camera3.start();
        // camera3.snap();
    }

}