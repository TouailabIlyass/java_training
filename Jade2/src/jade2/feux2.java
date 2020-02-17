
package jade2;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import java.awt.EventQueue;




public class feux2 extends Agent{
    private String Etat="vert";
     FXMLDocumentController cont=FXMLDocumentController.getController();
    feux2 f2=this;
    
    @Override
    public void setup()
    {
        
               
       
      
                
                addBehaviour(new TickerBehaviour(this,100) {
                    int i=120;
                    @Override
                    public  void onTick() {
                        if(i==120)
                        {
                            ACLMessage msg2= new ACLMessage(ACLMessage.INFORM);
                        
                        msg2.setContent("f2:"+cont.getEtatfeux1());
                        msg2.addReceiver(new AID("F1",AID.ISLOCALNAME));
                        send(msg2);
                        i=0;
                        }
                        
                        ACLMessage msg=receive();
              
                if(msg!=null){
                    
                       String message=msg.getContent();
                    if (message.contains("f1")) {
                       
                        if(message.contains("rouge"))
                        {
                            cont.setFeux2Vert();
                            cont.setFeux4Vert();
                            
                            Etat="vert";
                        }else if(message.contains("vert"))
                        {
                            cont.setFeux2Rouge();
                            cont.setFeux4Rouge();
                            Etat="rouge";
                        }

                         
                         
                    }
            
                
                }
                      EventQueue.invokeLater(new Runnable() {
                           @Override
                         public void run() {
                                if(Etat.equals("vert"))
                                 {
                                    cont.mv2();
                            
                                 }
                 
                       else {cont.moveCar2tofeux2();cont.moveCar4tofeux4();cont.ContinueCar2();}
                                
                        
                      }   });
                 
                 i++;
                
                 
                    }
                });
                
                
                
                
                
        
        
       
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    private String Etat="stop";
    @Override
    protected void setup() {
        
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
               
                    ACLMessage msg= new ACLMessage(ACLMessage.INFORM);
                System.out.println("in f2");
                msg.setContent(Etat);
                msg.addReceiver(new AID("F",AID.ISLOCALNAME));
                send(msg);
                System.out.println("sentx f2"); 
                 
            }
        });
        /*
        addBehaviour(new CyclicBehaviour(){
            @Override
            public void action() {
                ACLMessage msg=receive();
                if(msg!=null){
                    if(msg.getContent().equals("ask"))
                    {
                        System.out.println("odre");
                        Etat="stop";
                    }
               
                }
                else
                    block();
            }
        
    });
        
        
        
    }
*/
    
}
