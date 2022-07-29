package emotionalsongs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EmotionalSongManager {

    final static String path = "src/DATA/Emozioni.dati.txt";
    //public static ArrayList<EmotionalSong> arrEmo = new ArrayList<EmotionalSong>();

    public static void scriviEmoSong(ArrayList<EmotionalSong> emoSong) throws IOException {
        FileOutputStream fOS = new FileOutputStream(path);
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        oOS.writeObject(emoSong);
        oOS.flush();
        oOS.close();
        //arrEmo.add(emoSong);
    }

    public static ArrayList<EmotionalSong> leggiEmoSong() throws IOException, ClassNotFoundException {
        Object ob = FileManager.leggiFile(path);
        ArrayList<EmotionalSong> arrEmo = new ArrayList<EmotionalSong>();
        if(ob instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) ob;
            arrEmo = castArrayEmo(tmp);
        }
        return arrEmo;
    }

    public static ArrayList<EmotionalSong> castArrayEmo(ArrayList<?> arrProv) {
        ArrayList<EmotionalSong> arrEmo = new ArrayList<EmotionalSong>();
        for(Object ob : arrProv) {
            if(ob instanceof EmotionalSong) {
                arrEmo.add((EmotionalSong) ob);
            }
        }
        return arrEmo;
    }
}

