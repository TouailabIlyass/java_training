/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kingdragon
 * //stream de communication ,traitement
 */
public class ex1 {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            DataOutputStream dot = new DataOutputStream(new FileOutputStream("test.txt"));
            for (int i = 1; i <=2; i++) {
                System.out.print("Nom "+i+" : ");
                dot.writeUTF(s.nextLine()+" ");
                System.out.print("Prenom  : ");
                dot.writeUTF(s.nextLine()+" ");
                System.out.print("Annee Nais  : ");
                dot.writeInt(s.nextInt());
                s.nextLine();
                dot.writeUTF(" ");
                System.out.println("");
                
                
            }
            dot.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ex1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ex1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("test.txt"));
            
            while(true)
            {
                
                try {
                    System.out.println(dis.readUTF());
                    System.out.println(dis.readUTF());
                    System.out.println(dis.readInt());
                    System.out.println(dis.readUTF());
                    
                } catch (IOException ex) {
                    try {
                        dis.close();
                    } catch (IOException ex1) {
                        Logger.getLogger(ex1.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                   break;
                }
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ex1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
