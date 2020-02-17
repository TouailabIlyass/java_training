/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author kingdragon
 */
public class Test extends JApplet {
    
    private static final int JFXPANEL_WIDTH_INT = 100;
    private static final int JFXPANEL_HEIGHT_INT = 100;
    private static JFXPanel fxContainer;
    
    private Line l= new Line();
    private Line l3= new Line();
    private Line l4= new Line();
    private Line l5= new Line();
    private Line l7= new Line();
    private Line l8= new Line();
    private Line l9= new Line();
    private Line R= new Line();
    private Line R1= new Line();
    private Line R2= new Line();
    private Line axe= new Line();
    private Line op= new Line();
    private Line Miroire= new Line();
    private Line M1= new Line();
    private Line M2= new Line();
    private Circle f1 = new Circle();
    private Circle f2 =new Circle();
    private Arc arc =new Arc();
    private Arc arc1=new Arc();
    private Arc arc2 =new Arc();
    private Arc arc3=new Arc();
    private Arc arc4=new Arc();
    private Label lbl = new Label();
    private Label lbl1 = new Label();
    private Panel pan=new Panel();
    private Panel pan2=new Panel();
 Scene scene;
 static JFrame frame;
 static FXMLLoader f;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }
                
                 frame = new JFrame("JavaFX 2 in Swing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                JApplet applet = new Test();
                applet.init();
                
                frame.setContentPane(applet.getContentPane());
                
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                applet.start();
                frame.setSize(800, 600);
            }
        });
    }
    
    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.runLater(new Runnable() {
            
            @Override
            public void run() {
                try {
                    createScene();
                } catch (IOException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void createScene() throws IOException {
       
        start2();
         f= new FXMLLoader();
        f.setLocation(getClass().getResource("fenetrexml.fxml")); 
         f.load();
                    
        Pane root = f.getRoot();
       // root.getChildren().addAll(axe,op,R);
        scene= new Scene(root);
        fxContainer.setScene(scene);
        
    }
      public static FXMLLoader getCtl()
      {
          return f;
      }
       public void start2()
    {
        axe.setStartX(10);axe.setStartY(frame.getHeight()/2);
        axe.setEndX(frame.getWidth()-10);axe.setEndY(axe.getStartY());
        op.setStartX(frame.getWidth()/2); op.setStartY(30);
        op.setEndX(op.getStartX()); op.setEndY(frame.getHeight()-90);
        Miroire.setStartX(op.getStartX()); Miroire.setStartY(op.getStartY());
        Miroire.setEndX(op.getEndX()); Miroire.setEndY(op.getEndY());
        R.setStartX(op.getStartX()-60);
        R.setEndX(op.getStartX()-60);
        R1.setStartX(op.getStartX()-30);
        R1.setEndX(op.getStartX()-30);
      R.setEndY(axe.getStartY()-5);
      R.setStartY(R.getEndY()-30);
      R1.setEndY(axe.getStartY()-5);
       R1.setStartY(R1.getEndY()-30);
    
        
    }
    
}
