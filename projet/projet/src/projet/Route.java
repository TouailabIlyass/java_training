/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import java.util.*;
public class Route{

       private int num;
       private String nom;
       private Vector<Feu> f;
       private Vector<Vehicule> v;
      
       public Route(int num, String nom) {
             this.num = num;
             this.nom = nom;
             f= new Vector<Feu>();
             v= new Vector<Vehicule>();
       }
      
       public Vector<Vehicule> getVehicules()
       {
             return v;
       }
      
       public int getNum()
       {
             return num;
       }
      
       public String getString()
       {
             return nom;
       }
      
      
       public Vector<Feu> getF() {
             return f;
       }

       public void addFeu(Feu f1) {
             f.add(f1);
       }


       public void addVehicule(Vehicule v1) {
             v.add(v1);
       }

      

}
