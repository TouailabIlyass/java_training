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
public abstract class Contact {
    
    private Car car;

    public Contact(Car car) {
        this.car = car;
    }
    
    public void buttonOpenPressed()
    {
        car.buttonOpenPressed();
    }
    public void buttonClosedPressed()
    {
        car.buttonClosedPressed();
    }
    
    public void state()
    {
        car.State();
    }
    
}
