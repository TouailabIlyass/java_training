


import jade.core.Agent;
import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.Location;
import javax.swing.JLabel;
import javax.swing.*;

public class Feuxrouge1 extends Agent{

    private int i=0;
    private  boolean light =true ;
    
 protected void setup(){
     
                    
		addBehaviour(new TickerBehaviour(this,20){
 
                    protected void onTick() 
                    {
                        if (light== true)
                        {
                        	 i++; 
                        	 Route.LightF1(true);
                        	 ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                        	 ACLMessage msg1 = new ACLMessage(ACLMessage.INFORM);
                        	 msg.setContent("Rouge1");
                        	 msg1.setContent("Rouge1");
                        	 msg.addReceiver(new AID("Voiture1", AID.ISLOCALNAME));
                        	 msg1.addReceiver(new AID("Voiture3", AID.ISLOCALNAME));
                        	 send(msg);
                        	 send(msg1);
                        }
                        else {
                        	
                           i++;
                           Route.LightF1(false);                                        
                                              
                              }
                        
                        if (i%400==0){light=!light;}    
                    }
			
		});
                	}
	
	protected void takeDown(){
	}
	public void doMove(Location loc){
		System.out.println("Migration vers"+loc.getName());
	}
}
