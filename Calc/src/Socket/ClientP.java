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
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author kingdragon
 */
public class ClientP {
    
    
   public  static String cl(double x,double y ,char op) throws IOException
    {
        Socket s = new Socket("127.0.0.1",5001);
        Scanner sc = new Scanner(System.in);
      
           System.out.println("Nom : "+s.getInetAddress().getHostName());
           System.out.println("Ip : "+s.getInetAddress().getHostAddress());
         
        
           Calcule c = new Calcule(x, y, op);
          
           ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
           oos.writeObject(c);
           oos.flush();
           
           
           BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
          String result =bf.readLine();
             s.close();
             return result;
    }
   
    
}
