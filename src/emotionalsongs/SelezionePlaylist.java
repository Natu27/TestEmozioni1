//Lorenzo Michele Naturale - Matricola n.749423 - Sede di Varese
//Riccardo Grazioli - Matricola n.748701 - Sede di Varese
//Jennifer Sculco - Matricola n.722306 - Sede di Varese
package emotionalsongs;

import prog.io.ConsoleInputManager;
import java.util.ArrayList;

/**
 * La classe {@code SelezionePlaylist} permette di selezionare una playlist a partire da un array di playlist
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 */

public class SelezionePlaylist {

    /**
     * Permette di selezionare una playlist a partire dall'array di playlist fornito come argomento
     * @param arr un oggetto di tipo {@code ArrayList<Playlist>}
     * @return un oggetto di tipo {@code Playlist}
     */
    public static Playlist selezionaPlaylist(ArrayList<Playlist> arr) {
        ConsoleInputManager in = new ConsoleInputManager();
        int scelta = in.readInt("Scegli Numero Identificativo Playlist: ");
        while(scelta<1 || scelta>arr.toArray().length) {
            scelta = in.readInt("VALORE NON CONSENTITO - Scegli Indice Playlist: ");
        }
        Playlist playlist = arr.get(scelta-1);
        return playlist;
    }
}


