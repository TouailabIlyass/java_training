/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author kingdragon
 */
public class First extends Agent{

    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour(){
            @Override
            public void action() {
                ACLMessage msg=receive();
                System.out.println("receive  "+msg);
                if(msg!=null){
                System.out.println(msg.getContent());
                    System.out.println("done");
                }
                else
                    System.out.println("block");
            }
        
    });
        
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                 ACLMessage msg= new ACLMessage(ACLMessage.INFORM);
                System.out.println("xxxxxx");
                msg.setContent("hello from agent1");
                msg.addReceiver(new AID("S",AID.ISLOCALNAME));
                send(msg);
                System.out.println("sentxxxxxxxxxxx");
            }
        });
    }
    
    
    
}
