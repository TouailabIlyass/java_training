/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import Socket.ClientP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author kingdragon
 */
public class Controller implements ActionListener{
    private Fenetre fenetre;
    
    public Controller(Fenetre f)
    {
        fenetre=f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(fenetre.getButtonEq()))
        {
            double x,y;
            char op='+';
            char [] s=fenetre.getTextfield().getText().toCharArray();
            String s1="";
            for (int i = 0; i <s.length; i++) {
                if(s[i]=='+')
                {   op='+';s1+=',';}
                else if(s[i]=='-')
                   {   op='-';s1+=',';}
                 else if(s[i]=='*')
                  {   op='*';s1+=',';}
                 else if(s[i]=='/')
                   {   op='/';s1+=',';}
                
                 else{
                     s1+=s[i];
                 }
                
                
            }
            String[] s2=  s1.split(",");
            x=Double.valueOf(s2[0]);
            y=Double.valueOf(s2[1]);
            try {
                fenetre.getTextfield().setText(ClientP.cl(x, y, op));
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        else {
            JButton btn =(JButton) e.getSource();
            fenetre.getTextfield().setText(fenetre.getTextfield().getText()+btn.getText());
        }
        
    }
    
}
