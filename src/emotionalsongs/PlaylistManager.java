//Lorenzo Michele Naturale - Matricola n.749423 - Sede di Varese
//Riccardo Grazioli - Matricola n.748701 - Sede di Varese
//Jennifer Sculco - Matricola n.722306 - Sede di Varese
package emotionalsongs;

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * La classe {@code PlaylistManager} permette di leggere/scrivere canzoni dal/sul file Playlist.dati
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 */
public class PlaylistManager {

    //final static String path = "src/DATA/Playlist.dati.txt";

    /**
     * Permette di registrare una playlist associata ad un utente indicato come argomento del metodo,
     * inserendo all'interno di quest'ultima i brani musicali selezionati tramite la funzione di ricerca per titolo
     * @param utente un oggetto di tipo {@code Utente}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void RegistraPlaylist(Utente utente) throws IOException, ClassNotFoundException {
        ArrayList<Canzone> listaCanzoni = CanzoneManager.leggiCanzone();
        Canzone songSelezionata;
        ConsoleInputManager in =new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        out.println("CREAZIONE PLAYLIST: ");
        String nomePlaylist = in.readLine("Inserisci nome Playlist --> ");
        nomePlaylist = controllNomePlaylist(nomePlaylist, utente);
        ArrayList<Canzone> arrayCanzoniPLaylist = new ArrayList<Canzone>();
        ArrayList<Canzone> arrayCanzoniTrovate = new ArrayList<Canzone>();
        out.println("INIZIO INSERIMENTO BRANI PLAYLIST <" + nomePlaylist + ">:");
        do {
            arrayCanzoniTrovate = RicercaCanzone.cercaTitolo(listaCanzoni);
            while(arrayCanzoniTrovate.size() == 0){
                out.println("!Necessaria ulteriore ricerca!");
                arrayCanzoniTrovate = RicercaCanzone.cercaTitolo(listaCanzoni);
            }
            songSelezionata = SelezioneBrano.selezionaBrano(arrayCanzoniTrovate);
            arrayCanzoniPLaylist.add(songSelezionata);
            listaCanzoni.remove(songSelezionata);
        } while(in.readSiNo("Vuoi inserire un altro brano?(SI/NO): "));

        Playlist playlist = new Playlist(nomePlaylist,utente,arrayCanzoniPLaylist);
        ArrayList<Playlist> arrPlaylist = new ArrayList<Playlist>();
        File file = new File(PathManager.getPath(PathType.playlist));
        if(file.length() !=0) {
            arrPlaylist = PlaylistManager.leggiPlaylist();
            arrPlaylist.add(playlist);
            PlaylistManager.scriviPlaylist(arrPlaylist);
        } else {
            arrPlaylist.add(playlist);
            PlaylistManager.scriviPlaylist(arrPlaylist);
        }
        try {
            TimeUnit.SECONDS.sleep(1);
            Loading.loading();
            out.println("Playlist salvata.");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {}
    }

    /**
     * Permette di scrivere una o più playlist tramite un ArrayList sul file di destinazione Playlist.dati
     * @param arrPlaylist un oggetto di tipo {@code ArrayList<Playlist>}
     * @throws IOException
     */
    public static void scriviPlaylist(ArrayList<Playlist> arrPlaylist) throws IOException {
        FileOutputStream fOS = new FileOutputStream(PathManager.getPath(PathType.playlist));
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        oOS.writeObject(arrPlaylist);
        oOS.flush();
        oOS.close();
    }

    /**
     * Permette di leggere una o più playlist tramite un ArrayList dal file di testo Playlist.dati
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Playlist> leggiPlaylist() throws IOException, ClassNotFoundException {
        Object o = FileManager.leggiFile(PathManager.getPath(PathType.playlist));
        ArrayList<Playlist> arrPlaylist = new ArrayList<Playlist>();
        if(o instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) o;
            arrPlaylist = castArrayPlaylist(tmp);
        }
        return arrPlaylist;
    }

    /**
     * Permette di eseguire un cast a partire dall'ArrayList generico fornito come argomento del metodo,
     * e dopo aver effettuato un opportuno controllo sul tipo di oggetti contenuti in questo array
     * restiusce un ArrayList di playlist
     * @param a un oggetto di tipo {@code ArrayList<?>}
     * @return un oggetto di tipo {@code ArrayList<Playlist>}
     */
    public static ArrayList<Playlist> castArrayPlaylist(ArrayList<?> a) {
        ArrayList<Playlist> arrPlaylist = new ArrayList<Playlist>();
        for(Object o : a) {
            if(o instanceof Playlist) {
                arrPlaylist.add((Playlist) o);
            }
        }
        return arrPlaylist;
    }

