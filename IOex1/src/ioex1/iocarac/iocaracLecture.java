 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioex1.iocarac;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author kingdragon
 */
public class iocaracLecture {
    
    public static void main(String[] args) {
        try{
        BufferedReader buf = new BufferedReader(new FileReader("test2.txt"));
       
      
        while(true)
        {    
           String l=buf.readLine();
            if(l==null) {buf.close();break;}
            String str=l.substring(l.indexOf(":")+2);
            System.out.println(l);
            System.out.println(str);
            
        }
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            
        } catch (IOException ex) {
           
        }
    }
}
