package emotionalsongs;

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class InserisciEmozioniBrano {

    public static EmotionalSong inserisciEmozioni(Canzone song, Utente utente, Playlist playlist) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        EmotionalSong emosong = new EmotionalSong(song, utente, playlist);
        Emozione e = null;
        EmozioneVoto emovoto = null;
        int voto;
        int scelta;
        String commento = "";

        do {
            scelta = (in.readInt("Scegli numericamente un emozione(0 per terminare): "));
            while(scelta<0 || scelta>9) {
                scelta = in.readInt("VALORE NON CONSENTITO - Scegli Opzione Disponbile: ");
            }
            switch (scelta) {
                case 1:
                    e = Emozione.AMAZEMENT;
                    voto = in.readInt("Valuta da 1 a 5 l'emozione AMAZEMENT: ");
                    if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                        commento = in.readLine("Inserire il commento --> ");
                    } else {
                        commento = "Nessun Commento";
                    }
                    emovoto = new EmozioneVoto(e, true, commento, voto);

                    emosong.setEmozione(emovoto);
                    break;
                case 2:
                    e = Emozione.SOLEMNITY;
                    voto = in.readInt("Valuta da 1 a 5 l'emozione SOLEMNITY: ");
                    if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                        commento = in.readLine("Inserire il commento --> ");
                    } else {
                        commento = "Nessun Commento";
                    }
                    emovoto = new EmozioneVoto(e, true, commento, voto);
                    emosong.setEmozione(emovoto);

                    break;
                case 3:
                    e = Emozione.TENDERNESS;
                    voto = in.readInt("Valuta da 1 a 5 l'emozione TENDERNESS: ");
                    if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                        commento = in.readLine("Inserire il commento --> ");
                    } else {
                        commento = "Nessun Commento";
                    }
                    emovoto = new EmozioneVoto(e, true, commento, voto);
                    emosong.setEmozione(emovoto);
                    break;
                case 4:
                    e = Emozione.NOSTALGIA;
                    voto = in.readInt("Valuta da 1 a 5 l'emozione NOSTALGIA: ");
                    if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                        commento = in.readLine("Inserire il commento --> ");
                    } else {
                        commento = "Nessun Commento";
                    }
                    emovoto = new EmozioneVoto(e, true, commento, voto);
                    emosong.setEmozione(emovoto);
                    break;
                case 5:
                    e = Emozione.CALMNESS;
                    voto = in.readInt("Valuta da 1 a 5 l'emozione CALMNESS: ");
                    if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                        commento = in.readLine("Inserire il commento --> ");
                    } else {
                        commento = "Nessun Commento";
                    }
                    emovoto = new EmozioneVoto(e, true, commento, voto);
                    emosong.setEmozione(emovoto);
                    break;
                case 6:
                    e = Emozione.POWER;
                    voto = in.readInt("Valuta da 1 a 5 l'emozione POWER: ");
                    if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                        commento = in.readLine("Inserire il commento --> ");
                    } else {
                        commento = "Nessun Commento";
                    }
                    emovoto = new EmozioneVoto(e, true, commento, voto);
                    emosong.setEmozione(emovoto);
                    break;
                case 7:
                    e = Emozione.JOY;
                    voto = in.readInt("Valuta da 1 a 5 l'emozione JOY: ");
                    if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                        commento = in.readLine("Inserire il commento --> ");
                    } else {
                        commento = "Nessun Commento";
                    }
                    emovoto = new EmozioneVoto(e, true, commento, voto);
                    emosong.setEmozione(emovoto);
                    break;
                case 8:
                    e = Emozione.TENSION;
                    voto = in.readInt("Valuta da 1 a 5 l'emozione TENSION: ");
                    if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                        commento = in.readLine("Inserire il commento --> ");
                    } else {
                        commento = "Nessun Commento";
                    }
                    emovoto = new EmozioneVoto(e, true, commento, voto);
                    emosong.setEmozione(emovoto);
                    break;
                case 9:
                    e = Emozione.SADNESS;
                    voto = in.readInt("Valuta da 1 a 5 l'emozione SADNESS: ");
                    if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                        commento = in.readLine("Inserire il commento --> ");
                    } else {
                        commento = "Nessun Commento";
                    }
                    emovoto = new EmozioneVoto(e, true, commento, voto);
                    emosong.setEmozione(emovoto);
                    break;

                // default
            }
        } while(scelta != 0);
        return emosong;
    }

    public static boolean verificaInsEmozioni(ArrayList<Emozione> arr) {
        //fai quello che ti pare controlli ecc ...
        return true;
    }
}