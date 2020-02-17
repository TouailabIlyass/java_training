package socketTHread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
	Scanner sc = new Scanner(System.in);
		
        Socket s = new Socket("localhost", 7777);
		
	Thread t = new Thread(new Runnable() {
			
	@Override
	public void run() {
				
	try {
					
	while(true)
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	String messageRecu = br.readLine();
        System.out.println(messageRecu);
		}
	} 
				
	catch (IOException e) {
	
	System.out.println("Erreur");
	}
				
}
});
		t.start();
		
		PrintWriter pw = new PrintWriter(s.getOutputStream());
		System.out.println("Tapez votre nom !");
		String nom = sc.nextLine();
		
		while(true)
		{
			String messageAenvoye = sc.nextLine();
			pw.println(nom+" a dit : "+messageAenvoye);
			pw.flush();
		}
	}
}
