package redserver.redserver.gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class GSONManager {

    public static String readFile(File fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            StringBuilder builder = new StringBuilder();
            for(int ch; (ch = fileReader.read()) != -1;) {
                builder.appendCodePoint(ch);
            }
            String message = builder.toString();
            fileReader.close();
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(File fileName, String toWrite) {
        try {
            fileName.createNewFile();
            FileWriter fileWriter = new FileWriter(fileName);
            for(int i = 0; i < toWrite.length(); i++) {
                fileWriter.write(toWrite.charAt(i));
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
