package emotionalsongs;

//import java.io.File;
import java.io.IOException;
//import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * La classe {@code CanzoneManager} permette di leggere/scrivere canzoni dal file Canzoni.dati
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 */
public class CanzoneManager {

    final static String path = "src/DATA/Canzoni.dati.txt";

    /***
     * Restituisce un array di canzoni contenente tutte le canzoni del file Canzoni.dati
     * @return un oggetto di tipo {@code ArrayList<Canzone>}
     * @exception IOException
     * @exception ClassNotFoundException
     */
    public static ArrayList<Canzone> leggiCanzone() throws IOException, ClassNotFoundException {
        Object ob = FileManager.leggiFile(path);
        ArrayList<Canzone> songs = new ArrayList<Canzone>();
        if(ob instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) ob;
            songs = castArray(tmp);
        }
        return songs;
    }

    /***
     * Verifica se l'oggetto fornito come parametro è un array di canzoni e, in tal caso, lo restituisce come tale
     * @param arr un oggetto di tipo {@code ArrayList<?>}
     * @return un oggetto di tipo {@code ArrayList<Canzone>}
     */
    public static ArrayList<Canzone> castArray(ArrayList<?> arr) {
        ArrayList<Canzone> songs = new ArrayList<Canzone>();
        for(Object ob : arr) {
            if(ob instanceof Canzone) {
                songs.add((Canzone) ob);
            }
        }
        return songs;
    }

    /***
     * Scrive l'array di canzoni indicato come argomento nel file Canzoni.dati
     * @param arr un oggetto di tipo {@code ArrayList<Canzone>}
     * @exception IOException
     */
    public static void scriviCanzone(ArrayList<Canzone> arr) throws IOException {
        FileManager.scriviFile(path, arr);
    }
}
