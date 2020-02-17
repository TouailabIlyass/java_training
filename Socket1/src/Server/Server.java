/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author kingdragon
 */
public class Server {
    
    
    public static void main(String[] args) throws IOException {
        ServerSocket s= new ServerSocket(5000);
        System.out.println("server pret !!");
        Socket S1=s.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(S1.getInputStream()));
        String m=br.readLine();
        //PrintWriter pw=new PrintWriter(S1.getOutputStream());
        System.out.println(m);
        
    }
}
