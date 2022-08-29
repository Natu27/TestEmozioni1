package emotionalsongs;

import java.io.Serializable;

/**
 * La classe {@code EmozioneVoto} permette di gestire un'emozione con punteggio ed eventuale commento associati
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 */
public class EmozioneVoto implements Serializable {
    public int Voto;
    public String commento;
    public boolean valutata;
    public Emozione emozione;

    /**
     * Permette di creare un'emozione, a partire dai parametri forniti come argomento, a cui è associato un voto, un commento
     * e una variabile booleana per verificare se l'emozione è stata valutata
     * @param e un oggetto di tipo {@code Emozione}
     * @param val un oggetto di tipo {@code boolean}
     * @param comm un oggetto di tipo {@code String}
     * @param v un oggetto di tipo {@code int}
     */
    public EmozioneVoto(Emozione e,boolean val, String comm, int v) {
        Voto = v;
        valutata = val;
        commento = comm;
        emozione = e;

    }
}