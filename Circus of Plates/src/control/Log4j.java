package control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * In log4j , the ordering of log levels is: ALL < TRACE < DEBUG < INFO < WARN <
 * ERROR < FATAL < OFF
 * 
 * @author Dahlia
 *
 */

public class Log4j {

  private static final Logger logger = LogManager.getLogger(Log4j.class.getName());

  public static void success(String message) {
    logger.trace(message);
  }

  public static void fail(String message) {
    logger.error(message);
  }

  public static void severeError(String message) {
    logger.fatal(message);
  }

  public static void warn(String message) {
    logger.warn(message);
  }

  public static void good(String message) {
    logger.debug(message);
  }

  public static void progress(String message) {
    logger.info(message);
  }
}
