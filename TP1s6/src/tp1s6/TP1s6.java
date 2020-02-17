/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1s6;

import com.sun.xml.internal.stream.Entity;
import java.util.Scanner;

/**
 *
 * @author kingdragon
 */
public class TP1s6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        try{
            
            System.out.println("debut");
            int x=s.nextInt();
            EntNat obj= new EntNat(x);
            x=s.nextInt();
            EntNat obj2= new EntNat(x);
            System.out.println("fin");
            
        }catch(ErrConst e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
}
