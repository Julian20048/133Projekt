package ch.bzz.KaderVerwaltung.service;

import ch.bzz.KaderVerwaltung.data.DataHandler;
import ch.bzz.KaderVerwaltung.model.Spieler;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * services for reading, adding, changing and deleting spielers
 */
@Path("spieler")
public class SpielerService {

    /**
     * reads a list of all spielers
     * @return  spielers as JSON
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listSpielers() {
        List<Spieler> spielerList = DataHandler.readAllSpielers();
        return Response
                .status(200)
                .entity(spielerList)
                .build();
    }

    /**
     * reads a spieler identified by the uuid
     * @param spielerUUID the key
     * @return spieler
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readSpieler(
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String spielerUUID
    ) {
        int httpStatus = 200;
        Spieler spieler = DataHandler.readSpielerByUUID(spielerUUID);
        if (spieler == null) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity(spieler)
                .build();
    }

    /**
     * inserts a new spieler
     * @param spielUUID the uuid of the spiel
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertSpieler(
            @Valid @BeanParam Spieler spieler,
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @FormParam("spielUUID") String spielUUID
    ) {

        spieler.setSpielUUID(spielUUID);

        DataHandler.insertSpieler(spieler);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * updates a new spieler
     * @param spielUUID the uuid of the spiel
     * @return Response
     */
    @PUT
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateSpieler(
            @Valid @BeanParam Spieler spieler,
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @FormParam("spielUUID") String spielUUID
    ) {
        int httpStatus = 200;
        Spieler oldSpieler = DataHandler.readSpielerByUUID(spieler.getSpielerUUID());
        if (oldSpieler != null) {
            oldSpieler.setName(spieler.getName());
            oldSpieler.setNationalität(spieler.getNationalität());
            oldSpieler.setSpielUUID(spielUUID);
            oldSpieler.setPosition(spieler.getPosition());
            oldSpieler.setAlter(spieler.getAlter());
            oldSpieler.setSpielerNr(spieler.getSpielerNr());

            DataHandler.updateSpieler();
        } else {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * deletes a spieler identified by its uuid
     * @param spielerUUID  the key
     * @return  Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteSpieler(
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String spielerUUID
    ) {
        int httpStatus = 200;
        if (!DataHandler.deleteSpieler(spielerUUID)) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}