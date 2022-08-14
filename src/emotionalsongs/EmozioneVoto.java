package emotionalsongs;

import java.io.Serializable;

public class EmozioneVoto implements Serializable {

    public int Voto;
    public String commento;
    public boolean valutata;
    public Emozione emozione;

    public EmozioneVoto(Emozione e,boolean val, String comm, int v){
        Voto = v;
        valutata = val;
        commento = comm;
        emozione = e;

    }
    public String stampaEmozioneVoto(){
        return emozione.toString()+ " - "+Voto;
    }
    public String stampaCommento(){
        return commento;
    }
}