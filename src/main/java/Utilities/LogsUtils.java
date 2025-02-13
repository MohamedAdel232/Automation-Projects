package Utilities;

import org.apache.logging.log4j.LogManager;

public class LogsUtils {
    public static void info(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2])
                .info(msg);
    }

    public static void error(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2])
                .error(msg);
    }

    public static void warn(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2])
                .warn(msg);
    }

    public static void fatal(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2])
                .fatal(msg);
    }

    public static void debug(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2])
                .debug(msg);
    }

    public static void trace(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2])
                .trace(msg);
    }
}
