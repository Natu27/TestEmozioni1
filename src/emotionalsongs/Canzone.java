//Lorenzo Michele Naturale - Matricola n.749423 - Sede di Varese
//Riccardo Grazioli - Matricola n.748701 - Sede di Varese
//Jennifer Sculco - Matricola n.722306 - Sede di Varese
package emotionalsongs;

import java.io.Serializable;

/**
 * La classe {@code Canzone} permette di gestire un brano musicale composto da titolo, autore e anno
 */
public class Canzone implements Serializable {

    private final String titolo;
    private final String autore;
    private final String anno;

    /**
     * Costruisce un oggetto {@code Canzone} a partire dai parametri forniti
     * @param titolo un oggetto di tipo {@code String} dove è contenuto il titolo del brano
     * @param autore un oggetto di tipo {@code String} che rappresenta il nome dell'autore
     * @param anno un oggetto di tipo {@code String} che rappresenta l'anno del brano
     */
    public Canzone(String titolo, String autore, String anno) {
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
    }

    /**
     * Restituisce una stringa contenente il nome dell'autore
     * @return un oggetto di tipo {@code String} contenente il nome dell'autore
     */
    public String getAutore() {
        return autore;
    }

    /**
     * Restituisce una stringa contenente l'anno del brano
     * @return un oggetto di tipo {@code String} contenente l'anno del brano
     */
    public String getAnno() {
        return anno;
    }

    /**
     * Restituisce una stringa contenente il nome del brano
     * @return un oggetto di tipo {@code String} contenente il nome del brano
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Restituisce una stringa contenente titolo, autore e anno del brano
     * @return un oggetto di tipo {@code String} contenente titolo, autore e anno del brano
     */
    public String stampaCanzone() {
        return  this.titolo + " - " + this.autore + " - " + this.anno;
    }

}

