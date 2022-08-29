package emotionalsongs;

import prog.io.ConsoleInputManager;
import java.util.ArrayList;

/**
 * La classe {@code SelezioneBrano} permette di selezionare un brano musicale a partire da un array di canzoni
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 */

public class SelezioneBrano {

    /**
     * Permette di selezionare un brano a partire dall'array di canzoni fornito come argomento
     * @param arr un oggetto di tipo {@code ArrayList<Canzone>}
     * @return un oggetto di tipo {@code Canzone}
     */
    public static Canzone selezionaBrano(ArrayList<Canzone> arr) {
        ConsoleInputManager in = new ConsoleInputManager();
        int scelta = in.readInt("Scegli Numero Identificativo Brano Musicale: ");
        while(scelta<1 || scelta>arr.toArray().length) {
            scelta = in.readInt("VALORE NON CONSENTITO - Scegli Indice Brano Musicale: ");
        }
        Canzone song = arr.get(scelta-1);
        return song;
    }
}
