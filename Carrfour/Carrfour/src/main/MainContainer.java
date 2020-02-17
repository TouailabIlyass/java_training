package main;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.ControllerException;

public class MainContainer {
   public static void main(String[] args) {
	try {
		Runtime runtime = Runtime.instance();
		Properties properties = new ExtendedProperties();
		properties.setProperty(Profile.GUI, "true");
		ProfileImpl profileImpl = new ProfileImpl(properties);
		jade.wrapper.AgentContainer agentContainer= runtime.createMainContainer(profileImpl);
		agentContainer.start();
	} catch (ControllerException e) { 
		e.printStackTrace();
	}
	
}
	
}
