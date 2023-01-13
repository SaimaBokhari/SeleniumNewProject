package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Day15_Log4J2 {

    // Create object
    private static Logger logger = LogManager.getLogger(Day15_Log4J2.class.getName());


    @Test
    public void log4jTest(){
        // Use logger object to print (log) information
        logger.fatal("Fatal Log!!");  // Prints by default
        logger.error("Error Log!!");  // Prints by default
        logger.warn("Warning Log!!");
        logger.debug("Debug Log!!");
        logger.info("Info Log!!");

        // By default, it will show Fatal and Error log only

        // To see more result, we need to create a xml file
        // Official site https://logging.apache.org/log4j/2.x/manual/configuration.html




    }
}
/*
    What is log4j?
    It is an API to log information on the console OR in a file. (log means to print)
    Similar to Extent Reports but less advanced.

    > It's similar to System.out.println but advanced version (which shows the message on the console only, doesn't save it as a file)
       while log4J can print and store the message with time stamp.

    We don't use a lot of Log4j, we prefer Extent Reports. It's mostly used by the developers

    we'll use log4j2 ... means 2nd version which is the latest so far

    The log4j is used informing about the tests.. but this is not the best form of reports.. There are better ways of
    creating reports in Cucumber.


// Note: To change the levels, we

1. Create a folder in project level  : resources
2. Create a log file under resources : log4j2.xml
3. Mark Directory as > Test Resource Root

 and add this repository in the log4j2.xml   (used for small example, later we added the full configuration that's still in xml file)

 <?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Root level="error">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>

CHANGE THE LEVEL, AND CHANGE THE DEFAULT BEHAVIOUR OF THE LOG/PRINT
error > prints default messages only
info > prints higher level messages
trace > prints higher level messages
etc.

     */