
package pfe2;

import com.jfoenix.controls.JFXColorPicker;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class Cntl {
    @FXML
    private JFXColorPicker color;
 
   // private static String col;
    
    @FXML
   public void Change(ActionEvent e) throws IOException {
     // FileWriter f2 = new FileWriter("test2.txt");
           //f2.write(color.getValue().toString());  f2.close();
        // Ecrirefichier(Control.getS());
       
         Control.ChangeC(color.getValue().toString());
       
   
       
    }/*
private static void Ecrirefichier(String source) throws  IOException
  {
      
      
      String []st= new String[2];
                
               
               File f= new File("test.txt");
               
                Scanner sx = new Scanner(f);
                Scanner sx2 = new Scanner( new  File("test2.txt"));
         
                for (int i=0;i<2;i++) {
                    st[i]=sx.nextLine();
                    System.out.println(st[i]);
           }
                sx.close();
              FileWriter f2 = new FileWriter(f);
           for (int i = 0; i < 2; i++) {
               if(st[i].contains(source))
               {
                   System.out.println("nices");
                   col=st[i].substring(st[i].indexOf(":")+2);
                 
                  st[i]= st[i].replaceFirst(col,sx2.nextLine())+"\n";
                   System.out.println("****"+st[i]);
               }
               f2.write(st[i]);
           }
           f2.close();
           System.out.println(source);
           
  }
public static String getCol()
{
    return col;
}
*/
  
}
