package ch.bzz.KaderVerwaltung.model;

/**
 * a spieler in the KaderVerwaltung
 */
public class Spieler {

    private String spielerUUID;
    private String name;
    private String nationalität;
    private int spielerNr;
    private int alter;
    private String position;
    private Spiel spiel;

    /**
     * gets spiel
     *
     * @return value of spiel
     */
    public Spiel getSpiel() {
        return spiel;
    }

    /**
     * sets spiel
     *
     * @param spiel the value to set
     */
    public void setSpiel(Spiel spiel) {
        this.spiel = spiel;
    }

    /**
     * gets spielerNr
     *
     * @return value of spielerNr
     */

    public int getSpielerNr() {
        return spielerNr;
    }

    /**
     * sets spielerNr
     *
     * @param spielerNr the value to set
     */

    public void setSpielerNr(int spielerNr) {
        this.spielerNr = Spieler.this.spielerNr;
    }

    /**
     * gets name
     *
     * @return value of name
     */

    public String getName() {
        return name;
    }

    /**
     * sets name
     *
     * @param name the value to set
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets nationalität
     *
     * @return value of nationalität
     */

    public String getNationalität() {
        return nationalität;
    }

    /**
     * sets nationalität
     *
     * @param nationalität the value to set
     */

    public void setNationalität(String nationalität) {
        this.nationalität = nationalität;
    }


    /**
     * gets alter
     *
     * @return value of alter
     */
    public int getAlter() {
        return alter;
    }

    /**
     * sets alter
     *
     * @param alter the value to set
     */

    public void setAlter(int alter) {
        this.alter = alter;
    }

    /**
     * gets position
     *
     * @return value of position
     */

    public String getPosition() {
        return position;
    }

    /**
     * sets position
     *
     * @param Position the value to set
     */

    public void setPosition(String Position) {
        this.position = position;
    }


    public String getSpielerUUID() {
        return spielerUUID;
    }

    public void setSpielerUUID(String spielerUUID) {
        this.spielerUUID = spielerUUID;
    }

    public void setSpielUUID(String spielUUID) {
    }
}