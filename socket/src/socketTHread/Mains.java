package socketTHread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Mains {
	
	
	static Vector<Socket> clients = new Vector<Socket>();
	
	public static void main(String[] args) throws IOException {
		
		
		ServerSocket s = new ServerSocket(7777);
		System.out.println("Serveur pret !");
		while(true)
		{
			Socket s2 = s.accept();
			clients.addElement(s2);
			
			MonThread t = new MonThread(s2, clients);
			t.start();
		}
		
	}

}
