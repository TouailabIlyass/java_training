package Vue;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UserPanel extends JPanel{
	private JLabel labeljoueur1 = new JLabel("Joueur 1");
	private JLabel labeljoueur2 = new JLabel("Joueur 2");
	ButtonGroup groupe = new ButtonGroup() ;
	
	
	private JTextField nomjoueur1 = new JTextField(10);
	private JTextField nomjoueur2 = new JTextField(10);
	
	private JRadioButton button1x = new JRadioButton("X");
	private JRadioButton button1O = new JRadioButton("O");
	private JRadioButton button2x = new JRadioButton("X");
	private JRadioButton button2O = new JRadioButton("O");
	
	private   JButton buttonj = new JButton("Jouer");
	
	


	public UserPanel()
	{
		this.setLayout(null);
		
		
		
		
		labeljoueur1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		labeljoueur1.setBounds(130, 23, 121, 30);	
		labeljoueur2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		labeljoueur2.setBounds(130, 192, 121, 37);
		
		this.add(labeljoueur1);this.add(labeljoueur2);
		
		nomjoueur1.setBounds(67, 64, 121, 37);
		nomjoueur2.setBounds(67, 262, 121, 37);
		
		this.add(nomjoueur1);this.add(nomjoueur2);
		
		
		button1x.setFont(new Font("Tahoma", Font.BOLD, 16));
		button1x.setBounds(210, 71, 64, 23);
		button1x.setSelected(true);
		button1O.setFont(new Font("Tahoma", Font.BOLD, 16));
		button1O.setBounds(306, 71, 64, 23);
		groupe.add(button1x);groupe.add(button1O);
		this.add(button1x);this.add(button1O);
		
		
		
		
	
		button2x.setFont(new Font("Tahoma", Font.BOLD, 16));
		button2x.setBounds(210, 269, 64, 23);
		button2x.setEnabled(false);
		button2O.setFont(new Font("Tahoma", Font.BOLD, 16));
		button2O.setBounds(306, 269, 64, 23);button2O.setSelected(true);
		
		this.add(button2x);this.add(button2O);
		
		
		

		
		buttonj.setForeground(Color.RED);
		buttonj.setBounds(179, 375, 114, 30);this.add(buttonj);
		
	}
 

	public JTextField getNomjoueur1() {
		return nomjoueur1;
	}


	public void setNomjoueur1(JTextField nomjoueur1) {
		this.nomjoueur1 = nomjoueur1;
	}


	public JTextField getNomjoueur2() {
		return nomjoueur2;
	}


	public void setNomjoueur2(JTextField nomjoueur2) {
		this.nomjoueur2 = nomjoueur2;
	}


	public JRadioButton getButton1x() {
		return button1x;
	}


	public void setButton1x(JRadioButton button1x) {
		this.button1x = button1x;
	}


	public JRadioButton getButton1O() {
		return button1O;
	}


	public void setButton1O(JRadioButton button1o) {
		button1O = button1o; 
	}


	public JRadioButton getButton2x() {
		return button2x;
	}


	public void setButton2x(JRadioButton button2x) {
		this.button2x = button2x;
	}


	public JRadioButton getButton2O() {
		return button2O;
	}


	public void setButton2O(JRadioButton button2o) {
		button2O = button2o;
	}
	
	

	public JButton getButtonj() {
		return buttonj;
	}


	public void setButtonj(JButton buttonj) {
		this.buttonj = buttonj;
	}

}
