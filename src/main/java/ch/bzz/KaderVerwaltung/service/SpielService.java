package ch.bzz.KaderVerwaltung.service;

import ch.bzz.KaderVerwaltung.data.DataHandler;
import ch.bzz.KaderVerwaltung.model.Spiel;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

/**
 * services for reading, adding, changing and deleting spiels
 */
@Path("spiel")
public class SpielService {

    /**
     * reads a list of all spiels
     * @return
     */

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listSpiels() {
        List<Spiel> spielList = DataHandler.readAllSpiels();
        return Response
                .status(200)
                .entity(spielList)
                .build();
    }

    /**
     * reads one specific spiel
     * @return
     */

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readSpiel(
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String spielUUID
    ) {
        Spiel spiel = DataHandler.readSpielByUUID(spielUUID);
        int httpStatus = 200;
        if (spiel == null) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity(spiel)
                .build();
    }

    /**
     * deletes a specific spiel by uuid
     * @param spielUUID
     * @return
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteSpiel(
            @NotEmpty
            @Pattern(regexp = "[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
            @QueryParam("uuid") String spielUUID
    ) {
        int httpStatus = 200;
        if (!DataHandler.deleteSpiel(spielUUID)) {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * inserts a new spiel
     * @return
     */
    @PUT
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertSpiel(
            @Valid @BeanParam Spiel spiel,
            @FormParam("spielUUID") String spielUUID
    ) {
        spiel.setSpielUUID(UUID.randomUUID().toString());
        spiel.setSpielUUID(spielUUID);

        DataHandler.insertSpiel(spiel);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     * updates an existing spiel
     * @return
     */
    @POST
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateSpiel(
            @Valid @BeanParam Spiel spiel,
            @FormParam("spielUUID") String spielUUID
    ) {
        int httpStatus = 200;
        Spiel existingSpiel = DataHandler.readSpielByUUID(spiel.getSpielUUID());
        if (existingSpiel != null) {
            existingSpiel.setSpielzeit(spiel.getSpielzeit());
            existingSpiel.setErzTore(spiel.getErzTore());
            existingSpiel.setErzAssists(spiel.getErzAssists());
            existingSpiel.setGelbeKarten(spiel.getGelbeKarten());
            existingSpiel.setRoteKarten(spiel.getRoteKarten());
            existingSpiel.setErfolgPässe(spiel.getErfolgPässe());
            existingSpiel.setSpielUUID(spielUUID);

            DataHandler.updateSpiel();
        } else {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

}
