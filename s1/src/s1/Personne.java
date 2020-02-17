/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s1;

/**
 *
 * @author kingdragon
 */
public class Personne {
    
    protected int age;
    protected String nom,prenom;
    protected static String ville="SAFI";

    public Personne() {
        age=10;
        this.nom="nnnnn";
        
        this.prenom="hhhh";
    }
   public Personne(int age,String s,String p)
           
   {
       this.age=age;
       nom=s;
       prenom=p;
   }
    
    
    public int getAge()
    {
        return age;
    }
    
    
    public  void sleep(){
        
         System.out.println("sleep");
         
    }       
}
