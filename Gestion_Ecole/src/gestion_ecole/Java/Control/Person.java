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
public class Person {

    private int ID;
    private String Firstname;
    private String Lastname;
    private Date Brith_Date;
    private String Brith_Place;
    private String CIN;
    private String Phone;
    private String Email;
    private String Url_Picture;

    protected Person(String Firstname, String Lastname, String Brith_Place, Date Brith_Date, String CIN, String Phone, String Email, String Url_Picture) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Brith_Date = Brith_Date;
        this.Brith_Place = Brith_Place;
        this.CIN = CIN;
        this.Phone = Phone;
        this.Email = Email;
        this.Url_Picture = Url_Picture;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public Date getBrith_Date() {
        return Brith_Date;
    }

    public void setBrith_Date(Date Brith_Date) {
        this.Brith_Date = Brith_Date;
    }

    public String getBrith_Place() {
        return Brith_Place;
    }

    public void setBrith_Place(String Brith_Place) {
        this.Brith_Place = Brith_Place;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUrl_Picture() {
        return Url_Picture;
    }

    public void setUrl_Picture(String Url_Picture) {
        this.Url_Picture = Url_Picture;
    }

}
