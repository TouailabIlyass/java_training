import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Butn implements ActionListener {

	Vue v;
	Clients clt;
	public Butn(Vue v, Clients clt) {
		
		this.v = v;
		this.clt = clt;
	}


	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==v.btn)
		{
			String s=v.textPane.getText();v.textPane.setText("");
			try {
				clt.sendmsg("moi :  "+s);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
	}

}
