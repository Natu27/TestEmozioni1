package emotionalsongs;

import prog.io.ConsoleOutputManager;
import java.io.Serializable;
import java.util.ArrayList;

public class EmotionalSong implements Serializable {

    //CAMPI
    private final Canzone song;
    private ArrayList<Emozione> arrEmotions = new ArrayList<Emozione>(9);

    //COSTRUTTORE
    public EmotionalSong(Canzone canzone) {
        song = canzone;
        for (Emozione e : Emozione.values()) {
            arrEmotions.add(e);
        }
    }

    public Canzone getCanzone(EmotionalSong emoSong) {
        return emoSong.song;
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
            if (emozione.commento.equals("")) {
                out.println("Commento Emozione <" + emozione.getEmozione() + "> = " + emozione.commento);
            } else {
                out.println("Nessun commento inserito!");
            }
        }
    }
}
