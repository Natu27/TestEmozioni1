package emotionalsongs;

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

import java.util.ArrayList;

public class InserisciEmozioniBrano {

    public static EmotionalSong inserisciEmozioni(Canzone song) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        int[] evitaDuplicati = new int[9];
        for (int i = 0; i < evitaDuplicati.length; i++) {
            evitaDuplicati[i] = i + 1;
        }

        EmotionalSong emoSong = new EmotionalSong(song);
        ArrayList<Emozione> arrUtente = emoSong.getArrEmotions(emoSong);
        int scegliEmozioni = in.readInt("Scegli Emozione(0 per terminare)--> ");
        while ((scegliEmozioni < 0 || scegliEmozioni > 9)) {
            scegliEmozioni = in.readInt("VALORE NON CONSENTITO - " +
                                        "Inserisci valore compreso tra 0 e 9(0 per terminare)--> ");
        }
        while (scegliEmozioni != 0) {
            if (evitaDuplicati[scegliEmozioni - 1] != 0) {
                evitaDuplicati[scegliEmozioni - 1] = 0;
                Emozione eUtente = arrUtente.get(scegliEmozioni-1);
                arrUtente.get(scegliEmozioni-1).score = in.readInt("Inserisci livello emozione " +
                        eUtente.getEmozione() + " (da 1 a 5)--> ");
                while (eUtente.score < 1 || eUtente.score > 5) {
                    arrUtente.get(scegliEmozioni-1).score = in.readInt("VALORE NON CONSENTITO - " +
                                                           "Inserisci valore compreso tra 1 e 5--> ");
                }
                scegliEmozioni = in.readInt("Scegli Emozione(0 per terminare)--> ");
                while (scegliEmozioni < 0 || scegliEmozioni > 9) {
                    scegliEmozioni = in.readInt("Inserisci valore compreso tra 0 e 9(0 per terminare)--> ");
                }
            } else {
                out.println("VALORE NON CONSENTITO - Emozione già inserita");
                scegliEmozioni = in.readInt("Scegli Emozione(0 per terminare)--> ");
                while (scegliEmozioni < 0 || scegliEmozioni > 9) {
                    scegliEmozioni = in.readInt("Inserisci valore compreso tra 0 e 9(0 per terminare)--> ");
                }
            }
        }
        return emoSong;
    }
}