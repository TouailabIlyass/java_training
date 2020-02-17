
package jade;

import jade.core.Agent;
import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.Location;
import javax.swing.JLabel;
import javax.swing.*;


public class Voiture3 extends Agent{

    private JLabel Img2;
    private Object[] args;
    private int x2=975;
    
 protected void setup(){

        args=getArguments();	
        Img2=(JLabel) args[0];
                    
		addBehaviour(new TickerBehaviour(this,20)
		{
			protected void onTick() 
			{
				if(x2<=0)x2=1360;
				Img2.setLocation(x2, 265);
				ACLMessage msg = receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
				if(msg!=null && Img2.getX()<=973 && Img2.getX()>=897)
				{					
				}
				else
				{
					x2-=2;  
				}
			}
			
		});
         					}
	
	protected void takeDown(){
	}
	public void doMove(Location loc){
		System.out.println("Migration vers"+loc.getName());
	}
}
