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
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author kingdragon
 */
public class ClientP {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Socket s = new Socket("127.0.0.1",5001);
       Scanner sc = new Scanner(System.in);
      
           System.out.println("Nom : "+s.getInetAddress().getHostName());
           System.out.println("Ip : "+s.getInetAddress().getHostAddress());
         
        
        
             Point p = new Point(3,9);
             
             System.out.println("donner operation : ");
             String op=sc.next();
             
      
           ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
           oos.writeObject(p);
           oos.flush();
           PrintWriter pw = new PrintWriter(s.getOutputStream());
           pw.println(op);
           pw.flush();
           
           BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
           System.out.println("Result "+bf.readLine());
             s.close();
    }
    
}
