package ch.bzz.KaderVerwaltung.data;

import ch.bzz.KaderVerwaltung.model.Spieler;
import ch.bzz.KaderVerwaltung.model.Spiel;
import ch.bzz.KaderVerwaltung.model.Spieler;
import ch.bzz.KaderVerwaltung.service.Config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * reads and writes the data in the JSON-files
 */
public class DataHandler {
    private static DataHandler instance = null;
    private List<Spieler> spielerList;
    private List <Spiel> spielList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
        setSpielList(new ArrayList<>());
        readSpielJSON();
        setSpielerList(new ArrayList<>());
        readSpielerJSON();
    }

    /**
     * gets the only instance of this class
     * @return
     */
    public static DataHandler getInstance() {
        if (instance == null)
            instance = new DataHandler();
        return instance;
    }


    /**
     * reads all spielers
     * @return list of spielers
     */
    public List<Spieler> readAllSpielers() {
        return getSpielerList();
    }

    /**
     * reads a spieler by its uuid
     * @param spielerNr
     * @return the Spieler (null=not found)
     */
    public Spieler readbyspielerNr(int spielerNr) {
        Spieler spieler = null;
        for (Spieler entry : getSpielerList()) {
            if (entry.getSpielerNr() == spielerNr) {
                spieler = entry;
            }
        }
        return spieler;
    }

    /**
     * reads all Spiels
     * @return list of spiels
     */
    public List<Spiel> readAllSpiels() {

        return getSpielList();
    }

    /**
     * reads a spiel by its uuid
     * @param spielId
     * @return the Spiel (null=not found)
     */
    public Spiel readbyspielId(int spielId) {
        Spiel spiel = null;
        for (Spiel entry : getSpielList()) {
            if (entry.getSpielId() == spielId) {
                spiel = entry;
            }
        }
        return spiel;
    }

    /**
     * reads the spielers from the JSON-file
     */
    private void readSpielerJSON() {
        try {
            String path = Config.getProperty("spielerJSON");
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(path)
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Spieler[] spielers = objectMapper.readValue(jsonData, Spieler[].class);
            for (Spieler spieler : spielers) {
                getSpielerList().add(spieler);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * reads the spiels from the JSON-file
     */
    private void readSpielJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("spielJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Spiel[] spiels = objectMapper.readValue(jsonData, Spiel[].class);
            for (Spiel spiel : spiels) {
                getSpielList().add(spiel);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * gets spielerList
     *
     * @return value of spielerList
     */
    private List<Spieler> getSpielerList() {
        return spielerList;
    }

    /**
     * sets spielerList
     *
     * @param spielerList the value to set
     */
    private void setSpielerList(List<Spieler> spielerList) {
        this.spielerList = spielerList;
    }

    /**
     * gets spielList
     *
     * @return value of spielList
     */
    private List<Spiel> getSpielList() {
        return spielList;
    }

    /**
     * sets spielList
     *
     * @param spielList the value to set
     */
    private void setSpielList(List<Spiel> spielList) {
        this.spielList = spielList;
    }


}