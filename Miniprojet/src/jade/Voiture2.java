
package jade;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.Location;
import javax.swing.JLabel;


public class Voiture2 extends Agent{

      private JLabel Img1;
    private Object[] args;
    private int y1=120;
    
 protected void setup(){
	 
       args=getArguments();
       Img1=(JLabel) args[0];
	
       addBehaviour(new TickerBehaviour(this,20)
       {
 
    	   protected void onTick() 
    	   {
    		   if (y1>=610)y1=0;
    		   Img1.setLocation(540, y1);
    		   ACLMessage msg = receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
    		   if(msg!=null && Img1.getY()<=239 && Img1.getY()>=120 )
    		   {
    		   }
               else
               {
                	y1=y1+2;
                      
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
