/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade2;

import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author kingdragon
 */
public class FXMLDocumentController implements Initializable{
    
       
      private static FXMLDocumentController f;

    @FXML
    private ImageView feux1,feux2,feux3,feux4,car1,car2,car3,car4;
   
     @FXML
    void test2(MouseEvent e ) {
        
       moveCar1tofeux();
       moveCar2tofeux();
      
        
    }
 @FXML
    public void test() {
         System.out.println(car1.getLayoutX());
        while(car1.getLayoutX()<feux1.getLayoutX()-75){
             try {
                 sleep(500);
             } catch (InterruptedException ex) {
                 System.out.println(ex.getMessage());
             }
          System.out.println(car1.getLayoutX());
            car1.setLayoutX(car1.getLayoutX()+10);
            
           
        } 
        
        System.out.println(car1.getLayoutX());
    }
    
     public void moveCar1tofeux(){
          if(car1.getLayoutX()<181)
          {
              Th1  t1 = new Th1(car1,car1.getLayoutX(),181,1);
             t1.start();
          }
    }
     
   
    public void moveCar2tofeux()
     {   if(car2.getLayoutY()<feux2.getLayoutY()-80)
            {
                 Th1 t2 = new Th1(car2,car2.getLayoutY(),feux2.getLayoutY()-80,2);
                t2.start();
            }
     }
    
    
    public void moveCar1tofeux2(){
          if(car1.getLayoutX()<140)
          {
               car1.setLayoutX(car1.getLayoutX()+3);
               car3.setLayoutX(car3.getLayoutX()-3);
          }
    }
    public void moveCar4tofeux4()
    {
        if(car4.getLayoutY()>410)
        {
             car4.setLayoutY(car4.getLayoutY()-3);
        }
    }
     
   
    public void moveCar2tofeux2()
     {   if(car2.getLayoutY()<140)
            {
                car2.setLayoutY(car2.getLayoutY()+3);
                //car4.setLayoutY(car4.getLayoutY()-3);
            }
     }
    
    
    public void mv1()
    {
        car1.setLayoutX(car1.getLayoutX()+3);
        car3.setLayoutX(car3.getLayoutX()-3);
        if(car1.getLayoutX()>600) car1.setLayoutX(0);
        if(car3.getLayoutX()<=0) car3.setLayoutX(519);
       

    }
    public void mv3()
    { 
        if(car1.getLayoutX()>=300){
        if(car1.getRotate()!=-90)
            car1.setRotate(-90);
        
            car1.setLayoutY(car1.getLayoutY()-3);
            if(car1.getLayoutY()<=0) {car1.setLayoutY(519);car1.setRotate(0);}
        }
            if(car1.getRotate()!=-90)
            {car1.setLayoutX(car1.getLayoutX()+3);
               
                if(car1.getLayoutX()>600) car1.setLayoutX(0);
           

              }
         car3.setLayoutX(car3.getLayoutX()-3);
       if(car3.getLayoutX()<=0) car3.setLayoutX(519);

    }
    public void mv2()
    {
        car2.setLayoutY(car2.getLayoutY()+3);
        car4.setLayoutY(car4.getLayoutY()-3);
        if(car2.getLayoutY()>550) car2.setLayoutY(0);
        if(car4.getLayoutY()<=0) car4.setLayoutY(490);

    }
   
   
    
    public static FXMLDocumentController getController()
    {
        return f;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        f=this;
    }
    
    
    public void setFeux1Rouge()
    {
        feux1.setImage(new Image("jade/red.png"));
        feux1.setAccessibleText("rouge");
       
    }
    public void setFeux1Vert()
    {
        feux1.setImage(new Image("jade/green.png"));
         feux1.setAccessibleText("vert");
         
    }
     public void setFeux1Jaune()
    {
        feux1.setImage(new Image("jade/yellow.png"));
         feux1.setAccessibleText("jaune");
    }
     
      public void setFeux2Rouge()
    {
        feux2.setImage(new Image("jade/red.png"));
        feux2.setAccessibleText("rouge");
        
    }
    public void setFeux2Vert()
    {
        feux2.setImage(new Image("jade/green.png"));
         feux2.setAccessibleText("vert");
         
    }
     public void setFeux2Jaune()
    {
        feux2.setImage(new Image("jade/yellow.png"));
         feux2.setAccessibleText("jaune");
    }
      public void setFeux3Rouge()
    {
        feux3.setImage(new Image("jade/red.png"));
        feux3.setAccessibleText("rouge");
    }
    public void setFeux3Vert()
    {
        feux3.setImage(new Image("jade/green.png"));
         feux3.setAccessibleText("vert");
    }
     public void setFeux3Jaune()
    {
        feux3.setImage(new Image("jade/yellow.png"));
         feux3.setAccessibleText("jaune");
    }
      public void setFeux4Rouge()
    {
        feux4.setImage(new Image("jade/red.png"));
        feux4.setAccessibleText("rouge");
    }
    public void setFeux4Vert()
    {
        feux4.setImage(new Image("jade/green.png"));
         feux4.setAccessibleText("vert");
    }
     public void setFeux4Jaune()
    {
        feux4.setImage(new Image("jade/yellow.png"));
         feux4.setAccessibleText("jaune");
    }
     
  
     public String getEtatfeux1()
     {
        return feux1.getAccessibleText();
     }
     public String getEtatfeux2()
     {
        return feux2.getAccessibleText();
     }
   
     public void ContinueCar1()
     {
        if(car1.getLayoutX()>150)
        { car1.setLayoutX(car1.getLayoutX()+3);
             car3.setLayoutX(car3.getLayoutX()-3);
        }
          if(car1.getLayoutX()>600) {car1.setLayoutX(0); car3.setLayoutX(519);}
        
     }
     /*public void ContinueCar3()
     {
        if(car1.getLayoutX()>150 && car1.getLayoutX()<300)
        { car1.setLayoutX(car1.getLayoutX()+3);
            // car3.setLayoutX(car3.getLayoutX()-3);
        }
        else if(car1.getLayoutX()>=300){
            if(car1.getRotate()!=-90)
            car1.setRotate(-90);
            car1.setLayoutY(car1.getLayoutY()-3);
        }
         // if(car1.getLayoutX()>600) {car1.setLayoutX(0); car3.setLayoutX(519);}
        
     }*/
      public void ContinueCar3()
     {
        if(car1.getLayoutX()>150 && car1.getLayoutX()<300)
        { car1.setLayoutX(car1.getLayoutX()+3);
            
        }
        else if(car1.getLayoutX()>=300){
            car1.setRotate(-90);
            car1.setLayoutY(car1.getLayoutY()-3);
            if(car1.getLayoutY()<=0){ car1.setLayoutY(315); car1.setRotate(0);}
        }
         car3.setLayoutX(car3.getLayoutX()-3);
         // if(car1.getLayoutX()>600) {car1.setLayoutX(0); }
         if(car3.getLayoutX()<=0) car3.setLayoutX(519);
        
     }
     public void ContinueCar2()
     {
         if(car2.getLayoutY()>150)
         { car2.setLayoutY(car2.getLayoutY()+3);
            car4.setLayoutY(car4.getLayoutY()-3);
         }
      
          if(car2.getLayoutY()>550){ car2.setLayoutY(0);car4.setLayoutY(490);}
     }
     
     public double getXFeux1()
     {
         return feux1.getLayoutX();
     }
    
}
