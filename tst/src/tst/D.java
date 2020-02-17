/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tst;

import java.util.ArrayList;

/**
 *
 * @author kingdragon
 */
public class D {
    
    private ArrayList<A> t= new ArrayList<A>();
    
    public  void Ajouter(A a)
    {    t.add(a);
        
    }
    
    public void afficher()
    {
        for(A e :t)
        {
            System.out.println(e);
        }
        
    }
    
}
