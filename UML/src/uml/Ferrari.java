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
public class Ferrari extends Car {

    @Override
    public void buttonOpenPressed() {
        System.out.println("Ferrari was opened");
        state="Open";
        
    }

    @Override
    public void buttonClosedPressed() {
        System.out.println("Ferrari was closed");
        state="Close";
        
    }
    
}
