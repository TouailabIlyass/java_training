 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Databases.*;
import Models.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author drging
 */
public class CoursesService {
    
    
    public static ArrayList<Course> getCourses()
    {
        ArrayList<Course> list = new ArrayList<Course>();
        PreparedStatement stmt = null;
        try {
            stmt = PostgresqlCon.getInstance().getConnexion().prepareStatement("SELECT  c.id,c.category,cg.name,cg.description,c.fullname,c.shortname,c.summary from mdl_course c ,mdl_course_categories cg where c.category=cg.id");
            ResultSet rst=stmt.executeQuery();
            while(rst.next())
                list.add(new CourseMDL(rst.getInt(1),rst.getInt(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7))); 
          
            stmt = chamilloDB.getInstance().getConnexion().prepareStatement("SELECT  c.id,c.code,c.title,c.directory,c.description,c.department_name from course c");
            rst = stmt.executeQuery();
            while(rst.next())
                list.add(new CourseCML(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        
        return null;
    }
    public static ArrayList<Course> getCourse(String name)
    {
        ArrayList<Course> list = new ArrayList<Course>();
        try {
            PreparedStatement stmt = MysqlCon.getConnexion().prepareStatement("SELECT  c.id,c.category,cg.name,cg.description,c.fullname,c.shortname,c.summary from mdl_course c ,mdl_course_categories cg  where c.category=cg.id and c.fullname like '%"+name+"%'");
            //stmt.setString(1, name);
            ResultSet rst=stmt.executeQuery();
            while(rst.next())
                list.add(new CourseMDL(rst.getInt(1),rst.getInt(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7))); 
            stmt = chamilloDB.getInstance().getConnexion().prepareStatement("SELECT  c.id,c.code,c.title,c.directory,c.description,c.department_name from course c");
            rst = stmt.executeQuery();
            while(rst.next())
                list.add(new CourseCML(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        
        return null;
    }
    
}
