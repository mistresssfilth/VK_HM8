package api;

import lombok.NoArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;
@Path("/help")
@NoArgsConstructor
public final class HelpREST {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public InputStream getHelp(){
        return HelpREST.class.getResourceAsStream("/static/index.html");

    }
}
