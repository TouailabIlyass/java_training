package pfe2;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Control implements Initializable{

   
    @FXML private  Line R,R2,axe,op,l,l3,l4,l5,l7,Miroire,M1,M2;
    @FXML private  Pane pan,pn;
    @FXML private  Circle f1,f2;
    @FXML private Arc arc,arc1,arc2,arc3;
    @FXML private JFXHamburger hamburger;
    @FXML private JFXDrawer drawer;
    @FXML private ImageView img;
    @FXML private Label lbl,lbl1,lbl2;
     private static Stage stg ;
     static private double OldWidth,OldHeight;
     static private String source="axe";
     private HamburgerBackArrowBasicTransition hamb;
     private ContainerDrawerControlle cdc;
     private FXMLLoader load ;
   
   @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
            
           
             load =new FXMLLoader();
            load.setLocation(getClass().getResource("ContainerDrawer.fxml"));
        try {
            load.load();
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
            pn=load.getRoot();
            drawer.setSidePane(pn);
                  cdc=load.getController();
	hamb = new HamburgerBackArrowBasicTransition(hamburger);
        hamb.setRate(-1);
		//stg= new Stage();
              
        try {
            Lire();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
              
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
        if(x<=op.getStartX() && x>= axe.getStartX() && (cdc.isConvergente() || !cdc.isConvergente()))
                {
                R.setStartX(x);R.setEndX(x);
                arc.setLayoutX(x-1);
                }
        else if(cdc.isMiroireConcave() && x>=axe.getStartX() && x <=axe.getEndX())
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
    		f1.setLayoutX(x); x=op.getStartX()-x;
    		f2.setLayoutX(op.getStartX()+x);
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
		//Dessin();
		//Calculer();
              // hamburger.setLayoutX(stg.getWidth()-54);
		}

	
        
		
		
		
private void Dessin()
		   {  
			if(OldWidth!=stg.getWidth() || OldHeight!=stg.getHeight())
			{    
			
				
			axe.setEndX(pan.getWidth()-10);
			axe.setStartY(pan.getHeight()/2);
			axe.setEndY(axe.getStartY());
			op.setStartX(((axe.getEndX()-axe.getStartX())/2));
			op.setEndX(op.getStartX());
			op.setEndY(pan.getHeight()-94);
			arc1.setLayoutX(op.getStartX()-1);
			arc2.setLayoutX(op.getEndX()+1);
			arc2.setLayoutY(op.getEndY()+9);
			R.setEndY(axe.getStartY()-5);
			f1.setLayoutY(axe.getStartY()); f2.setLayoutY(axe.getStartY());
                        double mil=((axe.getEndX()-10)/2.0);
                        f1.setLayoutX(mil-20);f2.setLayoutX(mil+20);
			R2.setStartY(axe.getStartY());
			arc3.setLayoutY(R2.getLayoutY()+68);
			arc3.setLayoutX(R2.getLayoutX()-1);
		        OldWidth=stg.getWidth();OldHeight=stg.getHeight();
                        
			img.setFitHeight(OldHeight);
                        img.setFitWidth(OldWidth);
		
			}
                       
                       
		}

public void Calculer()
{     
	 
     
          if(cdc.isConvergente())
          {     
             
    
	      if(f1.getLayoutX()>R.getStartX())
	         {  if(!l.isVisible())
			    	{
                                    SetVisible(true);
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
     double mil=((axe.getEndX()-10)/2.0);
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
        dist=1;
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
     double OA=mil-R.getStartX();
     double OB=mil-f1.getLayoutX();
             // System.out.println("OA = "+OA);
             // System.out.println("OB = "+OB);
               
               //double dist2;
           // dist2 = Math.pow(((1/OA)+(1/OB)),-1);
         //  dist2 = Math.pow((1/OA),-1);
          // dist2 += Math.pow((1/OB),-1);
                //dist2 = (OA+OB);
             // System.out.println("dist = "+dist2);
             double cm=0.026458333;
               lbl.setText(" "+((mil-R.getStartX())*cm)+" cm");
               lbl1.setText("foyer "+((mil-f1.getLayoutX())*cm)+" cm");
               lbl2.setText("X : "+((op.getStartX()-R2.getStartX())*cm)+" cm");
    R2.setStartX(l5.getEndX());R2.setEndX(l5.getEndX());
    R2.setEndY(l7.getEndY()-10);
    arc3.setLayoutX(R2.getStartX()-1);
    arc3.setLayoutY(l7.getEndY()-26);
    R2.setVisible(true);arc3.setVisible(true);
          
   //R2.setStartX(mil+dist2);R2.setEndX(mil+dist2);
     
 	}
 	else 
              SetVisible(false);
 		
 	  }
          else if(!cdc.isConvergente())
          {  
               l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
              l3.setEndX(op.getStartX());l3.setEndY(l3.getStartY());
              l5.setStartX(l3.getEndX());
              l5.setStartY(l3.getEndY());
              l5.setEndX(f1.getLayoutX());
              l5.setEndY(f1.getLayoutY());
              l7.setVisible(false);
              l.setVisible(false);
             R2.setVisible(false);
             arc3.setVisible(false);
           
              double mil=((axe.getEndX()-10)/2.0);
               l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
               l4.setEndX(mil);l4.setEndY(axe.getStartY());
          }
          else if(cdc.isMiroireConcave())
          {
              Miroire.setLayoutX(((axe.getEndX()-axe.getStartX())/2));
             // Miroire.setEndX(Miroire.getStartX());
            l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
            l3.setEndX(Miroire.getLayoutX());l3.setEndY(l3.getStartY());
            l.setStartX(l3.getEndX());l.setStartY(l3.getEndY());
            l.setEndX(f1.getLayoutX());l.setEndY(f1.getLayoutY());
            
              
              
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
                
                System.out.println("sourcttttttttttttt"+e.getSource());
            }
       

    }
  
    public  void ChangeC(String s) throws JDOMException, IOException
    {   
        
        
        for (Node elem : pan.getChildren()) {
            
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
                Enregistrer(source, s);
                break;
            }
            }
           
        }
 
    }

    
    public void ChangeOP(int x)
    {  
            arc1.setRotate(x);
            arc2.setRotate(x);
        
        
    }
    
    private void Enregistrer(String element,String Couleur) throws JDOMException, IOException
    {
        SAXBuilder sax= new SAXBuilder();
        Document doc=sax.build(new File("/home/kingdragon/Desktop/NetBeansProjects/pfe2/src/pfe2/save.xml"));
        Element racine = doc.getRootElement();
        Element elm = new Element("Objet");
         List l =racine.getChildren();
         Iterator i=l.iterator();
         
         while(i.hasNext())
         {
             elm= (Element) i.next();
             System.out.println("Enregistrer()"+elm.getAttribute("id").getValue());
             if(elm.getAttribute("id").getValue().equals(element))
             {
                 elm.setAttribute("couleur", Couleur);
             }
         }
         XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
         sortie.output(doc, new FileOutputStream("/home/kingdragon/Desktop/NetBeansProjects/pfe2/src/pfe2/save.xml"));
        
    }
    private void Lire() throws JDOMException, IOException
    { 
         SAXBuilder sax= new SAXBuilder();
        Document doc=sax.build(new File("/home/kingdragon/Desktop/NetBeansProjects/pfe2/src/pfe2/save.xml"));
        Element racine = doc.getRootElement();
        Element elm = new Element("Objet");
         List list =racine.getChildren();
         Iterator i=list.iterator();
         
         while(i.hasNext())
         {
             elm= (Element) i.next();
             if(elm.getAttribute("class").getValue().equals("line"))
             {   
                Line l= (Line) pan.lookup("#"+elm.getAttribute("id").getValue());
                 l.setStroke(Paint.valueOf(elm.getAttribute("couleur").getValue()));
             }
           else if(elm.getAttribute("class").getValue().equals("cercle"))
             {   
                Circle c= (Circle) pan.lookup("#"+elm.getAttribute("id").getValue());
                 c.setFill(Paint.valueOf(elm.getAttribute("couleur").getValue()));
             }
         }
        
    }
    public void ChangeToMiroire()
    {
        op.setVisible(false);
        arc1.setVisible(false);
        arc2.setVisible(false);
        arc3.setVisible(false);
        R2.setVisible(false);
        Miroire.setVisible(true);
        M1.setVisible(true);
        M2.setVisible(true);
    }
      public void ChangeToLentille()
    {
        op.setVisible(true);
        arc1.setVisible(true);
        arc2.setVisible(true);
        arc3.setVisible(true);
        R2.setVisible(true);
        Miroire.setVisible(false);
        M1.setVisible(false);
        M2.setVisible(false);
    }
      
      public void SetVisible(boolean b)
      {
             for (Node elem : pan.getChildren()) {
                  if(elem.getClass().getSimpleName().equals("Line")&& elem.getId().contains("l"))
                { 
                    elem.setVisible(b);
                    
                     
                }
            }
            
      }
      public void ChangeWidth(double w)
      {
          stg.setWidth(w);
      }
      public void ChangeHeight(double h)
      {
          stg.setHeight(h);
      }
 
}
