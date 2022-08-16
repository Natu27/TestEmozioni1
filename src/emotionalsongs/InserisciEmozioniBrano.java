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
                    if(!emosong.getArrEmotions().get(0).valutata) {
                        e = Emozione.AMAZEMENT;
                        voto = in.readInt("Valuta da 1 a 5 l'emozione AMAZEMENT: ");
                        if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                            commento = in.readLine("Inserire il commento --> ");
                        } else {
                            commento = "Nessun Commento";
                        }
                        emovoto = new EmozioneVoto(e, true, commento, voto);

                        emosong.setEmozione(emovoto);
                    }else {
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 2:
                    if(!emosong.getArrEmotions().get(1).valutata) {
                        e = Emozione.SOLEMNITY;
                        voto = in.readInt("Valuta da 1 a 5 l'emozione SOLEMNITY: ");
                        if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                            commento = in.readLine("Inserire il commento --> ");
                        } else {
                            commento = "Nessun Commento";
                        }
                        emovoto = new EmozioneVoto(e, true, commento, voto);
                        emosong.setEmozione(emovoto);
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 3:
                    if(!emosong.getArrEmotions().get(2).valutata) {
                        e = Emozione.TENDERNESS;
                        voto = in.readInt("Valuta da 1 a 5 l'emozione TENDERNESS: ");
                        if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                            commento = in.readLine("Inserire il commento --> ");
                        } else {
                            commento = "Nessun Commento";
                        }
                        emovoto = new EmozioneVoto(e, true, commento, voto);
                        emosong.setEmozione(emovoto);
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 4:
                    if(!emosong.getArrEmotions().get(3).valutata) {
                        e = Emozione.NOSTALGIA;
                        voto = in.readInt("Valuta da 1 a 5 l'emozione NOSTALGIA: ");
                        if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                            commento = in.readLine("Inserire il commento --> ");
                        } else {
                            commento = "Nessun Commento";
                        }
                        emovoto = new EmozioneVoto(e, true, commento, voto);
                        emosong.setEmozione(emovoto);
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 5:
                    if(!emosong.getArrEmotions().get(4).valutata) {
                        e = Emozione.CALMNESS;
                        voto = in.readInt("Valuta da 1 a 5 l'emozione CALMNESS: ");
                        if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                            commento = in.readLine("Inserire il commento --> ");
                        } else {
                            commento = "Nessun Commento";
                        }
                        emovoto = new EmozioneVoto(e, true, commento, voto);
                        emosong.setEmozione(emovoto);
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 6:
                    if(!emosong.getArrEmotions().get(5).valutata) {
                        e = Emozione.POWER;
                        voto = in.readInt("Valuta da 1 a 5 l'emozione POWER: ");
                        if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                            commento = in.readLine("Inserire il commento --> ");
                        } else {
                            commento = "Nessun Commento";
                        }
                        emovoto = new EmozioneVoto(e, true, commento, voto);
                        emosong.setEmozione(emovoto);
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 7:
                    if(!emosong.getArrEmotions().get(6).valutata) {
                        e = Emozione.JOY;
                        voto = in.readInt("Valuta da 1 a 5 l'emozione JOY: ");
                        if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                            commento = in.readLine("Inserire il commento --> ");
                        } else {
                            commento = "Nessun Commento";
                        }
                        emovoto = new EmozioneVoto(e, true, commento, voto);
                        emosong.setEmozione(emovoto);
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 8:
                    if(!emosong.getArrEmotions().get(7).valutata) {
                        e = Emozione.TENSION;
                        voto = in.readInt("Valuta da 1 a 5 l'emozione TENSION: ");
                        if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                            commento = in.readLine("Inserire il commento --> ");
                        } else {
                            commento = "Nessun Commento";
                        }
                        emovoto = new EmozioneVoto(e, true, commento, voto);
                        emosong.setEmozione(emovoto);
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 9:
                    if(!emosong.getArrEmotions().get(8).valutata) {
                        e = Emozione.SADNESS;
                        voto = in.readInt("Valuta da 1 a 5 l'emozione SADNESS: ");
                        if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
                            commento = in.readLine("Inserire il commento --> ");
                        } else {
                            commento = "Nessun Commento";
                        }
                        emovoto = new EmozioneVoto(e, true, commento, voto);
                        emosong.setEmozione(emovoto);
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
            }
        } while(scelta != 0);
        return emosong;
    }

    public static boolean verificaInsEmozioni(ArrayList<Emozione> arr) {
        //fai quello che ti pare controlli ecc ...
        return true;
    }
}