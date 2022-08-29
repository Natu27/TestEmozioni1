package emotionalsongs;

import java.io.File;

/**
 * La classe {@code PathManager} permette di ottenere il percorso dei file su cui effettuare una lettura/scrittura
 * a seconda del sistema operativo utilizzato(Windows/ISOS)
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
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
        String result = "";
        if(System.getProperty("os.name").startsWith("W")) {
            result = "C:/Users/" + System.getProperty("user.name") + "/Desktop/naturale_749423/data/";
        } else {
            result = System.getProperty("user.name") + "$/Desktop/naturale_749423/data/";
        }
        //String result = "C:/Users/loren%sIdeaProjects/TestEmozioni/out/production/TestEmozioni/DATA/"; //prima di consegnarlo alla prof metto "..%sDATA%s" al posto di src....
        //String result = System.getProperty("user.dir") + "\\out\\production\\TestEmozioni\\DATA\\";
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
