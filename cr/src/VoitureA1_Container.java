import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class VoitureA1_Container {

	public static void main(String[] args) {
		try {
			Runtime runtime= Runtime.instance();
			ProfileImpl profileImpl1 =new ProfileImpl(false);
			ProfileImpl profileImpl2 =new ProfileImpl(false);
			//la premiere voiture A1
			AgentContainer carA1=runtime.createAgentContainer(profileImpl1);
			AgentController agentController_CarA1= carA1.createNewAgent("VoitureA1", VoitureA1_Agent.class.getName(), new Object[]{});
			//le premier feu rouge
			AgentContainer feuA1=runtime.createAgentContainer(profileImpl2);
			AgentController agentController_feuA1= feuA1.createNewAgent("FeuA1", FeuA1_Agent.class.getName(), new Object[]{});	
			// demarage du controlleur de voiture
			agentController_CarA1.start();
			//demarage du controlleur de feu rouge
			agentController_feuA1.start();
		} catch (ControllerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
