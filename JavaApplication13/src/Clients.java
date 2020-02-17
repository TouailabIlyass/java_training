
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;

public class Clients {

  public Socket s;
  DefaultListModel<String> dfl  = new DefaultListModel<String>();
  public Clients(DefaultListModel<String> dfl) {
	this.dfl=dfl;
}
		public void sendmsg(String msg) throws UnknownHostException, IOException
		{  s= new Socket("localhost", 1111);
			
			
			
			
			
			PrintWriter pw = new PrintWriter(s.getOutputStream());
		
			
			
			  pw.println(msg);
			    pw.flush();
			   
			
		}
		
		
		public void   getmsg() throws UnknownHostException, IOException
		{
			s= new Socket("localhost", 1111);
			
			
			Thread t =new Thread(new Runnable() {
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				@Override
				public void run() {
					while(true)
					{
						try {
							 
							
							
							dfl.addElement(br.readLine());
							
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					 
				}
			});
			t.start();
			
		}
		

	

}

