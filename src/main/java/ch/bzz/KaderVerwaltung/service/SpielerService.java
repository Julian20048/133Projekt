package ch.bzz.KaderVerwaltung.service;

import ch.bzz.KaderVerwaltung.data.DataHandler;
import ch.bzz.KaderVerwaltung.model.Spieler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * services for reading, adding, changing and deleting players
 */
@Path("spieler")
public class SpielerService {

    /**
     * reads a list of all players
     * @return  players as JSON
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPlayer(){
        List<Spieler> spielerList = DataHandler.readAllSpielers();
        return Response
                .status(200)
                .entity(spielerList)
                .build();
    }

    /**
     * reads a player identified by the spielerNr
     * @param spielerNr
     * @return Spieler
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readSpieler(
            @QueryParam("spielerNr") int spielerNr
    ) {
        int httpStatus = 200;
        Spieler spieler = DataHandler.readbyspielerNr(spielerNr);
        return Response
                .status(200)
                .entity(spieler)
                .build();
    }
}
