/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

/**
 *
 * @author drging
 */
public class CourseMDL implements Course{
    private int id,id_c;
    private String categorie,description,fullname,shortname,summary,image;
     public  String link="http://localhost/moodle/moodle/course/view.php?id=";
   // private ArrayList<String> sections;
   // private ArrayList<String> sections;
//SELECT DISTINCT c.id,c.category,cg.name,cg.description,c.fullname,c.shortname,c.summary,f.filename from mdl_course c ,mdl_course_categories cg , mdl_files f,mdl_user u where c.category=cg.id and u.id=f.userid and f.filearea='overviewfiles' 
    public CourseMDL() {
    }

    public CourseMDL(int id, int id_c, String categorie, String description, String fullname, String shortname, String summary) {
        this.id = id;
        this.id_c = id_c;
        this.categorie = categorie;
        this.description = description;
        this.fullname = fullname;
        this.shortname = shortname;
        this.summary = summary;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLink() {
        return link;
    }
    
}
