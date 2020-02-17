/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1ex2s6;

/**
 *
 * @author kingdragon
 */
public class EntNat {
    private int i;
    public EntNat(int x) throws ErrConst
    {
        if(x<0) throw new ErrConst("la valeur est null "+x);
        i=x;
    }
    
    public int getN(){return i;}
    
    
    public EntNat somme(int x) throws ErrConst,ErrSom
    {
        if(i+x>Integer.MAX_VALUE) 
                throw new  ErrConst("la valeur de somme depasse le nombre maximal "+Integer.MAX_VALUE);
        return new EntNat(i+x);
    }
     public EntNat produit(int x) throws ErrConst,ErrProd
    {
        if(i*x>Integer.MAX_VALUE) 
                throw new  ErrConst("la valeur de produit depasse le nombre maximal "+Integer.MAX_VALUE);
        return new EntNat(i*x);
    }
      public EntNat diff(int x) throws ErrConst,ErrDiff
    {
        if(i-x>Integer.MAX_VALUE) 
                throw new  ErrConst("la valeur de difference depasse le nombre maximal "+Integer.MAX_VALUE);
        return new EntNat(i-x);
    }
}

class ErrConst extends Exception{
    
    public ErrConst(String s)
    {
        super(s);
    }
    
}

class ErrSom extends Exception{
    
    public ErrSom(String s)
    {
        super(s);
    }
    
}

class ErrDiff extends Exception{
    
    public ErrDiff(String s)
    {
        super(s);
    }
    
}

class ErrProd extends Exception{
    
    public ErrProd(String s)
    {
        super(s);
    }
    
}
