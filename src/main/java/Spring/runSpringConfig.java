package Spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

public class runSpringConfig {
    public static void main(String[] args) {
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(HelloWorldConfig.class);

        HelloWorld1 helloWorld = ctx.getBean(HelloWorld1.class);
        helloWorld.setMessage("Hello World!");
        helloWorld.getMessage();
    }
}