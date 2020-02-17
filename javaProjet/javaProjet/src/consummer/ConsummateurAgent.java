package consummer;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.JADEAgentManagement.ShowGui;
import jade.domain.introspection.ACLMessage;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;


public class ConsummateurAgent extends GuiAgent {
 private ConsummateurGui gui ;
 @Override
	protected void setup() {
	 gui= new ConsummateurGui();
	 gui.setConsummateurAgent(this);
		System.out.println("DEMARAGE DE L'AGENT CONSOMMATEUR");
//		ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
//		addBehaviour(parallelBehaviour);
//		
//		
//		parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
//			
//			
//			
//			@Override
//			public void action() {
//				gui.showMessage("behiviours one shot", true);
//				
//			}
//		});
//		parallelBehaviour.addSubBehaviour(new TickerBehaviour(this,1000) {
//					private int conteur ;
//			@Override
//			protected void onTick() {
//				++conteur ;
//				gui.showMessage("ticker behaviour :"+conteur, true);
//				
//			}
//		addBehaviour(new CyclicBehaviour() {
//			private int conteur ;
//			
//			@Override
//			public void action() {
//				++conteur ;
//				gui.showMessage("cyclic behaviour"+conteur, true);
//				 jade.lang.acl.ACLMessage aclmssg = receive();
//				if(aclmssg!=null){
//					gui.showMessage("sender : "+aclmssg.getSender(),true);
//					gui.showMessage("acte de communication : "+jade.lang.acl.ACLMessage.getPerformative(aclmssg.getPerformative()),true);
//					gui.showMessage("content : "+aclmssg.getContent(),true);
//					gui.showMessage("langue : "+aclmssg.getLanguage(),true);
//					gui.showMessage("ontology : "+aclmssg.getOntology(),true);
//					gui.showMessage("x : "+aclmssg.getUserDefinedParameter("x"),true);
//					gui.showMessage("y : "+aclmssg.getUserDefinedParameter("y"),true);
//				}else block();
//			}
//		});
//		
		
//		addBehaviour(new Behaviour() {
//			private int conteur ;
//			@Override
//			public boolean done() {
//				if(conteur ==8) return true ;
//				else return false ;
//				
//			}
//			
//			@Override
//			public void action() {
//				++conteur ;
//				gui.showMessage("generic behaviour", true);
//				
//			}
//		});
		
	}
 
 
 
@Override
protected void onGuiEvent(GuiEvent arg0) {
	// TODO Auto-generated method stub
	
}

	
	
	

}
 