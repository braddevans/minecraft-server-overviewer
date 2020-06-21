package uk.co.piratescode.overview.util;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggingUtil {
    public static Logger log = LogManager.getLogger("MSO");

    public static void log(Level l, String s) {
        log.log(l, s);
    }

}
