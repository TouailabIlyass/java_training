/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author kingdragon
 */
public class Client {
    
    public static void main(String[] args) throws IOException {
        Socket s= new Socket("127.0.0.1", 5000);
        Scanner sc = new Scanner(System.in);
        
        PrintWriter pw = new PrintWriter(s.getOutputStream());
        pw.println("ilyase : "+sc.nextLine());
        pw.flush();
        
    }
}
