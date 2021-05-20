package Spring;

import org.springframework.context.annotation.*;

@Configuration
public class HelloWorldConfig {
    @Bean
    public HelloWorld1 helloWorld(){
        return new HelloWorld1();
    }
}