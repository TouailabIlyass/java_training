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
public abstract class Car {
    
    protected String state;
    
    public abstract void buttonOpenPressed();
    public abstract void buttonClosedPressed();
    
    public void State()
    {
        System.out.println("car is "+state);
    }
    
}
