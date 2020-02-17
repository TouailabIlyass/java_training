/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Resources;

import Model.Produit;
import Services.ProduitService;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author drging
 */

@Path("produit")
public class ProduitResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Produit> getProduits()
    {
        return ProduitService.getProduits();
    }

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{ProduitId}")
    public Produit getProduit(@PathParam("ProduitId") int id)
    {
        return ProduitService.getProduit(id);
        
    }
    
}
