package Vue;

import javax.swing.JFrame;

import Controlle.ControlUser;

public class FenetreUser extends JFrame{
	
private	UserPanel userpanel = new UserPanel();
private JouePanel jouepanel = new JouePanel();

	public FenetreUser()
	{
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void fenetrePrincipal()
	{  	
		this.add(userpanel);
		ControlUser c = new ControlUser(this);
		userpanel.getButtonj().addActionListener(c);
		userpanel.getButton1x().addActionListener(c);
		userpanel.getButton1O().addActionListener(c);
		
	}
	
	public void fenetrejoue()
	{
		this.remove(userpanel);
		this.validate();
		this.add(jouepanel);
		System.out.println("valide");
	}
	
	
	
	
	public UserPanel getUserpanel() {
	return userpanel;
}

public void setUserpanel(UserPanel userpanel) {
	this.userpanel = userpanel;
	
}


public JouePanel getJouepanel() {
return jouepanel;
}

public void setJouepanel(JouePanel jouepanel) {
this.jouepanel = jouepanel;
}





}
