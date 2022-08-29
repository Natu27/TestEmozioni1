//Lorenzo Michele Naturale - Matricola n.749423 - Sede di Varese
//Riccardo Grazioli - Matricola n.748701 - Sede di Varese
//Jennifer Sculco - Matricola n.722306 - Sede di Varese
package emotionalsongs;

import java.io.*;
import java.util.ArrayList;

/**
 * La classe {@code FileManager} permette di leggere/scrivere su un file di testo,
 * fornendo come parametri il percorso del file e/o l'array impiegato per la lettura/scrittura
 */
public class FileManager {

    /**
     * Permette la lettura su un file di testo, partendo dal parametro passato come argomento
     * @param path indica il percorso del file su cui effettuare la lettura
     * @return un oggetto di tipo {@code Object}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object leggiFile(String path) throws IOException, ClassNotFoundException {
        Object ob = null;
        FileInputStream fIS = new FileInputStream(path);
        ObjectInputStream oIS = new ObjectInputStream(fIS);
        ob = oIS.readObject();
        oIS.close();
        return ob;
    }

    /**
     * Permette la scrittura su un file di testo, partendo dai parametri passato come argomento
     * @param path indica il percorso del file di destinazione su cui effettuare la scrittura
     * @param array un oggetto di tipo {@code ArrayList<?>}
     * @throws IOException
     */
    public static void scriviFile(String path, ArrayList<?> array) throws IOException {
        FileOutputStream fOS = new FileOutputStream(path);
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        oOS.writeObject(array);
        oOS.flush();
        oOS.close();
    }
}


