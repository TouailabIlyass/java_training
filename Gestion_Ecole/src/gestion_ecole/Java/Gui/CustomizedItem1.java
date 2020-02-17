/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole.Java.Gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author FiveHearoes
 */
public class CustomizedItem1 extends HBox {

    private Label DEPARTMENT;
    private Label YEAR;
    private Label MODULE;
    private Label SUBJECT;
    private Label AS;
    private Label RS;
    private Label US;
    private Label AR;
    private Label RR;
    private Label UR;
    private Label AA;
    private Label RA;
    private Label UA;

    private HBox item;

    private String SDEPARTMENT;
    private String SYEAR;
    private String SMODULE;
    private String SSUBJECT;
    private String SAS;
    private String SRS;
    private String SUS;
    private String SAR;
    private String SRR;
    private String SUR;
    private String SAA;
    private String SRA;
    private String SUA;

    boolean SET;

    public CustomizedItem1(String SDEPARTMENT, String SYEAR, String SMODULE, String SSUBJECT, String SAS, String SRS, String SUS, String SAR, String SRR, String SUR, String SAA, String SRA, String SUA, boolean SET) {
        this.SDEPARTMENT = SDEPARTMENT;
        this.SYEAR = SYEAR;
        this.SMODULE = SMODULE;
        this.SSUBJECT = SSUBJECT;
        this.SAS = SAS;
        this.SRS = SRS;
        this.SUS = SUS;
        this.SAR = SAR;
        this.SRR = SRR;
        this.SUR = SUR;
        this.SAA = SAA;
        this.SRA = SRA;
        this.SUA = SUA;
        this.SET = SET;

        Init();
    }

    private void Init() {
        try {
            item = FXMLLoader.load(getClass().getResource("/gestion_ecole/Fxml/Item1.fxml"));

            DEPARTMENT = (Label) item.getChildren().get(0);
            YEAR = (Label) item.getChildren().get(1);
            MODULE = (Label) item.getChildren().get(2);
            SUBJECT = (Label) item.getChildren().get(3);
            AS = (Label) item.getChildren().get(4);
            RS = (Label) item.getChildren().get(5);
            US = (Label) item.getChildren().get(6);
            AR = (Label) item.getChildren().get(7);
            RR = (Label) item.getChildren().get(8);
            UR = (Label) item.getChildren().get(9);
            AA = (Label) item.getChildren().get(10);
            RA = (Label) item.getChildren().get(11);
            UA = (Label) item.getChildren().get(12);

            if (SET) {
                DEPARTMENT.setText(SDEPARTMENT);
                YEAR.setText(SYEAR);
                MODULE.setText(SMODULE);
                SUBJECT.setText(SSUBJECT);
                AS.setText(SAS);
                RS.setText(SRS);
                US.setText(SUS);
                AR.setText(SAR);
                RR.setText(SRR);
                UR.setText(SUR);
                AA.setText(SAA);
                RA.setText(SRA);
                UA.setText(SUA);
            }

            setPrefHeight(item.getPrefHeight());
            setPrefWidth(item.getPrefWidth());

            setPadding(item.getPadding());

            getChildren().addAll(DEPARTMENT, YEAR, MODULE, SUBJECT, AS, RS, US, AR, RR, UR, AA, RA, UA);
        } catch (IOException ex) {
            Logger.getLogger(CustomizedItem1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
