package emotionalsongs;

import prog.io.ConsoleOutputManager;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * La classe {@code EmotionalSong} permette di gestire un brano musicale inserito all' interno di una playlist,
 * valutato tramite l'inserimento di una o più emozioni da un utente registrato
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 */
public class EmotionalSong implements Serializable {

    private final Canzone song;
    private ArrayList<EmozioneVoto> arrEmotions = new ArrayList<EmozioneVoto>();
    private final Utente utente;
    private final Playlist playlist;

    /***
     * Costruisce un oggetto {@code EmotionalSong} a partire dai parametri forniti
     * @param canzone un oggetto di tipo {@code Canzone} dove è contenuto il titolo, l'autore e l'anno del brano
     * @param utente un oggetto di tipo {@code Utente} che rappresenta l'utente che ha inserito il brano in una playlist
     * @param playlist un oggetto di tipo {@code Playlist} che rappresenta la playlist in cui è contenuto il brano
     */
    public EmotionalSong(Canzone canzone, Utente utente, Playlist playlist) {
        song = canzone;
        this.utente = utente;
        this.playlist = playlist;
        for (Emozione emo : Emozione.values()) {
            EmozioneVoto def = new EmozioneVoto(emo, false, "Nessun Commento", 0);
            arrEmotions.add(def);
        }
    }

    /***
     * Restituisce un brano musicale a partire dell'instanza che esegue il metodo
     * @return un oggetto di tipo {@code Canzone} contenente il titolo, l'autore e l'anno di un brano musicale
     */
    public Canzone getCanzone() {
        return this.song;
    }

    /***
     * Restituisce un'utente a partire dell'instanza che esegue il metodo
     * @return un oggetto di tipo {@code Utente}
     */
    public Utente getUtente() {
        return this.utente;
    }

    /***
     * Restituisce una playlist a partire dell'instanza che esegue il metodo
     * @return un oggetto di tipo {@code Playlist}
     */
    public Playlist getPlaylist() {
        return this.playlist;
    }

    /***
     * Restituisce un'arraylist di emozioni a partire dell'instanza che esegue il metodo,
     * ognuna delle quali avrà un punteggio associato che rappresenta l'intensità relativa all'emozione inserita
     * @return un oggetto di tipo {@code ArrayList<EmozioneVoto>}
     */
    public ArrayList<EmozioneVoto> getArrEmotions() {
        return this.arrEmotions;
    }

    /***
     * Permette di settare nell'array di emozioni dell' oggetto che esegue il metodo l'emozione fornita come parametro
     * @param e un oggetto di tipo {@code EmozioneVoto}
     */
    public void setEmozione(EmozioneVoto e) {
        for (EmozioneVoto emozioneVoto : arrEmotions) {
            if ((emozioneVoto.emozione.toString().equals(e.emozione.toString()) && !emozioneVoto.valutata)) {
                int indx = arrEmotions.indexOf(emozioneVoto);
                arrEmotions.set(indx, e);
                break;
            }
        }
    }

    /***
     * Permette di visualizzare su terminale le emozioni disponibili per l'inserimento relativo al brano musicale
     * associato all'oggetto che esegue il metodo
     */
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

    /**
     * Permette di visualizzare su terminale il titolo del brano associato all'oggetto che esegue il metodo e le emozioni
     * disponibili per l'inserimento
     */
    public void stampaEmoSong() {
        ConsoleOutputManager out = new ConsoleOutputManager();
        out.println("CANZONE SELEZIONATA <" + this.song.getTitolo() + ">");
        EmotionalSong.stampaArrEmozioni();
    }

    /***
     * Permette di visualizzare su terminale a partire dal parametro fornito come argomento la media delle emozioni
     * inserite dagli utenti che hanno valutato il brano musicale in questione ed eventuali commenti inseriti
     * @param arrayBranoSel un oggetto di tipo {@code ArrayList<EmotionalSong>}
     */
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

    /***
     * Permette di controllare la media associata a un'emozione evitando di generare eccezioni di tipo NaN
     * a partire dai parametri forniti come argomento
     * @param media un oggetto di tipo {@code double}
     * @param countMedia un oggetto di tipo {@code int}
     */
    public static double normalizeMedia(double media, int countMedia) {
        double mediaFinal;
        if(media == 0.0) {
            mediaFinal = media;
        } else {
            mediaFinal = media/countMedia;
        }
        return mediaFinal;
    }

    /***
     * Permette di visualizzare a schermo tramite una stringa il numero di utenti che hanno valutato il brano musicale
     * associato all'oggetto che esegue il metodo
     * @param numVoti un oggetto di tipo {@code int} che rappresenta il numero di utenti che hanno valutato il brano in questione
     */
    public static void numUtentiVotanti(int numVoti) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        if(numVoti == 1) {
            out.println("BRANO VALUTATO DA UN SOLO UTENTE");
        } else {
            out.println("BRANO VALUTATO DA " + numVoti + " UTENTI");
        }
    }

    /***
     * Permette di visualizzare su terminale gli eventuali commenti associati a un certo brano musicale
     * a partire dal parametro fornito come argomento
     * @param arrayBranoSel un oggetto di tipo {@code ArrayList<EmotionalSong>}
     */
    public static void visualizzaCommentiBrano(ArrayList<EmotionalSong> arrayBranoSel) {
        //ConsoleOutputManager out = new ConsoleOutputManager();
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

    /***
     * Permette di visualizzare a schermo tramite una o più stringhe gli eventuali commenti inseriti dagli utenti
     * @param arrayCommenti un oggetto di tipo {@code ArrayList<String>}
     */
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