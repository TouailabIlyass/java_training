/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Control;

import com.jfoenix.controls.JFXListView;
import gestion_ecole.Java.Gui.AddUserController;
import gestion_ecole.Java.Gui.CustomizedItem1;

/**
 *
 * @author FiveHearoes
 */
public class ManagerStudents extends CustomizedItem1 {

    private int IDMS;
    private boolean AddStd;
    private boolean RemoveStd;
    private boolean UpdateStd;
    private boolean AddResult;
    private boolean ReadResult;
    private boolean UpdateResult;
    private boolean AddAbsenceStd;
    private boolean ReadAbsenceStd;
    private boolean UpdateAbsenceStd;
    private String SDEPARTMENT;
    private String SYEAR;
    private String SMODULE;
    private String SSUBJECT;
    private JFXListView<CustomizedItem1> listA;

    public ManagerStudents(int IDMS, boolean AddStd, boolean RemoveStd, boolean UpdateStd, boolean AddResult, boolean ReadResult, boolean UpdateResult, boolean AddAbsenceStd, boolean ReadAbsenceStd, boolean UpdateAbsenceStd, String SDEPARTMENT, String SYEAR, String SMODULE, String SSUBJECT, JFXListView<CustomizedItem1> listA) {
        super(SDEPARTMENT, SYEAR, SMODULE, SSUBJECT, AddStd + "", RemoveStd + "", UpdateStd + "", AddResult + "", ReadResult + "", UpdateResult + "", AddAbsenceStd + "", ReadAbsenceStd + "", UpdateAbsenceStd + "", true);
        this.IDMS = IDMS;
        this.AddStd = AddStd;
        this.RemoveStd = RemoveStd;
        this.UpdateStd = UpdateStd;
        this.AddResult = AddResult;
        this.ReadResult = ReadResult;
        this.UpdateResult = UpdateResult;
        this.AddAbsenceStd = AddAbsenceStd;
        this.ReadAbsenceStd = ReadAbsenceStd;
        this.UpdateAbsenceStd = UpdateAbsenceStd;
        this.SDEPARTMENT = SDEPARTMENT;
        this.SYEAR = SYEAR;
        this.SMODULE = SMODULE;
        this.SSUBJECT = SSUBJECT;
        this.listA = listA;
    }

    public int getIDMS() {
        return IDMS;
    }

    public void setIDMS(int IDMS) {
        this.IDMS = IDMS;
    }

    public boolean isAddStd() {
        return AddStd;
    }

    public void setAddStd(boolean AddStd) {
        this.AddStd = AddStd;
    }

    public boolean isRemoveStd() {
        return RemoveStd;
    }

    public void setRemoveStd(boolean RemoveStd) {
        this.RemoveStd = RemoveStd;
    }

    public boolean isUpdateStd() {
        return UpdateStd;
    }

    public void setUpdateStd(boolean UpdateStd) {
        this.UpdateStd = UpdateStd;
    }

    public boolean isAddResult() {
        return AddResult;
    }

    public void setAddResult(boolean AddResult) {
        this.AddResult = AddResult;
    }

    public boolean isReadResult() {
        return ReadResult;
    }

    public void setReadResult(boolean ReadResult) {
        this.ReadResult = ReadResult;
    }

    public boolean isUpdateResult() {
        return UpdateResult;
    }

    public void setUpdateResult(boolean UpdateResult) {
        this.UpdateResult = UpdateResult;
    }

    public boolean isAddAbsenceStd() {
        return AddAbsenceStd;
    }

    public void setAddAbsenceStd(boolean AddAbsenceStd) {
        this.AddAbsenceStd = AddAbsenceStd;
    }

    public boolean isReadAbsenceStd() {
        return ReadAbsenceStd;
    }

    public void setReadAbsenceStd(boolean ReadAbsenceStd) {
        this.ReadAbsenceStd = ReadAbsenceStd;
    }

    public boolean isUpdateAbsenceStd() {
        return UpdateAbsenceStd;
    }

