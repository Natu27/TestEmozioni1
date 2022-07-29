package emotionalsongs;

import prog.io.ConsoleInputManager;

import java.util.ArrayList;

public class SelezioneBrano {

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
