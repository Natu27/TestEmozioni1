package emotionalsongs;

import prog.io.ConsoleOutputManager;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * La classe {@code Playlist} permette ad un utente di gestire un oggetto di tipo Playlist,
 * a cui è associato un nome univoco per ogni utente, e un ArrayList di canzoni
 * in cui saranno inseriti i brani musicali appartenenti alla playlist in questione
 */

public class Playlist implements Serializable {

    String nomePlaylist;
    ArrayList<Canzone> arrCanzoni = new ArrayList<Canzone>();
    Utente utente;

    /**
     * Costruisce un oggetto di tipo Playlist a partire dai parametri forniti come argomento
     * @param nomePlaylist un oggetto di tipo {@code String}
     * @param utente un oggetto di tipo {@code Utente}
     * @param arrCanzoni un oggetto di tipo {@code ArrayList<Canzone>}
     */
    public Playlist(String nomePlaylist, Utente utente, ArrayList<Canzone> arrCanzoni){
        this.nomePlaylist = nomePlaylist;
        this.utente = utente;
        this. arrCanzoni = arrCanzoni;
    }

    /**
     * Permette di ottenere il nome della Playlist dell'oggetto che esegue il metodo
     * @return un oggetto di tipo {@code String}
     */
    public String getNomePlaylist(){
        return nomePlaylist;
    }

    /**
     * Permette di ottenere l'oggetto di tipo Utente dell'instanza che esegue il metodo
     * @return un oggetto di tipo {@code Utente}
     */
    public Utente getUtente(){
        return  utente;
    }

    /**
     * Permette di visualizzare su schermo i brani contenuti all'interno della playlist creata dall'utente
     * associato all'instanza che esegue il metodo
     * @return un oggetto di tipo {@code ArrayList<Canzone>}
     */
    public ArrayList<Canzone> stampaCanzoniPlaylist() {
        ConsoleOutputManager out = new ConsoleOutputManager();
        int count = 1;
        out.println("CANZONI PLAYLIST <" + this.getNomePlaylist() + ">:");
        for(Canzone song : this.arrCanzoni) {
            out.println(count++ + " --> " + song.stampaCanzone());
        }
        return this.arrCanzoni;
    }
}