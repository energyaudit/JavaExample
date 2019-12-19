package main.Java3.JavaCompleteBeginner;


class MachineAn {
    public void start() {
        System.out.println("Starting machine ...");
    }
}

interface Plant3 {
    public void grow();
}

public class AnonymousClass  {

    public static void main(String[] args) {

        // This is equivalent to creating a class that "extends"
        // Machine and overrides the start method.
        MachineAn machine1 = new MachineAn() {
            @Override public void start() {
                System.out.println("Camera snapping ....");
            }
        };

        machine1.start();

        // This is equivalent to creating a class that "implements"
        // the Plant interface
        Plant3 plant1 = new Plant3() {// Plant3 plant1 = new Plant3() without {} will error
            @Override//this override annotation actually class implement interface
            public void grow() {
                System.out.println("Plant growing");

            }
        };

        plant1.grow();
    }
}