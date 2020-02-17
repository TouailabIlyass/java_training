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
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author kingdragon
 */
public class Client {
    
    
    public static void main(String[] args) throws IOException {
        
        Socket s = new Socket("127.0.0.1",5001);
        // OutputStream os =s.getOutputStream();
           // InputStream is= s.getInputStream();
           // os.write((int)'a');
            //System.out.println(is.read());
           // s.close();
           System.out.println("Nom : "+s.getInetAddress().getHostName());
           System.out.println("Ip : "+s.getInetAddress().getHostAddress());
            Scanner sc = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            BufferedReader bf= new BufferedReader(new InputStreamReader(s.getInputStream()));
            while(true)
            {
                pw.println(sc.nextLine());pw.flush();
                System.out.println(bf.readLine());
            }
            
    }
}
