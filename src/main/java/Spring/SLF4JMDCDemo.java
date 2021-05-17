package Spring;


import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.slf4j.MDC;

public class SLF4JMDCDemo {
    private static Logger LOGGER = LoggerFactory.getLogger(SLF4JMDCDemo.class);

    public static void main(String[] args) {
        MDC.put("user", "rafal.kuc@sematext.com");
        LOGGER.info("This is an info level log message!");
        LOGGER.warn("This is an WARN level log");
    }
}