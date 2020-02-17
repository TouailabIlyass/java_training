/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import calc.Calcule;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author kingdragon
 */
public class Calc {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {

         ServerSocket s= new ServerSocket(5001);
        System.out.println("server start");
     
        
        Socket client=null;
        while(true)
        {
            client=s.accept();
      
        
         System.out.println("client accepte");
            
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            
            Calcule c= (Calcule) ois.readObject();
           
           //BufferedReader bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
           // String op=bf.readLine();
            double result=0;
            switch(c.getOp())
            {
                case '+':  result=c.getX()+c.getY();break;
                case '-': result=c.getX()-c.getY();break;
                case '*': result=c.getX()*c.getY();break;
                case '/': result=c.getX()/c.getY();break;
                
            }
                
            PrintWriter pw = new PrintWriter(client.getOutputStream());
            pw.println(result);
            pw.flush();
            System.out.println(result);
            client.close();
            
        }
           
    }
}

