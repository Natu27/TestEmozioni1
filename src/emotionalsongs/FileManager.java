package emotionalsongs;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static Object leggiFile(String path) throws IOException, ClassNotFoundException {
        Object ob = null;
        FileInputStream fIS = new FileInputStream(path);
        ObjectInputStream oIS = new ObjectInputStream(fIS);
        ob = oIS.readObject();
        oIS.close();
        return ob;
    }

    public static void scriviFile(String path, ArrayList<?> array) throws IOException {
        FileOutputStream fOS = new FileOutputStream(path);
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        oOS.writeObject(array);
        oOS.flush();
        oOS.close();
    }
}


