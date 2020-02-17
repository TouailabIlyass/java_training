
package jade;

import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import javax.swing.JLabel;

import java.io.IOException;

import javax.swing.*;


public class Voiture1 extends Agent{

      private JLabel Img1;
    private Object[] args;
    private int x1=305;
    
 protected void setup(){

        args=getArguments();	
        Img1=(JLabel) args[0];
                    
		addBehaviour(new TickerBehaviour(this,20)
		{
			protected void onTick() 
			{
				if (x1>=1360)x1=0;
				Img1.setLocation(x1, 378);
				ACLMessage msg = receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
				if(msg!=null && Img1.getX()<=411 && Img1.getX()>= 300)
				{
				}
				else
				{
					x1+=2;
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
