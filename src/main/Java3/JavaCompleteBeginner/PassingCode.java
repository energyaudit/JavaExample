package main.Java3.JavaCompleteBeginner;



interface Executable {
    void execute();
}

class Runner {
    public void run(Executable e) {
        e.execute();
    }
}

public class PassingCode {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run(new Executable() {
            public void execute() {
                System.out.println("Hello there.");
            }
        });
    }
}
