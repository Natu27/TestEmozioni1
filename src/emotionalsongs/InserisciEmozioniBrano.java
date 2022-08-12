package emotionalsongs;

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
        while (!verificaInsEmozioni(arrUtente)) {
            out.println("!Necessario inserire almeno un'emozione!");
            int scegliEmozioni = in.readInt("Scegli Emozione(0 per terminare): ");
            while ((scegliEmozioni < 0 || scegliEmozioni > 9)) {
                scegliEmozioni = in.readInt("VALORE NON CONSENTITO - " +
                        "Inserisci valore compreso tra 0 e 9(0 per terminare): ");
            }
            while (scegliEmozioni != 0) {
                if (evitaDuplicati[scegliEmozioni - 1] != 0) {
                    evitaDuplicati[scegliEmozioni - 1] = 0;
                    Emozione eUtente = arrUtente.get(scegliEmozioni - 1);
                    arrUtente.get(scegliEmozioni - 1).score = in.readInt("Inserisci livello emozione " +
                            eUtente.getEmozione() + " (da 1 a 5): ");
                    while (eUtente.score < 1 || eUtente.score > 5) {
                        arrUtente.get(scegliEmozioni - 1).score = in.readInt("VALORE NON CONSENTITO - " +
                                "Inserisci valore compreso tra 1 e 5: ");
                    }
                    if (in.readSiNo("Vuoi inserire un commento relativo all'emozione " + eUtente.getEmozione() + "?(SI/NO): ")) {
                        eUtente.commento = in.readLine("Inserire commento --> ");
                        eUtente.commento = RicercaCanzone.controll(eUtente.commento);
                        while (eUtente.commento.length() > 256) {
                            out.println("!Lunghezza max 256 caratteri!");
                            eUtente.commento = in.readLine("INPUT NON CONSENTITO - Reinserire --> ");
                        }
                    }
                    scegliEmozioni = in.readInt("Scegli Emozione(0 per terminare): ");
                    while (scegliEmozioni < 0 || scegliEmozioni > 9) {
                        scegliEmozioni = in.readInt("Inserisci valore compreso tra 0 e 9(0 per terminare): ");
                    }
                } else {
                    out.println("!Emozione già inserita!");
                    scegliEmozioni = in.readInt("Scegli Emozione(0 per terminare): ");
                    while (scegliEmozioni < 0 || scegliEmozioni > 9) {
                        scegliEmozioni = in.readInt("Inserisci valore compreso tra 0 e 9(0 per terminare): ");
                    }
                }
            }
        }
        try{
            TimeUnit.SECONDS.sleep(1);
            Loading.loading();
            out.println("Emozioni registrate.");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {}
        return emoSong;
    }

    public static boolean verificaInsEmozioni(ArrayList<Emozione> arr){
        boolean verifica = false;
        for(Emozione e : arr){
            if(e.score != 0){
                verifica = true;
                break;
            }
        }
        return verifica;
    }
}