package socketTHread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class MonThread extends Thread {
	
	Socket socketClient;
	Vector<Socket> clients;
	
	public MonThread(Socket socket, Vector<Socket> clients) {
		socketClient = socket;
		this.clients = clients;
	}
	@Override
	public void run() {
		
		
	try {
			
	while(true)
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
	String messageRecu = br.readLine();
				
				
	for (int i = 0; i < clients.size(); i++) {
	if(clients.elementAt(i)!=socketClient)
	{
	PrintWriter pw = new PrintWriter(clients.elementAt(i).getOutputStream());
	pw.println(messageRecu);
	pw.flush();
	}
					
	}
			
	}
			
		
        } catch (IOException e) {
		
	e.printStackTrace();
      }
		
		
	}

}
