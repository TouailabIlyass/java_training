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
public class Department {

    private int ID;
    private String Name;
    private String Description;

    public Department(int ID, String Name, String Description) {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
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
}
