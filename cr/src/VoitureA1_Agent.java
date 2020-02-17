import java.io.IOException;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class VoitureA1_Agent extends Agent {
   private Chemin gui;
	@Override
	protected void setup(){
		 gui= new Chemin();
		super.setup();
		
		addBehaviour(new TickerBehaviour(this,100) {
			@Override
			protected void onTick(){
				jade.lang.acl.ACLMessage msg=receive();
				String message=msg.getContent();
	          	
	              if (message.contentEquals("WAHD")){
                          System.out.println("m1");
	            	  try {
						gui.light_feuA1_green();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	  try {
						gui.light_feuA2_green();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	  try {
							gui.light_feuB1_orange();
						} catch (IOException e) {	
							e.printStackTrace();
						}
						try {
							gui.light_feuB2_orange();
						} catch (IOException e) {
							e.printStackTrace();
						}
					
	              }
	              else if (message.contentEquals("JOJ")){
                           System.out.println("m2");
	            	  try {
							gui.light_feuA1_orange();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							gui.light_feuA2_orange();
						} catch (IOException e) {
							
							e.printStackTrace();
						}
						try {
							gui.light_feuB1_red();
						} catch (IOException e) {
						
							e.printStackTrace();
						}
						try {
							gui.light_feuB2_red();
						} catch (IOException e) {
						
							e.printStackTrace();
						}
					
	              }
	              else if (message.contentEquals("TLATA")){
                           System.out.println("m3");
	            	  try {
							gui.light_feuA1_red();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							gui.light_feuA2_red();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							gui.light_feuB1_green();
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							gui.light_feuB2_green();
						} catch (IOException e) {
							e.printStackTrace();
						}
	              }	
				
if(gui.location_voitureA1()<=240 && gui.location_voitureA1()>=186 && message.contentEquals("TLATA")) gui.stop_carA1();
else gui.move_carA1();
if(gui.location_voitureA2()<=585 && gui.location_voitureA2()>=543 && message.contentEquals("TLATA")) gui.stop_carA2();
else gui.move_carA2();
if((gui.location_voitureB1()<=212 && gui.location_voitureB1()>=130 && message.contentEquals("WAHD"))|| (gui.location_voitureB1()<=212 && gui.location_voitureB1()>=130 && message.contentEquals("JOJ")) ) gui.stop_carB1();
else gui.move_carB1();
if ((gui.location_voitureB2()>=440 && gui.location_voitureB2()<=455 && message.contentEquals("WAHD"))|| (gui.location_voitureB2()>=440 && gui.location_voitureB2()<=455 && message.contentEquals("JOJ"))) gui.stop_carB2();
else gui.move_carB2();	
			}
		});	
		
	/*	paralel.addSubBehaviour(new TickerBehaviour(this,5000) {

			@Override
			protected void onTick() {
				jade.lang.acl.ACLMessage msg=receive();
				String message=msg.getContent();
				if(gui.location_voitureA1()==200 && message.contentEquals("TLATA")) gui.stop_carA1();
				
				
			
				
				if () gui.stop_carB2();
	              if (message.contentEquals("WAHD")){
	            	  try {
						gui.light_feuA1_green();
						gui.light_feuA2_green();
						gui.light_feuB1_red();
						gui.light_feuB2_red();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	              }
	              else if (message.contentEquals("JOJ")){
	            	  try {
						gui.light_feuA1_orange();
						gui.light_feuA2_orange();
						gui.light_feuB1_red();
						gui.light_feuB2_red();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	              }
	              else if (message.contentEquals("TLATA")){
	            	  try {
						gui.light_feuA1_red();
						gui.light_feuA2_red();
						gui.light_feuB1_orange();
						gui.light_feuB2_orange();
					} catch (IOException e) {
		
						e.printStackTrace();
					}
	              }
	              else {
	            	  try {
						gui.light_feuA1_black();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	              }
				
			}
		});*/
	}
	
}
