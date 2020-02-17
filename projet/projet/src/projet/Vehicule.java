/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import java.awt.*;
public class Vehicule extends Thread{
       private int num;
       private boolean rouley=false;
       private boolean roulex=false;
       private Color clr;
       private int vitesse;
       private int x,y;
      
      
       public Vehicule(int num, Color clr, int vitesse, int x, int y) {
             this.num = num;
             this.clr = clr;
             this.vitesse = vitesse;
             this.x = x;
             this.y=y;
       }
      
      
       public int getNum() {
             return num;
       }
      
       public void setId(int num) {
             this.num = num;
       }
      
       public Color getClr() {
             return clr;
       }

       public void setClr(Color clr) {
             this.clr = clr;
       }
       public int getVitesse() {
             return vitesse;
       }
       public void setVitesse(int vitesse) {
             this.vitesse = vitesse;
       }
       public int getX() {
             return x;
       }
       public void setX(int x) {
             this.x = x;
       }
       public int getY() {
             return y;
       }
       public void setY(int y) {
             this.y = y;
       }
      
       public void move()
       {
             x=x+vitesse;
       }
       public void movey()
       {
             y=y+vitesse;
       }
      
      
 public boolean isRoule() {
             return roulex;
       }
 public boolean isRouley() {
             return rouley;
       }

       public void setRoule(boolean roule) {
             this.roulex = roule;
       }
 public void setRouley(boolean roule) {
             this.rouley = roule;
       }

public void run()
 {
        while(true)
        {
       try {
             sleep(50);
       } catch (InterruptedException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
       }
       if(isRoule())
        move();
      if(isRouley())
           movey();
        }
                
                
 }
}

