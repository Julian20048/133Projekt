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

@Path("spieler")
public class SpielerService {

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

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readSpieler(
            @QueryParam("spielerNr") int spielerNr
    ) {
        Spieler spieler = DataHandler.readbyspielerNr(spielerNr);
        return Response
                .status(200)
                .entity(spieler)
                .build();
    }
    }
