/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Control;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author FiveHearoes
 */
public class Users extends Person {

    private String Username;
    private String Code;
    private String Position;
    private ManagerUsers PermissionMU = null;
    private List<ManagerStudents> PermissionMS = null;

    public Users(String Username, String Code, String Position, String Firstname, String Lastname, String Brith_Place, Date Brith_Date, String CIN, String Phone, String Email, String Url_Picture) {
        super(Firstname, Lastname, Brith_Place, Brith_Date, CIN, Phone, Email, Url_Picture);
        this.Username = Username;
        this.Code = Code;
        this.Position = Position;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public ManagerUsers getPermissionMU() {
        return PermissionMU;
    }

    public void setPermissionMU(ManagerUsers PermissionMU) {
        this.PermissionMU = PermissionMU;
    }

    public List<ManagerStudents> getPermissionMS() {
        return PermissionMS;
    }

    public void setPermissionMS(List<ManagerStudents> PermissionMS) {
        this.PermissionMS = PermissionMS;
    }

}
