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
public class Result {
    private float Ds1;
    private float Ds2;
    private float Exam;
    private float Ratt;
    private boolean AR;

    public Result(float Ds1, float Ds2, float Exam, float Ratt, boolean AR) {
        this.Ds1 = Ds1;
        this.Ds2 = Ds2;
        this.Exam = Exam;
        this.Ratt = Ratt;
        this.AR = AR;
    }

    public float getDs1() {
        return Ds1;
    }

    public void setDs1(float Ds1) {
        this.Ds1 = Ds1;
    }

    public float getDs2() {
        return Ds2;
    }

    public void setDs2(float Ds2) {
        this.Ds2 = Ds2;
    }

    public float getExam() {
        return Exam;
    }

    public void setExam(float Exam) {
        this.Exam = Exam;
    }

    public float getRatt() {
        return Ratt;
    }

    public void setRatt(float Ratt) {
        this.Ratt = Ratt;
    }

    public boolean getAR() {
        return AR;
    }

    public void setAR(boolean AR) {
        this.AR = AR;
    }
    
    
    
}
