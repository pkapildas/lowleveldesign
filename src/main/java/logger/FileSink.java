package logger;

import java.io.IOException;
import java.io.PrintWriter;

public class FileSink implements LogSink{

    private String filename;

    public FileSink(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {
        try {
            PrintWriter writer = new PrintWriter(filename);
            writer.println("FILE: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
