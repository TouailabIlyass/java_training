/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Control;

/**
 *
 * @author FiveHearoes
 */
public class Module {
    int IdM;
    String NumMdl;
    String NameMdl;
    int Semester;

    public Module(String NumMdl, String NameMdl, int Semester) {
        this.NumMdl = NumMdl;
        this.NameMdl = NameMdl;
        this.Semester = Semester;
    }

    public Module(int IdM, String NumMdl, String NameMdl, int Semester) {
        this.IdM = IdM;
        this.NumMdl = NumMdl;
        this.NameMdl = NameMdl;
        this.Semester = Semester;
    }

    public int getIdM() {
        return IdM;
    }

    public void setIdM(int IdM) {
        this.IdM = IdM;
    }

    public String getNumMdl() {
        return NumMdl;
    }

    public void setNumMdl(String NumMdl) {
        this.NumMdl = NumMdl;
    }

    public String getNameMdl() {
        return NameMdl;
    }

    public void setNameMdl(String NameMdl) {
        this.NameMdl = NameMdl;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int Semester) {
        this.Semester = Semester;
    }
    
}
