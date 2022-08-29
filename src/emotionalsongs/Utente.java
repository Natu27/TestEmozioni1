//Lorenzo Michele Naturale - Matricola n.749423 - Sede di Varese
//Riccardo Grazioli - Matricola n.748701 - Sede di Varese
//Jennifer Sculco - Matricola n.722306 - Sede di Varese
package emotionalsongs;

import java.io.Serializable;

/**
 * La classe {@code Utente} permette di gestire un oggetto di tipo Utente
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 * @author <a href="https://github.com">name</a>
 */
public class Utente implements Serializable {

    private final String nomeCognome;
    private final String codFiscale;
    private final String indFisico;
    private final String indMail;
    private final String userId;
    private final String password;

    /**
     * Costruisce, a partire dai parametri forniti come argomento, un oggetto di tipo Utente
     * @param nomeCognome un oggetto di tipo {@code String}
     * @param codFiscale un oggetto di tipo {@code String}
     * @param indFisico un oggetto di tipo {@code String}
     * @param indMail un oggetto di tipo {@code String}
     * @param userId un oggetto di tipo {@code String}
     * @param password un oggetto di tipo {@code String}
     */
    public Utente(String nomeCognome, String codFiscale, String indFisico, String indMail, String userId,
                  String password) {
        this.nomeCognome = nomeCognome;
        this.codFiscale = codFiscale;
        this.indFisico = indFisico;
        this.indMail = indMail;
        this.userId = userId;
        this.password = password;
    }

    /**
     * Restituisce il nome ed il cognome dell'istanza che esegue il metodo
     * @return un oggetto di tipo {@code String}
     */
    public String getNomeCognome() { return nomeCognome; }

    /**
     * Restituisce il codice fiscale dell'istanza che esegue il metodo
     * @return un oggetto di tipo {@code String}
     */
    public String getCodFiscale() { return codFiscale; }

    /**
     * Restituisce l'indirizzo fisico dell'istanza che esegue il metodo
     * @return un oggetto di tipo {@code String}
     */
    public String getIndFisico() { return indFisico; }

    /**
     * Restituisce l'indirizzo mail dell'istanza che esegue il metodo
     * @return un oggetto di tipo {@code String}
     */
    public String getIndMail() { return indMail; }

    /**
     * Restituisce l'username dell'istanza che esegue il metodo
     * @return un oggetto di tipo {@code String}
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Restituisce la password dell'istanza che esegue il metodo
     * @return un oggetto di tipo {@code String}
     */
    public String getPassword() {
        return password;
    }

    /**
     * Permette di controllare che la provincia passata come parametro del metodo sia corretta
     * @return un oggetto di tipo {@code boolean} (true: stringa di sole lettere / false: altrimenti)
     */

    public static boolean controlloProvincia(String provincia) {
        boolean tutteLettere = true;
        for(Character c: provincia.toCharArray()) {
            if(Character.isDigit(c)) {
                tutteLettere = false;
            }
        }
        return tutteLettere;
    }

    /**
     * Permette di controllare che l'indirizzo mail passato come parametro del metodo sia corretto
     * @return un oggetto di tipo {@code boolean} (true: stringa contenente @ / false: altrimenti)
     */
    public static boolean controlloMail(String mail) {
        boolean mailCorretta = false;
        for(Character c : mail.toCharArray()) {
            if(c.equals('@')) {
                mailCorretta = true;
            }
        }
        return mailCorretta;
    }

    /**
     * Permette di ottenere una stringa con la prima lettera maiuscola
     * @param str un oggetto di tipo {@code String}
     * @return un oggetto di tipo {@code String}
     */
    public static String primaLetteraMaiuscola(String str) {
        str = str.replaceFirst(Character.toString(str.charAt(0)) , Character.toString(Character.toUpperCase(str.charAt(0))));
        return str;
    }
}
