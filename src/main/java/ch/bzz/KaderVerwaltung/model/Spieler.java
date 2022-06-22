package ch.bzz.KaderVerwaltung.model;

import ch.bzz.KaderVerwaltung.data.DataHandler;
import ch.bzz.KaderVerwaltung.util.LocalDateDeserializer;
import ch.bzz.KaderVerwaltung.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.time.LocalDate;

/**
 * a player in the KaderVerwaltung
 */
public class Spieler {
    @JsonIgnore
    private Spiel Spiel;

    @FormParam("spielerUUID")
    @NotEmpty
    @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
    private String spielerUUID;

    @FormParam("name")
    @NotEmpty
    @Size(min=3, max=30)
    private String name;

    @FormParam("nationalität")
    @NotEmpty
    @Size(min=4, max=50)
    private String nationalität;

    @FormParam("spielerNr")
    @NotNull
    private int spielerNr;

    @FormParam("alter")
    @NotEmpty
    private int alter;

    @FormParam("spiel")
    @NotEmpty
    private Spiel spiel;

    @FormParam("position")
    @NotEmpty
    private String position;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate release;

    /**
     * gets the publisherUUID from the Spiel-object
     * @return
     */
    public String getSpielUUID() {
        if (getSpielUUID()== null) return null;
        return spiel.getSpielUUID();
    }

    /**
     * creates a Spiel-object without the booklist
     * @param spielUUID the key
     */
    public void setSpielUUID(String spielUUID) {
        setSpiel(new Spiel());
        Spiel publisher = DataHandler.readSpielByUUID(spielUUID);
        getSpiel().setSpielUUID(spielUUID);
        getSpiel().setSpielzeit(spiel.getSpielzeit());
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

}