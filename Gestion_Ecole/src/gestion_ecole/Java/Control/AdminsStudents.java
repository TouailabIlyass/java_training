/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Control;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FiveHearoes
 */
public class AdminsStudents extends AdminsDB {

    public static void AddStudents(Students std) {

        int st = InsertInto("person(FIRSTNAME,LASTNAME,BRITH_PLACE,BRITH_DATE,CIN,PHONE,EMAIL,URL_PICTURE)", "('" + std.getFirstname() + "','" + std.getLastname() + "','" + std.getBrith_Place() + "','" + std.getBrith_Date() + "','" + std.getCIN() + "','" + std.getPhone() + "','" + std.getEmail() + "','" + std.getUrl_Picture() + "')");
        if (st > 0) {

            //ResultSet IDper = Select("ID_PERSON", "person", "FIRSTNAME LIKE '" + std.getFirstname() + "' and LASTNAME LIKE '" + std.getLastname() + "'");
            ResultSet IDper = Select("Max(ID_PERSON)", "person", "FIRSTNAME LIKE '" + std.getFirstname() + "' and LASTNAME LIKE '" + std.getLastname() + "'");
            try {
                if (IDper.next()) {
                    std.setID(IDper.getInt(1));
                    st = InsertInto("students(ID_PERSON,DATE_INSC,CNE)", "(" + std.getID() + ",'" + std.getDate_Insc() + "','" + std.getCNE() + "')");
                    if (st > 0) {
                        ResultSet IDDep = Select("ID_DPRT", "department", "DESCRIPION_DPRT LIKE '" + std.getDepartement() + "'");
                        if (IDDep.next()) {
                            ResultSet IDYr = Select("ID_YEAR", "year", "ID_DPRT = " + IDDep.getInt(1) + " and YEAR = " + std.getYear());
                            ResultSet IDStd = Select("ID_STD ", "students", "ID_PERSON = " + std.getID());
                            if (IDYr.next() && IDStd.next()) {
                                InsertInto("class(ID_YEAR,ID_STD)", "(" + IDYr.getInt(1) + "," + IDStd.getInt(1) + ")");
                            }
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static List<Students> getStudents(String Dprt, int Year, String Firstname) {
        String WhereD = "";
        String WhereY = "";
        if (!Dprt.equals("")) {
            try {
                ResultSet st = Select("ID_DPRT", "department", "DESCRIPION_DPRT LIKE '" + Dprt + "'");
                if (st.next()) {
                    WhereD = new String("ID_DPRT = " + st.getInt(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            WhereD = new String("1");
        }
        if (Year != 0) {
            WhereY = new String("YEAR = " + Year);
        } else {
            WhereY = new String("YEAR != " + Year);
        }

        ResultSet st = Select("ID_YEAR", "year", WhereD + " AND " + WhereY);

        StringBuffer WIS = new StringBuffer("(");
        try {
            StringBuffer WIY = new StringBuffer("(");
            while (st.next()) {
                WIY.append(st.getInt(1) + ",");
            }
            WIY.replace(WIY.length() - 1, WIY.length(), ")");
            ResultSet stds = Select("ID_STD", "class", "ID_YEAR IN" + WIY.toString());
            while (stds.next()) {
                WIS.append(stds.getInt(1) + ",");
            }
            WIS.replace(WIS.length() - 1, WIS.length(), ")");
            if (WIS.charAt(0) == ')') {
                return new ArrayList<Students>();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
        }

        String WhereF = "";
        if (Firstname.equals("")) {
            WhereF = "1";
        } else {
            WhereF = "FIRSTNAME LIKE '%" + Firstname + "%'";
        }

        ResultSet prs = Select("ID_PERSON", "person", WhereF);
        List<Students> students = new ArrayList<Students>();
        try {
            StringBuffer WIP = new StringBuffer("(");
            while (prs.next()) {
                WIP.append(prs.getInt(1) + ",");
            }
            WIP.replace(WIP.length() - 1, WIP.length(), ")");
            if (WIP.charAt(0) == ')') {
                return new ArrayList<Students>();
            }
            ResultSet STD = Select("*", "students", "ID_STD IN" + WIS.toString() + " AND ID_PERSON IN" + WIP.toString());
            while (STD.next()) {
                ResultSet PR = Select("*", "person", "ID_PERSON = " + STD.getInt(2));
                ResultSet Y = Select("YEAR,ID_DPRT", "year", "ID_YEAR = (SELECT ID_YEAR FROM class WHERE ID_STD = " + STD.getInt(1) + ")");
                Students s = null;
                if (PR.next()) {
                    s = new Students(STD.getDate(3), STD.getString(4), PR.getString(2), PR.getString(3), PR.getString(4), PR.getDate(5), PR.getString(6), PR.getString(7), PR.getString(8), PR.getString(9));
                    s.setID(STD.getInt(2));
                    s.setIDS(STD.getInt(1));
                }
                if (Y.next()) {
                    s.setYear(Y.getInt(1));
                    ResultSet D = Select("DESCRIPION_DPRT", "department", "ID_DPRT = " + Y.getInt(2));
                    if (D.next()) {
                        s.setDepartement(D.getString(1));
                    }
                }

                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public static List<Module> getMdl(int IdS) {
        List<Module> listM = new ArrayList<Module>();
        try {
            ResultSet Y = Select("ID_YEAR", "class", "ID_STD = " + IdS);
            if (Y.next()) {
                ResultSet M = Select("*", "module", "ID_YEAR = " + Y.getInt(1));
                while (M.next()) {
                    listM.add(new Module(M.getInt(1), M.getString(3), M.getString(4), M.getInt(5)));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listM;
    }

    public static List<Subject> getSub(int IdM) {
        List<Subject> listS = new ArrayList<Subject>();
        try {
            ResultSet S = Select("*", "subject", "ID_MDL = " + IdM);

            while (S.next()) {
                listS.add(new Subject(S.getInt(1), S.getString(4), S.getString(5), S.getInt(6), S.getInt(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listS;
    }

    public static Result getResult(int IdS, int IdSb) {
        Result R = null;

        ResultSet Rslt = Select("*", "results", "ID_SBJ = " + IdSb + " AND ID_STD = " + IdS);
        try {
            if (Rslt.next()) {
                R = new Result(Rslt.getFloat(3), Rslt.getFloat(4), Rslt.getFloat(5), Rslt.getFloat(6), Rslt.getBoolean(7));
            } else {
                InsertInto("results(ID_SBJ,ID_STD)", "(" + IdSb + "," + IdS + ")");
                R = new Result(0.0f, 0.0f, 0.0f, 0.0f, false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        return R;
    }

    public static void UploadRslt(float period, int index, int IdS, int IdSb) {
        String set = "";
        switch (index) {
            case 0:
                set = "DS_1 = " + period;
                break;
            case 1:
                set = "DS_2 = " + period;
                break;
            case 2:
                set = "EXAM = " + period;
                break;
            case 3:
                set = "RATT = " + period;
                break;
            case 4:
                set = "AR = " + (period == 1.0f);
                break;
        }

        Update("results", set, "ID_SBJ = " + IdSb + " AND ID_STD = " + IdS);
    }

    public static void UpDateStd(Students std) {
        Update("person", "FIRSTNAME = '" + std.getFirstname() + "', LASTNAME = '" + std.getLastname() + "', BRITH_PLACE = '" + std.getBrith_Date() + "', BRITH_DATE = '" + std.getDate_Insc() + "', CIN = '" + std.getCIN() + "', PHONE = '" + std.getPhone() + "', EMAIL = '" + std.getEmail() + "', URL_PICTURE = '" + std.getUrl_Picture() + "'", "ID_PERSON = " + std.getID());
        Update("students", "ID_PERSON = " + std.getID() + ", DATE_INSC = '" + std.getBrith_Date() + "', CNE = '" + std.getCNE() + "'", "ID_STD = " + std.getIDS());
        ResultSet IDY = Select("ID_YEAR", "year", "YEAR = " + std.getYear() + " AND ID_DPRT = (SELECT ID_DPRT FROM department WHERE DESCRIPION_DPRT = '" + std.getDepartement() + "')");
        try {
            if (IDY.next()) {
                Update("class", "ID_YEAR = " + std.getYear(), "ID_STD = " + std.getIDS());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void addAbsence(Courses Crs, int IdS, int just) {

        try {
            boolean Check = true;
            while (Check) {

                ResultSet IdC = Select("ID_CRS", "courses", "ID_SBJ = " + Crs.getID_SBJ() + " AND DATE_CRS LIKE '" + Crs.getDATE_CRS() + "' AND Time LIKE '" + Crs.getTIME_CRS() + "' AND HOURS_NBR = " + Crs.getNbrH());
                if (IdC.next()) {
                    Crs.setID_CRS(IdC.getInt(1));
                    Check = false;
                } else {
                    InsertInto("courses(ID_SBJ,DATE_CRS,Time,HOURS_NBR)", "(" + Crs.getID_SBJ() + ",'" + Crs.getDATE_CRS() + "','" + Crs.getTIME_CRS() + "'," + Crs.getNbrH() + ")");
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        InsertInto("absence_student(ID_CRS,ID_STD,JUSTIFIED )", "(" + Crs.getID_CRS() + "," + IdS + "," + just + ")");
    }

    public static List<Absence> getAb(int STD) {
        List<Absence> listAb = new ArrayList<>();

        ResultSet ABSEN = Select("*", "absence_student", "ID_STD = " + STD);
        try {
            while (ABSEN.next()) {
                ResultSet CRS = Select("*", "courses", "ID_CRS = " + ABSEN.getInt(1));
                if (CRS.next()) {
                    listAb.add(new Absence(new Courses(CRS.getInt(1), CRS.getInt(2), CRS.getDate(3), CRS.getTime(4), CRS.getInt(5)), ABSEN.getInt(3), ABSEN.getInt(2), ABSEN.getInt(1)));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAb;
    }

    public static Subject getS(int IDSb) {
        ResultSet sb = Select("*", "subject", "ID_SBJ = " + IDSb);
        Subject sbj = new Subject("");
        try {
            if (sb.next()) {
                sbj.setID(sb.getInt(1));
                sbj.setName(sb.getString(4));
                sbj.setDescription(sb.getString(5));
                sbj.setNbrHours(sb.getInt(6));
                sbj.setPersentage(sb.getInt(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sbj;
    }

    public static Module getM(int IDSb) {
        ResultSet sb = Select("ID_MDL", "subject", "ID_SBJ = " + IDSb);
        Module MDL = new Module("", "", 0);
        try {
            if (sb.next()) {
                ResultSet Mdl = Select("*", "module", "ID_MDL = " + sb.getInt(1));
                if (Mdl.next()) {
                    MDL.setIdM(Mdl.getInt(1));
                    MDL.setNumMdl(Mdl.getString(3));
                    MDL.setNameMdl(Mdl.getString(4));
                    MDL.setSemester(Mdl.getInt(5));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminsStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        return MDL;
    }

    public static void UpdateAbs(Absence ab) {
        Update("absence_student", "JUSTIFIED = " + ab.getJUST(), "ID_CRS = " + ab.getID_CRS()+ " AND ID_STD = " + ab.getID_STD());
        Update("courses", "DATE_CRS = '"+ab.getCrs().getDATE_CRS()+"' , Time = '"+ab.getCrs().getTIME_CRS()+"' , HOURS_NBR = "+ab.getCrs().getNbrH(), "ID_CRS = " + ab.getID_CRS());
    }
    
    public static void DeletedAbs(int IdC) {
        Delete("courses", "ID_CRS = "+IdC);
    }

}
