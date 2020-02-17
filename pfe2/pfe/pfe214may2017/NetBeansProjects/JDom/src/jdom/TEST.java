/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdom;

/**
 *
 * @author kingdragon
 */
public class TEST {
    
    public String Nom,coulour;

    public TEST(String Nom, String coulour) {
        this.Nom = Nom;
        this.coulour = coulour;
    }
    public TEST()
    {
        
    }
    
    @Override
    public String toString()
    {
        return Nom+" "+coulour;
    }
    
}
