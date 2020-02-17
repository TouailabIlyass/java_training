package pfe2;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Control implements Initializable{

    @FXML
    public  Line R,R2,axe,op,l,l3,l4,l5,l7;
    @FXML
    private  Pane pan;
    private static Pane p;
    @FXML
    private  Circle f1,f2;
    @FXML
    private Arc arc,arc1,arc2,arc3;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private JFXDrawer drawer;

    private static Stage stg ;
   static private double OldWidth,OldHeight;
static private String source="axe";
private HamburgerBackArrowBasicTransition hamb;


   
   @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
            
            Pane pn;
        try {
            pn = FXMLLoader.load(getClass().getResource("ContainerDrawer.fxml"));
            drawer.setSidePane(pn);
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
	hamb = new HamburgerBackArrowBasicTransition(hamburger);
        hamb.setRate(-1);
		stg= new Stage();
               p=pan;
	}
   @FXML
   private void ClickHamburger(MouseEvent e){
       
  hamb.setRate(hamb.getRate()*-1);
  hamb.play();
  
  if(drawer.isShown())
  {   drawer.toBack();
      drawer.close();
  
  }else{
      drawer.open();
      drawer.toFront();
     
  }
    }

    @FXML
   private void ClickDragged(MouseEvent e) {
    	Calculer();
    	
    	double x;
    	if (R.getCursor()==Cursor.H_RESIZE)
    	{ x=e.getSceneX();
        if(x<=op.getStartX() && x>= axe.getStartX())
                {
                R.setStartX(x);R.setEndX(x);
                arc.setLayoutX(x-1);
                }
    	}
    	else if(arc.getCursor()==Cursor.V_RESIZE)
    	{   
    		x=e.getSceneY();
                if(x>=op.getStartY() && x<= (axe.getStartY()-20))
                {
    		R.setStartY(x);
        	arc.setLayoutY(x-15);
                }
        }
    	
    	else
    	{   x=e.getSceneX();
        if(x<=op.getStartX() && x>= axe.getStartX())
        {
    		f1.setLayoutX(x);
    		f2.setLayoutX(axe.getEndX()+axe.getStartX()-x);
        }
    	}
     
}
    	
 

    @FXML
  private  void Hover(MouseEvent e) {
       
    	if(e.getSource()==R )
    	{
    		R.setCursor(Cursor.H_RESIZE);
    		f1.setCursor(Cursor.DEFAULT);
    		arc.setCursor(Cursor.DEFAULT);
    	}
    		
    	else if(e.getSource()==arc)
    	{
    		arc.setCursor(Cursor.V_RESIZE);
    		R.setCursor(Cursor.DEFAULT);
    		f1.setCursor(Cursor.DEFAULT);
    	}
        else if(e.getSource()==f1)
    	{  
    		f1.setCursor(Cursor.H_RESIZE);
    		R.setCursor(Cursor.DEFAULT);
    		arc.setCursor(Cursor.DEFAULT);
    		
    	}
    		
    	
    }
 public static  void setStage(Stage s)
		{ 
			stg=s;
			OldWidth=stg.getWidth();
		    OldHeight=stg.getHeight();
                    System.out.println("pfe.Control.setStage()");
		}

        
		@FXML
		private void fen(MouseEvent e) {
		Dessin();
		Calculer();
               hamburger.setLayoutX(stg.getWidth()-54);
		}

	
        
		
		
		
private void Dessin()
		   {  
			if(OldWidth!=stg.getWidth() || OldHeight!=stg.getHeight())
			{    
			
				
			axe.setEndX(pan.getWidth()-10);
			axe.setStartY(pan.getHeight()/2);
			axe.setEndY(axe.getStartY());
			op.setStartX(((axe.getEndX()-axe.getStartX())/2)+10.0);
			op.setEndX(op.getStartX());
			op.setEndY(pan.getHeight()-94);
			arc1.setLayoutX(op.getStartX()-1);
			arc2.setLayoutX(op.getEndX()+1);
			arc2.setLayoutY(op.getEndY()+9);
			R.setEndY(axe.getStartY()-5);
			f1.setLayoutY(axe.getStartY()); f2.setLayoutY(axe.getStartY());
			R2.setStartY(axe.getStartY());
			arc3.setLayoutY(R2.getLayoutY()+68);
			arc3.setLayoutX(R2.getLayoutX()-1);
		        OldWidth=stg.getWidth();OldHeight=stg.getHeight();
                        
			
		
			}
                       
                       
		}

private void Calculer()
{
	
	if(f1.getLayoutX()>R.getStartX())
	   {            if(!l.isVisible())
			    	{
			    	for (Node elem : pan.getChildren()) {
                  if(elem.getClass().getSimpleName().equals("Line")&& elem.getId().contains("l"))
                { 
                    elem.setVisible(true);
                    
                     
                }
			    	}
                                }
 		l.setStartX(arc.getLayoutX());l.setStartY(arc.getLayoutY());
     	l.setEndX(f1.getLayoutX());l.setEndY(f1.getLayoutY());
 	
 	

 	double angle1 = Math.atan2(l.getStartY() - l.getEndY(), l.getStartX() - l.getEndX());
     double angle2 = Math.atan2(-axe.getStartY() + axe.getEndY(), -axe.getStartX() + axe.getEndX());

     double angle =((angle1 - angle2 ) * (180 / Math.PI)) + 180;

   
     if (angle < 0)
         angle = angle * -1;
     
     angle= (Math.PI / 180.0) * angle;
     int dist=1;
     double y=f1.getLayoutX()+Math.cos(angle)*dist;
   
     while(y<op.getStartX())
     { dist++;
     	y=f1.getLayoutX()+Math.cos(angle)*dist;
     }
     l.setEndX(y);
     l.setEndY(f1.getLayoutY()+Math.sin(angle)*dist);
     /////////////////////////////////////
     double mil=((axe.getEndX()-10)/2)+10;
      l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
        l4.setEndX(mil);l4.setEndY(axe.getStartY());
     l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
        l3.setEndX(op.getStartX());l3.setEndY(l3.getStartY());
      angle1 = Math.atan2(l4.getStartY() - l4.getEndY(), l4.getStartX() - l4.getEndX());
     angle2 = Math.atan2(-axe.getStartY() + axe.getEndY(), -axe.getStartX() + axe.getEndX());

      angle =((angle1 - angle2 ) * (180 / Math.PI)) + 180;

   
     if (angle < 0)
         angle = angle * -1;
     
     angle= (Math.PI / 180.0) * angle;
     
    l7.setStartX(l.getEndX());l7.setStartY(l.getEndY());
        l7.setEndX(axe.getEndX());l7.setEndY(l7.getStartY());
        l5.setStartX(l3.getEndX());l5.setStartY(l3.getEndY());
        l5.setEndX(f2.getLayoutX());l5.setEndY(f2.getLayoutY());
        y=l4.getEndY()+Math.sin(angle)*dist;
   
     while(y<l7.getEndY())
     { dist++;
     	     y=l4.getEndY()+Math.sin(angle)*dist;

     }
     
     l4.setEndX(mil+Math.cos(angle)*dist);
     l4.setEndY(y);
    
     angle1 = Math.atan2(l5.getStartY() - l5.getEndY(), l5.getStartX() - l5.getEndX());
     angle2 = Math.atan2(-axe.getStartY() + axe.getEndY(), -axe.getStartX() + axe.getEndX());

      angle =((angle1 - angle2 ) * (180 / Math.PI)) + 180;

   
     if (angle < 0)
         angle = angle * -1;
     
     angle= (Math.PI / 180.0) * angle;
     dist=1;
     y=l5.getEndY()+Math.sin(angle)*dist;
   
     while(y<l7.getEndY())
     { dist++;
     	     y=l5.getEndY()+Math.sin(angle)*dist;

     }
     
     l5.setEndX(l5.getEndX()+Math.cos(angle)*dist);
     l5.setEndY(y);
     
    R2.setStartX(l5.getEndX());R2.setEndX(l5.getEndX());
    R2.setEndY(l7.getEndY()-10);
    arc3.setLayoutX(R2.getStartX()-1);
    arc3.setLayoutY(l7.getEndY()-26);
    R2.setVisible(true);arc3.setVisible(true);
          
 	}
 	else 
            
 	          for (Node elem : pan.getChildren()) {
                  if(elem.getClass().getSimpleName().equals("Line")&& elem.getId().contains("l"))
                { 
                    elem.setVisible(false);
                    
                     
                }
            }
 		
 	
         
       
       
        

}


  @FXML
  private  void ClickBtn(MouseEvent e) throws IOException  {
      
       if(e.getClickCount() == 2){
               Parent vue = FXMLLoader.load(getClass().getResource("Vue.fxml"));
               Scene scene = new Scene(vue);
                Stage stage = new Stage();
                stage.setScene(scene);  
                stage.show();
                source=String.valueOf(e.getSource());
                source=source.substring(source.indexOf("=")+1,source.indexOf(","));
                
            }
       

    }

  
  public static String getS()
  {
      return source;
  }
  

  
  
    public static void ChangeC(String s)
    {   
        
        
        for (Node elem : p.getChildren()) {
            
            System.out.println(elem.getAccessibleText());
            if(elem.getAccessibleText()!=null)
            {
                 if(elem.getAccessibleText().equals(source))
            {
                if(elem.getClass().getSimpleName().equals("Line") )
                { 
                    Line l =(Line)elem;
                     l.setStroke(Paint.valueOf(s));
            
                    
                
                }else
                {
                    Circle c=(Circle)elem;
                    c.setFill(Paint.valueOf(s));
                 
                }
                break;
            }
            }
           
        }
 
    }

 
}
