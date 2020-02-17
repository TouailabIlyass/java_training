
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class Read implements NativeKeyListener {
	
	
	

	InputStream inputStream = null;
	Properties properties = null;
	
        File f=null;

	/**
	 * The constructor.
	 * @throws IOException
	 */
	public Read() throws IOException {
		
		
		properties = new Properties();
		properties.load(inputStream);
		
		
                f=new File("test.txt");
	}


	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		
		System.out.println(NativeKeyEvent.getKeyText(e.getKeyCode()));
             
	}

	
	@Override
	public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
	}

	
	@Override
	public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
	}

  	



    
}
