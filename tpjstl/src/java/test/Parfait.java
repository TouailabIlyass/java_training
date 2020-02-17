package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author drging
 */
public class Parfait {
 
    
   public static Boolean isParfait(int x)
        {
            int s=0;
            for(int i=1;i<x;i++)
            {
                if(x%i==0)
                    s+=i;
            }
            return (s==x);
        }
}
