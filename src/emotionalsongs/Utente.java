package emotionalsongs;

import java.io.Serializable;

public class Utente implements Serializable {

    private final String nomeCognome;
    private final String codFiscale;
    private final String indFisico;
    private final String indMail;
    private final String userId;
    private final String password;


    public Utente(String nomeCognome, String codFiscale, String indFisico, String indMail, String userId,
                  String password) {
        this.nomeCognome = nomeCognome;
        this.codFiscale = codFiscale;
        this.indFisico = indFisico;
        this.indMail = indMail;
        this.userId = userId;
        this.password = password;
    }

    public String getNomeCognome() {return nomeCognome;}
    public String getCodFiscale() {return codFiscale;}
    public String getIndFisico() {return indFisico;}
    public String getIndMail() {return indMail;}
    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public static boolean controlloProvincia(String provincia) {
        boolean tutteLettere = true;
        for(Character c: provincia.toCharArray()) {
            if(Character.isDigit(c)) {
                tutteLettere = false;
            }
        }
        return tutteLettere;
    }

    public static boolean controlloMail(String mail) {
        boolean mailCorretta = false;
        for(Character c : mail.toCharArray()) {
            if(c.equals('@')) {
                mailCorretta = true;
            }
        }
        return mailCorretta;
    }

    public static String primaLetteraMaiuscola(String str) {
        str = str.replace(str.charAt(0), Character.toUpperCase(str.charAt(0)));
        return str;
    }
}
