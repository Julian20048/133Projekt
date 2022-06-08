package ch.bzz.KaderVerwaltung.model;

import ch.bzz.KaderVerwaltung.data.DataHandler;
import ch.bzz.KaderVerwaltung.util.LocalDateDeserializer;
import ch.bzz.KaderVerwaltung.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.*;
import javax.ws.rs.FormParam;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * a spieler in the spielershelf
 */
public class Spieler {
    @JsonIgnore
    private Spiel spiel;

    @FormParam("spielerUUID")
    @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
    private String spielerUUID;

    @FormParam("nationalität")
    @NotEmpty
    @Size(min = 5, max = 40)
    private String nationalität;

    @FormParam("spielerNr")
    @NotEmpty
    @Size(min = 4, max = 50)
    private int spielerNr;

    @FormParam("alter")
    @DecimalMax(value = "199.95")
    @DecimalMin(value = "0.05")
    private int alter;

    @FormParam("position")
    @Pattern(regexp = "(?=[0-9]{13}|[- 0-9]{17})97[89](-[0-9]{1,5}){3}-[0-9]")
    private String position;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate release;

    /**
     * gets the spielUUID from the Spiel-object
     *
     * @return
     */
    public int getSpielID() {
        if (getSpiel() == null) return null;
        return getSpiel().getSpielId();
    }

    /**
     * creates a Spiel-object without the Kaderverwaltung
     *
     * @param spielId the key
     */
    public void setSpielId(int spielId) {
        setSpiel(new Spiel());
        Spiel spiel = DataHandler.readSpielsBySpielId(spielId);
        getSpiel().setSpielId(spielId);
        getSpiel().setSpieler(spiel.getSpieler());
    }

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
     * gets spielerUUID
     *
     * @return value of spielerUUID
     */

    public int getSpielerNr() {
        return spielerNr;
    }

    /**
     * sets spielerUUID
     *
     * @param spielerNr the value to set
     */

    public void setspielerNr(int spielerNr) {
        this.spielerNr = spielerNr;
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
     * gets spielerNr
     *
     * @return value of spielerNr
     */

    public int getspielerNr() {
        return spielerNr;
    }

    /**
     * sets spielerNr
     *
     * @param spielerNr the value to set
     */

    public void setSpielerNr(int spielerNr) {
        this.spielerNr = spielerNr;
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
     * @param position the value to set
     */

    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * gets release
     *
     * @return value of release
     */

    public LocalDate getRelease() {
        return release;
    }

    /**
     * sets release
     *
     * @param release the value to set
     */

    public void setRelease(LocalDate release) {
        this.release = release;
    }
}





