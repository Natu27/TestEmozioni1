package emotionalsongs;

import java.io.Serializable;

public enum Emozione implements Serializable {

    AMAZEMENT("Amazement", 0, ""),
    SOLEMNITY("Solemnity",0, ""),
    TENDERNESS("Tenderness",0, ""),
    NOSTALGIA("Nostalgia",0, ""),
    CALMNESS("Calmness",0, ""),
    POWER("Power",0, ""),
    JOY("Joy",0, ""),
    TENSION("Tension",0, ""),
    SADNESS("Sadness",0, "");
    private final String emozione;
    public int score;

    public String commento;

    Emozione(String emozione,int score, String commento) {
        this.emozione = emozione;
        this.score = score;
        this.commento = commento;
    }

    Emozione(String emozione) {
        this.emozione = emozione;
    }

    public String getEmozione() {
        return this.emozione;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String stampaEmozione() {
        return this.getEmozione() + " - " + this.getScore();
    }

}

