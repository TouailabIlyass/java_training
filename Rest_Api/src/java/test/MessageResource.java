/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import Model.Message;
import Services.MessageService;
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
@Path("/messages")
public class MessageResource {
    MessageService ms = new MessageService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getmessages()
    {
        return ms.getMessages();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{MessageId}")
    public Message getmessages(@PathParam("MessageId") int id)
    {
        return ms.getMessage(id);
        
    }
    
}
