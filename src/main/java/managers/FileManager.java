package managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {
    public static String getTextFromFile(String fileName) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName));
            StringBuilder s = new StringBuilder();
            int curB = inputStreamReader.read();
            while (curB != -1) {
                s.append((char) curB);
                curB = inputStreamReader.read();
            }
            inputStreamReader.close();
            return s.toString();
        } catch (IOException e) {
            return "ошибка ввода-вывода";
        }
    }
}