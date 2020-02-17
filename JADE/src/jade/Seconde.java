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
public class Seconde extends Agent{

    @Override
    protected void setup() {
       
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                ACLMessage msg= new ACLMessage(ACLMessage.INFORM);
                System.out.println("ooooooooooooo");
                msg.setContent("hello from agent2");
                msg.addReceiver(new AID("F",AID.ISLOCALNAME));
                send(msg);
                System.out.println("sentkkkkkkkkkkkkkk");
                
            }
        });
        
         addBehaviour(new CyclicBehaviour(){
            @Override
            public void action() {
                ACLMessage msg=receive();
                System.out.println("receive in S  "+msg);
                if(msg!=null){
                System.out.println(msg.getContent());
                    System.out.println("doneS");
                }
                else
                    System.out.println("Seconde block");
            }
        
    });
        
    }
    
   
    
}
