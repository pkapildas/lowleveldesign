package logger;

public class ConsoleSink implements LogSink{
    @Override
    public void log(String message) {
        System.out.println("CONSOLE: " + message);

    }
}
