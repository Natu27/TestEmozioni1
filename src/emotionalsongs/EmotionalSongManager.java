package emotionalsongs;

import prog.io.ConsoleOutputManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * La classe {@code EmotionalSongManager} permette di leggere/scrivere emozioni sul file di testo Emozioni.dati e controllare le emozioni inserite
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 */

public class EmotionalSongManager {

    /**
     * Permette di scrivere sul file di testo Emozioni.dati le emozioni relative ai brani musicali valutati contenuti all'interno dell'array passato come argomento
     * @param emoSong un oggetto di tipo {@code ArrayList<EmotionalSong>}
     * @throws IOException
     */
    public static void scriviEmoSong(ArrayList<EmotionalSong> emoSong) throws IOException {
        FileOutputStream fOS = new FileOutputStream(PathManager.getPath(PathType.emotion));
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        oOS.writeObject(emoSong);
        oOS.flush();
        oOS.close();
    }

    /**
     * Permette di leggere le emozioni presenti nel file di testo Emozioni.dati e salvarle all'interno di un ArrayList
     * @return un oggetto di tipo {@code ArrayList<EmotionalSong>}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<EmotionalSong> leggiEmoSong() throws IOException, ClassNotFoundException {
        Object ob = FileManager.leggiFile(PathManager.getPath(PathType.emotion));
        ArrayList<EmotionalSong> arrEmo = new ArrayList<EmotionalSong>();
        if(ob instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) ob;
            arrEmo = castArrayEmo(tmp);
        }
        return arrEmo;
    }

    /**
     * Permette di aggiungere tramite cast, partendo dal parametro fornito come argomento, oggetti di tipo EmotionalSong all'interno di un ArrayList
     * @param arrProv un oggetto di tipo {@code ArrayList<EmotionalSong>}
     * @return un oggetto di tipo {@code ArrayList<EmotionalSong>}
     */
    public static ArrayList<EmotionalSong> castArrayEmo(ArrayList<?> arrProv) {
        ArrayList<EmotionalSong> arrEmo = new ArrayList<EmotionalSong>();
        for(Object ob : arrProv) {
            if(ob instanceof EmotionalSong) {
                arrEmo.add((EmotionalSong) ob);
            }
        }
        return arrEmo;
    }

    /**
     * Permette di stabilire, a partire dai parametri passati come argomento, la valutazione di una canzone inserita all'interno di una playlist
     * @param canzone un oggetto di tipo {@code Canzone}
     * @param utente un oggetto di tipo {@code Utente}
     * @param playlist un oggetto di tipo {@code Playlist}
     * @return un oggetto di tipo {@code boolean}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static boolean verificaEmoInserite(Canzone canzone, Utente utente, Playlist playlist) throws IOException,ClassNotFoundException {
        File file = new File(PathManager.getPath(PathType.emotion));
        ConsoleOutputManager out = new ConsoleOutputManager();
        ArrayList<EmotionalSong> arrEmo = new ArrayList<EmotionalSong>();
        boolean controllo = false;
        if(file.length() != 0){
            arrEmo = leggiEmoSong();
            for(EmotionalSong e : arrEmo){
                if(canzone.getTitolo().equals(e.getCanzone().getTitolo()) && utente.getUserId().equals(e.getUtente().getUserId())
                    && playlist.getNomePlaylist().equals(e.getPlaylist().getNomePlaylist())) {
                    controllo = true;
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        out.println("!Non è possibile inserire o modificare le emozioni inserite per il seguente brano!");
                        out.println(canzone.getTitolo() + " è già stato valutato.");
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException ex) {}
                }
            }
        }
        return controllo;
    }
}

