package me.renf.gcm.output;

import me.renf.gcm.GenConfig;
import me.renf.gcm.exceptions.WriterException;

import java.io.*;

public class DataWriter {
    private GenConfig config;
    private Writer writer;

    public DataWriter(GenConfig config) throws WriterException{
        this.config = config;
        File outFile = new File(config.getOutFile());
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        }catch (FileNotFoundException e) {
            throw new WriterException(config.getOutFile() + " file not found");
        }
    }

    public void write(char[] chars) throws IOException{
        writer.write(chars);
    }

    public void write(String s) throws IOException {
        writer.write(s);
    }

    public void print(String s) throws IOException {
        writer.write(s);
    }

    public void println(String s) throws IOException {
        writer.write(s + "\n");
    }

    public void close() throws IOException{
        if (writer != null) writer.close();
    }
}
