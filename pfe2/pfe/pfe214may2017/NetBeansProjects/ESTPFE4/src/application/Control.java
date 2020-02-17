package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Control implements Initializable{
	@FXML
    private GridPane B;
    @FXML
    private Line R,R2,axe,op;
    @FXML
    private Pane pan,pan2;
    @FXML
    private RadioButton radioOp1,radioOp2;
    @FXML
    private ColorPicker color;
    @FXML
    private Circle f1,f2;
    @FXML
    private CheckBox caxe;
    @FXML
    private Slider slide;
    @FXML
    private Arc arc,arc1,arc2,arc3;
    private static Stage stg ;
    private Line l;
    private  Line l2;
   static private double OldWidth,OldHeight;
     private double p=300;
   
   @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		stg= new Stage();
		l = new Line(); 
		l2 = new Line(); 
		pan.getChildren().addAll(l,l2);
		
	}
   

    @FXML
   private void ClickDragged(MouseEvent e) {
    	Calculer();
    	
    	double x;
    	if (R.getCursor()==Cursor.H_RESIZE)
    	{ x=e.getSceneX()-pan2.getWidth();
    	R.setStartX(x);R.setEndX(x);
    	arc.setLayoutX(x-1);
    	
    	}
    	else if(arc.getCursor()==Cursor.V_RESIZE)
    	{ 
    		x=e.getSceneY();
    		if(x>261) return;
    		R.setStartY(x);
        	arc.setLayoutY(x-15);
    		
        }
    	
    	else
    	{   x=e.getSceneX()-pan2.getWidth();
    		f1.setLayoutX(x);
    		f2.setLayoutX(axe.getEndX()-x);
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
    	else
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
		    
	
		}
    
		@FXML
		private void fen(MouseEvent event) {
		Dessin();
		Calculer();
		}

		@FXML
	private void ChangeRadio(ActionEvent e) {
		
			if(e.getSource()==radioOp1)
			{
				arc1.setRotate(0);
				arc2.setRotate(0);
				
			}
			else if(e.getSource()==radioOp2)
			{
				arc1.setRotate(180);
				arc2.setRotate(180);
			}
			
		}
		
		
		@FXML
	  private   void ChangeColor(ActionEvent e) {
          
			if( caxe.isSelected())
			{ 
				axe.setStroke(color.getValue());
			}
	    }
		
private void Dessin()
		   {   
			if(OldWidth!=stg.getWidth() || OldHeight!=stg.getHeight())
			{    
				
				p=axe.getEndX()/2;
			axe.setEndX(pan.getWidth()-10);
			axe.setStartY(pan.getHeight()/2);
			axe.setEndY(axe.getStartY());
			op.setStartX(pan.getWidth()/2);
			op.setEndX(pan.getWidth()/2);
			op.setEndY(pan.getHeight()-94);
			arc1.setLayoutX(op.getStartX()-1);
			arc2.setLayoutX(op.getEndX());
			arc2.setLayoutY(op.getEndY());
			R.setEndY(axe.getStartY());
			f1.setLayoutY(axe.getStartY()); f2.setLayoutY(axe.getStartY());
			R2.setLayoutY(axe.getStartY());
			arc3.setLayoutY(R2.getLayoutY()+68);
			arc3.setLayoutX(R2.getLayoutX()-1);
			OldWidth=stg.getWidth();OldHeight=stg.getHeight();
			if(OldWidth> stg.getWidth())
			{
				f1.setLayoutX(f1.getLayoutX()-(p-(axe.getEndX()/2)));
				System.out.println("f1x "+f1.getLayoutX());
				System.out.println("pan "+p);
				System.out.println("axe "+(axe.getEndX()/2)+"***************\n");
			}
			else
				f1.setLayoutX(f1.getLayoutX()+(p-(axe.getEndX()/2)));

			
			}
		}

private void Calculer()
{
	
	if(f1.getLayoutX()>R.getStartX())
	   {            if(!l.isVisible())
			    	{
			    		l.setVisible(true);l2.setVisible(true);
			    	}
 		l.setStartX(arc.getLayoutX());l.setStartY(arc.getLayoutY());
     	l.setEndX(f1.getLayoutX());l.setEndY(f1.getLayoutY());
 	
 	l2.setStartX(f1.getLayoutX());l2.setStartY(f1.getLayoutY());

 	double angle1 = Math.atan2(l.getStartY() - l.getEndY(), l.getStartX() - l.getEndX());
     double angle2 = Math.atan2(-axe.getStartY() + axe.getEndY(), -axe.getStartX() + axe.getEndX());

     double angle =((angle1 - angle2 ) * (180 / Math.PI)) + 180;

   
     if (angle < 0)
         angle = angle * -1;
     
     angle= (Math.PI / 180.0) * angle;
     int dist=500;
     double y=f1.getLayoutX()+Math.cos(angle)*dist;
   
     while(y>op.getStartX())
     { dist--;
     	y=f1.getLayoutX()+Math.cos(angle)*dist;
     }
     l2.setEndX(y);
     l2.setEndY(f1.getLayoutY()+Math.sin(angle)*dist);
 	}
 	else{ 
 		l2.setVisible(false);l.setVisible(false);
 		
 	}
	
}


}
