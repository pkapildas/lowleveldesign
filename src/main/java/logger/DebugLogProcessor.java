package logger;

import java.util.Date;

import static logger.LogLevel.DEBUG;
import static logger.LogLevel.ERROR;

public class DebugLogProcessor extends LogProcessor{
    public DebugLogProcessor(LogProcessor nexLogProcessor, LogSink logSink){
        super(nexLogProcessor, logSink);
    }
public void log(LogLevel logLevel,String message){
        if(logLevel == DEBUG) {
                logSink.log("[" + new Date() + "][DEBUG]"+message);
        } else{

            super.log(logLevel, message);
        }
   }
}