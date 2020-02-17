
package rsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author drging
 */
public class RSA {

    
    private static int binarypublic[]=null;
    private static int binaryprive[]=null;
    public static void main(String[] args) {
        HashMap <Character,Integer> keys;
        ArrayList<Integer> l=crible(100);
        keys=clefs(l);
        //System.out.println("d = "+RandomChoice(l));
        /*
        String str="Hello";
         binarypublic=convertBinary(71);
         ArrayList<Integer> msgC= new ArrayList<Integer>();
        for(int i=0;i<str.length();i++)
        {
         msgC.add(squarMultiply((int)str.charAt(i),71,1073,binarypublic));
        }
        for(int i=0;i<msgC.size();i++)
        {
            System.out.println("dec = "+squarMultiply(msgC.get(i),71,1073,binarypublic));
        }
        */
         
       
        System.out.println(inv_mode(keys.get('n'), keys.get('e')));
    
        
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
    
    public static int inv_mode(int m,int e)
    {
        try{
        int a0,a1,s,r,q1,y0,y1,m0;
        a0=m;y0=0;y1=1;
        a1=e;q1=m/e;m0=m;
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
        while(y1<0)
            y1+=m0;
        return y1;
       
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
         return 0;
    }
    public static HashMap <Character,Integer> clefs(ArrayList<Integer> prem)
    {  HashMap <Character,Integer> keys = new HashMap<>();
        int p=RandomChoice(prem);
        int q=RandomChoice(prem);
        int n=p*q;
        int m=(p-1)*(q-1);
        int i=0;
        int e=prem.get(i);
        //int e=71;
        int d;
        while(inv_mode(m, e)==0)
        {
            e=prem.get(++i);
            if(i+1==prem.size())
                break;
        }
        d=inv_mode(m, e);
        keys.put('e', e);
        keys.put('d', d);
        keys.put('n', n);
        return keys;
    }
    public static int RandomChoice(ArrayList<Integer> keys)
    {
        Random rand = new Random();
        return rand.nextInt((keys.size() - 0) + 1) + 0;
        //return rand.nextInt((keys.size()));
    }
   
    public static int[] convertBinary(int no) {
    int i = 0, temp[] = new int[7];
    int binary[];
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
    public static int squarMultiply(int a ,int n,int m,int binary[])
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

}
