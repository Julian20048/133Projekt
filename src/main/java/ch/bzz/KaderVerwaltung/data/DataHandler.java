package ch.bzz.KaderVerwaltung.data;

import ch.bzz.KaderVerwaltung.model.Spiel;
import ch.bzz.KaderVerwaltung.model.Spieler;
import ch.bzz.KaderVerwaltung.service.Config;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * reads and writes the data in the JSON-files
 */
public final class DataHandler {
    private static List<Spieler> spielerList;
    private static List<Spiel> spielList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
    }

    /**
     * initialize the lists with the data
     */
    public static void initLists() {
        DataHandler.setSpielerList(null);
        DataHandler.setSpielList(null);
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
     * @param spielerUUID
     * @return the Spieler (null=not found)
     */
    public static Spieler readSpielerByUUID(String spielerUUID) {
        Spieler spieler = null;
        for (Spieler entry : getSpielerList()) {
            if (entry.getSpielerUUID().equals(spielerUUID)) {
                spieler = entry;
            }
        }
        return spieler;
    }

    /**
     * inserts a new spieler into the spielerList
     *
     * @param spieler the spieler to be saved
     */
    public static void insertSpieler(Spieler spieler) {
        getSpielerList().add(spieler);
        writeSpielerJSON();
    }

    /**
     * updates the spielerList
     */
    public static void updateSpieler() {
        writeSpielerJSON();
    }

    /**
     * deletes a spieler identified by the spielerUUID
     * @param spielerUUID  the key
     * @return  success=true/false
     */
    public static boolean deleteSpieler(String spielerUUID) {
        Spieler spieler = readSpielerByUUID(spielerUUID);
        if (spieler != null) {
            getSpielerList().remove(spieler);
            writeSpielerJSON();
            return true;
        } else {
            return false;
        }
    }

    /**
     * reads all spiels
     * @return list of spielers
     */
    public static List<Spiel> readAllSpiels() {
        return getSpielList();
    }

    /**
     * reads a spiel by its uuid
     * @param spielUUID
     * @return the Spiel (null=not found)
     */
    public static Spiel readSpielByUUID(String spielUUID) {
        Spiel spiel = null;
        for (Spiel entry : getSpielList()) {
            if (entry.getSpielUUID().equals(spielUUID)) {
                spiel = entry;
            }
        }
        return spiel;
    }

    /**
     * inserts a new spiel into the spielerList
     *
     * @param spiel the spiel to be saved
     */
    public static void insertSpiel(Spiel spiel) {
        getSpielList().add(spiel);
        writeSpielJSON();
    }

    /**
     * updates the spielList
     */
    public static void updateSpiel() {
        writeSpielJSON();
    }

    /**
     * deletes a spiel identified by the spielUUID
     * @param spielUUID  the key
     * @return  success=true/false
     */
    public static boolean deleteSpiel(String spielUUID) {
        Spiel spiel = readSpielByUUID(spielUUID);
        if (spiel != null) {
            getSpielList().remove(spiel);
            writeSpielJSON();
            return true;
        } else {
            return false;
        }
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
     * writes the spielerList to the JSON-file
     */
    private static void writeSpielerJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String spielerPath = Config.getProperty("spielerJSON");
        try {
            fileOutputStream = new FileOutputStream(spielerPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getSpielerList());
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
     * writes the spielList to the JSON-file
     */
    private static void writeSpielJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String spielerPath = Config.getProperty("spielJSON");
        try {
            fileOutputStream = new FileOutputStream(spielerPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getSpielList());
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