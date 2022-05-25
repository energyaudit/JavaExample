package main.Java2;

/**
 * Created by byang on 2022-05-16.
 */

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Random;


public class propertyValueUpdate {//Properties class is a subclass of Hashtable
    private static final Logger log = LogManager.getLogger(propertyValueUpdate.class);
    public static void main(String[] args) throws ConfigurationException {

        PropertiesConfiguration config = new PropertiesConfiguration("./src/main/resources/application.properties");
        Random random = new Random();
        Integer inputId = random.nextInt(1000000);
        log.debug("inputId is: "+inputId);
        System.out.println("inputId is: "+inputId);
        config.setProperty("MswLiaLoginAccount", "new value"+inputId);
          config.save();

    }
}