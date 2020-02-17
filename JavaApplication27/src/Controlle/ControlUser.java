package Controlle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import Vue.FenetreUser;


public class ControlUser implements ActionListener {
       
	FenetreUser v;
	String s1,s2;
	public ControlUser(FenetreUser v )
	{
		this.v=v;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButton r = new JRadioButton();
		JRadioButton r2 = new JRadioButton();
		
		
		 if(e.getSource()== v.getUserpanel().getButtonj())
			{
				s1=v.getUserpanel().getNomjoueur1().getText();
				s2=v.getUserpanel().getNomjoueur2().getText();
				v.fenetrejoue();System.out.println("voila");
			}
		
		
		else if(v.getUserpanel().getButton1O().isSelected())
		{    r=v.getUserpanel().getButton2x();
		     r.setEnabled(true);
		     r.setSelected(true);
		     r2=v.getUserpanel().getButton2O();
		     r2.setEnabled(false);
			r2.setSelected(false);
			v.getUserpanel().setButton2x(r);
			v.getUserpanel().setButton2O(r2);
			
		}
		else if(v.getUserpanel().getButton1x().isSelected())
		{
			r=v.getUserpanel().getButton2x();
			r.setSelected(false);r.setEnabled(false);
			r2=v.getUserpanel().getButton2O();
			r2.setEnabled(true);r2.setSelected(true);
			v.getUserpanel().setButton2x(r);
			v.getUserpanel().setButton2O(r2);
			}
			
		
		
	}
}
