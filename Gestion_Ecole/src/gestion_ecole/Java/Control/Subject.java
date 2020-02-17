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
public class Subject {

    private int ID;
    private String Name;
    private String Description;
    private int NbrHours;
    private double Persentage;

    public Subject(String Name) {
        this.Name = Name;
    }

    public Subject(int ID, String Description) {
        this.ID = ID;
        this.Description = Description;
    }

    public Subject(int ID, String Name, String Description, int NbrHours, double Persentage) {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.NbrHours = NbrHours;
        this.Persentage = Persentage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getNbrHours() {
        return NbrHours;
    }

    public void setNbrHours(int NbrHours) {
        this.NbrHours = NbrHours;
    }

    public double getPersentage() {
        return Persentage;
    }

    public void setPersentage(double Persentage) {
        this.Persentage = Persentage;
    }

}
