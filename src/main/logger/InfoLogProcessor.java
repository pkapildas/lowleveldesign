public class InfoLogProcessor extends LogProcessor{
    public InfoLogProcessor(LogProcessor nexLogProcessor){
        super(nexLogProcessor);
    }
public void log(LogLevel logLevel,String message){
    if(logLevel == INFO) {
            logSink.log("[" + new Date() + "][INFO]"+message);
    } else{

        super.log(logLevel, message);
    }
}
}