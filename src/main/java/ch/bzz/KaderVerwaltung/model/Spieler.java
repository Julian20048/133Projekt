package ch.bzz.KaderVerwaltung.model;

/**
 * Spieler, der das Spiel spielt
 */
public class Spieler {
    private String name;
    private String nationalität;
    private int spielerNr;
    private int alter;
    private String position;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalität() {
        return nationalität;
    }

    public void setNationalität(String nationalität) {
        this.nationalität = nationalität;
    }

    public int getSpielerNr() {
        return spielerNr;
    }

    public void setSpielerNr(int spielerNr) {
        this.spielerNr = spielerNr;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
