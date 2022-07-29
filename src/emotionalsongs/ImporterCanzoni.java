package emotionalsongs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImporterCanzoni {

    private static ArrayList<Canzone> importListaCanzoni() throws IOException {
        String tPath = "src/DATA/CanzoniProv.txt";
        File file = new File(tPath);
        FileReader frd = new FileReader(file);
        BufferedReader brd = new BufferedReader(frd);
        ArrayList<Canzone> listaCanzoni = new ArrayList<Canzone>();
        String str;

        while ((str = brd.readLine()) != null) {
            String[] songProv = str.split(" - ");
            Canzone song = new Canzone(songProv[0], songProv[1], songProv[songProv.length-1]);
            listaCanzoni.add(song);
        }
        brd.close();
        frd.close();
        return listaCanzoni;
    }

    public static void serializzaCanzone() throws IOException {
        ArrayList<Canzone> arr = importListaCanzoni();
        CanzoneManager.scriviCanzone(arr);
    }
}

