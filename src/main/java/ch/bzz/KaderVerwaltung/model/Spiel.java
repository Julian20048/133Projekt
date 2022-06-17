package ch.bzz.KaderVerwaltung.model;

import java.util.List;

/**
 * Alles was der Spieler während dem Spiel tut
 */
public class Spiel {
    private String spielUUID;
    private int spielzeit;
    private int erzTore;
    private int erzAssists;
    private int gelbeKarten;
    private int roteKarten;
    private int erfolgPässe;
    private List<Spieler> spieler;

    public String getSpielUUID() {
        return spielUUID; }

    public void setSpielUUID(String spielUUID) {
        this.spielUUID = spielUUID; }

    public int getSpielzeit() {
        return spielzeit;
    }

    public void setSpielzeit(int spielzeit) {
        this.spielzeit = spielzeit;
    }

    public int getErzTore() {
        return erzTore;
    }

    public void setErzTore(int erzTore) {
        this.erzTore = erzTore;
    }

    public int getErzAssists() {
        return erzAssists;
    }

    public void setErzAssists(int erzAssists) {
        this.erzAssists = erzAssists;
    }

    public int getGelbeKarten() {
        return gelbeKarten;
    }

    public void setGelbeKarten(int gelbeKarten) {
        this.gelbeKarten = gelbeKarten;
    }

    public int getRoteKarten() {
        return roteKarten;
    }

    public void setRoteKarten(int roteKarten) {
        this.roteKarten = roteKarten;
    }

    public int getErfolgPässe() {
        return erfolgPässe;
    }

    public void setErfolgPässe(int erfolgPässe) {
        this.erfolgPässe = erfolgPässe;
    }

    public List<Spieler> getSpieler() {
        return spieler;
    }

    public void setSpieler(List<Spieler> spieler) {
        this.spieler = spieler;
    }
}

