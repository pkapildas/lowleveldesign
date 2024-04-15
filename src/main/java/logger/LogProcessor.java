package logger;

public abstract class LogProcessor {
    LogLevel logLevel;
    LogProcessor nextLogProcessor;
    LogSink logSink;
    public LogProcessor(LogProcessor nextLogProcessor, LogSink logSink){

        this.nextLogProcessor = nextLogProcessor;
        this.logSink = logSink;
    }

    public void log(LogLevel logLevel, String message){
        if(nextLogProcessor!=null){
            nextLogProcessor.log(logLevel, message);
        }
    }
}