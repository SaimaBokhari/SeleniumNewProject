package tests.log4Jtests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day15_Log4J2 {
    // Create object
    private  static Logger logger = LogManager.getLogger(Day15_Log4J2.class.getName());

    @Test
    public void test1(){
        // Use logger object to log/print information

        logger.fatal("FATAL");
        logger.error("ERROR");
        logger.warn("WARNING");
        logger.debug("DEBUG");
        logger.info("INFO");

        // We want to print all loggers in this folder, so we apply special settings in our xml file for this folder.
        // can be configured  with an xml file.

        /*
         <!--       Special setting for this package tests.log4Jtests Folder   -->
        <Logger name="tests.log4Jtests" level="trace" additivity="false">
            <AppenderRef ref="Console"/>
            <AppenderRef ref="file"/>
        </Logger>

         */
    }
}
