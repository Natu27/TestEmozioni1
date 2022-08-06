import emotionalsongs.*;
import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {

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
                                        out.println("TAG EMOZIONI DA FARE!!!");
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
                                        out.println("TAG EMOZIONI DA FARE!!!");
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
                            Utente nuovoUtente = UtenteManager.registraUtente();
                            ArrayList<Utente> arrUtenti = new ArrayList<Utente>();
                            File fileUtenti = new File("src/DATA/UtentiRegistrati.txt");
                            if (fileUtenti.length() != 0) {
                           //ArrayList<Utente> arrUtenti = new ArrayList<Utente>();
                                arrUtenti = UtenteManager.leggiUtenti();
                            }
                            arrUtenti.add(nuovoUtente);
                            UtenteManager.scriviUtente(arrUtenti);
                            try {
                                TimeUnit.SECONDS.sleep(1);
                                out.println("Utente registrato con successo\n");
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                //e.toString();
                            }
                            break;
                       case 2:
                           //out.println("LOG OUT DA FARE!!");
                           try {
                               utente = null;
                               TimeUnit.SECONDS.sleep(1);
                               out.println("Logout effettuato con successo");
                               TimeUnit.SECONDS.sleep(1);
                           } catch (InterruptedException e) {
                               //e.toString();
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
                            } else {
                                out.println("Login già effettuato");
                            }
                            break;
                        case 2:
                            try {
                                utente = null;
                                TimeUnit.SECONDS.sleep(1);
                                out.println("Logout effettuato con successo");
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                //e.toString();
                            }
                            break;
                        case 3:
                            break;
                    }
                    out.println();
                    break;
                case 4:
                    out.println("OPZIONI: ");
                    out.println("1--> SCEGLI BRANO MUSICALE PER TITOLO:");
                    out.println("2--> SCEGLI BRANO MUSICALE PER AUTORE E ANNO:");
                    out.println("3--> TORNA AL MENU APP");
                    scelta = in.readInt("Scegli Opzione: ");
                    while (scelta < 1 || scelta > 3) {
                        scelta = in.readInt("VALORE NON CONSENTITO - Scegli Opzione Disponibile: ");
                    }
                    switch (scelta) {
                        case 1:
                            ArrayList<Canzone> arrSelezioneBrano = RicercaCanzone.cercaTitolo(listaCanzoni);
                            if(!arrSelezioneBrano.isEmpty()) {
                                //Quando nel file ci sono 0 emozioni usare istruzione seguente altrimenti Exception
                                //ArrayList<EmotionalSong> arr = new ArrayList<EmotionalSong>();
                                ArrayList<EmotionalSong> arr = EmotionalSongManager.leggiEmoSong();
                                Canzone songSelezionata = SelezioneBrano.selezionaBrano(arrSelezioneBrano);
                                EmotionalSong emoSong = new EmotionalSong(songSelezionata);
                                emoSong.stampaEmoSong();
                                emoSong = InserisciEmozioniBrano.inserisciEmozioni(songSelezionata);
                                if(in.readSiNo("Vuoi inserire un commento associato al brano musicale selezionato?(Si/No) ")) {
                                    emoSong.commento = in.readLine("Inserire commento: ");
                                    emoSong.commento = RicercaCanzone.controll(emoSong.commento);
                                    while(emoSong.commento.length()>256) {
                                        emoSong.commento = in.readLine("VALORE NON CONSENTITO - Lunghezza Max 256 Caratteri - Reinserire: ");
                                    }
                                }
                                arr.add(emoSong);
                                out.println("BRANO MUSICALE + EMOZIONI INSERITE + EVENTUALE COMMENTO: ");
                                emoSong.stampaEmoSongPunteggio();
                                EmotionalSongManager.scriviEmoSong(arr);
                            }
                            break;
                        case 2:
                            ArrayList<Canzone> arrSelezioneSong = RicercaCanzone.cercaAutore(listaCanzoni);
                            if(!arrSelezioneSong.isEmpty()) {
                                //Quando nel file ci sono 0 emozioni usare istruzione seguente altrimenti Exception
                                //ArrayList<EmontionalSong> arr = new ArrayList<EmotionalSong>();
                                ArrayList<EmotionalSong> arr = EmotionalSongManager.leggiEmoSong();
                                Canzone songSelezionata = SelezioneBrano.selezionaBrano(arrSelezioneSong);
                                EmotionalSong emoSong = new EmotionalSong(songSelezionata);
                                emoSong.stampaEmoSong();
                                emoSong = InserisciEmozioniBrano.inserisciEmozioni(songSelezionata);
                                if(in.readSiNo("Vuoi inserire un commento associato al brano musicale selezionato?(Si/No) ")) {
                                    emoSong.commento = in.readLine("Inserire commento: ");
                                    emoSong.commento = RicercaCanzone.controll(emoSong.commento);
                                    while(emoSong.commento.length()>256) {
                                        emoSong.commento = in.readLine("VALORE NON CONSENTITO - Lunghezza Max 256 Caratteri - Reinserire: ");
                                    }
                                }
                                arr.add(emoSong);
                                out.println("BRANO MUSICALE + EMOZIONI INSERITE + EVENTUALE COMMENTO: ");
                                emoSong.stampaEmoSongPunteggio();
                                EmotionalSongManager.scriviEmoSong(arr);
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