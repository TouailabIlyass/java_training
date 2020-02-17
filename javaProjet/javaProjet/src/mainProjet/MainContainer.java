package mainProjet;
import javax.swing.JFrame;
import javax.swing.JPanel;

import consummer.ConsummateurGui;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;

import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;

public class MainContainer {

	public static void main(String[] args) {
	try{
	
		
		
		
	Runtime runtime = Runtime.instance();
	Properties properties =new ExtendedProperties();
	properties.setProperty(Profile.GUI, "true");
	ProfileImpl profileImpl= new ProfileImpl(properties);
	AgentContainer mainContainer = runtime.createMainContainer(profileImpl);
	mainContainer.start();	
	
	
	JFrame jf = new JFrame("a");
	JPanel jp = new JPanel();
		//jf.add(new ConsummateurGui());
		jf.setSize(600, 600);
		jf.setVisible(true);
		//JButton JL = new JButton("hahaha jade");
		ConsummateurGui var = new ConsummateurGui();
		jp.add(var.getbutton());
		jf.add(jp);
	}catch(ControllerException e){e.printStackTrace();}	
		
	}

}