    /**
     * Permette di ottenere un ArrayList di String contenente i nomi delle Playlist utilizzati dall'utente indicato
     * come argomento del metodo
     * @param utente un oggetto di tipo {@code Utente}
     * @return un oggetto di tipo {@code ArrayList<String>}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<String> leggiNomePlaylist(Utente utente)throws IOException, ClassNotFoundException {
        Object o = FileManager.leggiFile(PathManager.getPath(PathType.playlist));
        ArrayList<Playlist> arrPlaylist = new ArrayList<Playlist>();
        if(o instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) o;
            arrPlaylist = castArrayPlaylist(tmp);
        }
        ArrayList<String> arrayNomiPlaylist = new ArrayList<String>();
        for(Playlist playlist :  arrPlaylist) {
            if(playlist.getUtente().getUserId().equals(utente.getUserId())) {
                arrayNomiPlaylist.add(playlist.getNomePlaylist());
            }
        }
        return arrayNomiPlaylist;
    }

    /**
     * Permette di leggere, se esistono, dal file di testo Playlist.dati una o più playlist appartenenti all'utente
     * indicato come argomento del metodo
     * @param utente un oggetto di tipo {@code Utente}
     * @return un oggetto di tipo {@code ArrayList<Playlist>}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Playlist> leggiPlaylistUtente(Utente utente)throws IOException, ClassNotFoundException {
        Object o = FileManager.leggiFile(PathManager.getPath(PathType.playlist));
        ArrayList<Playlist> arrPlaylist = new ArrayList<Playlist>();
        if(o instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) o;
            arrPlaylist = castArrayPlaylist(tmp);
        }
        ArrayList<Playlist> arrayNomiPlaylist = new ArrayList<Playlist>();
        if(utente != null) {
            for (Playlist playlist : arrPlaylist) {
                if (playlist.getUtente().getUserId().equals(utente.getUserId())) {
                    arrayNomiPlaylist.add(playlist);
                }
            }
        }
        return arrayNomiPlaylist;
    }

    /**
     * Permette di verificare a partire dai parametri forniti come argomento del metodo se il nome scelto dall'utente
     * sia univoco o meno
     * @param arrayNomiPlaylist un oggetto di tipo {@code ArrayList<String>}
     * @param nomePlaylist un oggetto di tipo {@code String}
     * @return un oggetto di tipo {@code boolean} (true: se è univoco / false: altrimenti)
     */
    public static boolean nomePlaylistUtilizzato(ArrayList<String> arrayNomiPlaylist, String nomePlaylist) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        boolean nomeUtilizzato = false;
        File file = new File(PathManager.getPath(PathType.playlist));
        if(file.length()!= 0) {
            for(String nomePlay : arrayNomiPlaylist) {
                if(nomePlaylist.equals((nomePlay))) {
                    nomeUtilizzato = true;
                    out.println("!Nome playlist già utilizzato!");
                    break;
                }
            }
        }
        return nomeUtilizzato;
    }

    /**
     * Permette di evitare duplicati sui nomi delle Playlist utilizzati dall'utente indicato come argomento del metodo,
     * obbligandolo tramite opportuni controlli a scegliere un nome univoco per ogni playlist creata
     * @param s un oggetto di tipo {@code String}
     * @param utente un oggetto di tipo {@code Utente}
     * @return un oggetto di tipo {@code String}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static String controllNomePlaylist(String s,Utente utente)throws IOException, ClassNotFoundException {
        ConsoleInputManager in = new ConsoleInputManager();
        ArrayList<String> nomePlaylistUtilizzati = new ArrayList<String>();
        File file = new File(PathManager.getPath(PathType.playlist));
        if(file.length() != 0) {
            nomePlaylistUtilizzati = PlaylistManager.leggiNomePlaylist(utente);
        }
        s = s.trim();
        while(nomePlaylistUtilizzato(nomePlaylistUtilizzati,s) || s.equals("") || RicercaCanzone.everyCharWhitespace(s)) {
            s = in.readLine("INPUT NON CONSENTITO - Reinserire --> ");
            s = s.trim();
        }
        return s;
    }
}
