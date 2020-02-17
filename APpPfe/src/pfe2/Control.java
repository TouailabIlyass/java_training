
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
  
    @FXML private Label lbl,lbl1,lblObjet,lblFoyer;
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
    
        try {
            Lire();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
                
        int x=0;
        int j=0;
        
        int i=0;
       Line ll;
        for (; i <=600; i++,x+=9) {
           ll=new Line(0, x, 2000, x);
           if(j==0)
           {
               ll.setStrokeWidth(2);
           }
          ll.setId("gridX");
           ll.setStroke(Paint.valueOf("c4bcbc"));
          ll.toBack();
           pan.getChildren().add(ll);
           j++;
           if(j==4) j=0;
           
          
     }
           
       double xy=0;      
       double cm=0.026;     
      
       for (i = 0; i < 800; i++,xy+=38.46) {          
          ll=new Line(xy, 0, xy, 1000);
           ll.toBack();
          ll.setId("gridY");
          pan.getChildren().add(ll);
    }
      
       R.toFront();
       arc.toFront();
       op.toFront();
       arc1.toFront();
       arc2.toFront();
       f2.toFront();f1.toFront();
       lbl.toFront();lbl1.toFront();
       lblObjet.toFront();
       lblFoyer.toFront();
     l.toFront();l3.toFront();l4.toFront();l5.toFront();l7.toFront();l8.toFront();l9.toFront();
     
     
   }
   @FXML
   public void ClickHamburger(MouseEvent e){
       
          Close();
    }
   
   
    public void Close() {
     
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
              
    		f2.setLayoutX(op.getStartX()+x);
        }
        else if(cdc.isMiroireConcave() && x<=Miroire.getStartX() && x>= (Miroire.getStartX()/2))
        {
            f1.setLayoutX(x); 
        }
        else if(cdc.isMiroireConvexe() && x<=(axe.getEndX()-Miroire.getStartX())+(Miroire.getStartX()/2) && x>=Miroire.getStartX()){
            
            f1.setLayoutX(x); 
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
               lblObjet.setVisible(true);
               lblObjet.setLayoutX(arc.getLayoutX()+10);
               lblObjet.setLayoutY(arc.getLayoutY()+10);
                
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
                lblFoyer.setVisible(true);
                lblFoyer.setLayoutX(f1.getLayoutX()+10);
                lblFoyer.setLayoutY(f1.getLayoutY()+10);
    		
    	}
       
    	       
                 
    	
    }
  @FXML
   private void Label(MouseEvent e) {
   
        lblObjet.setVisible(false);
        lblFoyer.setVisible(false);
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
              double cm=0.026458333;
              double mil=((axe.getEndX()-10)/2.0);
          String str=String.valueOf(((mil-R.getStartX())*cm));
          if(str.length()>4) str=str.substring(0, 4);
               lbl.setText("Objet : "+str+" cm");
             str=String.valueOf(((mil-f1.getLayoutX())*cm));
          if(str.length()>4) str=str.substring(0, 4);
               lbl1.setText("foyer : "+str+" cm");
               lblFoyer.setLayoutX(f1.getLayoutX()+10);
                lblFoyer.setLayoutY(f1.getLayoutY()+10);
                 lblObjet.setLayoutX(arc.getLayoutX()+10);
                lblObjet.setLayoutY(arc.getLayoutY()+10);
    		

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
                stage.setTitle("Chose Color");
                stage.setResizable(false);
               
                source=String.valueOf(e.getSource());
                source=source.substring(source.indexOf("=")+1,source.indexOf(","));
                
               
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
        Document doc=sax.build(new File("save.xml"));
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
         sortie.output(doc, new FileOutputStream("save.xml"));
        
    }
    private void Lire() throws JDOMException, IOException
    { 
         SAXBuilder sax= new SAXBuilder();
        Document doc=sax.build(new File("save.xml"));
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
             R1.setVisible(b);arc4.setVisible(b);
            
      }
      public void ChangeWidth(double w)
      {
          stg.setWidth(w);
      }
      public void ChangeHeight(double h)
      {
          stg.setHeight(h);
      }

      
  public void Init()
  {
      
      /////////////////////////
      
        lbl.setLayoutY(stg.getHeight()-70);
        lbl1.setLayoutY(lbl.getLayoutY());
        axe.setStartY(stg.getHeight()/2.0);
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
      
      if(cdc.isMiroireConvexe())
      {
          f1.setLayoutX(mil+20);
      }
  }
  
  
  private void DrawConvergente()
  {
        
               l9.setVisible(false);
                l8.setVisible(false);
    
	      if(f1.getLayoutX()>R.getStartX())
	         {  if(!l.isVisible())
			    	{
                                    SetVisible(true);
                                   
                                }
 		l.setStartX(arc.getLayoutX());l.setStartY(arc.getLayoutY());
     	        l.setEndX(f1.getLayoutX());l.setEndY(f1.getLayoutY());
 	R1.setVisible(false);arc4.setVisible(false);
        l7.setVisible(true);
        arc3.setVisible(true);
        R2.setVisible(true);
        double  angle =getAngle(l, axe);
        double mil=((axe.getEndX()-10)/2.0);
        l.setEndX(l.getStartX()+Math.cos(angle)*stg.getWidth());
        l.setEndY(l.getStartY()+Math.sin(angle)*stg.getWidth());
        Point p=lineIntersect((int)op.getStartX(),(int)op.getStartY(),(int)op.getEndX(),(int)op.getEndY(),(int)l.getStartX(), (int)l.getStartY(), (int)l.getEndX(), (int)l.getEndY());
           if(p==null){ 
               l.setVisible(false);
               l7.setVisible(false);
               R2.setVisible(false);
               arc3.setVisible(false);
               l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
              l4.setEndX(mil);l4.setEndY(axe.getStartY());
              angle=getAngle(l4, axe);
              l4.setEndX(mil+Math.cos(angle)*stg.getWidth());
              l4.setEndY(axe.getStartY()+Math.sin(angle)*stg.getWidth());
              l5.setStartX(l3.getEndX());l5.setStartY(l3.getEndY());
           l5.setEndX(f2.getLayoutX());l5.setEndY(f2.getLayoutY());
           angle=getAngle(l5, axe);
            l5.setEndX(f2.getLayoutX()+Math.cos(angle)*stg.getWidth());
             l5.setEndY(f2.getLayoutY()+Math.sin(angle)*stg.getWidth());
           }else
           {   
               l.setEndX(p.x);l.setEndY(p.y);
               System.out.println("ok");
               
      l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
     l4.setEndX(mil);l4.setEndY(axe.getStartY());
     l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
        l3.setEndX(op.getStartX());l3.setEndY(l3.getStartY());
     
 
     
    l7.setStartX(l.getEndX());l7.setStartY(l.getEndY());
    l7.setEndX(axe.getEndX());l7.setEndY(l7.getStartY());

  angle=getAngle(l4, axe);
  l4.setEndX(mil+Math.cos(angle)*stg.getWidth());
  l4.setEndY(axe.getStartY()+Math.sin(angle)*stg.getWidth());
  p=lineIntersect((int)l7.getStartX(),(int)l7.getStartY(),(int)l7.getEndX(),(int)l7.getEndY(),(int)l4.getStartX(), (int)l4.getStartY(), (int)l4.getEndX(), (int)l4.getEndY());
   if(p!=null)
     {
    l4.setEndX(p.x);l4.setEndY(p.y);
    l5.setStartX(l3.getEndX());l5.setStartY(l3.getEndY());
    l5.setEndX(p.x);l5.setEndY(p.y);
      R2.setStartX(l5.getEndX());R2.setEndX(l5.getEndX());
    R2.setEndY(l7.getEndY()-10);
    arc3.setLayoutX(R2.getStartX()-1);
    arc3.setLayoutY(l7.getEndY()-26);
     }

  
           }
        
    
     /////////////////////////////////////
     

     
 	} else if(f1.getLayoutX()<R.getStartX())
              {  R1.setVisible(true);arc4.setVisible(true);
              R2.setVisible(false);arc3.setVisible(false);
                       l.setVisible(false);
                       l7.setVisible(false);
                       l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
                       l3.setEndX(op.getStartX());l3.setEndY(l3.getStartY());
  
      double mil=((axe.getEndX()-10)/2.0);
     
 l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
     l4.setEndX(mil);l4.setEndY(axe.getStartY());
double angle=getAngle(l4, axe);
           l5.setStartX(l3.getEndX());l5.setStartY(l3.getEndY());
           l5.setEndX(f2.getLayoutX());l5.setEndY(f2.getLayoutY());
                      l4.setStartX(arc.getLayoutX()-Math.cos(angle)*stg.getWidth());
                      l4.setStartY(arc.getLayoutY()-Math.sin(angle)*stg.getWidth());
                      l4.setEndX(arc.getLayoutX()+Math.cos(angle)*stg.getWidth());
                      l4.setEndY(arc.getLayoutY()+Math.sin(angle)*stg.getWidth());
                       angle =getAngle(l5, axe);
                      l5.setStartX(l5.getStartX()-Math.cos(angle)*stg.getWidth());
                      l5.setStartY(l5.getStartY()-Math.sin(angle)*stg.getWidth());
                       l5.setEndX(f2.getLayoutX()+Math.cos(angle)*stg.getWidth());
                      l5.setEndY(f2.getLayoutY()+Math.sin(angle)*stg.getWidth());
                      
              Point p=lineIntersect((int)l5.getStartX(),(int)l5.getStartY(),(int)l5.getEndX(),(int)l5.getEndY(),(int)l4.getStartX(), (int)l4.getStartY(), (int)l4.getEndX(), (int)l4.getEndY());
   if(p!=null)
     {
         arc4.setLayoutX(p.x);arc4.setLayoutY(p.y);
        R1.setStartX(arc4.getLayoutX()-10);R1.setStartY(arc4.getLayoutY()+15);
        R1.setEndX(arc4.getLayoutX()-10);R1.setEndY(axe.getEndY());
       
     } else
   {
       R1.setVisible(false);arc4.setVisible(false);
   }
                      
                      
                       
                       
              }
  }
  
  private void DrawDivergente()
  {            SetVisible(true);
                l9.setVisible(false);
                l8.setVisible(false);
              l3.setStartX(arc.getLayoutX());l3.setStartY(arc.getLayoutY());
              l3.setEndX(op.getStartX());l3.setEndY(l3.getStartY());
              l5.setStartX(l3.getEndX());l5.setStartY(l3.getEndY());
              l5.setEndX(f1.getLayoutX());l5.setEndY(f1.getLayoutY());
              l7.setVisible(false);
              l.setVisible(false);
             R2.setVisible(false);
             arc3.setVisible(false);
              R1.setVisible(true);
                arc4.setVisible(true);
              double mil=((axe.getEndX()-10)/2.0);
               l4.setStartX(arc.getLayoutX());l4.setStartY(arc.getLayoutY());
               l4.setEndX(mil);l4.setEndY(axe.getStartY());
          
          Point p=lineIntersect((int)l5.getStartX(),(int)l5.getStartY(),(int)l5.getEndX(),(int)l5.getEndY(),(int)l4.getStartX(), (int)l4.getStartY(), (int)l4.getEndX(), (int)l4.getEndY());
   if(p!=null)
     {
       arc4.setLayoutX(p.x);arc4.setLayoutY(p.y);
        R1.setStartX(arc4.getLayoutX()-10);R1.setStartY(arc4.getLayoutY()+15);
        R1.setEndX(arc4.getLayoutX()-10);R1.setEndY(axe.getEndY());
       
     }
               
  }
  
  private void DrawMiroireConcave()
  {
              SetVisible(true);
              l8.setVisible(true);
              l9.setVisible(true);
              
              if(R.getStartX()<f1.getLayoutX())
              {   R1.setVisible(false);
                  arc4.setVisible(false);
                  double mil=((axe.getEndX()-10)/2.0);
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
            
         double angle=getAngle(l, axe);
         l.setEndX(l.getStartX()+Math.cos(angle)*stg.getWidth());
         l.setEndY(l.getStartY()+Math.sin(angle)*stg.getWidth());
    Point  p=lineIntersect((int)Miroire.getStartX(),(int)Miroire.getStartY(),(int)Miroire.getEndX(),(int)Miroire.getEndY(),(int)l.getStartX(), (int)l.getStartY(), (int)l.getEndX(), (int)l.getEndY());
     if(p!=null)
        {
         l.setEndX(p.x);l.setEndY(p.y);
       }
             
              
              l7.setStartX(l.getEndX()); l7.setStartY(l.getEndY());
              l7.setEndX(10);l7.setEndY(l7.getStartY());

         
          angle=getAngle(l8,axe);
         l8.setEndX(f1.getLayoutX()+Math.cos(angle)*stg.getWidth());
         l8.setEndY(f1.getLayoutY()+Math.sin(angle)*stg.getWidth());
     p=lineIntersect((int)l7.getStartX(),(int)l7.getStartY(),(int)l7.getEndX(),(int)l7.getEndY(),(int)l8.getStartX(), (int)l8.getStartY(), (int)l8.getEndX(), (int)l8.getEndY());
     if(p!=null)
        {
         l8.setEndX(p.x);l8.setEndY(p.y);
       }
     
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
              
            
              
              l5.setStartX(arc.getLayoutX());l5.setStartY(arc.getLayoutY());
              l5.setEndX(f2.getLayoutX());l5.setEndY(f2.getLayoutY());
              
               l.setStartX(arc.getLayoutX());l.setStartY(arc.getLayoutY());
               l.setEndX(f1.getLayoutX());l.setEndY(f1.getLayoutY());
             
    Point p=lineIntersect((int)Miroire.getStartX(),(int)Miroire.getStartY(),(int)Miroire.getEndX(),(int)Miroire.getEndY(),(int)l.getStartX(), (int)l.getStartY(), (int)l.getEndX(), (int)l.getEndY());
     if(p!=null)
        {
        l9.setStartX(p.x);l9.setStartY(p.y);
       }
             
      p=lineIntersect((int)l5.getStartX(),(int)l5.getStartY(),(int)l5.getEndX(),(int)l5.getEndY(),(int)l9.getStartX(), (int)l9.getStartY(), 0, (int)l9.getStartY());
     if(p!=null)
        {
         l9.setEndX(p.x);l9.setEndY(p.y);
       }          
                
                arc4.setLayoutX(p.x);
                arc4.setLayoutY(p.y);
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
           
               
             double angle=getAngle(l5,axe);
             l5.setEndX(l5.getStartX()+Math.cos(angle)*stg.getWidth());
             l5.setEndY(l5.getStartY()+Math.sin(angle)*stg.getWidth());
      double mil=((axe.getEndX()-10)/2.0);
               double c=(2*f1.getLayoutX());
              f2.setLayoutX(c-mil);
               l9.setStartX(arc.getLayoutX());l9.setStartY(arc.getLayoutY());
               l9.setEndX(Miroire.getStartX());l9.setEndY(l9.getStartY());
             
            

                      l.setStartX(f1.getLayoutX());l.setStartY(f1.getLayoutY());

                    l.setStartX(f1.getLayoutX());l.setStartY(f1.getLayoutY());
               l.setEndX(l9.getEndX());l.setEndY(l9.getEndY());
            
              angle=getAngle(l,axe);
             l.setEndX(l.getStartX()+Math.cos(angle)*stg.getWidth());
             l.setEndY(l.getStartY()+Math.sin(angle)*stg.getWidth());
             
                
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
            
              l.setStartX(l3.getEndX());l.setStartY(l3.getEndY());
              l.setEndX(f1.getLayoutX());l.setEndY(f1.getLayoutY());
    
 
            
    Point p=lineIntersect((int)l5.getStartX(),(int)l5.getStartY(),(int)l5.getEndX(),(int)l5.getEndY(),(int)l.getStartX(), (int)l.getStartY(), (int)l.getEndX(), (int)l.getEndY());
           if(p!=null){ 
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
             

               double angle =getAngle(l,axe);

           l.setEndX(l.getStartX()+Math.cos(angle)*500); 
             l.setEndY(l.getStartY()+Math.sin(angle)*500);
             /////////////////////////////////////////////////////
             l5.setStartX(f2.getLayoutX());l5.setStartY(f2.getLayoutY());
             l5.setEndX(arc.getLayoutX());l5.setEndY(arc.getLayoutY());
          

      angle =getAngle(l5,axe);
           l5.setEndX(l5.getStartX()+Math.cos(angle)*stg.getWidth()); 
           l5.setEndY(l5.getStartY()+Math.sin(angle)*stg.getWidth());
             
             
             
        Point p=lineIntersect((int)Miroire.getStartX(),(int)Miroire.getStartY(),(int)Miroire.getEndX(),(int)Miroire.getEndY(),(int)l.getStartX(), (int)l.getStartY(), (int)l.getEndX(), (int)l.getEndY());
           if(p!=null){ 
               
                l.setEndX(p.x);l.setEndY(p.y);
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
              
           }
                            
 }
             
  
  private double  getAngle(Line l1,Line l2)
  {
      
      
           double angle1 = Math.atan2(l1.getStartY() - l1.getEndY(), l1.getStartX() - l1.getEndX());
           double angle2 = Math.atan2(-l2.getStartY() + l2.getEndY(), -l2.getStartX() + l2.getEndX());

     double angle =((angle1 - angle2 ) * (180 / Math.PI)) + 180;

   
    if (angle < 0)
         angle = angle * -1;
  
     angle= (Math.PI / 180.0) * angle;
     return angle;
  }
 
}
