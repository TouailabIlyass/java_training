/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

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
        client=s.accept();
      
        
         System.out.println("client accepte");
            
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            
            Point p= (Point) ois.readObject();
            System.out.println(p);
            BufferedReader bf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String op=bf.readLine();
            double result=0;
            switch(op)
            {
                case "+":  result=p.getX()+p.getY();break;
                case "-": result=p.getX()-p.getY();break;
                case "*": result=p.getX()*p.getY();break;
                case "/": result=p.getX()/p.getY();break;
                
            }
                
            PrintWriter pw = new PrintWriter(client.getOutputStream());
            pw.println(result);
            pw.flush();
            System.out.println(result);
           s.close();
           client.close();
        
        
        
        
    }
}

