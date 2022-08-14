package emotionalsongs;

import prog.io.ConsoleOutputManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class EmotionalSongManager {

    final static String path = "src/DATA/Emozioni.dati.txt";

    public static void scriviEmoSong(ArrayList<EmotionalSong> emoSong) throws IOException {
        FileOutputStream fOS = new FileOutputStream(path);
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        oOS.writeObject(emoSong);
        oOS.flush();
        oOS.close();
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

    public static boolean verificaEmoInserite(Canzone canzone, Utente utente, Playlist playlist) throws IOException,ClassNotFoundException{
        File file = new File(path);
        ConsoleOutputManager out = new ConsoleOutputManager();
        ArrayList<EmotionalSong> arrEmo = new ArrayList<EmotionalSong>();
        boolean controllo = false;
        if(file.length() != 0){
            arrEmo = leggiEmoSong();
            for(EmotionalSong e : arrEmo){
                if(canzone.getTitolo().equals(e.getCanzone().getTitolo()) && utente.getUserId().equals(e.getUtente().getUserId())
                    && playlist.getNomePlaylist().equals(e.getPlaylist().getNomePlaylist())){
                    controllo = true;
                    try{
                        TimeUnit.SECONDS.sleep(1);
                        out.println("!Non è possibile inserire o modificare le emozioni inserite per il seguente brano!");
                        out.println(canzone.getTitolo() + " è già stato valutato.");
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException ex) {}
                }
            }
        }
        return controllo;
    }
}

