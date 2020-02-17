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
public class CourseCML implements Course{
    private int id;
    private String code,fullname,categorie,summary,tutor_name;
    public  String link="http://localhost/chamilo/courses/";
   // private ArrayList<String> sections;
//SELECT DISTINCT c.id,c.category,cg.name,cg.description,c.fullname,c.shortname,c.summary,f.filename from mdl_course c ,mdl_course_categories cg , mdl_files f,mdl_user u where c.category=cg.id and u.id=f.userid and f.filearea='overviewfiles' 
    public CourseCML() {
    }

    public CourseCML(int id, String code, String fullname, String categorie, String summary, String tutor_name) {
        this.id = id;
        this.code = code;
        this.fullname = fullname;
        this.categorie = categorie;
        this.summary = summary;
        this.tutor_name = tutor_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getSummary() {
        return summary;
    }

    public void setDescription(String summary) {
        this.summary = summary;
    }

    public String getTutor_name() {
        return tutor_name;
    }

    public void setTutor_name(String tutor_name) {
        this.tutor_name = tutor_name;
    }

    public  String getLink() {
        return link;
    }
    

}
