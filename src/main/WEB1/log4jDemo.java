package main.WEB1;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class log4jDemo {
static Logger logger = LogManager.getLogger(log4jDemo.class);
    public static void main(String[] args) {
        BasicConfigurator.configure();
        System.out.println("Hello world!");
        logger.info(" This is log info");
        logger.error(" This is ERROR info");
        logger.warn(" This is WARN info");
    }
}