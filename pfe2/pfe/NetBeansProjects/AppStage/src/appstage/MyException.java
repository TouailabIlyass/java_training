/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appstage;


import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kingdragon
 */
public class MyException extends Exception{
    
    
    public MyException()
    {
        super("erreur");
    }
    
    
    public static int StringtoNumber(String s)
    {  int x=0;
        if(s==null)
            x=0;
        else
            x=Integer.parseInt(s);
        
        return x;
        
    }
    public static boolean isNumber(String s)
    {     
          
         boolean b=true;
         int x;
         try{
             x=Integer.parseInt(s);
         }catch(NumberFormatException e)
         {
             b=false;
         }
         
       
         return  b;
    }
     public static boolean isDouble(String s)
    {     
          
         boolean b=true;
         double x;

         try{
             x=Double.parseDouble(s);
         }catch(NumberFormatException e)
         {
             b=false;
         }
         
       
         return  b;
    }

    public static Date isDate(LocalDate date)
    {Date d;
          try
          {
              d=Date.valueOf(date);
          }catch(Exception e)
          {
              return null;
          }
        
         
        return d;
    }
    
   
}
