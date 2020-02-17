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
public class S1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Personne p = new Personne();
        Personne p1 = new Personne(12,"nnn","pppp");
        System.out.println(Personne.ville);
        Etudiant e = new Etudiant();
        e.sleep();
        
       
        
    }
    
}
