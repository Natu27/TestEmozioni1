//Lorenzo Michele Naturale - Matricola n.749423 - Sede di Varese
//Riccardo Grazioli - Matricola n.748701 - Sede di Varese
//Jennifer Sculco - Matricola n.722306 - Sede di Varese
package emotionalsongs;

import java.io.Console;
import java.io.File;

/**
 * La classe {@code PathManager} permette di ottenere il percorso dei file su cui effettuare una lettura/scrittura
 * a seconda del sistema operativo utilizzato
 */

public class PathManager {
    final static String userPath = "UtentiRegistrati.txt";
    final static String songPath = "Canzoni.dati.txt";
    final static String playlistPath = "Playlist.dati.txt";
    final static String tPath = "CanzoniProv.txt";
    final static String oPath = "Emozioni.dati.txt";

    /**
     * Permette di selezionare il percorso del file di import/export su cui effettuare una lettura/scrittura
     * @param tipo un oggetto di tipo {@code PathType}
     * @return un oggetto di tipo {@code String} che rappresenta il percorso del file selezionato
     */
    public static String getPath(PathType tipo) {
        //String result = "src%sDATA%s";  // <---- INTELLIJ
        String result = "..%sdata%s";

        switch (tipo) {
            case user :
                    result +=userPath;
            break;
            case song :
                    result +=songPath;
            break;
            case playlist :
                    result += playlistPath;
            break;
            case emotion :
                    result += oPath;
            break;
            case prov :
                    result += tPath;
            break;
        }
        result = String.format(result,File.separator, File.separator);
        return result;
    }
}
