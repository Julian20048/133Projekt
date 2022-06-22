package ch.bzz.KaderVerwaltung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.ws.rs.FormParam;
import java.util.List;

/**
 * Alles was der Spieler während dem Spiel tut
 */
public class Spiel {
    @FormParam("spielUUID")
    @NotEmpty
    @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
    private String spielUUID;

    @FormParam("spielzeit")
    @NotEmpty
    private int spielzeit;

    @FormParam("erzTore")
    @NotEmpty
    private int erzTore;

    @FormParam("erzAssists")
    @NotEmpty
    private int erzAssists;

    @FormParam("gelbeKarten")
    @NotEmpty
    private int gelbeKarten;

    @FormParam("roteKarten")
    @NotEmpty
    private int roteKarten;

    @FormParam("erfolgPässe")
    @NotEmpty
    private int erfolgPässe;

    private List<Spieler> spieler;

    /**
     * default constructor
     */
    public Spiel(){

    }
        /**
         * gets SpielUUID
         *
         * @return value of SpielUUID
         */
        public String getSpielUUID(){
            return spielUUID;
        }

    /**
     * sets SpielUUID
     *
     * @param spielUUID the value to set
     */
    public void setSpielUUID(String spielUUID) {
        this.spielUUID = spielUUID;
    }

    /**
     * gets Spielzeit
     *
     * @return value of Spielzeit
     */
    public int getSpielzeit() {
        return spielzeit;
    }
    /**
     * sets spielzeit
     *
     * @param spielzeit the value to set
     */
    public void setSpielzeit(int spielzeit) {
        this.spielzeit = spielzeit;
    }

    /**
     * gets erzTore
     *
     * @return value of erzTore
     */
    public int getErzTore() {
        return erzTore;
    }

    /**
     * sets erzTore
     *
     * @param erzTore the value to set
     */
    public void setErzTore(int erzTore) {
        this.erzTore = erzTore;
    }

    /**
     * gets erzAssists
     *
     * @return value of erzAssists
     */
    public int getErzAssists() {
        return erzAssists;
    }

    /**
     * sets erzAssists
     *
     * @param erzAssists the value to set
     */
    public void setErzAssists(int erzAssists) {
        this.erzAssists = erzAssists;
    }

    /**
     * gets gelbeKarten
     *
     * @return value of gelbeKarten
     */
    public int getGelbeKarten() {
        return gelbeKarten;
    }

    /**
     * sets gelbeKarten
     *
     * @param gelbeKarten the value to set
     */
    public void setGelbeKarten(int gelbeKarten) {
        this.gelbeKarten = gelbeKarten;
    }

    /**
     * gets roteKarten
     *
     * @return value of roteKarten
     */
    public int getRoteKarten() {
        return roteKarten;
    }

    /**
     * sets roteKarten
     *
     * @param roteKarten the value to set
     */
    public void setRoteKarten(int roteKarten) {
        this.roteKarten = roteKarten;
    }

    /**
     * gets erfolgPässe
     *
     * @return value of erfolgPässe
     */
    public int getErfolgPässe() {
        return erfolgPässe;
    }

    /**
     * sets erfolgpässe
     *
     * @param erfolgPässe the value to set
     */
    public void setErfolgPässe(int erfolgPässe) {
        this.erfolgPässe = erfolgPässe;
    }

    /**
     * gets spieler
     *
     * @return value of spieler
     */
    public List<Spieler> getSpieler() {
        return spieler;
    }

    /**
     * sets spieler
     *
     * @param spieler the value to set
     */
    public void setSpieler(List<Spieler> spieler) {
        this.spieler = spieler;
    }
}

