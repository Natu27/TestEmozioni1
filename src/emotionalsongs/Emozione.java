package emotionalsongs;

import java.io.Serializable;

public enum Emozione implements Serializable {

    AMAZEMENT("Amazement", 0),
    SOLEMNITY("Solemnity",0),
    TENDERNESS("Tenderness",0),
    NOSTALGIA("Nostalgia",0),
    CALMNESS("Calmness",0),
    POWER("Power",0),
    JOY("Joy",0),
    TENSION("Tension",0),
    SADNESS("Sadness",0);
    private final String emozione;
    public int score;

    Emozione(String emozione,int score) {
        this.emozione = emozione;
        this.score = score;
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

    public String stampaEmozione() {
        return this.getEmozione() + " - " + this.getScore();
    }

}

