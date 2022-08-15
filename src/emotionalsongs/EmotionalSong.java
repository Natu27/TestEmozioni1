package emotionalsongs;

import prog.io.ConsoleOutputManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class EmotionalSong implements Serializable {

    // CAMPI
    private final Canzone song;
    private ArrayList<EmozioneVoto> arrEmotions = new ArrayList<EmozioneVoto>();
    private Utente utente;
    private Playlist playlist;

    // COSTRUTTORE
    public EmotionalSong(Canzone canzone, Utente utente, Playlist playlist) {
        song = canzone;
        this.utente = utente;
        this.playlist = playlist;
        for (Emozione emo : Emozione.values()) {
            EmozioneVoto def = new EmozioneVoto(emo, false, "Nessun Commento", 0);
            arrEmotions.add(def);
        }
    }

    public Canzone getCanzone() {
        return this.song;
    }

    public Utente getUtente() {
        return this.utente;
    }

    public Playlist getPlaylist() {
        return this.playlist;
    }

    public ArrayList<EmozioneVoto> getArrEmotions() {
        return this.arrEmotions;
    }

    public void setEmozione(EmozioneVoto e) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        boolean inserita = false;
        // controlli se già inserita
        for (EmozioneVoto emozioneVoto : arrEmotions) {
            if ((emozioneVoto.emozione.toString().equals(e.emozione.toString()) && !emozioneVoto.valutata)) {
                int indx = arrEmotions.indexOf(emozioneVoto);
                arrEmotions.set(indx, e);
                break;
            } else {
                if(emozioneVoto.valutata)
                inserita = true;
            }
        }
        if (inserita) {
            try {
                TimeUnit.SECONDS.sleep(1);
                out.println("!Emozione già inserita per il seguente brano!");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException iE) {}
        }
    }

    public static void stampaArrEmozioni() {
        int index = 1;
        ConsoleOutputManager out = new ConsoleOutputManager();
        out.println("EMOZIONI DISPONIBILI PER L'INSERIMENTO: ");
        for (Emozione e : Emozione.values()) {
            if (index != 9) {
                out.print(index + "--> " + e.toString() + " / ");
            } else {
                out.print(index + "--> " + e.toString());
            }
            index++;
        }
        out.println();
    }

    public static void stampaArrEmozioniPunteggio(ArrayList<EmozioneVoto> arrEmotions) {
        int index = 1;
        ConsoleOutputManager out = new ConsoleOutputManager();
        for (EmozioneVoto e : arrEmotions) {
            if (index != 9) {

                out.print(e.stampaEmozioneVoto() + " / ");
            } else {
                out.print(e.stampaEmozioneVoto());
            }
            index++;
        }
        out.println();
    }

    public void stampaEmoSong() {
        ConsoleOutputManager out = new ConsoleOutputManager();
        out.println("CANZONE SELEZIONATA <" + this.song.getTitolo() + ">");
        EmotionalSong.stampaArrEmozioni();
    }

    public void stampaEmoSongPunteggio() {
        ConsoleOutputManager out = new ConsoleOutputManager();
        out.println(song.getTitolo() + " - " + song.getTitolo() + " - " + song.getAnno());
        for (EmozioneVoto e : arrEmotions) {
            out.print(e.stampaEmozioneVoto() + " / ");
        }
        out.print("\n");
        for (EmozioneVoto e : arrEmotions) {
            out.println(e.stampaCommento());
        }

        out.println();
    }
}