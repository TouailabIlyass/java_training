package pfe2;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.awt.Point;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
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

   
    @FXML private  Line R,R2,axe,op,l,l3,l4,l5,l7,Miroire,M1,M2,l8,R1,l9;
    @FXML private  Pane pan,pn;
    @FXML private  Circle f1,f2;
    @FXML private Arc arc,arc1,arc2,arc3,arc4;
    @FXML private JFXHamburger hamburger;
    @FXML private JFXDrawer drawer;
    @FXML private ImageView img;
    @FXML private Label lbl,lbl1,lbl2;
     private static Stage stg ;
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
            System.out.println(ex.getMessage());
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
    	
    	
    	double x;
    	if (R.getCursor()==Cursor.H_RESIZE)
    	{ x=e.getSceneX();
        if((cdc.isConvergente() || !cdc.isConvergente()) && x<=op.getStartX() && x>= axe.getStartX())
                {
                R.setStartX(x);R.setEndX(x);
                arc.setLayoutX(x-1);
                }
      
        else if((cdc.isMiroireConcave() || cdc.isMiroireConvexe()) && x>=axe.getStartX() && x <=axe.getEndX())
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
        if( (cdc.isConvergente() || cdc.isDivergente()) && x<=op.getStartX() && x>= axe.getStartX() )
        {
    		f1.setLayoutX(x); x=op.getStartX()-x;
               // if((cdc.isConvergente() || cdc.isDivergente()))
    		f2.setLayoutX(op.getStartX()+x);
        }
        else if(cdc.isMiroireConcave() && x<=Miroire.getStartX() && x>= (Miroire.getStartX()/2))
        {
            f1.setLayoutX(x); x=op.getStartX()-x;
        }
        else if(cdc.isMiroireConvexe() && x<=(axe.getEndX()-Miroire.getStartX())+(Miroire.getStartX()/2) && x>= (Miroire.getStartX()/2)){
            
            f1.setLayoutX(x); x=op.getStartX()-x;
        }
      
    	}
     
       Calculer(); 
        
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
 }

