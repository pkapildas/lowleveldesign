package logger;

import java.util.Date;
import static logger.LogLevel.ERROR;

public class ErrorLogProcessor extends LogProcessor{
    public ErrorLogProcessor(LogProcessor nexLogProcessor, LogSink logSink){
        super(nexLogProcessor, logSink);
    }
public void log(LogLevel logLevel,String message){
        if(logLevel == ERROR) {
                logSink.log("[" + new Date() + "][ERROR]"+message);
        } else{

            super.log(logLevel, message);
        }
   }
}