package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Main_Server {
  
	private static Vector<Socket> clients= new Vector<Socket>();
  
	public static void main(String[] args) throws IOException{
		
            ServerSocket  s = new  ServerSocket(1111);
           
		System.out.println("server pret");
		
	while(true)
	{   
	       Socket  s1 = s.accept(); 
	   clients.addElement(s1);
		Monthread t = new Monthread(s1,clients);
		t.start();
                
	}

	}

}


class Monthread extends Thread {
	 private Socket s;
         private Vector<Socket> clients;
	public Monthread(Socket s,Vector<Socket> clients) {
		
		this.s=s;
		this.clients=clients;
		
	}
	
	@Override
	public void run() {
		try {
                 while(true)
		{     BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		    String msg=br.readLine();
		    for(int i=0;i<clients.size();i++)
		    {   if(!clients.get(i).equals(s))
                    {    PrintWriter pw = new PrintWriter(clients.get(i).getOutputStream());
		         pw.println(msg);
		    	  pw.flush();
                    }
		    }
		      
		}
			
		} catch (IOException e) {
		
		  System.out.println(e.getMessage());
		}
		
		
		
		
	}
	
}