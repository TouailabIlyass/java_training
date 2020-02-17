

package game1;

import java.awt.Canvas;
import javax.swing.JFrame;

/**
 *
 * @author kingdragon
 */
public class Window extends Canvas {
    
    
    public Window(int w,int h ,String title,Game1 g)
    {
        JFrame frame= new JFrame(title);
        frame.setSize(w, h);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(g);
        g.start();
        
    }
}
