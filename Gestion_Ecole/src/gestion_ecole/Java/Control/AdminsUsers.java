/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FiveHearoes
 */
public class AdminsUsers extends AdminsDB {

    public static Users getUser(String Username) {
        ResultSet User = Select("*", "users", "username Like '" + Username + "'");
        Users user = null;
        try {
            if (User.next()) {
                ResultSet person = Select("*", "person", "ID_PERSON = " + User.getInt(2));
                if (person.next()) {
                    user = new Users(User.getString(1), User.getString(4), User.getString(5), person.getString(2), person.getString(3), person.getString(4), person.getDate(5), person.getString(6), person.getString(7), person.getString(8), person.getString(9));
                    user.setID(person.getInt(1));
                }
                ResultSet ManagerUser = Select("*", "manager_user", "ID_MANAGER_USER = " + User.getInt(3));
                if (ManagerUser.next()) {
                    user.setPermissionMU(new ManagerUsers(ManagerUser.getInt(1), ManagerUser.getBoolean(2), ManagerUser.getBoolean(3), ManagerUser.getBoolean(4)));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public static List<Subject> getSB(String SDP, String SYR, String SMDL, String SSBJ) {
        String WhereD = new String(SDP.equals("All") ? "1" : "NAME_DPRT LIKE '" + SDP + "'");
        String WhereY = new String(SYR.equals("All") ? "1" : "YEAR = " + SYR);
        String WhereM = new String(SMDL.equals("All") ? "1" : "NUM_MDL LIKE '" + SMDL + "'");
        String WhereS = new String(SSBJ.equals("All") ? "1" : "DESCRIPTION_SBJ LIKE '" + SSBJ + "'");
        ResultSet Sub = Select("ID_SBJ", "subject", WhereS + " AND ID_MDL IN(SELECT ID_MDL FROM module WHERE " + WhereM + " AND ID_YEAR IN(SELECT ID_YEAR FROM year WHERE " + WhereY + " AND ID_DPRT IN(SELECT ID_DPRT FROM department WHERE " + WhereD + ")))");
        List<Subject> listS = new ArrayList<>();
        try {
            while (Sub.next()) {
                listS.add(new Subject(Sub.getInt(1), ""));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listS;
    }

    public static List<Users> getUsers(String Firstname) {

        List<Users> listUsers = new ArrayList<Users>();

        try {

            String WhereF = "";
            if (Firstname.equals("")) {
                WhereF = "1";
            } else {
                WhereF = "FIRSTNAME LIKE '%" + Firstname + "%'";
            }
            

            ResultSet prs = Select("ID_PERSON", "person", WhereF);

            StringBuffer WIP = new StringBuffer("(");
            while (prs.next()) {
                WIP.append(prs.getInt(1) + ",");
            }
            WIP.replace(WIP.length() - 1, WIP.length(), ")");

            if (WIP.charAt(0) == ')') {
                return new ArrayList<Users>();
            }

            ResultSet users = Select("*", "users", "ID_PERSON IN" + WIP.toString());

            while (users.next()) {
                ResultSet person = Select("*", "person", "ID_PERSON = " + users.getInt(2));
                Users user = null;
                if (person.next()) {
                    user = new Users(users.getString(1), users.getString(4), users.getString(5), person.getString(2), person.getString(3), person.getString(4), person.getDate(5), person.getString(6), person.getString(7), person.getString(8), person.getString(9));
                    user.setID(person.getInt(1));
                }
                ResultSet ManagerUser = Select("*", "manager_user", "ID_MANAGER_USER = " + users.getInt(3));
                if (ManagerUser.next()) {
                    user.setPermissionMU(new ManagerUsers(ManagerUser.getInt(1), ManagerUser.getBoolean(2), ManagerUser.getBoolean(3), ManagerUser.getBoolean(4)));
                }
                listUsers.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listUsers;
    }

    public static void addUser(Users user) {
        try {
            int st = InsertInto("person("+(user.getID() != 0 ?"ID_PERSON,":"")+"FIRSTNAME,LASTNAME,BRITH_PLACE,BRITH_DATE,CIN,PHONE,EMAIL,URL_PICTURE)", (user.getID() != 0 ?"("+user.getID()+",'":"('") + user.getFirstname() + "','" + user.getLastname() + "','" + user.getBrith_Place() + "','" + user.getBrith_Date() + "','" + user.getCIN() + "','" + user.getPhone() + "','" + user.getEmail() + "','" + user.getUrl_Picture() + "')");
            ResultSet IDper = Select("Max(ID_PERSON)", "person", "FIRSTNAME LIKE '" + user.getFirstname() + "' and LASTNAME LIKE '" + user.getLastname() + "'");

            boolean Check = true;
            while (Check) {
                ResultSet IDMU = Select("ID_MANAGER_USER", "manager_user", "ADD_USER = " + user.getPermissionMU().isAddUser() + " AND REMOVE_USER = " + user.getPermissionMU().isRemoveUser() + " AND UPDATE_USER = " + user.getPermissionMU().isUpdateUser());
                if (IDMU.next()) {
                    user.getPermissionMU().setIDMU(IDMU.getInt(1));
                    Check = false;
                } else {
                    InsertInto("manager_user(ADD_USER,REMOVE_USER,UPDATE_USER)", "(" + (user.getPermissionMU().isAddUser() ? 1 : 0) + "," + (user.getPermissionMU().isRemoveUser() ? 1 : 0) + "," + (user.getPermissionMU().isUpdateUser() ? 1 : 0) + ")");
                }
            }

            if (IDper.next()) {
                user.setID(IDper.getInt(1));
                st = InsertInto("users(USERNAME,ID_MANAGER_USER,ID_PERSON,PASSWORD,POSITION)", "('" + user.getUsername() + "'," + user.getPermissionMU().getIDMU() + "," + user.getID() + ",'" + user.getCode() + "','" + user.getPosition() + "')");
            }
            user.getPermissionMS().forEach((ms) -> {
                InsertInto("manager_student("+(ms.getIDMS() != 0 ?"ID_MANAGER_STD,":"")+"`AS`,`RS`,`US`,`AR`,`RR`,`UR`,`AAS`,`RAS`,`UAS`,`SDEPARTMENT`,`SYEAR`,`SMODULE`,`SSUBJECT`)", (ms.getIDMS() != 0 ?"("+ms.getIDMS()+",":"(") + (ms.isAddStd() ? 1 : 0) + "," + (ms.isRemoveStd() ? 1 : 0) + "," + (ms.isUpdateStd() ? 1 : 0) + "," + (ms.isAddResult() ? 1 : 0) + "," + (ms.isReadResult() ? 1 : 0) + "," + (ms.isUpdateResult() ? 1 : 0) + "," + (ms.isAddAbsenceStd() ? 1 : 0) + "," + (ms.isReadAbsenceStd() ? 1 : 0) + "," + (ms.isUpdateAbsenceStd() ? 1 : 0) + ",'" + ms.getSDEPARTMENT() + "','" + ms.getSYEAR() + "','" + ms.getSMODULE() + "','" + ms.getSSUBJECT() + "')");
                ResultSet IDMS = Select("ID_MANAGER_STD", "manager_student", "ID_MANAGER_STD NOT IN (SELECT ID_MANAGER_STD FROM management_student) AND `AS` = " + ms.isAddStd() + " AND `RS` = " + ms.isRemoveStd() + " AND `US` = " + ms.isUpdateStd() + " AND AR  = " + ms.isAddResult() + " AND `RR` = " + ms.isReadResult() + " AND UR  = " + ms.isUpdateResult() + " AND AAS  = " + ms.isAddAbsenceStd() + " AND `RAS` = " + ms.isReadAbsenceStd() + " AND `UAS`   = " + ms.isUpdateAbsenceStd() + " AND SDEPARTMENT LIKE '" + ms.getSDEPARTMENT() + "' AND SYEAR LIKE '" + ms.getSYEAR() + "' AND SMODULE LIKE '" + ms.getSMODULE() + "' AND SSUBJECT LIKE '" + ms.getSSUBJECT() + "'");
                try {
                    if (IDMS.next()) {
                        ms.setIDMS(IDMS.getInt(1));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AdminsUsers.class.getName()).log(Level.SEVERE, null, ex);
                }
                InsertInto("management_student(USERNAME,ID_MANAGER_STD)", "('" + user.getUsername() + "'," + ms.getIDMS() + ")");
                List<Subject> listS = getSB(ms.getSDEPARTMENT(), ms.getSYEAR(), ms.getSMODULE(), ms.getSSUBJECT());
                listS.forEach((s) -> {
                    InsertInto("supervisor_sbj(ID_MANAGER_STD,ID_SBJ )", "(" + ms.getIDMS() + "," + s.getID() + ")");
                });

            });

        } catch (SQLException ex) {
            Logger.getLogger(AdminsUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<ManagerStudents> getAcesse(String Username) {
        List<ManagerStudents> listM = new ArrayList<>();
        ResultSet IDMS = Select("ID_MANAGER_STD", "management_student", "USERNAME LIKE '" + Username + "'");
        try {
            while (IDMS.next()) {
                ResultSet MS = Select("*", "manager_student", "ID_MANAGER_STD = "+IDMS.getInt(1));
                if (MS.next()) {
                    listM.add(new ManagerStudents(MS.getInt(1), MS.getBoolean(2), MS.getBoolean(3), MS.getBoolean(4), MS.getBoolean(5), MS.getBoolean(6), MS.getBoolean(7), MS.getBoolean(8), MS.getBoolean(9), MS.getBoolean(10), MS.getString(11), MS.getString(12), MS.getString(13), MS.getString(14), null));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listM;
    }
}