public void Calculer()
{     
          if(cdc.isConvergente())
          {   
 		DrawConvergente();
 	  }
          else if(cdc.isDivergente())
          {  
               DrawDivergente();
          }
          else if(cdc.isMiroireConcave())
          {  
              DrawMiroireConcave();
          }
          else if(cdc.isMiroireConvexe())
          {     
              DrawMiroireConvexe();
              
          }


  }

 public static Point lineIntersect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
  double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
  if (denom == 0.0) { // Lines are parallel.
     return null;
  }
  double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3))/denom;
  double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3))/denom;
    if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {
        
        return new Point((int) (x1 + ua*(x2 - x1)), (int) (y1 + ua*(y2 - y1)));
    }

  return null;
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
             R2.setVisible(b);arc3.setVisible(b);
            
      }
      public void ChangeWidth(double w)
      {
          stg.setWidth(w);
      }
      public void ChangeHeight(double h)
      {
          stg.setHeight(h);
      }
      
      private void CalculDistance(Line l1,Line l2,double start,double end,double d,boolean flag)
      {
          int dist=1;
           double angle1 = Math.atan2(l1.getStartY() - l1.getEndY(), l1.getStartX() - l1.getEndX());
     double angle2 = Math.atan2(-l2.getStartY() + l2.getEndY(), -l2.getStartX() + l2.getEndX());

     double angle =((angle1 - angle2 ) * (180 / Math.PI)) + 180;

   
     if (angle < 0)
         angle = angle * -1;
     
     angle= (Math.PI / 180.0) * angle;
    double y;
     if(flag)
     {
           y=start+Math.cos(angle)*dist;
   
                while(y<end)
                { dist++;
                   y=start+Math.cos(angle)*dist;

                }
    
     l1.setEndX(y);
     l1.setEndY(d+Math.sin(angle)*dist);
                
                return;
     }
     
     y=start+Math.sin(angle)*dist;
   
                while(y<end)
                { dist++;
                   y=start+Math.sin(angle)*dist;

                }
     
     l1.setEndX(d+Math.cos(angle)*dist);
     l1.setEndY(y);
          
       
      }
      
      
  public void Init()
  {
      f1.setLayoutX(op.getStartX()-30);
      f2.setLayoutX(op.getStartX()+30);
      R.setStartX(op.getStartX()-60);
      R.setEndX(op.getStartX()-60);
      arc.setLayoutX(R.getEndX()-1);
      SetVisible(false);
  }
  
  
  private void DrawConvergente()
  {
        
             
    
	      if(f1.getLayoutX()>R.getStartX())
	         {  if(!l.isVisible())
			    	{
                                    SetVisible(true);
                                }
 		l.setStartX(arc.getLayoutX());l.setStartY(arc.getLayoutY());
     	        l.setEndX(f1.getLayoutX());l.setEndY(f1.getLayoutY());
 	
 
                  CalculDistance(l, axe, f1.getLayoutX(), op.getStartX(),f1.getLayoutY(),true);
    
     /////////////////////////////////////
     double mil=((axe.getEndX()-10)/2.0);
      l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
       l4.setEndX(mil);l4.setEndY(axe.getStartY());
     l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
        l3.setEndX(op.getStartX());l3.setEndY(l3.getStartY());
     
 
     
    l7.setStartX(l.getEndX());l7.setStartY(l.getEndY());
        l7.setEndX(axe.getEndX());l7.setEndY(l7.getStartY());
        l5.setStartX(l3.getEndX());l5.setStartY(l3.getEndY());
        l5.setEndX(f2.getLayoutX());l5.setEndY(f2.getLayoutY());
 
  CalculDistance(l4, axe, l4.getEndY(), l7.getEndY(), l4.getEndX(), false);
 
 CalculDistance(l5, axe, l5.getEndY(), l7.getEndY(), l5.getEndX(), false);

           
             double cm=0.026458333;
               lbl.setText(" "+((mil-R.getStartX())*cm)+" cm");
               lbl1.setText("foyer "+((mil-f1.getLayoutX())*cm)+" cm");
           
    R2.setStartX(l5.getEndX());R2.setEndX(l5.getEndX());
    R2.setEndY(l7.getEndY()-10);
    arc3.setLayoutX(R2.getStartX()-1);
    arc3.setLayoutY(l7.getEndY()-26);

     
 	}
 	else 
              SetVisible(false);
  }
  
  private void DrawDivergente()
  {
              l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
              l3.setEndX(op.getStartX());l3.setEndY(l3.getStartY());
              l5.setStartX(l3.getEndX());l5.setStartY(l3.getEndY());
              l5.setEndX(f1.getLayoutX());l5.setEndY(f1.getLayoutY());
              l7.setVisible(false);
              l.setVisible(false);
             R2.setVisible(false);
             arc3.setVisible(false);
           
              double mil=((axe.getEndX()-10)/2.0);
               l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
               l4.setEndX(mil);l4.setEndY(axe.getStartY());
  }
  
  private void DrawMiroireConcave()
  {
             SetVisible(true);
              l8.setVisible(true);
              l9.setVisible(true);
              if(R.getStartX()<f1.getLayoutX())
              {double mil=((axe.getEndX()-10)/2.0);
                  double c=(2*f1.getLayoutX());
              f2.setLayoutX(c-mil);
             
            l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
            l3.setEndX(mil);l3.setEndY(l3.getStartY());
            l.setStartX(l3.getStartX());l.setStartY(l3.getStartY());
            l.setEndX(f1.getLayoutX());l.setEndY(f1.getLayoutY());
            
            
            l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
            l4.setEndX(mil);l4.setEndY(axe.getStartY());
            l8.setStartX(l3.getEndX());l8.setStartY(l3.getEndY());
            l8.setEndX(f1.getLayoutX());l8.setEndY(f1.getLayoutY());
             CalculDistance(l, axe, f1.getLayoutX(), mil, f1.getLayoutY(), true);
              
              l7.setStartX(l.getEndX()); l7.setStartY(l.getEndY());
              l7.setEndX(l7.getStartX());l7.setEndY(l7.getStartY());
              
          while(l7.getEndX()>R.getEndX())
          {
              l7.setEndX(l7.getEndX()-1);
          }
          CalculDistance(l8, axe, f1.getLayoutY(), l7.getEndY(), f1.getLayoutX(), false);

     
    R2.setStartX(l8.getEndX());R2.setEndX(l8.getEndX());
    R2.setEndY(l7.getEndY()-10);
    arc3.setLayoutX(R2.getStartX()-1);
    arc3.setLayoutY(l7.getEndY()-26);
    
      
      
        
             
        l5.setStartX(arc.getLayoutX());l5.setStartY(arc.getLayoutY());
        l5.setEndX(l8.getEndX()); l5.setEndY(l8.getEndY());
        
         l9.setStartX(l4.getEndX());l9.setStartY(l4.getEndY());
         l9.setEndX(l8.getEndX());l9.setEndY(l8.getEndY());
         l9.setStroke(l4.getStroke());
         l7.setStroke(l.getStroke());
         l8.setStroke(l3.getStroke());
              
          }else if(R.getEndX()>Miroire.getStartX())
          {
              R2.setVisible(false);
              arc3.setVisible(false);
              R1.setVisible(true);
              arc4.setVisible(true);
              double mil=((axe.getEndX()-10)/2.0);
              l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
              l3.setEndX(mil);l3.setEndY(l3.getStartY());
              
              
              
              double c=(2*f1.getLayoutX());
              f2.setLayoutX(c-mil);
              
              System.out.println(c-mil);
              
              l5.setStartX(arc.getLayoutX());l5.setStartY(arc.getLayoutY());
              l5.setEndX(f2.getLayoutX());l5.setEndY(f2.getLayoutY());
              
               l.setStartX(arc.getLayoutX());l.setStartY(arc.getLayoutY());
               l.setEndX(f1.getLayoutX());l.setEndY(f1.getLayoutY());
                double x,y;
                for(x=mil,y=mil;!l.contains(x,y);y--);
               
             
                
                l9.setStartX(x);l9.setStartY(y);
                
               for(x=l9.getStartX(),y=l9.getStartY();!l5.contains(x,y);x--);
           
                l9.setEndX(x);l9.setEndY(y);
                
                

                arc4.setLayoutX(x);
                arc4.setLayoutY(y);
                R1.setStartX(arc4.getLayoutX()-10);R1.setStartY(arc4.getLayoutY()+15);
                R1.setEndX(arc4.getLayoutX()-10);R1.setEndY(axe.getEndY());
                l8.setStartX(arc4.getLayoutX());l8.setStartY(arc4.getLayoutY());
                l8.setEndX(l3.getEndX());l8.setEndY(l3.getEndY());
                l4.setStartX(arc4.getLayoutX()); l4.setStartY(arc4.getLayoutY());
                l4.setEndX(mil);l4.setEndY(axe.getStartY());

          }
          else if(R.getStartX()<Miroire.getStartX() && R.getStartX()> f1.getLayoutX())
          {
              R2.setVisible(false);
              arc3.setVisible(false);
              R1.setVisible(true);
              arc4.setVisible(true);
              l5.setStartX(f2.getLayoutX());l5.setStartY(f2.getLayoutY());
              l5.setEndX(arc.getLayoutX());l5.setEndY(arc.getLayoutY());
               CalculDistance(l5, axe, arc.getLayoutX(), axe.getEndX(),arc.getLayoutY(),true);
              
               l9.setStartX(arc.getLayoutX());l9.setStartY(arc.getLayoutY());
               l9.setEndX(Miroire.getStartX());l9.setEndY(l9.getStartY());
             
             double mil=((axe.getEndX()-10)/2.0);
//             double x=mil,y=axe.getEndY();
//              for (;!l5.contains(x, y) && x<axe.getEndX(); x++,y--);
                      l.setStartX(f1.getLayoutX());l.setStartY(f1.getLayoutY());
                   // CalculDistance(l, axe, l9.getEndX(), axe.getEndX(),l9.getEndY(),true);
                    l.setStartX(f1.getLayoutX());l.setStartY(f1.getLayoutY());
               l.setEndX(l9.getEndX());l.setEndY(l9.getEndY());
              CalculDistance(l, axe,l.getEndX(),axe.getEndX(), l.getEndY(),true);
                
       Point p=lineIntersect((int)l5.getStartX(),(int)l5.getStartY(),(int)l5.getEndX(),(int)l5.getEndY(),(int)l.getStartX(), (int)l.getStartY(), (int)l.getEndX(), (int)l.getEndY());
           if(p==null){ 
               
           }else
           {
                  l.setEndX(p.x);l.setEndY(p.y);
                  l5.setEndX(p.x);l5.setEndY(p.y);
                 arc4.setLayoutX(p.x);
                  arc4.setLayoutY(p.y);
                R1.setStartX(arc4.getLayoutX()-10);R1.setStartY(arc4.getLayoutY()+15);
                R1.setEndX(arc4.getLayoutX()-10);R1.setEndY(axe.getEndY());
                l3.setStartX(arc4.getLayoutX());l3.setStartY(arc4.getLayoutY());
                l3.setEndX(mil);l3.setEndY(l3.getStartY());
                
                l8.setStartX(arc.getLayoutX());l8.setStartY(arc.getLayoutY());
                l8.setEndX(l3.getEndX());l8.setEndY(l3.getEndY());
                l4.setStartX(arc.getLayoutX()); l4.setStartY(arc.getLayoutY());
                l4.setEndX(mil);l4.setEndY(axe.getStartY());
                
           }
                   
                   
                   
                
             }
      
  }
  
  private void DrawMiroireConvexe()
  {       SetVisible(true);
            double mil=((axe.getEndX()-10)/2.0);
                double c=(2*f1.getLayoutX());
                R2.setVisible(false);
              arc3.setVisible(false);
              R1.setVisible(true);
              arc4.setVisible(true);
                f2.setLayoutX(c-mil);
           if(R.getStartX()<Miroire.getStartX()) 
           {   
                
              l5.setStartX(f2.getLayoutX());l5.setStartY(f2.getLayoutY());
              l5.setEndX(arc.getLayoutX());l5.setEndY(arc.getLayoutY());
              
              l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
              l4.setEndX(mil); l4.setEndY(axe.getStartY());
               l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
               l3.setEndX(mil);l3.setEndY(l3.getStartY());
             CalculDistance(l4, axe, l4.getEndX(), l4.getEndX(), l4.getEndY(), true);
             
             

     
    l.setStartX(l3.getEndX());l.setStartY(l3.getEndY());
    l.setEndX(f1.getLayoutX());l.setEndY(f1.getLayoutY());
    
    //double x=l8.getEndX(),y=l8.getEndY();
            
    Point p=lineIntersect((int)l5.getStartX(),(int)l5.getStartY(),(int)l5.getEndX(),(int)l5.getEndY(),(int)l.getStartX(), (int)l.getStartY(), (int)l.getEndX(), (int)l.getEndY());
           if(p==null){ 
               
           }else
           {
                arc4.setLayoutX(p.x);
                arc4.setLayoutY(p.y);
                R1.setStartX(arc4.getLayoutX()-10);R1.setStartY(arc4.getLayoutY()+15);
                R1.setEndX(arc4.getLayoutX()-10);R1.setEndY(axe.getEndY());
                l8.setStartX(mil);l8.setStartY(axe.getEndY());
                l8.setEndX(p.x);l8.setEndY(p.y);
                
           }
    }
           else
           {    
             
                 l.setStartX(f1.getLayoutX());l.setStartY(f1.getLayoutY());
                  l.setEndX(arc.getLayoutX());l.setEndY(arc.getLayoutY());
              


           double angle1 = Math.atan2(l.getStartY() - l.getEndY(), l.getStartX() - l.getEndX());
           double angle2 = Math.atan2(-axe.getStartY() + axe.getEndY(), -axe.getStartX() + axe.getEndX());

     double angle =((angle1 - angle2 ) * (180 / Math.PI)) + 180;

   
    if (angle < 0)
         angle = angle * -1;
  
     angle= (Math.PI / 180.0) * angle;

           l.setEndX(l.getStartX()+Math.cos(angle)*500); 
             l.setEndY(l.getStartY()+Math.sin(angle)*500);
             /////////////////////////////////////////////////////
             l5.setStartX(f2.getLayoutX());l5.setStartY(f2.getLayoutY());
             l5.setEndX(arc.getLayoutX());l5.setEndY(arc.getLayoutY());
             
            angle1 = Math.atan2(l5.getStartY() - l5.getEndY(), l5.getStartX() - l5.getEndX());
            angle2 = Math.atan2(-axe.getStartY() + axe.getEndY(), -axe.getStartX() + axe.getEndX());

      angle =((angle1 - angle2 ) * (180 / Math.PI)) + 180;

   
    if (angle < 0)
         angle = angle * -1;
  
     angle= (Math.PI / 180.0) * angle;

           l5.setEndX(l5.getStartX()+Math.cos(angle)*stg.getWidth()); 
           l5.setEndY(l5.getStartY()+Math.sin(angle)*stg.getWidth());
             
             
             
        Point p=lineIntersect((int)Miroire.getStartX(),(int)Miroire.getStartY(),(int)Miroire.getEndX(),(int)Miroire.getEndY(),(int)l.getStartX(), (int)l.getStartY(), (int)l.getEndX(), (int)l.getEndY());
           if(p==null){ 
               
           }else
           {    l.setEndX(p.x);l.setEndY(p.y);
                l3.setStartX(p.x);l3.setStartY(p.y);
                 Point p2=lineIntersect((int)l5.getStartX(),(int)l5.getStartY(),(int)l5.getEndX(),(int)l5.getEndY(),(int)l3.getStartX(), (int)l3.getStartY(), 0, (int)l3.getStartY());
                if(p2!=null)
                {l3.setEndX(p2.x);l3.setEndY(p2.y);
                arc4.setLayoutX(p2.x);
                arc4.setLayoutY(p2.y);
                R1.setStartX(arc4.getLayoutX()-10);R1.setStartY(arc4.getLayoutY()+15);
                R1.setEndX(arc4.getLayoutX()-10);R1.setEndY(axe.getEndY());
                l4.setStartX(mil);l4.setStartY(axe.getEndY());
                l4.setEndX(p2.x);l4.setEndY(p2.y);
                l8.setStartX(arc.getLayoutX());l8.setStartY(arc.getLayoutY());
                l8.setEndX(mil);l8.setEndY(axe.getStartY());
                }
                else {
                    System.out.println("virtual image");
                }
           }
             
             
             
                
                 
                 
                 
                 
              
//              l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
//              l4.setEndX(mil); l4.setEndY(axe.getStartY());
//               l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
//               l3.setEndX(mil);l3.setEndY(l3.getStartY());
//               CalculDistance(l4, axe, l4.getEndX(), l4.getEndX(), l4.getEndY(), true);
//               
//               
//               l5.setStartX(f2.getLayoutX());l5.setStartY(f2.getLayoutY());
//               l5.setEndX(arc4.getLayoutX());l5.setEndY(arc4.getLayoutY());
               
           }
             
  }
 
}
