import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Vue extends JFrame {
  JPanel panel = new JPanel(); 
  DefaultListModel<String> dfl  = new DefaultListModel<String>();
  JList list = new JList(dfl);
  JTextPane textPane = new JTextPane();
  JButton btn = new JButton("Envoyer");
  Clients clt=new Clients(dfl);
	public Vue() {
		
		
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		panel.setLayout(null);
		
		
		JScrollPane js= new JScrollPane(list);
         js.setBounds(60, 11, 255, 141);
   
		
		panel.add(js);
		
		
		textPane.setBounds(26, 193, 219, 58);
		panel.add(textPane);
		btn.setBounds(291, 211, 110, 23);
		panel.add(btn);
		this.add(panel);
		try {
			clt.getmsg();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btn.addActionListener(new Butn(this,clt));
	}
}
