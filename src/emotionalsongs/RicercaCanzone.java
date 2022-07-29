package emotionalsongs;

import java.time.Year;
import java.util.ArrayList;
import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

/**
 * La classe {@code RicercaCanzoni} effettua una ricerca in base ai parametri forniti in una lista di canzoni
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 */
public class RicercaCanzone {

    /***
     * Controlla che la stringa inserita sia diversa dalla stringa vuota/stringa composta da soli spazi
     * @param s un oggetto di tipo {@code String}
     */

    public static String controll(String s) {
        ConsoleInputManager in = new ConsoleInputManager();
        s = s.trim();
        while(s.equals("") || everyCharWhitespace(s))
            s = in.readLine("VALORE NON CONSENTITO - Reinserire: ");
        return s;
    }

    /***
     * Rimuove tutti gli spazi contigui presenti nella stringa inserita
     * @param s un oggetto di tipo {@code String}
     */
    public static String normalize(String s) {
        s = s.replaceAll("\s+","\s");
        return s;
    }
    /***
     * Rimuove i caratteri speciali dalla stringa e rende la stringa minuscola
     * @param s un oggetto di tipo {@code String}
     */
    public static String remove(String s) {
        s = s.replaceAll(" ","");
        s = s.replaceAll("-","");
        s = s.replaceAll(",","");
        s = s.replaceAll("'","");
        s = s.replaceAll("/","");
        s = s.toLowerCase();
        return s;
    }

    /***
     * Controlla se la stringa inserita è composta da soli spazi
     * @param s un oggetto di tipo {@code String}
     */
    //??????????????????????????Tipo ritorno boolean????????????????????????????????
    public static boolean everyCharWhitespace(String s) {
        boolean whiteSpace = false;
        for(int i = 0; i < s.length(); i++) {
            if(Character.isWhitespace(s.charAt(i))) {
                whiteSpace = true;
            } else {
                whiteSpace = false;
                break;
            }
        }
        return whiteSpace;
    }

    /***
     * Ricerca tramite titolo in una lista di canzoni
     * @param listaCanzoni un oggetto di tipo {@code ArrayList<Canzone>}
     */
    //??????????????????????????????Problema tipo ritorno????????????????????????????????????
    public static ArrayList<Canzone> cercaTitolo(ArrayList<Canzone> listaCanzoni) {
        int selezione = 1;
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        String s = in.readLine("Inserisci Titolo --> ");
        s = controll(s);
        s = normalize(s);
        ArrayList<Canzone> listaRicercaTitolo = new ArrayList<Canzone>();

        for (Canzone song : listaCanzoni) {
            if (iniziaPer(song.getTitolo(), s) || verificaAppartenenza(remove(song.getTitolo()), remove(s))) {
                listaRicercaTitolo.add(song);
            }
        }
        out.println("RISULTATI RICERCA: ");
        if(listaRicercaTitolo.isEmpty()) {
            out.println("La ricerca non ha prodotto risultati");
        }
        for (Canzone song : listaRicercaTitolo) {
            out.println(selezione++ + "--> " + song.stampaCanzone());
        }
        return listaRicercaTitolo;
    }

    /***
     * Ricerca tramite autore e anno in una lista di canzoni
     * @param listaCanzoni un oggetto di tipo {@code ArrayList<Canzone>}
     */
    //??????????????????????????????Problema tipo ritorno????????????????????????????????????
    public static ArrayList<Canzone> cercaAutore(ArrayList<Canzone> listaCanzoni) {
        int selezione = 1;
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();
        ArrayList<Canzone> listaRicercaAutore = new ArrayList<Canzone>();
        String s = in.readLine("Inserisci Autore --> ");
        s = controll(s);
        s = normalize(s);
        Integer anno = in.readInt("Inserisci Anno --> ");
        String annoOff = anno.toString();
        while (anno > Year.now().getValue() || (!annoOff.startsWith("18") && !annoOff.startsWith("19") && !annoOff.startsWith("20"))) {
            anno = in.readInt("Inserire valore ammissibile compreso tra il 1800 e l'anno corrente --> ");
            annoOff = anno.toString();
        }
        for (Canzone song : listaCanzoni) {
            if ((iniziaPer(song.getAutore(), s) || verificaAppartenenza(remove(song.getAutore()), remove(s))) &&
                    song.getAnno().startsWith(annoOff)) {
                listaRicercaAutore.add(song);
            }
        }
        out.println("RISULTATI RICERCA: ");
        if(listaRicercaAutore.isEmpty()) {
            out.println("La ricerca non ha prodotto risultati");
        }
        for (Canzone song : listaRicercaAutore) {
            out.println(selezione++ + "--> " + song.stampaCanzone());
        }
        return listaRicercaAutore;
    }

    /***
     * Verifica se la seconda stringa è contenuta nella prima, a patto che la seconda abbia una lunghezza maggiore di 2
     * @param str un oggetto di tipo {@code String}
     * @param s un oggetto di tipo {@code String}
     */
    //??????????????????????????Tipo ritorno boolean????????????????????????????????
    public static boolean verificaAppartenenza(String str, String s) {
        boolean verificaApp = false;
        if(s.length()>2) {
            if(str.contains(s))
                verificaApp = true;
        }
        return verificaApp;
    }

    /***
     * Dopo aver suddiviso entrambe le stringhe in due array, verifica l'appartenenza stringa per stringa del secondo nel primo
     * @param titolo un oggetto di tipo {@code String}
     * @param s un oggetto di tipo {@code String}
     */
    //??????????????????????????Tipo ritorno boolean????????????????????????????????
    public static boolean iniziaPer(String titolo, String s) {
        boolean trovato = true;
        boolean iniziaPer;
        String[] title = titolo.split(" ");
        String[] titleUser = s.split(" ");
        for (int i = 0; i < titleUser.length; i++) {
            if (trovato) {
                iniziaPer = false;
                for (int j = 0; j < title.length; j++) {
                    if (title[j].toLowerCase().startsWith(s.toLowerCase())) {
                        iniziaPer = true;
                        break;
                    }
                }
                trovato = iniziaPer;
            }
        }
        return trovato;
    }
}
