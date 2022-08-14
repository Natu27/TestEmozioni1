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
        int scelta = (in.readInt("emozione : "));
        Emozione e = null;
        EmozioneVoto emovoto = null;
        int voto;
        String s="";
        String commento = "";

        switch (scelta) {
            case 1:
                e = Emozione.AMAZEMENT;
                voto = in.readInt("Scegli un voto da 1 a 5 ");
                s = in.readLine("Vuoi inserire un commento?(SI/NO): ");
                if(s.contains("n")){
                    commento = "Nessun Commento";
                }else{
                    commento = in.readLine("Inserire il commento : ");
                }
                emovoto = new EmozioneVoto(e,true, commento, voto);

                emosong.setEmozione(emovoto);
                break;
            case 2:
                e = Emozione.SOLEMNITY;
                voto = in.readInt("Scegli un voto da 1 a 5 ");
                s = in.readLine("Vuoi inserire un commento (y/n) ?  : ");
                if(s.contains("n")){
                    commento = "Nessun Commento";
                }else{
                    commento = in.readLine("Inserire il commento : ");
                }
                emovoto = new EmozioneVoto(e,true, commento, voto);
                emosong.setEmozione(emovoto);

                break;
            case 3:
                e = Emozione.TENDERNESS;
                voto = in.readInt("Scegli un voto da 1 a 5 ");
                s = in.readLine("Vuoi inserire un commento (y/n) ?  : ");
                if(s.contains("n")){
                    commento = "Nessun Commento";
                }else{
                    commento = in.readLine("Inserire il commento : ");
                }
                emovoto = new EmozioneVoto(e,true, commento, voto);
                emosong.setEmozione(emovoto);
                break;
            case 4:
                e = Emozione.NOSTALGIA;
                voto = in.readInt("Scegli un voto da 1 a 5 ");
                s = in.readLine("Vuoi inserire un commento (y/n) ?  : ");
                if(s.contains("n")){
                    commento = "Nessun Commento";
                }else{
                    commento = in.readLine("Inserire il commento : ");
                }
                emovoto = new EmozioneVoto(e,true, commento, voto);
                emosong.setEmozione(emovoto);
                break;
            case 5:
                e = Emozione.CALMNESS;
                voto = in.readInt("Scegli un voto da 1 a 5 ");
                s = in.readLine("Vuoi inserire un commento (y/n) ?  : ");
                if(s.contains("n")){
                    commento = "Nessun Commento";
                }else{
                    commento = in.readLine("Inserire il commento : ");
                }
                emovoto = new EmozioneVoto(e,true, commento, voto);
                emosong.setEmozione(emovoto);
                break;
            case 6:
                e = Emozione.POWER;
                voto = in.readInt("Scegli un voto da 1 a 5 ");
                s = in.readLine("Vuoi inserire un commento (y/n) ?  : ");
                if(s.contains("n")){
                    commento = "Nessun Commento";
                }else{
                    commento = in.readLine("Inserire il commento : ");
                }
                emovoto = new EmozioneVoto(e,true, commento, voto);
                emosong.setEmozione(emovoto);
                break;
            case 7:
                e = Emozione.JOY;
                voto = in.readInt("Scegli un voto da 1 a 5 ");
                s = in.readLine("Vuoi inserire un commento (y/n) ?  : ");
                if(s.contains("n")){
                    commento = "Nessun Commento";
                }else{
                    commento = in.readLine("Inserire il commento : ");
                }
                emovoto = new EmozioneVoto(e,true, commento, voto);
                emosong.setEmozione(emovoto);
                break;
            case 8:
                e = Emozione.TENSION;
                voto = in.readInt("Scegli un voto da 1 a 5 ");
                s = in.readLine("Vuoi inserire un commento (y/n) ?  : ");
                if(s.contains("n")){
                    commento = "Nessun Commento";
                }else{
                    commento = in.readLine("Inserire il commento : ");
                }
                emovoto = new EmozioneVoto(e,true, commento, voto);
                emosong.setEmozione(emovoto);
                break;
            case 9:
                e = Emozione.SADNESS;
                voto = in.readInt("Scegli un voto da 1 a 5 ");
                s = in.readLine("Vuoi inserire un commento (y/n) ?  : ");
                if(s.contains("n")){
                    commento = "Nessun Commento";
                }else{
                    commento = in.readLine("Inserire il commento : ");
                }
                emovoto = new EmozioneVoto(e,true, commento, voto);
                emosong.setEmozione(emovoto);
                break;

            // default
        }
        out.println();
        return emosong;
    }

    public static boolean verificaInsEmozioni(ArrayList<Emozione> arr) {
        //fai quello che ti pare controlli ecc ...
        return true;
    }
}