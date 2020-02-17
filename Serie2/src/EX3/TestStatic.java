/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX3;

/**
 *
 * @author kingdragon
 */
public class TestStatic {
    
    private static int id=0;
    private int x;

    public TestStatic() {
       
        x=++id;
    }
    
    public int getIdent()
    {
        return x;
    }
    
    public static int getIdentMax()
    {
        return TestStatic.id;
    }
    
    public static int A(int m ,int n)
    {
        if(m==0 && n>0) return n+1;
        else if(n==0 && m>0) return A(m-1,1);
        return A(m-1,A(m,n-1));
    }
}
