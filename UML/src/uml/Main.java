/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

/**
 *
 * @author kingdragon
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        Contact F = new ContactFerrari( new Ferrari());
        Contact P = new ContactFerrari( new Porsch());
        
        System.out.println("Ferrari");
        F.buttonOpenPressed();
        F.buttonClosedPressed();
        F.state();
        System.out.println("Porsch");
        P.buttonOpenPressed();
        P.state();
        P.buttonClosedPressed();
        P.state();
        
    }
    
}
