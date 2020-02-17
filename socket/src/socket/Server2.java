/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author kingdragon
 */
public class Server2 {
    public static void main(String[] args) throws IOException {
        
         ServerSocket s= new ServerSocket(5001);
         ArrayList<Socket> cl= new ArrayList<Socket>();
        System.out.println("server start");
        
        
        Socket client1=null,client2=null;
        client1=s.accept();
        client2=s.accept();
        cl.add(client1);cl.add(client2);
         System.out.println("client accepte");
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            
           
            PrintWriter pw1 = new PrintWriter(client1.getOutputStream());
            PrintWriter pw2 = new PrintWriter(client2.getOutputStream());
             BufferedReader bf1= new BufferedReader(new InputStreamReader(client1.getInputStream()));
             BufferedReader bf2= new BufferedReader(new InputStreamReader(client2.getInputStream()));
             pw2.println(bf1.readLine());
             pw2.flush();
          
            
            
            
           

        }
    }
}
