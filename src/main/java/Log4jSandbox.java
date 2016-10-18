import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;

public class Log4jSandbox {
    final static Logger logger = Logger.getLogger(Log4jSandbox.class);

    public static void main(String[] args) {
        // Pass 0 for Property file, or 1 for XML file.
        configureLog4jLogging(0);
        executeLog4jLogging();

    }

    private static void configureLog4jLogging(int configurationOption) {
        if (configurationOption == 0) {
            configureWithPropertyFile();
        } else {
            configureWithXMLFile();
        }
    }

    private static void configureWithPropertyFile() {
        String log4jConfigFile = new StringBuilder().append(System.getProperty("user.dir")).append(File.separator).append("conf").append(File.separator).append("log4j.properties").toString();
        logger.debug("Config file is: " + log4jConfigFile);
        PropertyConfigurator.configure(log4jConfigFile);
    }

    private static void configureWithXMLFile() {
        String log4jConfigFile = new StringBuilder().append(System.getProperty("user.dir")).append(File.separator).append("conf").append(File.separator).append("log4j.xml").toString();
        logger.debug("Config file is: " + log4jConfigFile);
        DOMConfigurator.configure(log4jConfigFile);
    }

    private static void executeLog4jLogging() {
        try {
            while (true) {
                logger.info("Running Log4jSandbox endless loop test");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            logger.warn(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
