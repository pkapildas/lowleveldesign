package logger;

public class TestLogger {
    public static void main(String args[]) {
/**
 * Logger Imp
 */
        LogSink fileSink = new FileSink("abc.txt");
        ErrorLogProcessor nexErrorLogProcessor = new ErrorLogProcessor(null, fileSink);
        DebugLogProcessor debugLogProcessor = new DebugLogProcessor(nexErrorLogProcessor, fileSink);

        LogProcessor logObject = new InfoLogProcessor(debugLogProcessor,fileSink);

        logObject.log(LogLevel.ERROR, "exception happens");
        logObject.log(LogLevel.DEBUG, "need to debug this ");
        logObject.log(LogLevel.INFO, "just for info ");

    }
}
