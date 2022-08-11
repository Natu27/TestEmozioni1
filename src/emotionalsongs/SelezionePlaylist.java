package emotionalsongs;

import prog.io.ConsoleInputManager;

import java.util.ArrayList;

public class SelezionePlaylist {

    public static Playlist selezionaPlaylist(ArrayList<Playlist> arr) {
        ConsoleInputManager in = new ConsoleInputManager();
        int scelta = in.readInt("Scegli Numero Identificativo Playlist: ");
        while(scelta<1 || scelta>arr.toArray().length) {
            scelta = in.readInt("VALORE NON CONSENTITO - Scegli Indice Playlist: ");
        }
        Playlist playlist = arr.get(scelta-1);
        return playlist;
    }
}


