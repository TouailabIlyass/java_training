/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2;

/**
 *
 * @author kingdragon
 */
public class Point {
    private double x,y;
    private char nom;

    public char getNom() {
        return nom;
    }

    public void setNom(char nom) {
        this.nom = nom;
    }

    public Point(double x, double y, char nom) {
        this.x = x;
        this.y = y;
        this.nom = nom;
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

    
    public double distance(Point p)
    {
        return Math.sqrt(  Math.pow(x-p.x,2)+Math.pow(y-p.y, 2));
    }
    
    public double distanceOrigine()
    {
        return Math.sqrt(x*x+y*y);
    }
}
