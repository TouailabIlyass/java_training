/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;
public class Fenetre extends JFrame{
private Panneau pan = new Panneau();
private Route r1=new Route(1,"national");
public Fenetre(){
this.setTitle("Animation");
this.setSize(720,755);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setLocationRelativeTo(null);
this.setContentPane(pan);
this.setVisible(true);

go();
}
private void go(){
          Feu f1= new Feu(20,Color.green,7000,180,450);
          Feu f2= new Feu(20,Color.red,7000,220,180);
          Feu f3= new Feu(20,Color.green,7000,490,220);
          Feu f4= new Feu(20,Color.red,7000,450,490);
          
    Vehicule v1=new Vehicule(50,Color.red,5,10,400);
    Vehicule v2=new Vehicule(50,Color.red,-5,660,290);
    Vehicule v3=new Vehicule(50,Color.red,5,290,10);
    Vehicule v4=new Vehicule(50,Color.red,-5,400,660);
    r1.addFeu(f1);
    r1.addFeu(f2);
    r1.addFeu(f3);
    r1.addFeu(f4);
    r1.addVehicule(v1);
    r1.addVehicule(v2);
     r1.addVehicule(v3);
      r1.addVehicule(v4);
    Vector<Feu> f=r1.getF();
    Vector<Vehicule> v=r1.getVehicules();
   
    for(int i=0;i<f.size();i++)
    {
       f.get(i).start();
    }
   
    for(int i=0;i<v.size();i++)
    {
       v.get(i).start();
    }

while(true)
{

       System.out.println(v1.getX());
       System.out.println(f1.getClr());
       try {
             Thread.sleep(25);
       } catch (InterruptedException e) {
             e.printStackTrace();
       }
pan.setFeu(r1.getF());
pan.setVehicule(r1.getVehicules());
v1.setRoule(true);
v2.setRoule(true);
v3.setRouley(true);
v4.setRouley(true);
if(v1.getX()==f1.getX()-20 && f1.getClr().equals(Color.red))
       v1.setRoule(false);

if(v2.getX()>f3.getX() && v2.getX()<f3.getX()+20 && f3.getClr().equals(Color.red))
       v2.setRoule(false);


if(((v4.getY())==(f4.getY()+20)) && (f4.getClr().equals(Color.red)))
       v4.setRouley(false);

if(v3.getY()==f2.getY()-20 && f2.getClr().equals(Color.red))
       v3.setRouley(false);
/*
if(v4.getY()>f4.getY() && v4.getY()<f4.getY()+20 && f4.getClr().equals(Color.red))
       v4.setRoule(false);
*/
if(v1.getX()>pan.getWidth())
       v1.setX(0);
if(v2.getX()<0)
       v2.setX(pan.getWidth());


if(v3.getY()>pan.getWidth())
       v3.setY(0);
if(v4.getY()<0)
       v4.setY(pan.getWidth());

pan.repaint();
}
}

public static void main(String[] args) {
       Fenetre f=new Fenetre();
}
}