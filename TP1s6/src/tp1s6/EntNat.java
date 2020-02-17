/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1s6;

/**
 *
 * @author kingdragon
 */
public class EntNat {
    private int x;
    
    public EntNat(int i) throws ErrConst
    {
        if(i<0) throw  new ErrConst("la valeur est negatife : "+i);
        x=i;
        
    }
    
    public int getN(){return x;}
}


class ErrConst extends Exception{
    
    public ErrConst(String msg)
    {
        super(msg);
    }
    
}