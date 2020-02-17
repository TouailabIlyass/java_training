/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioex1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kingdragon
 */
public class IOex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      
        try {
          DataOutputStream   data = new DataOutputStream(new FileOutputStream("test.txt"));
            System.out.println("donner un entier");
            int n;
            do{
                n=s.nextInt();
                 
                 if(n==0) break;
                 data.writeInt(n);
            }while(true);
            
           
            
            data.close();
        } catch (FileNotFoundException e) {
           
            
            System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
            System.out.println("fin ecriture");
        
         int n=0;
         int i=0;
        try{
             DataInputStream lecture = new DataInputStream(new FileInputStream("test.txt"));
        
             while(true)
             {
                 try {
                     n+=lecture.readInt();
                    
                     i++;
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                     lecture.close();
                     break;
                 }
                 
             }
        }catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("la somme des entiers est : "+n);
        System.out.println("la moyenne est : "+n/i);
       
       
        
        
        
    }
    
}
