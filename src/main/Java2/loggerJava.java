package src.main.Java2;


import java.util.logging.Level;
import java.util.logging.Logger;

public class loggerJava {

    public static void main(String[] args)
    {

        // Create a Logger
        Logger logger
                = Logger
                .getLogger("com.api.jar");

        // Call info method
        logger.info("Welcome to gfg");
        logger.info("google of codes");
        // Create a Logger
        Logger logger1
                = Logger.getLogger(
                loggerJava.class.getName());

        // log messages using log(Level level, String msg)
        logger1.log(Level.INFO, "This is message 1");
        logger1.log(Level.WARNING, "This is message 2");
    }
}