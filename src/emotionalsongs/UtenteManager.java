package emotionalsongs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UtenteManager {

    final static String path = "src/DATA/UtentiRegistrati.txt";

    public static void scriviUtente(ArrayList<Utente> arrUtenti) throws IOException {
        FileOutputStream fOS = new FileOutputStream(path);
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        oOS.writeObject(arrUtenti);
        oOS.flush();
        oOS.close();
    }

    public static ArrayList<Utente> leggiUtenti() throws IOException, ClassNotFoundException {
        Object ob = FileManager.leggiFile(path);
        ArrayList<Utente> arrUtenti = new ArrayList<Utente>();
        if(ob instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) ob;
            arrUtenti = castArrayUtenti(tmp);
        }
        return arrUtenti;
    }

    public static ArrayList<Utente> castArrayUtenti(ArrayList<?> arrProv) {
        ArrayList<Utente> arrUtenti = new ArrayList<Utente>();
        for(Object ob : arrProv) {
            if(ob instanceof Utente) {
                arrUtenti.add((Utente) ob);
            }
        }
        return arrUtenti;
    }
}
