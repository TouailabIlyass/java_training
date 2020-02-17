/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tst;

import java.util.ArrayList;

/**
 *
 * @author kingdragon
 */
public class B extends A{
    
    private int id;
    private String nom;

    public B(int id, String nom) {
        this.id = id;
        this.nom = nom;
        
    }
      public B() {
    
        
    }
    
    
    public String toString()
    {
        return "id = "+id+" nom = "+nom;
    }
    
    /**
     *
     * @return
     */
    public String serialize()
    {
        return "B:id="+id+":nom="+nom+":";
       
    }
    public B unserilize(String str)
    {    String []s=search(str);
        B b= new B(Integer.valueOf(s[0]),s[1]);
        
        
       return b;
    }
    
    private String[] __attr()
    {
        String[] T= {"id","nom"};
        return T;
    }
    
    private String[] search(String str)
    {
        String[] T=__attr();
        String [] T2= new String[T.length];
        String S="";
       
        int i=0;
        for (String string : T) {
            
            int x=str.indexOf(string);
           // System.out.println(""+x);
       try{
           String s=   str.substring(x+string.length()+1, str.indexOf(":",x+string.length()));
         T2[i]=s;i++;
         
            //System.out.println("s = "+s);
       }catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
         
       
        }
        return T2;
    }
    
    public static ArrayList ok()
    {
        ArrayList<String> l = new ArrayList<String>();
        l.add("ilyase");
         l.add("ilyase1");
          l.add("ilyase2");
           l.add("ilyase3");
            l.add("ilyase4");
        
        return l;
    }
    
}