    public void setUpdateAbsenceStd(boolean UpdateAbsenceStd) {
        this.UpdateAbsenceStd = UpdateAbsenceStd;
    }

    public String getSDEPARTMENT() {
        return SDEPARTMENT;
    }

    public void setSDEPARTMENT(String SDEPARTMENT) {
        this.SDEPARTMENT = SDEPARTMENT;
    }

    public String getSMODULE() {
        return SMODULE;
    }

    public void setSMODULE(String SMODULE) {
        this.SMODULE = SMODULE;
    }

    public String getSYEAR() {
        return SYEAR;
    }

    public void setSYEAR(String SYEAR) {
        this.SYEAR = SYEAR;
    }

    public String getSSUBJECT() {
        return SSUBJECT;
    }

    public void setSSUBJECT(String SSUBJECT) {
        this.SSUBJECT = SSUBJECT;
    }

    public JFXListView<CustomizedItem1> getListA() {
        return listA;
    }

    public void setListA(JFXListView<CustomizedItem1> listA) {
        this.listA = listA;
    }

    public boolean equalMS(ManagerStudents ms) {
        return ((AddStd == ms.AddStd) && (RemoveStd == ms.RemoveStd) && (UpdateStd == ms.UpdateStd) && (AddResult == ms.AddResult) && (ReadResult == ms.ReadResult) && (UpdateResult == ms.UpdateResult) && (AddAbsenceStd == ms.AddAbsenceStd) && (ReadAbsenceStd == ms.ReadAbsenceStd) && (UpdateAbsenceStd == ms.UpdateAbsenceStd));
    }

    public boolean THERE(ManagerStudents ms) {
        if (this.equalMS(ms)) {
            if (!getSDEPARTMENT().equals(ms.getSDEPARTMENT()) && !getSDEPARTMENT().equals("All")) {
                if (ms.getSDEPARTMENT().equals("All")) {
                    listA.getItems().remove(this);
                    AddUserController.b = true;
                    AddUserController.m = this;
                }
                return false;
            } else if (!getSYEAR().equals(ms.getSYEAR()) && !getSYEAR().equals("All")) {
                if (ms.getSYEAR().equals("All")) {
                    listA.getItems().remove(this);
                    AddUserController.b = true;
                    AddUserController.m = this;
                }
                return false;
            } else if (!getSMODULE().equals(ms.getSMODULE()) && !getSMODULE().equals("All")) {
                if (ms.getSMODULE().equals("All")) {
                    listA.getItems().remove(this);
                    AddUserController.b = true;
                    AddUserController.m = this;
                }
                return false;
            } else if (!getSSUBJECT().equals(ms.getSSUBJECT()) && !getSSUBJECT().equals("All")) {
                if (ms.getSSUBJECT().equals("All")) {
                    listA.getItems().remove(this);
                    AddUserController.b = true;
                    AddUserController.m = this;
                }
                return false;
            }
            return true;
        } else if (getSDEPARTMENT().equals(ms.getSDEPARTMENT()) && getSYEAR().equals(ms.getSYEAR()) && getSMODULE().equals(ms.getSMODULE()) && getSSUBJECT().equals(ms.getSSUBJECT())) {
            ms.setAddStd(isAddStd() || ms.isAddStd());
            ms.setRemoveStd(isRemoveStd() || ms.isRemoveStd());
            ms.setUpdateStd(isUpdateStd() || ms.isUpdateStd());
            ms.setAddResult(isAddResult() || ms.isAddResult());
            ms.setReadResult(isReadResult() || ms.isReadResult());
            ms.setUpdateResult(isUpdateResult() || ms.isUpdateResult());
            ms.setAddAbsenceStd(isAddAbsenceStd() || ms.isAddAbsenceStd());
            ms.setReadAbsenceStd(isReadAbsenceStd() || ms.isReadAbsenceStd());
            ms.setUpdateAbsenceStd(isUpdateAbsenceStd() || ms.isUpdateAbsenceStd());
            listA.getItems().remove(this);
            AddUserController.b = true;
            AddUserController.m = this;
        }
        return false;
    }

}
