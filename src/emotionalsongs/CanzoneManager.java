//Lorenzo Michele Naturale - Matricola n.749423 - Sede di Varese
//Riccardo Grazioli - Matricola n.748701 - Sede di Varese
//Jennifer Sculco - Matricola n.722306 - Sede di Varese
package emotionalsongs;

import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe {@code CanzoneManager} permette di leggere/scrivere canzoni dal/sul file Canzoni.dati
 */
public class CanzoneManager {

    /**
     * Restituisce un array di canzoni contenente tutte le canzoni del file Canzoni.dati
     * @return un oggetto di tipo {@code ArrayList<Canzone>}
     * @exception IOException
     * @exception ClassNotFoundException
     */
    public static ArrayList<Canzone> leggiCanzone() throws IOException, ClassNotFoundException {
        Object ob = FileManager.leggiFile(PathManager.getPath(PathType.song));
        ArrayList<Canzone> songs = new ArrayList<Canzone>();
        if(ob instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) ob;
            songs = castArray(tmp);
        }
        return songs;
    }

    /**
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

    /**
     * Scrive l'array di canzoni indicato come argomento nel file Canzoni.dati
     * @param arr un oggetto di tipo {@code ArrayList<Canzone>}
     * @exception IOException
     */
    public static void scriviCanzone(ArrayList<Canzone> arr) throws IOException {
        FileManager.scriviFile(PathManager.getPath(PathType.song), arr);
    }
}
