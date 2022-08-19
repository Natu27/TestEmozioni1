package emotionalsongs;

import prog.io.ConsoleOutputManager;

import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable {

    String nomePlaylist;
    ArrayList<Canzone> arrCanzoni = new ArrayList<Canzone>();
    Utente utente;

    public Playlist(String nomePlaylist, Utente utente, ArrayList<Canzone> arrCanzoni){
        this.nomePlaylist = nomePlaylist;
        this.utente = utente;
        this. arrCanzoni = arrCanzoni;
    }

    public String getNomePlaylist(){
        return nomePlaylist;
    }

    public Utente getUtente(){
        return  utente;
    }

    public ArrayList<Canzone> getArrCanzoni() {
        return arrCanzoni;
    }

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

