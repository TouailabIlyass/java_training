
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;


public class Server {

    
    public static void main(String[] args) throws IOException  {
        
        ServerSocket s= new ServerSocket(5001);
        System.out.println("server start");
        Date  d= new Date();
        
        Socket client=null;
        client=s.accept();
       // PrintWriter jr = new PrintWriter(new FileWriter("journal.txt"));
       // jr.print("client = "+client.getInetAddress().getHostName());
        //jr.println("  Time : "+d.getTime());
       // jr.close();
        
         System.out.println("client accepte");
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            
           
           // OutputStream os =client.getOutputStream();
            
          //  InputStream is= client.getInputStream();
           // os.write(is.read());
             BufferedReader bf= new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            System.out.println(bf.readLine());
            
            PrintWriter pw = new PrintWriter(client.getOutputStream());
            pw.println(sc.nextLine());
            pw.flush();

        }

     
    }
    
}


/*   InetAddress[] i;
        
        try {
            i = InetAddress.getAllByName("touailab");
            for (InetAddress inetAddress : i) {
            
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());
           
            
        }
        } catch (UnknownHostException ex) {
            System.out.println("erreur de cnx");
            System.out.println(ex.getMessage());
        }
        */
       