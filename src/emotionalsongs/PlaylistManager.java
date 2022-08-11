package emotionalsongs;

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PlaylistManager {

    final static String path = "src/DATA/Playlist.dati.txt";

    public static void RegistraPlaylist(Utente utente) throws IOException, ClassNotFoundException{
        ArrayList<Canzone> listaCanzoni = CanzoneManager.leggiCanzone();
        Canzone songSelezionata;
        ConsoleInputManager in =new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        out.println("CREAZIONE PLAYLIST: ");
        String nomePlaylist = in.readLine("Inserisci nome Playlist: ");
        nomePlaylist = controllNomePlaylist(nomePlaylist, utente);
        ArrayList<Canzone> arrayCanzoniPLaylist = new ArrayList<Canzone>();
        ArrayList<Canzone> arrayCanzoniTrovate = new ArrayList<Canzone>();
        out.println("INIZIO INSERIMENTO BRANI PLAYLIST " + nomePlaylist.toUpperCase());
        do{
            arrayCanzoniTrovate = RicercaCanzone.cercaTitolo(listaCanzoni);
            while(arrayCanzoniTrovate.size() == 0){
                out.println("!NECESSARIA ULTERIORE RICERCA!");
                arrayCanzoniTrovate = RicercaCanzone.cercaTitolo(listaCanzoni);
            }
            songSelezionata = SelezioneBrano.selezionaBrano(arrayCanzoniTrovate);
            arrayCanzoniPLaylist.add(songSelezionata);
            listaCanzoni.remove(songSelezionata);
        } while(in.readSiNo("Vuoi inserire un altro brano?(SI/NO): "));

        Playlist playlist = new Playlist(nomePlaylist,utente,arrayCanzoniPLaylist);
        ArrayList<Playlist> arrPlaylist = new ArrayList<Playlist>();
        File file = new File(path);
        if(file.length() !=0){
            arrPlaylist = PlaylistManager.leggiPlaylist();
            arrPlaylist.add(playlist);
            PlaylistManager.scriviPlaylist(arrPlaylist);
        }else{
            arrPlaylist.add(playlist);
            PlaylistManager.scriviPlaylist(arrPlaylist);
        }
        try{
            TimeUnit.SECONDS.sleep(1);
            Loading.loading();
            out.println("Playlist salvata.");
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){}
    }



    public static void scriviPlaylist(ArrayList<Playlist> arrPlaylist) throws IOException{
        FileOutputStream fOS = new FileOutputStream(path);
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        oOS.writeObject(arrPlaylist);
        oOS.flush();
        oOS.close();
    }

    public static ArrayList<Playlist> leggiPlaylist() throws IOException, ClassNotFoundException{
        Object o = FileManager.leggiFile(path);
        ArrayList<Playlist> arrPlaylist = new ArrayList<Playlist>();
        if(o instanceof ArrayList<?>){
            ArrayList<?> tmp = (ArrayList<?>) o;
            arrPlaylist = castArrayPlaylist(tmp);
        }
        return arrPlaylist;
    }


    public static ArrayList<Playlist> castArrayPlaylist(ArrayList<?> a){
        ArrayList<Playlist> arrPlaylist = new ArrayList<Playlist>();
        for(Object o : a){
            if(o instanceof Playlist){
                arrPlaylist.add((Playlist) o);
            }
        }
        return arrPlaylist;
    }

    //Legge nomi playlist dell'utente specificato come argomento
    public static ArrayList<String> leggiNomePlaylist(Utente utente)throws IOException, ClassNotFoundException{
        Object o = FileManager.leggiFile(path);
        ArrayList<Playlist> arrPlaylist = new ArrayList<Playlist>();
        if(o instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) o;
            arrPlaylist = castArrayPlaylist(tmp);
        }
        ArrayList<String> arrayNomiPlaylist = new ArrayList<String>();
        for(Playlist playlist :  arrPlaylist) {
            if(playlist.getUtente().getUserId().equals(utente.getUserId())){
                arrayNomiPlaylist.add(playlist.getNomePlaylist());
            }
        }
        return arrayNomiPlaylist;
    }

    public static boolean nomePlaylistUtilizzato(ArrayList<String> arrayNomiPlaylist, String nomePlaylist){
        ConsoleOutputManager out = new ConsoleOutputManager();
        boolean nomeUtilizzato = false;
        File file = new File(path);
        if(file.length()!= 0){
            for(String nomePlay : arrayNomiPlaylist){
                if(nomePlaylist.equals((nomePlay))){
                    nomeUtilizzato = true;
                    out.println("!Nome playlist già utilizzato!");
                    break;
                }
            }
        }
        return nomeUtilizzato;
    }

    public static String controllNomePlaylist(String s,Utente utente)throws IOException, ClassNotFoundException{
        ConsoleInputManager in = new ConsoleInputManager();
        ArrayList<String> nomePlaylistUtilizzati = new ArrayList<String>();
        File file = new File(path);
        if(file.length() != 0) {
            nomePlaylistUtilizzati = PlaylistManager.leggiNomePlaylist(utente);
        }
        s = s.trim();
        while(nomePlaylistUtilizzato(nomePlaylistUtilizzati,s) || s.equals("") || RicercaCanzone.everyCharWhitespace(s)){
            s = in.readLine("INPUT NON CONSENTITO - Reinserire: ");
            s = s.trim();
        }
        return s;
    }
}
