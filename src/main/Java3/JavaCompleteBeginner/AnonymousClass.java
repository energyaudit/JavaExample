package main.Java3.JavaCompleteBeginner;


class Machine5 {
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
        Machine5 machine1 = new Machine5() {
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