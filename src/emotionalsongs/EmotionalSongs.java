package emotionalsongs;
import emotionalsongs.*;
import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class EmotionalSongs {
    private static Utente utente = null;
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //ImporterCanzoni.serializzaCanzone();
        ArrayList<Canzone> listaCanzoni = CanzoneManager.leggiCanzone();
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        int scelta;
        do {
            out.println("MENU APP: ");
            out.println("1--> CONSULTA INFO CANZONE\n" + "2--> REGISTRATI\n" +
                    "3--> CREA PLAYLIST\n" + "4--> INSERISCI EMOZIONI\n" + "0--> ESCI DALL'APP");
            scelta = in.readInt("Scegli Opzione: ");
            while(scelta<0 || scelta>4) {
                scelta = in.readInt("VALORE NON CONSENTITO - Scegli Opzione Disponbile: ");
            }
            switch (scelta) {
                case 1:
                    out.println("OPZIONI: ");
                    out.println("1--> RICERCA TITOLO BRANO MUSICALE");
                    out.println("2--> RICERCA AUTORE BRANO MUSICALE");
                    out.println("3--> TORNA AL MENU APP");
                    scelta = in.readInt("Scegli Opzione: ");
                    while (scelta < 0 || scelta > 3) {
                        scelta = in.readInt("VALORE NON CONSENTITO - Scegli Opzione Disponibile: ");
                    }
                    switch (scelta) {
                        case 1:
                            ArrayList<Canzone> arrSelezioneTitolo = RicercaCanzone.cercaTitolo(listaCanzoni);
                            if (arrSelezioneTitolo.size() != 0) {
                                Canzone songSelezionata = SelezioneBrano.selezionaBrano(arrSelezioneTitolo);
                                out.println("OPZIONI: ");
                                out.println("1--> VISUALIZZA INFORMAZIONI BRANO");
                                out.println("2--> VISUALIZZA TAG EMOZIONI BRANO");
                                out.println("3--> TORNA AL MENU APP");
                                scelta = in.readInt("Scegli Opzione: ");
                                while (scelta < 1 || scelta > 3) {
                                    scelta = in.readInt("VALORE NON CONSENTITO - Scegli Opzione Disponibile: ");
                                }
                                switch (scelta) {
                                    case 1:
                                        out.println("TITOLO: " + songSelezionata.getTitolo() + " - AUTORE: "
                                                + songSelezionata.getAutore() + " - ANNO: " + songSelezionata.getAnno());
                                        break;
                                    case 2:
                                        File file = new File("C:/Users/loren/IdeaProjects/TestEmozioni/out/" +
                                                            "production/TestEmozioni/DATA/Emozioni.dati.txt");
                                        if(file.length() != 0){
                                            ArrayList<EmotionalSong> arraySelezione = EmotionalSongManager.leggiEmoSong();
                                            ArrayList<EmotionalSong> arrayBranoSel = new ArrayList<EmotionalSong>();
                                            for(EmotionalSong e : arraySelezione){
                                                Canzone song = e.getCanzone();
                                                if(song.getTitolo().equals(songSelezionata.getTitolo()) && song.getAutore().equals(songSelezionata.getAutore())
                                                        && song.getAnno().equals(songSelezionata.getAnno())){
                                                    arrayBranoSel.add(e);
                                                }
                                            }
                                            if(arrayBranoSel.size() !=0){
                                                int countUtenti = 0;
                                                for (EmotionalSong emo : arrayBranoSel) {
                                                    countUtenti++;
                                                }
                                                out.println("BRANO SELEZIONATO: " + songSelezionata.stampaCanzone());
                                                EmotionalSong.visualizzaEmozioniBrano(arrayBranoSel);
                                                EmotionalSong.visualizzaCommentiBrano(arrayBranoSel);
                                                EmotionalSong.numUtentiVotanti(countUtenti);
                                            }else {
                                                out.println("Non sono presenti emozioni inserite per il brano selezionato.");
                                            }
                                        }else{
                                            out.println("Non sono presenti emozioni inserite per il brano selezionato.");
                                        }
                                        break;
                                    case 3:
                                        break;
                                }
                            }
                            break;
                        case 2:
                            ArrayList<Canzone> arrSelezioneAutore = RicercaCanzone.cercaAutore(listaCanzoni);
                            if (arrSelezioneAutore.size() != 0) {
                                Canzone songSelected = SelezioneBrano.selezionaBrano(arrSelezioneAutore);
                                out.println("OPZIONI: ");
                                out.println("1--> VISUALIZZA INFORMAZIONI BRANO");
                                out.println("2--> VISUALIZZA TAG EMOZIONI BRANO");
                                out.println("3--> TORNA AL MENU APP");
                                scelta = in.readInt("Scegli Opzione: ");
                                while (scelta < 1 || scelta > 3) {
                                    scelta = in.readInt("VALORE NON CONSENTITO - Scegli Opzione Disponibile: ");
                                }
                                switch (scelta) {
                                    case 1:
                                        out.println("TITOLO: " + songSelected.getTitolo() + " - AUTORE: "
                                                + songSelected.getAutore() + " - ANNO: " + songSelected.getAnno());
                                        break;
                                    case 2:
                                        File file = new File("C:/Users/loren/IdeaProjects/TestEmozioni/out/" +
                                                            "production/TestEmozioni/DATA/Emozioni.dati.txt");
                                        if(file.length() != 0){
                                            ArrayList<EmotionalSong> arraySelezione = EmotionalSongManager.leggiEmoSong();
                                            ArrayList<EmotionalSong> arrayBranoSel = new ArrayList<EmotionalSong>();
                                            for(EmotionalSong e : arraySelezione){
                                                Canzone song = e.getCanzone();
                                                if(song.getTitolo().equals(songSelected.getTitolo()) && song.getAutore().equals(songSelected.getAutore())
                                                        && song.getAnno().equals(songSelected.getAnno())){
                                                    arrayBranoSel.add(e);
                                                }
                                            }
                                            if(arrayBranoSel.size() != 0) {
                                                int countUtenti = 0;
                                                for (EmotionalSong emo : arrayBranoSel) {
                                                    countUtenti++;
                                                }
                                                out.println("BRANO SELEZIONATO: " + songSelected.stampaCanzone());
                                                EmotionalSong.visualizzaEmozioniBrano(arrayBranoSel);
                                                EmotionalSong.visualizzaCommentiBrano(arrayBranoSel);
                                                EmotionalSong.numUtentiVotanti(countUtenti);
                                            }else {
                                                out.println("Non sono presenti emozioni inserite per il brano selezionato.");
                                            }
                                        }else{
                                            out.println("Non sono presenti emozioni inserite per il brano selezionato.");
                                        }
                                        break;
                                    case 3:
                                        break;
                                }
                            }
                            break;
                        case 3:
                            break;
                    }
                    out.println();
                    break;
                case 2:
                    out.println("OPZIONI: ");
                    out.println("1--> REGISTRATI");
                    out.println("2--> LOG OUT");
                    out.println("3--> TORNA AL MENU APP");
                    scelta = in.readInt("Scegli Opzione: ");
                    while (scelta < 1 || scelta > 3) {
                        scelta = in.readInt("VALORE NON CONSENTITO - Scegli Opzione Disponibile: ");
                    }
                    switch(scelta) {
                        case 1:
                            Utente nuovoUtente = UtenteManager.Registrazione();
                            ArrayList<Utente> arrUtenti = new ArrayList<Utente>();
                            File fileUtenti = new File("C:/Users/loren/IdeaProjects/TestEmozioni/out/" +
                                                        "production/TestEmozioni/DATA/UtentiRegistrati.txt");
                            if (fileUtenti.length() != 0) {
                                arrUtenti = UtenteManager.leggiUtenti();
                            }
                            arrUtenti.add(nuovoUtente);
                            UtenteManager.scriviUtente(arrUtenti);
                            try {
                                TimeUnit.SECONDS.sleep(1);
                                out.println("Utente registrato con successo");
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {}
                            break;
                        case 2:
                            if(utente != null) {
                                try {
                                    utente = null;
                                    TimeUnit.SECONDS.sleep(1);
                                    out.println("Logout effettuato con successo");
                                    TimeUnit.SECONDS.sleep(1);
                                } catch (InterruptedException e) {
                                }
                            }else{
                                out.println("!Necessario login prima di effettuare il logout!");
                            }
                            break;
                        case 3:
                            break;
                    }
                    out.println();
                    break;
                case 3:
                    out.println("OPZIONI: ");
                    out.println("1--> CREA PLAYLIST");
                    out.println("2--> LOG OUT");
                    out.println("3--> TORNA AL MENU APP");
                    scelta = in.readInt("Scegli Opzione: ");
                    while (scelta < 1 || scelta > 3) {
                        scelta = in.readInt("VALORE NON CONSENTITO - Scegli Opzione Disponibile: ");
                    }
                    switch(scelta) {
                        case 1:
                            if(utente == null) {
                                utente = UtenteManager.login();
                                if(utente != null)
                                    PlaylistManager.RegistraPlaylist(utente);
                            } else {
                                PlaylistManager.RegistraPlaylist(utente);
                            }
                            break;
                        case 2:
                            if(utente != null) {
                                try {
                                    utente = null;
                                    TimeUnit.SECONDS.sleep(1);
                                    out.println("Logout effettuato con successo");
                                    TimeUnit.SECONDS.sleep(1);
                                } catch (InterruptedException e) {
                                }
                            }else{
                                out.println("!Necessario login prima di effettuare il logout!");
                            }
                            break;
                        case 3:
                            break;
                    }
                    out.println();
                    break;
                case 4:
                    out.println("OPZIONI: ");
                    out.println("1--> INSERISCI EMOZIONI BRANO PLAYLIST");
                    out.println("2--> LOGOUT");
                    out.println("3--> TORNA AL MENU APP");
                    scelta = in.readInt("Scegli Opzione: ");
                    while (scelta < 1 || scelta > 3) {
                        scelta = in.readInt("VALORE NON CONSENTITO - Scegli Opzione Disponibile: ");
                    }
                    switch (scelta) {
                        case 1:
                            if(utente != null){
                                ArrayList<Playlist> playlistUtente = new ArrayList<Playlist>();
                                File file = new File("C:/Users/loren/IdeaProjects/TestEmozioni/out/" +
                                                        "production/TestEmozioni/DATA/Playlist.dati.txt");
                                if(file.length() != 0){
                                    playlistUtente = PlaylistManager.leggiPlaylistUtente(utente);
                                }
                                if(playlistUtente.size() != 0){
                                    int count = 1;
                                    out.println("PLAYLIST: ");
                                    for(Playlist p : playlistUtente){
                                        out.println(count++ + " --> " + p.getNomePlaylist());
                                    }
                                    Playlist playlist = SelezionePlaylist.selezionaPlaylist(playlistUtente);
                                    ArrayList<Canzone> arraySelezione = playlist.stampaCanzoniPlaylist();
                                    Canzone songSelezionata = SelezioneBrano.selezionaBrano(arraySelezione);
                                    EmotionalSong emoSong = new EmotionalSong(songSelezionata,utente,playlist);
                                    //emoSong.stampaEmoSong();
                                    if(!EmotionalSongManager.verificaEmoInserite(songSelezionata,utente,playlist)) {
                                        emoSong.stampaEmoSong();
                                        emoSong = InserisciEmozioniBrano.inserisciEmozioniBrano(songSelezionata, utente, playlist);
                                        File fileEmozioni = new File("C:/Users/loren/IdeaProjects/TestEmozioni/out/" +
                                                                    "production/TestEmozioni/DATA/Emozioni.dati.txt");
                                        ArrayList<EmotionalSong> arrEmozioni = new ArrayList<EmotionalSong>();
                                        if (fileEmozioni.length() != 0) {
                                            arrEmozioni = EmotionalSongManager.leggiEmoSong();
                                            arrEmozioni.add(emoSong);
                                        } else {
                                            arrEmozioni.add(emoSong);
                                        }
                                        EmotionalSongManager.scriviEmoSong(arrEmozioni);
                                    }
                                }else{
                                    if(utente!=null) {
                                        try {
                                            TimeUnit.SECONDS.sleep(1);
                                            out.println("!Non sono presenti Playlist per l'utente selezionato!");
                                            TimeUnit.SECONDS.sleep(1);
                                            break;
                                        } catch (InterruptedException e) {
                                        }
                                    }
                                }
                            }else {
                                utente = UtenteManager.login();
                                ArrayList<Playlist> playlistUtente = new ArrayList<Playlist>();
                                File file = new File("C:/Users/loren/IdeaProjects/TestEmozioni/out/" +
                                                    "production/TestEmozioni/DATA/Playlist.dati.txt");
                                if (file.length() != 0) {
                                    playlistUtente = PlaylistManager.leggiPlaylistUtente(utente);
                                }
                                if(playlistUtente.size() != 0) {
                                    int count = 1;
                                    out.println("PLAYLIST: ");
                                    for (Playlist p : playlistUtente) {
                                        out.println(count++ + " --> " + p.getNomePlaylist());
                                    }
                                    Playlist playlist = SelezionePlaylist.selezionaPlaylist(playlistUtente);
                                    ArrayList<Canzone> arraySelezione = playlist.stampaCanzoniPlaylist();
                                    Canzone songSelezionata = SelezioneBrano.selezionaBrano(arraySelezione);
                                    EmotionalSong emoSong = new EmotionalSong(songSelezionata,utente,playlist);
                                    //emoSong.stampaEmoSong();
                                    if(!EmotionalSongManager.verificaEmoInserite(songSelezionata,utente,playlist)) {
                                        emoSong.stampaEmoSong();
                                        emoSong = InserisciEmozioniBrano.inserisciEmozioniBrano(songSelezionata, utente, playlist);
                                        //emoSong.stampaEmoSongPunteggio();
                                        File fileEmozioni = new File("C:/Users/loren/IdeaProjects/TestEmozioni/out/" +
                                                                    "production/TestEmozioni/DATA/Emozioni.dati.txt");
                                        ArrayList<EmotionalSong> arrEmozioni = new ArrayList<EmotionalSong>();
                                        if (fileEmozioni.length() != 0) {
                                            arrEmozioni = EmotionalSongManager.leggiEmoSong();
                                            arrEmozioni.add(emoSong);
                                        } else {
                                            arrEmozioni.add(emoSong);
                                        }
                                        EmotionalSongManager.scriviEmoSong(arrEmozioni);
                                    }
                                }else{
                                    if(utente!=null) {
                                        try {
                                            TimeUnit.SECONDS.sleep(1);
                                            out.println("!Non sono presenti Playlist per l'utente selezionato!");
                                            TimeUnit.SECONDS.sleep(1);
                                            break;
                                        } catch (InterruptedException e) {}
                                    }
                                }
                            }
                            break;
                        case 2:
                            if(utente != null) {
                                try {
                                    utente = null;
                                    TimeUnit.SECONDS.sleep(1);
                                    out.println("Logout effettuato con successo");
                                    TimeUnit.SECONDS.sleep(1);
                                } catch (InterruptedException e) {
                                }
                            }else{
                                out.println("!Necessario login prima di effettuare il logout!");
                            }
                            break;
                        case 3:
                            break;
                    }
                    out.println();
                    break;
                case 0:
                    out.println("!CIAO, A PRESTO!");
                    break;
            }
        } while (scelta != 0);
    }
}

