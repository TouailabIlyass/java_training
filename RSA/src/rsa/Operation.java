/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author drging
 */
public class Operation {
    private static int binarypublic[]=null;
    private static int binaryprive[]=null;
    private static ArrayList<Integer> prem=crible(100);
    private static HashMap <Character,Integer> keys=clefs(prem);
   
    public static String Crypter(String str)
    {
        String msg="";
        binarypublic=convertBinary(keys.get('e'));
        int c;
        for(int i=0;i<str.length();i++)
        {
            c=squarMultiply((int)str.charAt(i),keys.get('n'),binarypublic);
            if(c<10)
                msg+="00";
            else if (c<100)
               msg+='0';
            else if(c>999)
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("RSA Dialog");
                alert.setHeaderText(null);
                alert.setContentText("impossible de crypter le message vous dever generer les clefs!!!");
                alert.showAndWait();
                keys=clefs(prem);
            }
            msg+=c;
        }
        return msg;
    }
    public static String Decrypter(String str)
    {
        String msg="";
        binaryprive=convertBinary(keys.get('d'));
        int c;
        for(int i=0;i<str.length();i+=3)
        {  try{
             c=squarMultiply(Integer.valueOf(str.substring(i, i+3)),keys.get('n'),binaryprive);
             msg+=(char)c;
        }catch(Exception e)
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("RSA Dialog");
            alert.setHeaderText(null);
            alert.setContentText("invalide key!!!");
            alert.showAndWait();
            
        }
           
        }
        return msg;
    }
    
    public static ArrayList<Integer> crible(int n)
    {
        ArrayList<Integer> prem = new ArrayList<>();
        for(int i=2;i<=n;i++)
        {
            if(isprime(i))
                prem.add(i);
        }
        
        return prem;
    }
    public static boolean isprime(int n)
    {
        for(int i=2;i<=n/2;i++)
        {
            if (n % i == 0)
                return false;
        }
        
        return true;
    }
    
    public static int puis_mod(int a,int n,int m)
    {
        int p=1;
        while (n>0)
        {
            while(n%2==0)
            {
                a=(a*a)%m;
                n=n/2;
                p=(p*a)%m;
                n=n-1;
            }
        }
        return p;
    }
    
    public static int inv_mode2(int m,int e)
    {
        try{
        int a0,a1,s,r,q1,y0,y1,m0;
        a0=m;y0=0;y1=1;m0=m;
        a1=e;q1=m/e;
        while(a1!=1)
        {
            s=-(q1*y1)+y0;
            y0=y1;
            y1=s;
            r=a1;
            a1=a0%a1;
            a0=r;
            q1=a0/a1;
        }
        if(a1==1)
        {
            while(y1<0)
            y1+=m0;
            return y1;
        }
        return 0;
        
       
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
         return 0;
    }
    static int inv_mode(int a, int m) 
    { 
        int m0 = m; 
        int s = 0, u = 1; 
  
        if (m == 1) 
            return 0; 
  
        while (a > 1) 
        { 
            int q = a / m; 
  
            int t = m; 
  
            
            m = a % m; 
            a = t; 
            t = s; 
  
            // Update x and y 
            s = u - q * s; 
            u = t; 
        } 
  
        // Make x positive 
        if (u < 0) 
            u += m0; 
  
        return u; 
    } 
    public static HashMap <Character,Integer> clefs(ArrayList<Integer> prem)
    {  HashMap <Character,Integer> keys = new HashMap<>();
        int p=RandomChoice(prem);
        int q=RandomChoice(prem);
        int n=p*q;
        int m=(p-1)*(q-1);
        System.out.println("p= "+p+", q = "+q+" n="+n+" m="+m);
        int e=RandomRandInt(10, 100);
        int d;
        while(inv_mode2(m, e)==0)
        {
            e=RandomRandInt(10, 100);
        }
        d=inv_mode2(m, e);
        keys.put('e', e);
        keys.put('d', d);
        keys.put('n', n);
        System.out.println("e="+e+" d="+d);
        if(e>=m)
            clefs(prem);
        return keys;
    }
    public static int RandomChoice(ArrayList<Integer> keys)
    {
        Random rand = new Random();
        int i= rand.nextInt((keys.size() - 1) + 1) + 0;
        return prem.get(i);
        //return rand.nextInt((keys.size()));
    }
     public static int RandomRandInt(int min,int max)
    {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) +min;
        //return rand.nextInt((keys.size()));
    }
    public static int[] convertBinary(int no) {
    int i = 0, temp[]= new int[20];
    int binary[];
   /* if(no<128)
    {
        temp = new int[7];
    }
    else if(no<256){
        temp = new int[8];
    }
    else if(no<512){
        temp = new int[9];
    }
    else {
        temp = new int[10];
    }*/
    while (no > 0) {
        temp[i++] = no % 2;
        no /= 2;
    }
    binary = new int[i];
    int k = 0;
    for (int j = i - 1; j >= 0; j--) {
        binary[k++] = temp[j];
    }

    return binary;
}
    public static int squarMultiply(int a ,int m,int binary[])
    {      
        int result=1;
        for(int i=0;i<binary.length;i++)
        {
            if (binary[i]==1)
            {
                result = (result*result)*a;
            }
            else 
            {
                result = result *result;
            }
            result = result %m;
        }
        
        return result;
    }
   
    public static HashMap<Character,Integer> getKey()
    {
        return  keys;
    }
}
