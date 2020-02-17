
package jade;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.Location;
import javax.swing.JLabel;


public class Voiture4 extends Agent{


    private JLabel Img2;
    private Object[] args;
    private int y2=500;
    
 protected void setup(){
	 
       args=getArguments();
       Img2=(JLabel) args[0];
	
       addBehaviour(new TickerBehaviour(this,20)
       {
 
    	   protected void onTick() 
    	   {
    		   if (y2<=0){y2=610;}
    		   Img2.setLocation(767, y2);
    		   ACLMessage msg = receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
    		   if(msg!=null && Img2.getY()==500)
    		   {
    		   }
               else
               {
                    y2=y2-2;
                      
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
