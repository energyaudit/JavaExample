package sprintBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ComponentExp {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ComponentExp.class, args);
        ComponentDemo componentDemo = (ComponentDemo) applicationContext.getBean("componentDemo");
        System.out.println(componentDemo.getValue());
    }
}


@Component
class ComponentDemo {
    public String getValue() {
        return "Hello World";
    }
}
