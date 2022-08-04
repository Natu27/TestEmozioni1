package emotionalsongs;

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UtenteManager {

    final static String path = "src/DATA/UtentiRegistrati.txt";

    public static void scriviUtente(ArrayList<Utente> arrUtenti) throws IOException {
        FileOutputStream fOS = new FileOutputStream(path);
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        oOS.writeObject(arrUtenti);
        oOS.flush();
        oOS.close();
    }

    public static ArrayList<Utente> leggiUtenti() throws IOException, ClassNotFoundException {
        Object ob = FileManager.leggiFile(path);
        ArrayList<Utente> arrUtenti = new ArrayList<Utente>();
        if(ob instanceof ArrayList<?>) {
            ArrayList<?> tmp = (ArrayList<?>) ob;
            arrUtenti = castArrayUtenti(tmp);
        }
        return arrUtenti;
    }

    public static ArrayList<String> leggiUsername() throws IOException, ClassNotFoundException {
        Object ob = FileManager.leggiFile(path);
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

    public static boolean usernameUtilizzato(String userInserito, ArrayList<String> usernameUtilizzati) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        boolean userUtilizzato = false;
        File file = new File("src/DATA/UtentiRegistrati.txt");
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

    public static String controllUsername(String s) throws IOException, ClassNotFoundException {
        ConsoleInputManager in = new ConsoleInputManager();
        File file = new File("src/DATA/UtentiRegistrati.txt");
        ArrayList<String> userUtilizzati = new ArrayList<String>();
        if(file.length() != 0) {
            userUtilizzati = UtenteManager.leggiUsername();
        }
        s = s.trim();
        while(usernameUtilizzato(s, userUtilizzati) || s.equals("") || RicercaCanzone.everyCharWhitespace(s))
            s = in.readLine("INPUT NON CONSENTITO - Reinserire: ");
        return s;
    }

    public static ArrayList<Utente> castArrayUtenti(ArrayList<?> arrProv) {
        ArrayList<Utente> arrUtenti = new ArrayList<Utente>();
        for(Object ob : arrProv) {
            if(ob instanceof Utente) {
                arrUtenti.add((Utente) ob);
            }
        }
        return arrUtenti;
    }

    public static Utente registraUtente() throws IOException, ClassNotFoundException {
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
        //out.println(codFiscale);
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
        //out.println(indFisico);
        String indMail = in.readLine("Inserisci indirizzo mail: ");
        while(indMail.length() < 6 || !Utente.controlloMail(indMail)) {
            indMail = in.readLine("VALORE NON CONSENTITO - Inserisci un indirizzo mail valido: ");
        }
        //out.println(indMail);
        out.println("DATI UTENTE: " + nomeCognome + " - " + codFiscale + " - " + indFisico + " - " + indMail);
        String username = in.readLine("Inserisci Username: ");
        username = controllUsername(username);
        String password = in.readLine("Inserisci Password: ");
        password = RicercaCanzone.controll(password);
        Utente nuovoUtente = new Utente(nomeCognome, codFiscale, indFisico, indMail, username, password);
        return nuovoUtente;
    }
}
