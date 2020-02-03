package main.Java3.JavaCompleteBeginner;



public class PassingCodeLambda  {

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run( () -> System.out.println("Hello there.") );

    }
}
