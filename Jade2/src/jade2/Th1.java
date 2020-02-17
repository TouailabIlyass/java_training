/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade2;

import static java.lang.Thread.sleep;

import javafx.scene.image.ImageView;

/**
 *
 * @author kingdragon
 */
public class Th1 extends Thread{

    private ImageView car;
    private double start,end;
    private int numcar;
  
    FXMLDocumentController cont=FXMLDocumentController.getController();

    public Th1(ImageView car, double start, double end,int i ) {
        this.car = car;
        this.start = start;
        this.end = end;
        this.numcar=i;
       
    }

   
    
    @Override
    public void run() {
        if(numcar==1)
        { 
            while(car.getLayoutX()<end ){
               
             try {
                 sleep(2000);
             } catch (InterruptedException ex) {
                 System.out.println(ex.getMessage());
             }
           car.setLayoutX(car.getLayoutX()+3);
             if(car.getLayoutX()>600) car.setLayoutX(0);
           
        }  
          
           
       
        }
        else if(numcar==2)
        { 
            while(car.getLayoutY()<end){
                
             try {
                 sleep(2000);
             } catch (InterruptedException ex) {
                 System.out.println(ex.getMessage());
             }
          
          car.setLayoutY(car.getLayoutY()+10);
            
           
        }  
            
        }
        
         
        // String [] x={"-gui", "R:jade2.road1;F:jade2.feux1;F2:jade2.feux2"};
       // String [] x={"-gui", "F1:jade2.feux1;F2:jade2.feux1"};
          
        
        
        
        
        
    }
    
}
