/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.io.Serializable;

/**
 *
 * @author kingdragon
 */
public class Calcule implements Serializable{
    private double x,y;
    private char op;

    public Calcule(double x, double y, char op) {
        this.x = x;
        this.y = y;
        this.op = op;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }
    
    
    
}
