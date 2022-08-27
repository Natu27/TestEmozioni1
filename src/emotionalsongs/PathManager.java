package emotionalsongs;

import java.io.File;

public class PathManager {
    final static String userPath = "UtentiRegistrati.txt";
    final static String songPath = "Canzoni.dati.txt";
    final static String playlistPath = "Playlist.dati.txt";
    final static String tPath = "CanzoniProv.txt";
    final static String oPath = "Emozioni.dati.txt";

    public static String getPath(PathType tipo) {
        String result = "";
        if(System.getProperty("os.name").startsWith("W")) {
            result = "C:/Users/" + System.getProperty("user.name") + "/Desktop/Università/LAB.A/TestEmozioni1/out/production/TestEmozioni/DATA/";
        } else {
            result = System.getProperty("user.name") + "$/Users/Desktop/Università/LAB.A/TestEmozioni1/out/production/TestEmozioni/DATA/";
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
