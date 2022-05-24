package ch.bzz.KaderVerwaltung.service;

import ch.bzz.KaderVerwaltung.data.DataHandler;
import ch.bzz.KaderVerwaltung.model.Spiel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("spiel")
public class SpielService {

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listSpiel(){
        List<Spiel> spielList = DataHandler.getInstance().readAllSpiels();
        return Response
                .status(200)
                .entity(spielList)
                .build();
    }
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readSpiel(
            @QueryParam("spielId") int spielId
    ) {
        Spiel spiel = DataHandler.getInstance().readbyspielId(spielId);
        return Response
                .status(200)
                .entity(spiel)
                .build();
    }
}
