/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminsDB {

    protected static ResultSet Select(String select, String from, String where) {
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;
        try {
            preparedStatement = Connecte.getConnection().prepareStatement("SELECT " + select + " FROM " + from + " WHERE " + where + ";");
            resultSet = preparedStatement.executeQuery();
            Connecte.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    protected static int Update(String update, String set, String where) {
        PreparedStatement preparedStatement;
        int st = 0;
        try {
            preparedStatement = Connecte.getConnection().prepareStatement("UPDATE " + update + " SET " + set + " WHERE " + where + ";");
            st = preparedStatement.executeUpdate();
            Connecte.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }

    protected static int Delete(String Deletefrom, String where) {
        PreparedStatement preparedStatement;
        int st = 0;
        try {
            preparedStatement = Connecte.getConnection().prepareStatement("DELETE FROM " + Deletefrom + " WHERE " + where + ";");
            st = preparedStatement.executeUpdate();
            Connecte.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }

    protected static int InsertInto(String insertInto, String values) {
        PreparedStatement preparedStatement;
        int result = 0;
        try {
            String sc = values;
            sc = sc.replace("(", "");
            sc = sc.replace(")", "");
            String[] list = sc.split(",");
            sc = "";
            for (int i = 0; i < list.length; i++) {
                if (i == 0) {
                    sc = sc.concat("?");
                } else {
                    sc = sc.concat(",?");
                }

            }
            preparedStatement = (PreparedStatement) Connecte.getConnection().prepareStatement("INSERT INTO " + insertInto + "VALUES (" + sc + ");");
            sc = values;
            sc = sc.replace("(", "");
            sc = sc.replace(")", "");
            list = sc.split(",");
            int i = 0;
            i++;
            for (String string : list) {
                if (!string.startsWith("'") && !string.endsWith("'")) {
                    preparedStatement.setInt(i, Integer.valueOf(string));
                    i++;
                } else {
                    string = string.replaceAll("'", "");
                    if ((string.split("-")).length == 3) {
                        preparedStatement.setDate(i, Date.valueOf(string));
                        i++;
                    } else {
                        preparedStatement.setString(i, string);
                        i++;
                    }
                }
            }
            result = preparedStatement.executeUpdate();
            Connecte.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static void prsDelete(int IdP) {
        ResultSet UserN = Select("USERNAME", "users", "ID_PERSON = " + IdP);
        try {
            ResultSet IMS = null;
            if(UserN.next()) {
                IMS = Select("ID_MANAGER_STD", "management_student", "USERNAME LIKE '"+UserN.getString(1)+"'");
            }
            while (IMS.next()) {
                int st = Delete("manager_student", "ID_MANAGER_STD = " + IMS.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        Delete("person", "ID_PERSON = " + IdP);
    }

    public static List<Department> getDep() {
        ResultSet dep = Select("*", "department", "1");
        List<Department> listDep = new ArrayList<Department>();
        try {
            while (dep.next()) {
                listDep.add(new Department(dep.getInt(1), dep.getString(2), dep.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDep;
    }
    

    public static List<Module> getMdl(String DescDprt, int Year) {
        List<Module> listMdl = new ArrayList<Module>();
        try {

            ResultSet dep = Select("ID_DPRT", "department", "DESCRIPION_DPRT LIKE '" + DescDprt + "'");
            String WhereY = Year == 0 ? "1" : "YEAR = " + Year;
            ResultSet Yr = null;
            if (dep.next()) {
                Yr = Select("ID_YEAR", "year", "ID_DPRT = " + dep.getInt(1) + " AND " + WhereY);
            }

            while (Yr.next()) {
                ResultSet Mdl = Select("*", "module", "ID_YEAR = " + Yr.getInt(1));
                while (Mdl.next()) {
                    listMdl.add(new Module(Mdl.getInt(1), Mdl.getString(3), Mdl.getString(4), Mdl.getInt(5)));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listMdl;
    }

    public static List<Subject> getSB(int IdM) {
        List<Subject> sb = new ArrayList<>();
        try {
            ResultSet SB = Select("ID_SBJ,DESCRIPTION_SBJ", "subject", "ID_MDL = " + IdM);
            while (SB.next()) {
                sb.add(new Subject(SB.getInt(1), SB.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb;
    }

    private static class Connecte {

        private static Connection cnx = null;

        protected static Connection getConnection() {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/gestionecole";
                cnx = DriverManager.getConnection(url, "root", "123456root");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(AdminsDB.class.getName()).log(Level.SEVERE, null, ex);
            }

            return cnx;
        }
    }

}
