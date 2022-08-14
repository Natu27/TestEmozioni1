package emotionalsongs;

import prog.io.ConsoleOutputManager;
import java.io.Serializable;
import java.util.ArrayList;

public class EmotionalSong implements Serializable {

    //CAMPI
    private final Canzone song;
    private ArrayList<Emozione> arrEmotions = new ArrayList<Emozione>(9);
    private Utente utente;
    private  Playlist playlist;

    //COSTRUTTORE
    public EmotionalSong(Canzone canzone, Utente utente, Playlist playlist) {
        song = canzone;
        this.utente = utente;
        this.playlist = playlist;
        for (Emozione e : Emozione.values()) {
            arrEmotions.add(e);
        }
    }

    /*public static int setScore(Emozione e, int score) {
        e.score = score;
        return score;
    }*/

    public EmotionalSong(Canzone canzone, Utente utente, Playlist playlist, ArrayList<Emozione> arrEmo) {
        this.song = canzone;
        this.utente = utente;
        this.playlist = playlist;
        this.arrEmotions = arrEmo;
    }

    public Canzone getCanzone() {
        return this.song;
    }

    public Utente getUtente(){
        return this.utente;
    }
    public Playlist getPlaylist(){
        return this.playlist;
    }

    public ArrayList<Emozione> getArrEmotions(EmotionalSong emoSong) {
        return emoSong.arrEmotions;
    }


    public static void stampaArrEmozioni(ArrayList<Emozione> arrEmotions) {
        int index = 1;
        ConsoleOutputManager out = new ConsoleOutputManager();
        out.println("EMOZIONI DISPONIBILI PER L'INSERIMENTO: ");
        for (Emozione e : arrEmotions) {
            if (index != 9) {
                out.print(index++ + "--> " + e.getEmozione() + " / ");
            } else {
                out.print(index++ + "--> " + e.getEmozione());
            }
        }
        out.println();
    }

    public static void stampaArrEmozioniPunteggio(ArrayList<Emozione> arrEmotions) {
        int index = 1;
        ConsoleOutputManager out = new ConsoleOutputManager();
        for (Emozione e : arrEmotions) {
            if (index != 9) {
                index++;
                out.print(e.getEmozione() + " - " + e.getScore() + " / ");
            } else {
                out.print(e.getEmozione() + " - " + e.getScore());
            }
        }
        out.println();
    }

    public void stampaEmoSong() {
        ConsoleOutputManager out = new ConsoleOutputManager();
        out.println("CANZONE SELEZIONATA <" + this.song.getTitolo() + ">");
        EmotionalSong.stampaArrEmozioni(this.arrEmotions);
    }

    public void stampaEmoSongPunteggio() {
        ConsoleOutputManager out = new ConsoleOutputManager();
        out.println(this.song.stampaCanzone());
        EmotionalSong.stampaArrEmozioniPunteggio(this.arrEmotions);
        for (Emozione emozione : Emozione.values()) {
            if (!emozione.commento.equals("")) {
                out.println("Commento Emozione <" + emozione.getEmozione() + "> = " + emozione.commento);
            } else {
                out.println("Nessun commento inserito!");
            }
        }
    }
}
