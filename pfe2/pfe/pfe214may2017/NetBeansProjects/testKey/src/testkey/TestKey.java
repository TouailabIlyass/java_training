/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testkey;

import java.math.MathContext;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author kingdragon
 */
public class TestKey implements NativeKeyListener{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NativeHookException {
        GlobalScreen.registerNativeHook();
        GlobalScreen.getInstance().addNativeKeyListener(new TestKey());
        
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
       
        System.out.println(NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
        System.out.println("Released()");
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
       System.out.println("typed()");
    }
    
}
