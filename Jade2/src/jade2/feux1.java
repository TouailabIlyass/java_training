
package jade2;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import java.awt.EventQueue;


public class feux1 extends Agent {
 private String Etat="vert";
 FXMLDocumentController cont=FXMLDocumentController.getController();

   
    
    @Override
    public void setup()
    {  
        addBehaviour(new  TickerBehaviour(this, 100) {
                    int i=0;
                            @Override
                    public  void onTick() {
                        if(i==120)
                        {
                         ACLMessage msg1= new ACLMessage(ACLMessage.INFORM);
                         msg1.setContent("f1:"+cont.getEtatfeux1());
                        msg1.addReceiver(new AID("F2",AID.ISLOCALNAME));
                        send(msg1);
                          
                        i=0;
                            
                        }
                               
                        ACLMessage msg=receive();
                               
                        
              
                if(msg!=null){
                    String message=msg.getContent();
                    if (message.contains("f2")) {
                        if(message.contains("rouge"))
                        { 
                            cont.setFeux1Vert();
                            cont.setFeux3Vert();
                            cont.setFeux2Rouge();
                            cont.setFeux4Rouge();
                            Etat="vert";
                        }else if(message.contains("vert"))
                        {
                            cont.setFeux1Rouge();
                            cont.setFeux3Rouge();
                            cont.setFeux2Vert();
                            cont.setFeux4Vert();
                            Etat="rouge";
                       
                        }
                      
                    }
                 
                }
                  EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                   if(Etat.equals("vert"))
                 { 
                   cont.mv1();
                    
                 }
                   else
                  {
                    cont.moveCar1tofeux2();cont.ContinueCar1();
                }
                                
                            }
                        });
                 
             
                    
               
                
                
                i++;
                        
                    }
                });
                        
              
                
                
      
        
       
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /* private String Etat="stop",oldEtat="";
   
    @Override
    protected void setup() {
       
        addBehaviour(new OneShotBehaviour()  {
            @Override
            public void action() {
               
                        if(!Etat.equals(oldEtat))
                        {
                        ACLMessage msg= new ACLMessage(ACLMessage.INFORM);
                     System.out.println("xxxxxx");
                     
                            for (int i = 1; i <=2; i++) {
                                msg.setContent(""+i+Etat);
                                msg.addReceiver(new AID("F"+i,AID.ISLOCALNAME));
                                  
                            }
                    send(msg);
                           
                     System.out.println("sentxxxxxxxxxxx");
                     oldEtat=Etat;
                        }
                        
                   
            
                    
                 
            }
        });
        
        addBehaviour(new CyclicBehaviour(){
            @Override
            public void action() {
                ACLMessage msg=receive();
               // System.out.println("receive in R  "+msg);
                if(msg!=null){
                    
                   
                        System.out.println(Etat);
                        Etat="marche";
                        
                        
                   
                
                }
                else
                    block();
            }
        
    });
        
        
        
    }*/
    
    /*
     addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if(!Etat.equals(oldEtat))
                        {
                        ACLMessage msg= new ACLMessage(ACLMessage.INFORM);
                     System.out.println("xxxxxx");
                     
                            for (int i = 1; i <=2; i++) {
                                msg.setContent(""+i+Etat);
                                msg.addReceiver(new AID("F"+i,AID.ISLOCALNAME));
                                  
                            }
                    send(msg);
                           
                     System.out.println("sentxxxxxxxxxxx");
                     oldEtat=Etat;
                        }else
                            try {
                                this.wait();
                                //
                        } catch (InterruptedException ex) {
                                System.out.println(ex.getMessage());
                        }
                    }
                });
            }
        });
    */
    
}
