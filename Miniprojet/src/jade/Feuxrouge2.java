
package jade;

import jade.core.Agent;
import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.Location;
import javax.swing.JLabel;
import javax.swing.*;

public class Feuxrouge2 extends Agent{

    private int i=0;
    private  boolean light =true ;
    
 protected void setup(){
    
                    
		addBehaviour(new TickerBehaviour(this,20){
 
                    protected void onTick() 
                    {
                        if (light== false)
                        {
                        	 i++;
                        	Route.LightF2U(true);
                        	Route.LightF2D(true);
                            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                            ACLMessage msg1 = new ACLMessage(ACLMessage.INFORM);
                            msg.setContent("Rouge2");
                            msg1.setContent("Rouge2");
                            msg.addReceiver(new AID("Voiture2", AID.ISLOCALNAME));
                            msg1.addReceiver(new AID("Voiture4", AID.ISLOCALNAME));
                            send(msg);
                            send(msg1);
                        }
                        else 
                        {
                        	Route.LightF2U(false);
                        	Route.LightF2D(false);
                            i++;
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
