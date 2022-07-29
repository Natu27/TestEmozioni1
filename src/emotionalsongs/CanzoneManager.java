package emotionalsongs;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CanzoneManager {

    final static String path = "src/DATA/Canzoni.dati.txt";

    public static ArrayList<Canzone> leggiCanzone() throws IOException, ClassNotFoundException {
        Object ob = FileManager.leggiFile(path);
        ArrayList<Canzone> songs = new ArrayList<Canzone>();
        if(ob instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) ob;
            songs = castArray(tmp);
        }
        return songs;
    }

    public static ArrayList<Canzone> castArray(ArrayList<?> arr) {
        ArrayList<Canzone> songs = new ArrayList<Canzone>();
        for(Object ob : arr) {
            if(ob instanceof Canzone) {
                songs.add((Canzone) ob);
            }
        }
        return songs;
    }

    public static void scriviCanzone(ArrayList<Canzone> arr) throws IOException {
        FileManager.scriviFile(path, arr);
    }
}
