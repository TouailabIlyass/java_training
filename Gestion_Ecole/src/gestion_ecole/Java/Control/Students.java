/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Control;

import java.sql.Date;

/**
 *
 * @author FiveHearoes
 */
public class Students extends Person {

    private int IDS;
    private Date Date_Insc;
    private String CNE;
    private String Departement;
    private int Year;

    public Students() {
        super("None", "None", "None", new Date(0), "None", "None", "None", "None");
    }

    
    
    public Students(Date Date_Insc, String CNE, String Firstname, String Lastname, String Brith_Place, Date Brith_Date, String CIN, String Phone, String Email, String Url_Picture) {
        super(Firstname, Lastname, Brith_Place, Brith_Date, CIN, Phone, Email, Url_Picture);
        this.Date_Insc = Date_Insc;
        this.CNE = CNE;
    }
    public Students(Date Date_Insc, String CNE, String Firstname, String Lastname, String Brith_Place, Date Brith_Date, String CIN, String Phone, String Email, String Url_Picture, String Departement, int Year) {
        super(Firstname, Lastname, Brith_Place, Brith_Date, CIN, Phone, Email, Url_Picture);
        this.Date_Insc = Date_Insc;
        this.CNE = CNE;
        this.Departement = Departement;
        this.Year = Year;
    }

    public int getIDS() {
        return IDS;
    }

    public void setIDS(int IDS) {
        this.IDS = IDS;
    }

    public Date getDate_Insc() {
        return Date_Insc;
    }

    public void setDate_Insc(Date Date_Insc) {
        this.Date_Insc = Date_Insc;
    }

    public String getCNE() {
        return CNE;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }

    public String getDepartement() {
        return Departement;
    }

    public void setDepartement(String Departement) {
        this.Departement = Departement;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }
}
