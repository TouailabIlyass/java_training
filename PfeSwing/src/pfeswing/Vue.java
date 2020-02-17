/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfeswing;

import java.awt.Canvas;
import java.awt.Graphics;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kingdragon
 */
public class Vue extends JFrame {
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
    private JLabel lbl = new JLabel();
    private JLabel lbl1 = new JLabel();
    private JPanel pan=new JPanel();
    private JPanel pan2=new JPanel();
 
    private Pane p = new Pane();
    

    public void init()
    {
        setTitle("pfe");
        setVisible(true);
      
        setSize(800, 600);
        pan.setLayout(null);
        pan.setSize(300, 300);
        start();
        
        
    
        pan.add(lbl);
        this.add(pan);
       // pan.add(p);
        p.getChildren().add(axe);
        
    }
    public void paint ( Graphics g )
  { 
      Draw(g,axe);
      Draw(g,op);
      Draw(g, R);
    
     
   }
    private void Draw(Graphics g ,Line l)
    {
        g.drawLine((int)l.getStartX(),(int)l.getStartY(),(int)l.getEndX(),(int)l.getEndY());
        
    }
    
    public void start()
    {
        axe.setStartX(10);axe.setStartY(this.getHeight()/2);
        axe.setEndX(this.getWidth()-10);axe.setEndY(axe.getStartY());
        op.setStartX(this.getWidth()/2); op.setStartY(30);
        op.setEndX(op.getStartX()); op.setEndY(this.getHeight()-90);
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
  
    /*
    public void init()
    {
        
       lbl.setLocation(lbl.getX(), this.getHeight()-70);
       lbl1.setLocation(lbl1.getX(),this.getHeight()-70);
       axe.setStartY(this.getHeight()/2.0);
       axe.setEndY(axe.getStartY());
                           
                 R.setEndY(axe.getStartY()-5);
                            R.setStartY(R.getEndY()-30);
                            
                            
                            R1.setEndY(axe.getStartY()-5);
                            R1.setStartY(R1.getEndY()-30);
                                        
                           
                  
                         f1.setLayoutY(axe.getStartY());
                         double mil=((axe.getEndX()-10)/2.0);
                    
                         f2.setLayoutY(f1.getLayoutY());
              
                         
                 
                          op.setEndY(stg.getHeight()-50);
                          op.setStartY(50);
                       
                       Miroire.setEndY(stg.getHeight()-50);

                         
                      
                        M2.setLayoutY(Miroire.getEndY()+10);
                        
                  
                       
                         arc.setLayoutY(R.getStartY()-22);
                         arc1.setLayoutY(op.getStartY()-4);
                       
                         arc2.setLayoutY(op.getEndY()+4);
                       
                         R2.setStartY(axe.getEndY());
                         R2.setEndY(axe.getEndY()+75);
                 
                         arc3.setLayoutY(R2.getEndY()-7);
                         arc4.setLayoutY(R1.getStartY()-22);
                       /////
                            
                            axe.setEndX(stg.getWidth()-10);
                            
                       
                         
                         f1.setLayoutX(mil-20);
                         f2.setLayoutX(mil+20);
                         
                          op.setStartX(mil);
                          op.setEndX(mil);
                       
                         Miroire.setStartX(mil);
                         Miroire.setEndX(mil);
                         
                         
                       
                        M1.setLayoutX(Miroire.getStartX()-8);
                        M2.setLayoutX(Miroire.getStartX()-8);
                        
                 
                        
                       
                         arc1.setLayoutX(mil);
                         arc2.setLayoutX(mil);
                    
                       
                     
                         R2.setStartX(mil+150);
                         R2.setEndX(mil+150);
                         arc3.setLayoutX(R2.getStartX()-1);
                         
      ////////////////////////
      
      f1.setLayoutX(op.getStartX()-30);
      f2.setLayoutX(op.getStartX()+30);
      R.setStartX(op.getStartX()-60);
      R.setEndX(op.getStartX()-60);
      R1.setStartX(op.getStartX()-30);
      R1.setEndX(op.getStartX()-30);
      arc.setLayoutX(R.getEndX()-1);
      arc4.setLayoutX(R1.getEndX()+9);
      
      cdc.SetSliderWidth(stg.getWidth());
      cdc.SetSliderHeight(stg.getHeight());
      
      
      SetVisible(false);
    }
    */
}
