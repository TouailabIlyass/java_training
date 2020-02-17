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
public class EX3 {
    
    
    public static void main(String[] args) {
        
        TestStatic obj1 = new TestStatic();
        TestStatic obj2 = new TestStatic();
        TestStatic obj3 = new TestStatic();
        
        System.out.println("id pour obj1 = "+obj1.getIdent());
        
        System.out.println("max des objet cree est : "+TestStatic.getIdentMax());
        System.out.println("----------------------------------------");
        
        System.out.println("Acker = "+TestStatic.A(2, 2));
        
    }
}
