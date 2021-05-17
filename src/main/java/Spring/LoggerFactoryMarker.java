package Spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class LoggerFactoryMarker {
    private static Logger LOGGER = LoggerFactory.getLogger(LoggerFactoryMarker.class);
    private static final Marker IMPORTANT = MarkerFactory.getMarker("IMPORTANT");

    public static void main(String[] args) {
        LOGGER.info("This is a log message that is not important!");
        LOGGER.info(IMPORTANT, "This is a very important log message!");
    }
}