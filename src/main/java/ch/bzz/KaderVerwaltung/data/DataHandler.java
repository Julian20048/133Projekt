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
    private static List<Spieler> spielerList;
    private static List <Spiel> spielList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {

    }
    
    /**
     * reads all spielers
     * @return list of spielers
     */
    public static List<Spieler> readAllSpielers() {
        return getSpielerList();
    }

    /**
     * reads a spieler by its uuid
     * @param spielerNr
     * @return the Spieler (null=not found)
     */
    public static Spieler readbyspielerNr(int spielerNr) {
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
    public static List<Spiel> readAllSpiels() {

        return getSpielList();
    }

    /**
     * reads a spiel by its uuid
     * @param spielId
     * @return the Spiel (null=not found)
     */
    public static Spiel readbyspielId(int spielId) {
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
    private static void readSpielerJSON() {
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
    private static void readSpielJSON() {
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
    private static List<Spieler> getSpielerList() {
        if (spielerList == null) {
            setSpielerList(new ArrayList<>());
            readSpielerJSON();
        }

        return spielerList;
    }

    /**
     * sets spielerList
     *
     * @param spielerList the value to set
     */
    private static void setSpielerList(List<Spieler> spielerList) {
        DataHandler.spielerList = spielerList;
    }

    /**
     * gets spielList
     *
     * @return value of spielList
     */
    private static List<Spiel> getSpielList() {
        if (spielList == null) {
            setSpielList(new ArrayList<>());
            readSpielJSON();
        }
        return spielList;
    }

    /**
     * sets spielList
     *
     * @param spielList the value to set
     */
    private static void setSpielList(List<Spiel> spielList) {
        DataHandler.spielList = spielList;
    }


}