/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appstage;


import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author kingdragon
 */
public class MyException extends Exception{
    
    
    public MyException()
    {
        super("erreur");
    }
    
    
    
    public static int  StringtoNumber(String s)
    {     
         int x;
       
         
         try{
             x=Integer.parseInt(s);
         }catch(NumberFormatException e)
         {
           x=0;
         }
           if(x==0 && FXMLAjouterController.valide)
        
            FXMLAjouterController.valide=false;
         
       
         return  x;
    }
     public static double StringtoDouble(String s)
    {     
          
        
         double x;

         try{
             x=Double.parseDouble(s);
         }catch(NumberFormatException e)
         {
             x=0;
         }
         if(x==0 && FXMLAjouterController.valide)
        
            FXMLAjouterController.valide=false;
       
         return  x;
    }

    public static Date StringToDate(LocalDate date)
    {Date d;
          try
          {
              d=Date.valueOf(date);
          }catch(Exception e)
          {   FXMLAjouterController.valide=false;
              return null;
          }
        
         
        return d;
    }
   public static String StringToString(String str)
   {
        
       if(FXMLAjouterController.valide  && (str.equals(null) || str.equals("")))
       { FXMLAjouterController.valide=false;
        return "NULL";
       }
       return str;
       
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
