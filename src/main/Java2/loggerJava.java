package src.main.Java2;


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
    }
}