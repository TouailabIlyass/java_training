package pfe;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXSlider;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Control implements Initializable{

    @FXML
    public  Line R,R2,axe,op;
    @FXML
    private  Pane pan,pan2;
    
    @FXML
    private RadioButton radioOp1,radioOp2;
    @FXML
    private JFXColorPicker color;
    @FXML
    private  Circle f1,f2;
   
    @FXML
    private JFXCheckBox caxe,coptique,cfocal;
    @FXML
    private JFXSlider slide1,slide2;
    @FXML
    private Arc arc,arc1,arc2,arc3;
    private static Stage stg ;
    private  Line l,l2,l3,l4,l5,l6,l7;
   static private double OldWidth,OldHeight;
static private String source="axe";

public static HashMap<String,Object> Mp;
   
   @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		stg= new Stage();
		l = new Line(); 
		l2 = new Line(); 
                l3=new Line();
                l4=new Line();l5=new Line();l6=new Line();l7=new Line();
		pan.getChildren().addAll(l,l2,l3,l4,l5,l6,l7);
		color.setValue(Color.BLUE);
                Mp=new HashMap<>();
                Mp.put("axe", axe);Mp.put("op", op);Mp.put("f1", f1);Mp.put("f2", f2);
                Mp.put("R", R);Mp.put("R2", R);Mp.put("l",l);Mp.put("l2",l2);Mp.put("l3",l3);
                Mp.put("l4",l4);Mp.put("l5",l5);Mp.put("l6",l6);Mp.put("l7",l7);
	}
   

    @FXML
   private void ClickDragged(MouseEvent e) {
    	Calculer();
    	
    	double x;
    	if (R.getCursor()==Cursor.H_RESIZE)
    	{ x=e.getSceneX()-pan2.getWidth();
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
    	{   x=e.getSceneX()-(pan2.getWidth());
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
               
		}

		@FXML
	private void ChangeRadio(ActionEvent e) {
		
			if(e.getSource()==radioOp1)
			{
				arc1.setRotate(0);
				arc2.setRotate(0);
				arc2.setLayoutX(op.getEndX()+1);
			}
			else if(e.getSource()==radioOp2)
			{
				arc1.setRotate(180);
				arc2.setRotate(180);
                                arc2.setLayoutX(arc2.getLayoutX()+2);
			}
			
		}
        
		
		@FXML
	  private   void ChangeColor(ActionEvent e) {
          
			if( caxe.isSelected())
				axe.setStroke(color.getValue());
                         if(coptique.isSelected())
                             op.setStroke(color.getValue());
                         if(cfocal.isSelected()){
                             f1.setFill(color.getValue());
                             f2.setFill(color.getValue());
                         }
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
			arc2.setLayoutX(op.getEndX());
			arc2.setLayoutY(op.getEndY());
			R.setEndY(axe.getStartY()-5);
			f1.setLayoutY(axe.getStartY()); f2.setLayoutY(axe.getStartY());
			R2.setLayoutY(axe.getStartY());
			arc3.setLayoutY(R2.getLayoutY()+68);
			arc3.setLayoutX(R2.getLayoutX()-1);
		        OldWidth=stg.getWidth();OldHeight=stg.getHeight();
                        slide1.setValue(stg.getWidth());
                         slide2.setValue(stg.getHeight());
                         
			
		
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
     int dist=1;
     double y=f1.getLayoutX()+Math.cos(angle)*dist;
   
     while(y<op.getStartX())
     { dist++;
     	y=f1.getLayoutX()+Math.cos(angle)*dist;
     }
     l2.setEndX(y);
     l2.setEndY(f1.getLayoutY()+Math.sin(angle)*dist);
     /////////////////////////////////////
     double mil=((axe.getEndX()-10)/2)+10;
      l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
        l4.setEndX(mil);l4.setEndY(axe.getStartY());
     l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
        l3.setEndX(op.getStartX());l3.setEndY(l3.getStartY());
     double angle3 = Math.atan2(l4.getStartY() - l4.getEndY(), l4.getStartX() - l4.getEndX());
     double angle4 = Math.atan2(-axe.getStartY() + axe.getEndY(), -axe.getStartX() + axe.getEndX());

     double angle5 =((angle3 - angle4 ) * (180 / Math.PI)) + 180;

   
     if (angle5 < 0)
         angle5 = angle5 * -1;
     
     angle5= (Math.PI / 180.0) * angle5;
     
     dist=500;
l5.setStartX(l3.getEndX());l5.setStartY(l3.getEndY());
        l5.setEndX(f2.getLayoutX());l5.setEndY(f2.getLayoutY());
     l6.setStartX(l4.getEndX());l6.setStartY(l4.getEndY());
     y=l6.getEndX()+Math.cos(angle5)*dist;
   
     /*while(y<l7.getEndX())
     { dist++;
     	     y=l6.getEndX()+Math.cos(angle5)*dist;

     }
     */
     
     l6.setEndX(y);
     l6.setEndY(mil+Math.sin(angle5)*dist);
     
     
     ////////////////////
          
 	}
 	else{ 
 		l2.setVisible(false);l.setVisible(false);
 		
 	}
         double mil=((axe.getEndX()-10)/2)+10;
        l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
        l3.setEndX(op.getStartX());l3.setEndY(l3.getStartY());
        l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
        l4.setEndX(mil);l4.setEndY(axe.getStartY());
        
        l5.setStartX(l3.getEndX());l5.setStartY(l3.getEndY());
        l5.setEndX(f2.getLayoutX());l5.setEndY(f2.getLayoutY());
        l7.setStartX(l2.getEndX());l7.setStartY(l2.getEndY());
        l7.setEndX(axe.getEndX());l7.setEndY(l7.getStartY());
       
       
        
      double OA=mil-(R.getStartX());
        double OF=mil-(f1.getLayoutX());
        double pos=Math.pow((1/OA)+(1/OF),-1);
	  /* System.out.println("OA = "+(mil-R.getStartX()));
           System.out.println("OF = "+(mil-f1.getLayoutX()));
                System.out.println("POs = "+pos);
                R2.setStartX(mil+pos);R2.setEndX(mil+pos);
                arc3.setLayoutX(R2.getStartX()-1);
                System.out.println("**********");
                System.out.println("R = "+(mil-R.getStartX()));
                System.out.println("f1 = "+(mil-f1.getLayoutX()));
                System.out.println("pfe.Control.Calculer()");
*/
}

@FXML
  private  void ChangeSize(MouseEvent e) {
         if(e.getSource()==slide1)
            stg.setWidth(slide1.getValue());
         else
             stg.setHeight(slide2.getValue());
        
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
        if(source.equals("axe"))
        {
            Line l =(Line)Mp.get("axe");
            l.setStroke(Paint.valueOf(s));
            
        }
        else if(source.equals("f1"))
        {
            Circle c=(Circle)Mp.get("f1");
            c.setFill(Paint.valueOf(s));
            c=(Circle)Mp.get("f2");
            c.setFill(Paint.valueOf(s));
        }
        else if(source.equals("op"))
        {
            Line l =(Line)Mp.get("op");
            l.setStroke(Paint.valueOf(s));
        }
    }
 
}
