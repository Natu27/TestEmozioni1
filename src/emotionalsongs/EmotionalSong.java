package emotionalsongs;

import prog.io.ConsoleOutputManager;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class EmotionalSong implements Serializable {

    private final Canzone song;
    private ArrayList<EmozioneVoto> arrEmotions = new ArrayList<EmozioneVoto>();
    private Utente utente;
    private Playlist playlist;

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
        for (EmozioneVoto emozioneVoto : arrEmotions) {
            if ((emozioneVoto.emozione.toString().equals(e.emozione.toString()) && !emozioneVoto.valutata)) {
                int indx = arrEmotions.indexOf(emozioneVoto);
                arrEmotions.set(indx, e);
                break;
            }
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
        out.println(song.getTitolo() + " - " + song.getAutore() + " - " + song.getAnno());
        for (EmozioneVoto e : arrEmotions) {
            out.print(e.stampaEmozioneVoto() + " / ");
        }
        out.print("\n");
        for (EmozioneVoto e : arrEmotions) {
            out.println(e.stampaCommento());
        }
    }

    public static void visualizzaEmozioniBrano(ArrayList<EmotionalSong> arrayBranoSel) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        double mediaAmazement = 0.0;
        int countAmazement = 0;
        double mediaSolemnity = 0.0;
        int countSolemnity = 0;
        double mediaTenderness = 0.0;
        int countTenderness = 0;
        double mediaNostalgia = 0.0;
        int countNostalgia = 0;
        double mediaCalmness = 0.0;
        int countCalmness = 0;
        double mediaPower = 0.0;
        int countPower = 0;
        double mediaJoy = 0.0;
        int countJoy = 0;
        double mediaTension = 0.0;
        int countTension= 0;
        double mediaSadness = 0.0;
        int countSadness = 0;
        for (EmotionalSong emoSong : arrayBranoSel) {
            for (EmozioneVoto emozioneVoto : emoSong.arrEmotions) {
                if (emozioneVoto.emozione.toString().equals("AMAZEMENT")) {
                    if (emozioneVoto.Voto != 0) {
                        countAmazement++;
                        mediaAmazement += emozioneVoto.Voto;
                    }
                }
                if (emozioneVoto.emozione.toString().equals("SOLEMNITY")) {
                    if (emozioneVoto.Voto != 0) {
                        countSolemnity++;
                        mediaSolemnity += emozioneVoto.Voto;
                    }
                }
                if (emozioneVoto.emozione.toString().equals("TENDERNESS")) {
                    if (emozioneVoto.Voto != 0) {
                        countTenderness++;
                        mediaTenderness += emozioneVoto.Voto;
                    }
                }
                if (emozioneVoto.emozione.toString().equals("NOSTALGIA")) {
                    if (emozioneVoto.Voto != 0) {
                        countNostalgia++;
                        mediaNostalgia += emozioneVoto.Voto;
                    }
                }
                if (emozioneVoto.emozione.toString().equals("CALMNESS")) {
                    if (emozioneVoto.Voto != 0) {
                        countCalmness++;
                        mediaCalmness += emozioneVoto.Voto;
                    }
                }
                if (emozioneVoto.emozione.toString().equals("POWER")) {
                    if (emozioneVoto.Voto != 0) {
                        countPower++;
                        mediaPower += emozioneVoto.Voto;
                    }
                }
                if (emozioneVoto.emozione.toString().equals("JOY")) {
                    if (emozioneVoto.Voto != 0) {
                        countJoy++;
                        mediaJoy += emozioneVoto.Voto;
                    }
                }
                if (emozioneVoto.emozione.toString().equals("TENSION")) {
                    if (emozioneVoto.Voto != 0) {
                        countTension++;
                        mediaTension += emozioneVoto.Voto;
                    }
                }
                if (emozioneVoto.emozione.toString().equals("SADNESS")) {
                    if (emozioneVoto.Voto != 0) {
                        countSadness++;
                        mediaSadness += emozioneVoto.Voto;
                    }
                }
            }
        }
        out.print("MEDIA EMOZIONI: ");
        mediaAmazement = normalizeMedia(mediaAmazement,countAmazement); out.print("AMAZEMENT: " + mediaAmazement);
        mediaSolemnity = normalizeMedia(mediaSolemnity,countSolemnity); out.print(" - SOLEMNITY: " + mediaSolemnity);
        mediaTenderness = normalizeMedia(mediaTenderness,countTenderness); out.print(" - TENDERNESS: " + mediaTenderness);
        mediaNostalgia = normalizeMedia(mediaNostalgia,countNostalgia); out.print(" - NOSTALGIA: " + mediaNostalgia);
        mediaCalmness = normalizeMedia(mediaCalmness,countCalmness); out.print(" - CALMNESS: " + mediaCalmness);
        mediaPower = normalizeMedia(mediaPower,countPower); out.print(" - POWER: " + mediaPower);
        mediaJoy = normalizeMedia(mediaJoy,countJoy); out.print(" - JOY: " + mediaJoy);
        mediaTension = normalizeMedia(mediaTension,countTension); out.print(" - TENSION: " + mediaTension);
        mediaSadness = normalizeMedia(mediaSadness,countSadness); out.print(" - SADNESS: " + mediaSadness);
    }

    public static double normalizeMedia(double media, int countMedia) {
        double mediaFinal;
        if(media == 0.0) {
            mediaFinal = media;
        } else {
            mediaFinal = media/countMedia;
        }
        return mediaFinal;
    }

    public static void numUtentiVotanti(int numVoti) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        if(numVoti == 1) {
            out.println("BRANO VALUTATO DA UN SOLO UTENTE");
        } else {
            out.println("BRANO VALUTATO DA " + numVoti + " UTENTI");
        }
    }

    public static void visualizzaCommentiBrano(ArrayList<EmotionalSong> arrayBranoSel) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        ArrayList<String> arrCommenti = new ArrayList<String>();
        for(EmotionalSong e : arrayBranoSel) {
            for(EmozioneVoto v : e.arrEmotions) {
                if(!v.commento.equals("Nessun Commento")){
                    arrCommenti.add(v.commento);
                }
            }
        }
        stampaCommenti(arrCommenti);
    }

    public static void stampaCommenti(ArrayList<String> arrayCommenti) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        int countCommenti = 1;
        if(arrayCommenti.size() > 1) {
            out.println("COMMENTI INSERITI: " + arrayCommenti.size());
            for(String commento : arrayCommenti) {
                out.println(countCommenti++ + ") " + commento);
            }
        }
        if(arrayCommenti.size() == 0) {
            out.println("NESSUN COMMENTO INSERITO");
        }
        if(arrayCommenti.size() == 1) {
            out.println("COMMENTO INSERITO: ");
            out.println(countCommenti + ") " + arrayCommenti.get(0));
        }
    }
}