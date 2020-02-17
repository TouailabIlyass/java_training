package consummer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ConsummateurGui extends JButton {

	 JButton JL ;
	
	private ConsummateurAgent consummateurAgent ;
	
	
	public ConsummateurGui(){
		  JL = new JButton("hahaha jade");
		
	}
	
	public JButton getbutton() {
		return JL;
	}
	
	public ConsummateurAgent getConsummateurAgent() {
		return consummateurAgent;
	}
	public void setConsummateurAgent(ConsummateurAgent consummateurAgent) {
		this.consummateurAgent = consummateurAgent;
	}

}
