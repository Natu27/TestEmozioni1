package emotionalsongs;

import java.io.File;

public class PathManager {
    final static String userPath = "UtentiRegistrati.txt";
    final static String songPath = "Canzoni.dati.txt";
    final static String playlistPath = "Playlist.dati.txt";
    final static String tPath = "CanzoniProv.txt";
    final static String oPath = "Emozioni.dati.txt";

    public static String getPath(PathType tipo) {
        String result = "src%sDATA%s"; //prima di consegnarlo alla prof metto "..%sDATA%s" al posto di src....
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
