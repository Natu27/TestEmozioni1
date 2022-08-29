//Lorenzo Michele Naturale - Matricola n.749423 - Sede di Varese
//Riccardo Grazioli - Matricola n.748701 - Sede di Varese
//Jennifer Sculco - Matricola n.722306 - Sede di Varese
package emotionalsongs;

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * La classe {@code UtenteManager} permette di leggere/scrivere utenti dal/sul file UtentiRegistrati.dati
 */

public class UtenteManager {

    //final static String path = "src/DATA/UtentiRegistrati.txt";

    /**
     * Permette di scrivere uno o più utenti tramite un ArrayList sul file di destinazione UtentiRegistrati.dati
     * @param arrUtenti un oggetto di tipo {@code ArrayList<Utente>}
     * @throws IOException
     */
    public static void scriviUtente(ArrayList<Utente> arrUtenti) throws IOException {
        FileOutputStream fOS = new FileOutputStream(PathManager.getPath(PathType.user));
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        oOS.writeObject(arrUtenti);
        oOS.flush();
        oOS.close();
    }

    /**
     * Permette di leggere uno o più utenti tramite un ArrayList dal file di testo UtentiRegistrati.dati
     * @return un oggetto di tipo {@code ArrayList<Utente>}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Utente> leggiUtenti() throws IOException, ClassNotFoundException {
        Object ob = FileManager.leggiFile(PathManager.getPath(PathType.user));
        ArrayList<Utente> arrUtenti = new ArrayList<Utente>();
        if(ob instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) ob;
            arrUtenti = castArrayUtenti(tmp);
        }
        return arrUtenti;
    }

    /**
     * Restituisce un ArrayList di stringhe contenente i nomi utenti già utilizzati per rispettare il vincolo dell'univocità
     * @return un oggetto di tipo {@code ArrayList<String>}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<String> leggiUsername() throws IOException, ClassNotFoundException {
        Object ob = FileManager.leggiFile(PathManager.getPath(PathType.user));
        ArrayList<Utente> arrUtenti = new ArrayList<Utente>();
        if(ob instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) ob;
            arrUtenti = castArrayUtenti(tmp);
        }
        ArrayList<String> arrUsername = new ArrayList<String>();
        for(Utente utente : arrUtenti) {
            arrUsername.add(utente.getUserId());
        }
        return arrUsername;
    }

    /**
     * Permette di controllare, a partire dai parametri forniti come argomento del metodo,
     * se il nome utente inserito è già stato utilizzato
     * @param userInserito un oggetto di tipo {@code String}
     * @param usernameUtilizzati un oggetto di tipo {@code ArrayList<String>}
     * @return un oggetto di tipo {@code boolean}
     */
    public static boolean usernameUtilizzato(String userInserito, ArrayList<String> usernameUtilizzati) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        boolean userUtilizzato = false;
        File file = new File(PathManager.getPath(PathType.user));
        if(file.length() != 0) {
            for (String username : usernameUtilizzati) {
                if (username.equals(userInserito)) {
                    userUtilizzato = true;
                    out.print("!Username già utilizzato!");
                    break;
                }
            }
        }
        return userUtilizzato;
    }

    /**
     * Permette di effettuare il login verificando che username e password siano corretti
     * @return un oggetto di tipo {@code Utente}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Utente login() throws IOException, ClassNotFoundException {
        Utente utente = null;
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        //out.println("EFFETTUA LOGIN: ");
        File fileUtenti = new File(PathManager.getPath(PathType.user));
        if (fileUtenti.length() != 0) {
            out.println("EFFETTUA LOGIN: ");
            ArrayList<String> arrUsername = UtenteManager.leggiUsername();
            String username = in.readLine("Inserisci Username: ");
            if(UtenteManager.userCorretto(username,arrUsername)) {
                String password = in.readLine("Inserisci Password: ");
                if(password.equals(UtenteManager.getPass(username))) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        utente = UtenteManager.getUtente(username);
                        out.println("Login effettuato con successo");
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                    }
                } else {
                    out.println("!Password Errata!");
                }
            } else {
                out.println("!Username Errato!");
            }
        } else {
            out.println("!Non è presente alcun utente!");
        }
        return utente;
    }

    /**
     * Restituisce la password relativa all'username fornito come argomento
     * @param userInserito un oggetto di tipo {@code String}
     * @return un oggetto di tipo {@code String}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static String getPass(String userInserito) throws IOException, ClassNotFoundException{
        File file = new File(PathManager.getPath(PathType.user));
        String password = "";
        if(file.length() != 0) {
            ArrayList<Utente> arrUtenti = UtenteManager.leggiUtenti();
            for(Utente utente: arrUtenti) {
                if(utente.getUserId().equals(userInserito)) {
                    password = utente.getPassword();
                }
            }
        }
        return password;
    }

    /**
     * Restituisce l'oggetto Utente relativo all'username fornito come argomento
     * @param userInserito un oggetto di tipo {@code String}
     * @return un oggetto di tipo {@code Utente}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Utente getUtente(String userInserito) throws IOException, ClassNotFoundException {
        File file = new File(PathManager.getPath(PathType.user));
        Utente utenteFinal = null;
        if(file.length() != 0) {
            ArrayList<Utente> arrUtenti = UtenteManager.leggiUtenti();
            for (Utente utente : arrUtenti) {
                if (utente.getUserId().equals(userInserito)) {
                    utenteFinal = utente;
                }
            }
        }
        return utenteFinal;
    }

    /**
     * Permette di verificare, a partire dai parametri forniti come argomento, se l'username inserito è già stato utilizzato da altri utenti
     * @param userInserito un oggetto di tipo {@code String}
     * @param usernameUtilizzati un oggetto di tipo {@code ArrayList<String>}
     * @return un oggetto di tipo {@code boolean} (true: username non utilizzato / false: altrimenti)
     */
    public static boolean userCorretto(String userInserito, ArrayList<String> usernameUtilizzati) {
        boolean userCorretto = false;
        File file = new File(PathManager.getPath(PathType.user));
        if(file.length() != 0) {
            for (String username : usernameUtilizzati) {
                if (username.equals(userInserito)) {
                    userCorretto = true;
                    break;
                }
            }
        }
        return userCorretto;
    }

    /**
     * Impone all'utente, tramite un'opportuna funzione di controllo del parametro fornito come argomento,
     * di inserire un nome utente diverso dalla stringa vuota e/o composta da soli spazi e che non sia già stato utilizzato
     * @param s un oggetto di tipo {@code String}
     * @return un oggetto di tipo {@code String}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static String controllUsername(String s) throws IOException, ClassNotFoundException {
        ConsoleInputManager in = new ConsoleInputManager();
        File file = new File(PathManager.getPath(PathType.user));
        ArrayList<String> userUtilizzati = new ArrayList<String>();
        if(file.length() != 0) {
            userUtilizzati = UtenteManager.leggiUsername();
        }
        s = s.trim();
        while(usernameUtilizzato(s, userUtilizzati) || s.equals("") || RicercaCanzone.everyCharWhitespace(s))
            s = in.readLine("INPUT NON CONSENTITO - Reinserire: ");
        return s;
    }

    /**
     * Permette di effettuare un cast da un'array generico un ArrayList di utenti
     * se e solo se gli oggetti contenuti nell'array fornito come argomento sono istanze di Utente
     * @param arrProv un oggetto di tipo {@code ArrayList<?>}
     * @return un oggetto di tipo {@code ArrayList<Utente>}
     */
    public static ArrayList<Utente> castArrayUtenti(ArrayList<?> arrProv) {
        ArrayList<Utente> arrUtenti = new ArrayList<Utente>();
        for(Object ob : arrProv) {
            if(ob instanceof Utente) {
                arrUtenti.add((Utente) ob);
            }
        }
        return arrUtenti;
    }

    /**
     * Permette di effettuare la registrazione di un nuovo utente mediante opportuni controlli
     * @return un oggetto di tipo {@code Utente}
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Utente Registrazione() throws IOException, ClassNotFoundException {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        String nome = in.readLine("Inserisci nome: ");
        nome = RicercaCanzone.controll(nome);
        nome = Utente.primaLetteraMaiuscola(nome);
        String cognome = in.readLine("Inserisci cognome: ");
        cognome = RicercaCanzone.controll(cognome);
        cognome = Utente.primaLetteraMaiuscola(cognome);
        String nomeCognome = nome + " " + cognome;
        String codFiscale = in.readLine("Inserisci codice fiscale: ");
        codFiscale = codFiscale.trim();
        while(codFiscale.length() != 16) {
            codFiscale = in.readLine("VALORE NON CONSENTITO - Inserire 16 caratteri alfanumerici: ");
            codFiscale = codFiscale.trim();
        }
        codFiscale = codFiscale.toUpperCase();
        String via = in.readLine("Inserisci via/piazza: ");
        via = RicercaCanzone.controll(via);
        via = Utente.primaLetteraMaiuscola(via);
        int numeroCivico = in.readInt("Inserisci numero civico: ");
        Integer cap = in.readInt("Inserisci CAP: ");
        while(cap.toString().length() != 5) {
            cap = in.readInt("VALORE NON CONSENTITO - Inserire 5 cifre: ");
        }
        String comune = in.readLine("Inserisci comune di residenza: ");
        comune = RicercaCanzone.controll(comune);
        comune = Utente.primaLetteraMaiuscola(comune);
        String provincia = in.readLine("Inserisci provincia di residenza: ");
        while(provincia.length() != 2 || !Utente.controlloProvincia(provincia)) {
            provincia = in.readLine("VALORE NON CONSENTITO - Inserire 2 lettere: ");
        }
        provincia = provincia.toUpperCase();
        String indFisico = via + " " + numeroCivico + ", " + cap + ", " + comune + ", " + provincia;
        String indMail = in.readLine("Inserisci indirizzo mail: ");
        while(indMail.length() < 6 || !Utente.controlloMail(indMail)) {
            indMail = in.readLine("VALORE NON CONSENTITO - Inserisci un indirizzo mail valido: ");
        }
        out.println("DATI UTENTE: " + nomeCognome + " - " + codFiscale + " - " + indFisico + " - " + indMail);
        String username = in.readLine("Inserisci Username: ");
        username = controllUsername(username);
        String password = in.readLine("Inserisci Password: ");
        password = RicercaCanzone.controll(password);
        Utente nuovoUtente = new Utente(nomeCognome, codFiscale, indFisico, indMail, username, password);
        return nuovoUtente;
    }
}
