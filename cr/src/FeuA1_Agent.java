import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class FeuA1_Agent extends Agent {

	@Override
	protected void setup(){
		super.setup();
		addBehaviour(new TickerBehaviour(this, 100) {
			private String msg;
			int i=0;
			@Override
			protected void onTick(){
				i++;
				jade.lang.acl.ACLMessage acl=new jade.lang.acl.ACLMessage(jade.lang.acl.ACLMessage.INFORM);
				acl.addReceiver(new AID("VoitureA1",AID.ISLOCALNAME));
				if(i==1){
					for(int j=0;j<50 ;j++){
					acl.setContent("WAHD");
					send(acl);}}

				if(i==2){
					for(int j=0;j<50;j++){
					acl.setContent("JOJ"); send(acl);}}
					
				
				if(i==3){
					for(int j=0;j<50;j++){
					acl.setContent("TLATA"); send(acl);
					}}

				if (i==3) i=0;
			}
		});
		
	}
	
}
