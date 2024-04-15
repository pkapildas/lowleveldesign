package logger;

import java.util.Date;

import static logger.LogLevel.INFO;


public class InfoLogProcessor extends LogProcessor{
    public InfoLogProcessor(LogProcessor nexLogProcessor, LogSink logSink){

        super(nexLogProcessor, logSink);
    }
public void log(LogLevel logLevel,String message){
    if(logLevel == INFO) {
            logSink.log("[" + new Date() + "][INFO]"+message);
    } else{

        super.log(logLevel, message);
    }
}
}