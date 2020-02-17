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
public class ManagerUsers {

    private int IDMU;
    private boolean AddUser;
    private boolean RemoveUser;
    private boolean UpdateUser;

    public ManagerUsers(int IDMU, boolean AddUser, boolean RemoveUser, boolean UpdateUser) {
        this.IDMU = IDMU;
        this.AddUser = AddUser;
        this.RemoveUser = RemoveUser;
        this.UpdateUser = UpdateUser;
    }

    public int getIDMU() {
        return IDMU;
    }

    public void setIDMU(int IDMU) {
        this.IDMU = IDMU;
    }

    public boolean isAddUser() {
        return AddUser;
    }

    public void setAddUser(boolean AddUser) {
        this.AddUser = AddUser;
    }

    public boolean isRemoveUser() {
        return RemoveUser;
    }

    public void setRemoveUser(boolean RemoveUser) {
        this.RemoveUser = RemoveUser;
    }

    public boolean isUpdateUser() {
        return UpdateUser;
    }

    public void setUpdateUser(boolean UpdateUser) {
        this.UpdateUser = UpdateUser;
    }
}
