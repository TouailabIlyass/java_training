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
public class Absence {

    private Courses Crs;
    private int JUST;
    private int ID_STD;
    private int ID_CRS;

    public Absence(Courses Crs, int JUST, int ID_STD, int ID_CRS) {
        this.Crs = Crs;
        this.JUST = JUST;
        this.ID_STD = ID_STD;
        this.ID_CRS = ID_CRS;
    }

    public Courses getCrs() {
        return Crs;
    }

    public void setCrs(Courses Crs) {
        this.Crs = Crs;
    }

    public int getJUST() {
        return JUST;
    }

    public void setJUST(int JUST) {
        this.JUST = JUST;
    }

    public int getID_STD() {
        return ID_STD;
    }

    public void setID_STD(int ID_STD) {
        this.ID_STD = ID_STD;
    }

    public int getID_CRS() {
        return ID_CRS;
    }

    public void setID_CRS(int ID_CRS) {
        this.ID_CRS = ID_CRS;
    }
    
    
}
