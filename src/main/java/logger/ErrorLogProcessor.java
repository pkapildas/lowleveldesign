package logger;
public class ErrorLogProcessor extends LogProcessor{
    public ErrorLogProcessor(LogProcessor nexLogProcessor){
        super(nexLogProcessor);
    }
public void log(LogLevel logLevel,String message){
        if(logLevel == ERROR) {
                logSink.log("[" + new Date() + "][ERROR]"+message);
        } else{

            super.log(logLevel, message);
        }
   }
}