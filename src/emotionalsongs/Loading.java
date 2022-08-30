//Lorenzo Michele Naturale - Matricola n.749423 - Sede di Varese
//Riccardo Grazioli - Matricola n.748701 - Sede di Varese
//Jennifer Sculco - Matricola n.722306 - Sede di Varese
package emotionalsongs;

/**
 * La classe {@code Loading} permette di visualizzare su schermo un caricamento con percentuale annessa
 */
public class Loading {

    final static int  length = 30;
    final static int speed = 40;

    /**
     * Permette di visualizzare su schermo un caricamento caratterizzato da una certa velocità (speed) e lunghezza (length)
     */
    public static void loading() {
        int i = 0;
        while(i <length) {
            System.out.print("[");
            for (int j = 0; j < i; j++) {
                System.out.print("=");
            }
            for (int j = 0; j < (length - 1) - i; j++) {
                System.out.print(" ");
            }
            try {
                System.out.print("] " + getPercentuale(i) + "%");
                if (i < (length - 1)) {
                    System.out.print("\r");
                    Thread.sleep(speed);
                }
                i++;
            } catch (InterruptedException e) {}
        }
        System.out.println();
    }

    /**
     * Permette di visualizzare su schermo la percentuale associata al caricamnto
     * @param i un oggetto di tipo {@code int}
     * @return un oggetto di tipo {@code int}
     */
    private static int getPercentuale(int i) {
        if(i==0){
            return 0;
        }
        else if(i == (length-1)){
            return 100;
        }
        else{
            return (i*100)/length;
        }
    }

}

