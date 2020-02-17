/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1ex2s6;

import java.util.Scanner;

/**
 *
 * @author kingdragon
 */
public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        try{
            int x,y;
            
            System.out.println("debut 1 try");
            x=sc.nextInt();
            y=sc.nextInt();
            EntNat obj = new EntNat(x);
            EntNat obj1 = new EntNat(y);
           int s= obj.somme(y).getN();
           int p=obj.produit(y).getN();
           int d=obj.diff(y).getN();
            System.out.println("fin 1 try");
            
        }catch(Exception e)
        {
            System.out.println("erreur");
        }
        
        try{
            int x,y;
            
            System.out.println("debut 1 try");
            x=sc.nextInt();
            y=sc.nextInt();
            EntNat obj = new EntNat(x);
            EntNat obj1 = new EntNat(y);
           int s= obj.somme(y).getN();
           int p=obj.produit(y).getN();
           int d=obj.diff(y).getN();
            System.out.println("fin 1 try");
            
        }catch(ErrConst e)
        {
            System.out.println(e.getMessage());
        }
        catch(ErrSom e)
        {
             System.out.println(e.getMessage());
        }
         catch(ErrProd e)
        {
             System.out.println(e.getMessage());
        }
         catch(ErrDiff e)
        {
             System.out.println(e.getMessage());
        }
        
        
        
        
        
    }
    
}
