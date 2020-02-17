/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author kingdragon
 */
public class serialMain {
    
    public static void main(String[] args) {
        
        Point p = new Point(10,2);
    
        try {
            FileOutputStream fos= new FileOutputStream("point.txt");
            
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(p);
            oos.flush();
            
            oos.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    
        try{
        FileInputStream fis= new FileInputStream("point.txt");
            ObjectInputStream ois= new ObjectInputStream(fis);
            Point p1=(Point)ois.readObject();
            System.out.println(p1);
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        } catch (IOException |ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } 
        
    }
}
