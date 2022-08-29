package emotionalsongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe {@code ImporterCanzoni} permette di gestire e/o serializzare oggetti di tipo Canzone
 * per scriverli nel file di destinazione Canzoni.dati
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 */
public class ImporterCanzoni {

    /**
     * Permette di inserire all'interno di un ArrayList di canzoni, a partire da un file di testo,
     * oggetti di tipo String con un particolare format (titolo - autore - anno)
     * @return un oggetto di tipo {@code ArrayList<Canzone>}
     * @throws IOException
     */
    private static ArrayList<Canzone> importListaCanzoni() throws IOException {
        //String tPath = "src/DATA/CanzoniProv.txt";
        File file = new File(PathManager.getPath(PathType.prov));
        FileReader frd = new FileReader(file);
        BufferedReader brd = new BufferedReader(frd);
        ArrayList<Canzone> listaCanzoni = new ArrayList<Canzone>();
        String str;
        while ((str = brd.readLine()) != null) {
            String[] songProv = str.split(" - ");
            Canzone song = new Canzone(songProv[0], songProv[1], songProv[songProv.length-1]);
            listaCanzoni.add(song);
        }
        brd.close();
        frd.close();
        return listaCanzoni;
    }

    /**
     * Permette di serializzare oggetti di tipo Canzone e di scriverli nel file Canzoni.dati
     * @throws IOException
     */
    public static void serializzaCanzone() throws IOException {
        ArrayList<Canzone> arr = importListaCanzoni();
        CanzoneManager.scriviCanzone(arr);
    }
}

