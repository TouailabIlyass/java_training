/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Control;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author FiveHearoes
 */
public class Courses {
    private  int ID_CRS;
    private int ID_SBJ;
    private Date DATE_CRS;
    private Time TIME_CRS;
    private int NbrH;

    public Courses(int ID_CRS, int ID_SBJ, Date DATE_CRS, Time TIME_CRS, int NbrH) {
        this.ID_CRS = ID_CRS;
        this.ID_SBJ = ID_SBJ;
        this.DATE_CRS = DATE_CRS;
        this.TIME_CRS = TIME_CRS;
        this.NbrH = NbrH;
    }

    public int getID_CRS() {
        return ID_CRS;
    }

    public void setID_CRS(int ID_CRS) {
        this.ID_CRS = ID_CRS;
    }

    public int getID_SBJ() {
        return ID_SBJ;
    }

    public void setID_SBJ(int ID_SBJ) {
        this.ID_SBJ = ID_SBJ;
    }

    public Date getDATE_CRS() {
        return DATE_CRS;
    }

    public void setDATE_CRS(Date DATE_CRS) {
        this.DATE_CRS = DATE_CRS;
    }

    public Time getTIME_CRS() {
        return TIME_CRS;
    }

    public void setTIME_CRS(Time TIME_CRS) {
        this.TIME_CRS = TIME_CRS;
    }

    public int getNbrH() {
        return NbrH;
    }

    public void setNbrH(int NbrH) {
        this.NbrH = NbrH;
    }
    
    
}
