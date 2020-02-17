/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Resources;

import Model.Client;
import Services.ClientService;
import Services.CmdService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author drging
 */
@Path("/client")
public class ClientResource {
    

   
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getClients()
    {
        return ClientService.getClients();
    }

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{ClientCin}")
    public Client getClient(@PathParam("ClientCin") String cin)
    {   
          return ClientService.getClient(cin);       
    }
   
    
}
