
package game1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kingdragon
 */
public class Game1 extends Canvas implements Runnable{
  
    public static final int W=640, H=W/12*9;
    private Thread thread;
    boolean running=false;
    
    public Game1()
    {
        new Window(W, H, "My First Game", this);
    }
    
    public void start()
    { 
        thread= new Thread(this);
        thread.start();
        running=true;
        
    }
    public void stop()
    {
        try {
            thread.join();
            running=false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void run() {
      long lastTime=System.nanoTime();
      double amountOfTicks=60.0;
      double ns=1000000000/amountOfTicks;
      double delta=0;
      long timer=System.currentTimeMillis();
      int frames=0;
      
      while(running)
      {
          long now=System.nanoTime();
          delta+=(now-lastTime)/ns;
          lastTime=now;
          while(delta>1)
          {
              ticks();
              delta--;
          }
          if(running)
              render();
           frames++;
           if(System.currentTimeMillis()-timer > 1000)
           {
               timer+=1000;
               System.out.println("FPS : "+frames);
               frames=0;
               
           }
      }
       stop(); 
        
    }
    public void ticks()
    {
        
    }
    
    public void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs==null)
        {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.green);
        g.fillRect(0, 0, W, H);
        g.dispose();
        bs.show();
        
    }
    
    
    
    
    
      public static void main(String[] args) {
        new Game1();
    }
    
}
