package emotionalsongs;

import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable {

    ArrayList<Canzone> arrCanzoni = new ArrayList<Canzone>();
    Utente utente;
}
