
package jade;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import java.awt.Color;
import static java.awt.Color.blue;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import jade.util.ExtendedProperties;
import jade.util.leap.Properties;

import jade.wrapper.StaleProxyException;

public class Route extends javax.swing.JFrame {
   
   
    public static AgentController A1 = null;
    public static AgentController A2 = null;
    public static AgentController A3 = null;
    public static AgentController A4 = null;
    public static AgentController A5 = null;
    public static AgentController A6 = null;
    public static AgentController A7 = null;
    public static AgentController A8 = null;
    
    private static JButton jButton1;
    private static JButton jButton2;
    private static JLabel jLabel1;
    private static JLabel jLabeln1;
    private static JLabel jLabeln2;
    
    private static JLabel jLabel2;
    private static JLabel jLabel3;
    private static JLabel jLabel4;
    private static JLabel jLabel5;
    private static JLabel jLabel7;
    private static JLabel jLabel6;
    private static JLabel jLabel8;
    private static JLabel jLabel11;
    private static JLabel jLabel10;
    private static JLabel jLabel9;
    private static JLabel jLabel12;
    private static JLabel jLabel13;
    
    
    
    public Route() {
        setSize(700,720);
        initComponents();

    }
    
    
    public static void LightF2U(boolean b)
    {
    	if(b)
    	{
    		jLabel6.setBounds(505, 120, 71, 190);
    		jLabel7.setBounds(767, 500, 0, 0);
    	}
    	else
    	{
    		jLabel7.setBounds(505, 165, 71, 90);
    		jLabel6.setBounds(767, 500, 0, 0);
    	}
    	
    }
    
    public static void LightF2D(boolean b)
    {
    	if(b)
    	{
    		jLabel8.setBounds(845, 385, 71, 190);
    		jLabel9.setBounds(767, 500, 0, 0);
    	}
    	else
    	{
    		jLabel9.setBounds(845, 420, 71, 90);
    		jLabel8.setBounds(767, 500, 0, 0);
    	}
    }
    
    public static void LightF1(boolean b)
    {
    	if(b)
    	{
    		jLabel10.setBounds(408, 350,71, 190);
    		jLabel11.setBounds(898, 150, 71, 190);
    		jLabel12.setBounds(767, 500, 0, 0);
    		jLabel13.setBounds(505, 120, 0, 0);
    	}
    	else
    	{
    		jLabel12.setBounds(408, 350, 71, 190);
    		jLabel13.setBounds(898, 150, 71, 190);
    		jLabel10.setBounds(767, 500, 0, 0);
    		jLabel11.setBounds(505, 120, 0, 0);
    	}
    	
    }
    
    
   
    private void initComponents() {

        jLabel2 = new JLabel();
        jLabeln1 = new JLabel();
        jLabeln2 = new JLabel();
        jLabel6 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel8 = new JLabel();
        jLabel7 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel1 = new JLabel();
        jLabel11 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
       

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1378, 768));
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/15995653_1116625091780178_1694.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(305, 378, 80, 40);
        

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/15995653_1116625091780178_1694 - Copy (3).png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(540, 120, 80, 100);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/15995653_1116625091780178_1694 - Copy_1.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(975, 265, 80, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/15995653_1116625091780178_1694 - Copy (2).png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(767, 500, 71, 90);
            
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/r.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(505, 120, 71, 190);
        
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/g.png"))); // NOI18N
        getContentPane().add(jLabel7);
        
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/r.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(845, 385, 71, 190);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/g.png"))); // NOI18N
        getContentPane().add(jLabel9);
        
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/rl.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(408, 350,71, 190);
        
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/rr.png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(898, 150, 71, 190);
        
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/gl.png"))); // NOI18N
        getContentPane().add(jLabel12);
        
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/gr.png"))); // NOI18N
        getContentPane().add(jLabel13);
       

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jade/route.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-1, 1, 1362, 688);

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(12, 694, 75, 23);

        jButton2.setText("Pause");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(100, 694, 75, 23);

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	
        
        
        try { 
        	
        	A1.start();
            if(A1.getState().getName().equals("Suspended"))
              {
            	  A1.activate();
              }
            	
            
            A2.start();
            if(A2.getState().getName().equals("Suspended"))
            {
          	  A2.activate();
            }
          
            
            A3.start();
            if(A3.getState().getName().equals("Suspended"))
            {
          	  A3.activate();
            }
          
            
            A4.start();
            if(A4.getState().getName().equals("Suspended"))
            {
          	  A4.activate();
            }
            A5.start();
            if(A5.getState().getName().equals("Suspended"))
            {
          	  A5.activate();
            }
            A6.start();
            if(A6.getState().getName().equals("Suspended"))
            {
          	  A6.activate();
            }
            

   
            
        } catch (StaleProxyException ex) {
            Logger.getLogger(Route.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            A1.suspend();
            A2.suspend();
            A3.suspend();
            A4.suspend();
            A5.suspend();
            A6.suspend();
            
        } catch (StaleProxyException ex) {
            Logger.getLogger(Route.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) throws StaleProxyException {

    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Route().setVisible(true);
            }
        });
    	
    	Runtime rt = Runtime.instance();
        Properties p = new ExtendedProperties();
        p.setProperty("gui", "true");
        ProfileImpl pc =new ProfileImpl(p);
        AgentContainer ac = rt.createMainContainer(pc);
        
        A1 = ac.createNewAgent("Voiture1","jade.Voiture1",new Object[]{jLabel2});
        
        
        A5 = ac.createNewAgent("Voiture3","jade.Voiture3",new Object[]{jLabel4});
        	  
        A2 = ac.createNewAgent("Voiture2","jade.Voiture2",new Object[]{jLabel3});
        A6 = ac.createNewAgent("Voiture4","jade.Voiture4",new Object[]{jLabel5});
        
        A3 = ac.createNewAgent("Feuxrouge1","jade.Feuxrouge1",new Object[]{});
        
        A4 = ac.createNewAgent("Feuxrouge2","jade.Feuxrouge2",new Object[]{});
        
        
    }
    
}
