/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Resources;

import Models.Course;
import Services.CoursesService;
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
@Path("course")
public class CoursesResource {
    
   @GET
   @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Course> getCources()
    {
        return CoursesService.getCourses();
    }
    @Path("/{name}")
    @GET
   @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Course> getCources(@PathParam("name") String name)
    {
        return CoursesService.getCourse(name);
    }
    
}
