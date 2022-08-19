package emotionalsongs;

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class InserisciEmozioniBrano {

    public static EmotionalSong inserisciEmozioniBrano(Canzone song, Utente utente, Playlist playlist) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        EmotionalSong emosong = new EmotionalSong(song, utente, playlist);
        Emozione e = null;
        EmozioneVoto emovoto = null;
        int voto = 0;
        int scelta;
        String commento = "";
        int countEmo = 0;

        do {
            scelta = (in.readInt("Scegli numericamente un emozione(0 per terminare): "));
            while(scelta<0 || scelta>9) {
                scelta = in.readInt("VALORE NON CONSENTITO - Scegli Opzione Disponbile: ");
            }
            switch (scelta) {
                case 1:
                    if(!emosong.getArrEmotions().get(0).valutata) {
                        e = Emozione.AMAZEMENT;
                        emovoto = creaEmoVoto(e,voto,commento);
                        emosong.setEmozione(emovoto);
                        countEmo++;
                    }else {
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 2:
                    if(!emosong.getArrEmotions().get(1).valutata) {
                        e = Emozione.SOLEMNITY;
                        emovoto = creaEmoVoto(e,voto,commento);
                        emosong.setEmozione(emovoto);
                        countEmo++;
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 3:
                    if(!emosong.getArrEmotions().get(2).valutata) {
                        e = Emozione.TENDERNESS;
                        emovoto = creaEmoVoto(e,voto,commento);
                        emosong.setEmozione(emovoto);
                        countEmo++;
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 4:
                    if(!emosong.getArrEmotions().get(3).valutata) {
                        e = Emozione.NOSTALGIA;
                        emovoto = creaEmoVoto(e,voto,commento);
                        emosong.setEmozione(emovoto);
                        countEmo++;
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 5:
                    if(!emosong.getArrEmotions().get(4).valutata) {
                        e = Emozione.CALMNESS;
                        emovoto = creaEmoVoto(e,voto,commento);
                        emosong.setEmozione(emovoto);
                        countEmo++;
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 6:
                    if(!emosong.getArrEmotions().get(5).valutata) {
                        e = Emozione.POWER;
                        emovoto = creaEmoVoto(e,voto,commento);
                        emosong.setEmozione(emovoto);
                        countEmo++;
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 7:
                    if(!emosong.getArrEmotions().get(6).valutata) {
                        e = Emozione.JOY;
                        emovoto = creaEmoVoto(e,voto,commento);
                        emosong.setEmozione(emovoto);
                        countEmo++;
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 8:
                    if(!emosong.getArrEmotions().get(7).valutata) {
                        e = Emozione.TENSION;
                        emovoto = creaEmoVoto(e,voto,commento);
                        emosong.setEmozione(emovoto);
                        countEmo++;
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
                case 9:
                    if(!emosong.getArrEmotions().get(8).valutata) {
                        e = Emozione.SADNESS;
                        emovoto = creaEmoVoto(e,voto,commento);
                        emosong.setEmozione(emovoto);
                        countEmo++;
                    }else{
                        out.println("!Emozione già inserita!");
                    }
                    break;
            }
        } while(scelta != 0 || controlloCount(countEmo));
        Loading.loading();
        out.println("Emozioni inserite con successo.");
        return emosong;
    }

    private static EmozioneVoto creaEmoVoto(Emozione e,int voto,String commento) {
        ConsoleInputManager in = new ConsoleInputManager();
        voto = in.readInt("Valuta da 1 a 5 l'emozione " + e.toString() + ": ");
        while(voto<1 || voto>5) {
            voto = in.readInt("VALORE NON CONSENTITO - Reinserire un valore compreso tra 1 e 5: ");
        }
        if (in.readSiNo("Vuoi inserire un commento?(SI/NO): ")) {
            commento = in.readLine("Inserire il commento --> ");
            commento = controlloCommento(commento);
        } else {
            commento = "Nessun Commento";
        }
        EmozioneVoto emovoto = new EmozioneVoto(e, true, commento, voto);
        return  emovoto;
    }

    private static boolean controlloCount(int count){
        ConsoleOutputManager out = new ConsoleOutputManager();
        if(count == 0){
            out.println("!Necessario inserire almeno un'emozione!");
            return true;
        }else{
            return false;
        }
    }

    private static String controlloCommento(String commento) {
        commento = commento.trim();
        while(commento.equals("") || RicercaCanzone.everyCharWhitespace(commento) || commento.length()>256) {
            commento = commento.trim();
            ConsoleInputManager in = new ConsoleInputManager();
            if (commento.length() > 256) {
                commento = in.readLine("INPUT NON CONSENTITO - !Lunghezza max 256 caratteri! - Reinserire commento: ");
            } else {
                commento = in.readLine("INPUT NON CONSENTITO - Reinserire commento: ");
            }
        }
        return commento;
    }

    public static boolean verificaInsEmozioni(ArrayList<Emozione> arr) {
        //fai quello che ti pare controlli ecc ...
        return true;
    }
}