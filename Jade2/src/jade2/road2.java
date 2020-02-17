
package jade2;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.awt.EventQueue;


public class road2 extends Agent{
  
    
 private String Etat="stop",oldEtat="";
 FXMLDocumentController cont=FXMLDocumentController.getController();
    
    private int mutex=1;
    
    @Override
    public void setup()
    {  
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               
                addBehaviour( new CyclicBehaviour() {
                    @Override
                    public void action() {
                       
                        if(!Etat.equals(oldEtat))
                        {
                        ACLMessage msg= new ACLMessage(ACLMessage.INFORM);
                             System.out.println("voiture 2");
                     
                           
                                msg.setContent("v2");
                                msg.addReceiver(new AID("F2",AID.ISLOCALNAME));
                                  
                      
                                 send(msg);
                           
                     System.out.println("sentxxxxxxxxxxx voiture2");
                     oldEtat=Etat;
                        }
                         else {
                                 System.out.println("in wait voiture2");
                                 this.block();
                                 System.out.println("fin wait voiture2");
                            }
                     
                        
                        
                    }
                });
                
                       
            }
        });
                
                EventQueue.invokeLater( new Runnable() {
                    @Override
                    public void run() {
                        
                        addBehaviour(new CyclicBehaviour() {
                    @Override
                    public void action() {
                        ACLMessage msg=receive();
              
                if(msg!=null){
                    System.out.println(Etat+" in voiture2");
                       
                
                }
                else
                {System.out.println("in block voiture2");
                    block();
                    System.out.println("fin block voiture2");
                }       
                        
                        
                        
                    }
                });
                        
                    }
                });
                
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /* 
    @Override
    protected void setup() {
       
        
        
         addBehaviour(new CyclicBehaviour(){
            @Override
            public void action() {
                ACLMessage msg=receive();
               // System.out.println("receive in R  "+msg);
                if(msg!=null){
                    if(msg.getContent().equals("stop"))
                    {
                        System.out.println("car stop");
                    }
                    else if(msg.getContent().equals("cont"))
                    {
                        System.out.println("car cont");
                    }
                
                }
                else
                    block();
            }
        
    });
        addBehaviour(new OneShotBehaviour() {
         @Override
            public void action() {
               
                    ACLMessage msg= new ACLMessage(ACLMessage.INFORM);
                System.out.println("car ask");
                msg.setContent("ask");
                msg.addReceiver(new AID("F",AID.ISLOCALNAME));
                send(msg);
                System.out.println(" ask sent"); 
                 
            }
        });
   
         
         
        
    }*/
    
}
