import emotionalsongs.*;
import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

//import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {

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
                            break;
                        case 2:
                            ArrayList<Canzone> arrSelezioneAutore = RicercaCanzone.cercaAutore(listaCanzoni);
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
                            break;
                        case 3:
                            break;
                    }
                    out.println();
                    break;
                case 2:
                   String nome = in.readLine("Inserisci nome: ");
                   RicercaCanzone.controll(nome);
                   String cognome = in.readLine("Inserisci cognome: ");
                   RicercaCanzone.controll(cognome);
                   String nomeCognome = nome + " " + cognome;
                   String codFiscale = in.readLine("Inserisci codice fiscale: ");
                   while(codFiscale.length() != 16) {
                       codFiscale = in.readLine("VALORE NON CONSENTITO - Inserire 16 caratteri alfanumerici: ");
                   }
                   codFiscale = codFiscale.toUpperCase();
                   out.println(codFiscale);
                   String via = in.readLine("Inserisci via/piazza: ");
                   RicercaCanzone.controll(via);
                   int numeroCivico = in.readInt("Inserisci numero civico: ");
                   Integer cap = in.readInt("Inserisci CAP: ");
                   while(cap.toString().length() != 5) {
                       cap = in.readInt("VALORE NON CONSENTITO - Inserire 5 cifre: ");
                   }
                   String comune = in.readLine("Inserisci comune di residenza: ");
                   RicercaCanzone.controll(comune);
                   String provincia = in.readLine("Inserisci provincia di residenza: ");
                   while(provincia.length() != 2 || !Utente.controlloProvincia(provincia)) {
                       provincia = in.readLine("VALORE NON CONSENTITO - Inserire 2 lettere: ");
                   }
                   provincia = provincia.toUpperCase();
                   String indFisico = via + " " + numeroCivico + ", " + cap + ", " + comune + ", " + provincia;
                   //out.println(indFisico);
                   String indMail = in.readLine("Inserisci indirizzo mail: ");
                   while(indMail.length() < 6 || !Utente.controlloMail(indMail)) {
                       indMail = in.readLine("VALORE NON CONSENTITO - Inserisci un indirizzo mail valido: ");
                   }
                   //out.println(indMail);
                    out.println("DATI UTENTE: " + nomeCognome + " - " + codFiscale + " - " + indFisico + " - " + indMail);
                   String username = in.readLine("Inserisci Username: ");
                   RicercaCanzone.controll(username);
                   String password = in.readLine("Inserisci Password: ");
                   RicercaCanzone.controll(password);
                   Utente nuovoUtente = new Utente(nomeCognome, codFiscale, indFisico, indMail, username, password);
                   ArrayList<Utente> arrUtenti = new ArrayList<Utente>();
                   File fileUtenti = new File("src/DATA/UtentiRegistrati.txt");
                   if(fileUtenti.length() != 0) {
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
                       e.toString();
                   }
                    break;
                case 3:
                    out.println("CASE 3");
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