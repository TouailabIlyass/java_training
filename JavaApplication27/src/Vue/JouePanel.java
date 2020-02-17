package Vue;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JouePanel extends JPanel{
	
public	JTextField textField_1_1 = new JTextField(10);
public	JTextField textField_1_2 = new JTextField(10);
public	JTextField textField_1_3 = new JTextField(10);
public	JTextField textField_2_1 = new JTextField(10);
public	JTextField textField_2_2 = new JTextField(10);
public	JTextField textField_2_3 = new JTextField(10);
public	JTextField textField_3_1 = new JTextField(10);
public	JTextField textField_3_2 = new JTextField(10);
public	JTextField textField_3_3 = new JTextField(10);


public JLabel nomjoueur1 = new JLabel("New label");
public JLabel nomjoueur2 = new JLabel("New label");
public JLabel tour = new JLabel("Le Tour de");
	
public JButton buttonreco = new JButton("Recommencer");
	
	
	public JouePanel()
	{
		this.setLayout(null);
		textField_1_1.setBounds(26, 123, 151, 56);
		textField_1_2.setBounds(176, 123, 137, 56);
		textField_1_3.setBounds(312, 123, 143, 56);
		textField_2_1.setBounds(26, 177, 151, 56);
		textField_2_2.setBounds(176, 177, 137, 56);
		textField_2_3.setBounds(312, 177, 143, 56);
		textField_3_1.setBounds(26, 232, 151, 56);
		textField_3_2.setBounds(176, 232, 137, 56);
		textField_3_3.setBounds(312, 232, 143, 56);
		this.add(textField_1_1);this.add(textField_1_2);this.add(textField_1_3);
		this.add(textField_2_1);this.add(textField_2_2);this.add(textField_2_3);
		this.add(textField_3_1);this.add(textField_3_2);this.add(textField_3_3);
		
		
		
		
		
		
		
		nomjoueur1.setBounds(26, 11, 101, 24);
		nomjoueur2.setBounds(312, 11, 101, 24);
		this.add(nomjoueur1);this.add(nomjoueur2);
		
		
		tour.setFont(new Font("Tahoma", Font.BOLD, 11));
		tour.setBounds(176, 58, 137, 35);
		this.add(tour);
		
	
		buttonreco.setBounds(354, 415, 101, 23);
		this.add(buttonreco);
    
		
	}

}
