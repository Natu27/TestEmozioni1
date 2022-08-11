package emotionalsongs;

import prog.io.ConsoleOutputManager;
import java.io.Serializable;
import java.util.ArrayList;

public class EmotionalSong implements Serializable {

    //CAMPI
    private final Canzone song;
    private ArrayList<Emozione> arrEmotions = new ArrayList<Emozione>(9);
    public String commento = "";
    public String commento1 = "";
    public String commento2 = "";
    public String commento3 = "";
    public String commento4 = "";
    public String commento5 = "";
    public String commento6 = "";
    public String commento7 = "";
    public String commento8 = "";

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
        out.println("EMOZIONI DISPONIBILI PER INSERIMENTO: ");
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
        out.println(this.song.stampaCanzone());
        EmotionalSong.stampaArrEmozioni(this.arrEmotions);
    }

    public void stampaEmoSongPunteggio() {
        ConsoleOutputManager out = new ConsoleOutputManager();
        out.println(this.song.stampaCanzone());
        EmotionalSong.stampaArrEmozioniPunteggio(this.arrEmotions);
        if (!this.commento.equals("")) {
            out.println("Commento emozione <Amazement> = " + this.commento);
        } else {
            out.println("Nessun commento inserito!");
        }
        if (!this.commento1.equals("")) {
            out.println("Commento emozione <Solemnity> = " + this.commento1);
        } else {
            out.println("Nessun commento inserito!");
        }
        if (!this.commento2.equals("")) {
            out.println("Commento emozione <Tenderness> = " + this.commento2);
        } else {
            out.println("Nessun commento inserito!");
        }
        if (!this.commento3.equals("")) {
            out.println("Commento emozione <Nostalgia> = " + this.commento3);
        } else {
            out.println("Nessun commento inserito!");
        }
        if (!this.commento4.equals("")) {
            out.println("Commento emozione <Calmness> = " + this.commento4);
        } else {
            out.println("Nessun commento inserito!");
        }
        if (!this.commento5.equals("")) {
            out.println("Commento emozione <Power> = " + this.commento5);
        } else {
            out.println("Nessun commento inserito!");
        }
        if (!this.commento6.equals("")) {
            out.println("Commento emozione <Joy> = " + this.commento6);
        } else {
            out.println("Nessun commento inserito!");
        }
        if (!this.commento7.equals("")) {
            out.println("Commento emozione <Tension> = " + this.commento7);
        } else {
            out.println("Nessun commento inserito!");
        }
        if (!this.commento8.equals("")) {
            out.println("Commento emozione <Sadness> = " + this.commento8);
        } else {
            out.println("Nessun commento inserito!");
        }
    }
}
