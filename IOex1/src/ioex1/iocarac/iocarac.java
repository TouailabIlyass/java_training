/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioex1.iocarac;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author kingdragon
 */
public class iocarac {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("test2.txt"));
            int n;
            while(true)
            {
                n=sc.nextInt();
                if(n==0) { pw.close();break;}
                pw.println(n+" a pour carre : "+n*n);
            }
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
