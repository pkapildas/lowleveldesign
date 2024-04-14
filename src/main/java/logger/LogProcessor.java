public abstract class LogProcessor {
    LogLevel logLevel;
    LogProcessor nextLogProcessor;
    public LogProcessor(LogProcessor nextLogProcessor){
        nextLogProcessor = nextLogProcessor;
    }

    public void log(LogLevel logLevel, String message){
        if(nextLogProcessor!=null){
            nextLogProcessor.log(logLevel, message);
        }
    }
}