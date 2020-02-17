
package chatapp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.commons.io.FileUtils;


public class Vue2 extends JFrame{
    private JPanel pan1= new JPanel();
    private JPanel pan2= new JPanel(new  GridLayout(1, 1));
    private JButton btn = new JButton("Entrer");
    private JButton send = new JButton("Envoyer");
    private JButton file = new JButton("new file");
    private JTextField field= new JTextField("");
    private JLabel lbl= new JLabel("user  :  ");
    private JLabel lbl2= new JLabel();
    private DefaultListModel<String> model= new DefaultListModel<String>();
    private JList<String>  Listclient = new JList<String>(model);
   
    private String user;
    private Socket s;
    private  PrintWriter pw;
    private   BufferedReader br;
    private boolean d=false;
    private String path="";

    public Vue2() throws IOException
    {
        this.setVisible(true);
        this.setBounds(500,200,420, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("chat app");
        pan1.setLayout(null);
        pan1.add(btn);
        btn.setBounds(130, 200, 110, 40);
        field.setBounds(90, 130, 220, 20);
        lbl.setBounds(90, 90, 210, 10);
        lbl2.setBounds(90, 90, 210, 10);
        pan1.add(lbl);
        pan1.add(field);
        this.add(pan1);
        

        pan2.setBounds(0, 0, 200, 200);
       
        pan2.add(Listclient);
        pan2.setSize(390,390);
       
        
         send.setBounds(250, 400, 100, 20);
        file.setBounds(360, 400, 100, 20);
      
        
        
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(!field.getText().equals("")) {
                   getContentPane().remove(pan1);setSize(500, 500);
                  getContentPane().setLayout(null);
                      
                       getContentPane().add(field);
                       getContentPane().add(send); 
                       getContentPane().add(file); 
                        getContentPane().add(pan2); 
                         field.setBounds(20, 400, 200, 20);
                       
                       user=field.getText();
                       field.setText("");
                     
                      
                 }
            }
        });
      
            s= new Socket("127.0.0.1", 1111);
         br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Thread t =new Thread(new Runnable(){
			
			@Override
			public void run() {
                            String str="";
				while(true)
				{
					try {  
                                            System.out.println("att");
						str=br.readLine();
                                                System.out.println("what  "+str);
                                                if(str.contains("true"))
                                                {  System.out.println("okokokok");
                                                     Read();
                                                     model.addElement("vous avez recu un fichier");
                                                     System.out.println("ici");
                                                   
                                                }
                                                else
                                                {
                                                    model.addElement(str);
                                                  System.out.println("recu "+str); 
                                                }
                                               
                                              
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
				 
			}
		});
		t.start();
                
                
                 pw = new PrintWriter(s.getOutputStream());
                
            send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             if(path.equals(""))
             {
                pw.println(user +" a dit : "+field.getText());
                pw.flush();
                model.addElement("moi : "+field.getText());
                 
               
              
             }
             else 
             {
                 try {
                     Write(field.getText());
                      model.addElement("vous avez envoyer un fichier");
                 } catch (IOException ex) {
                     System.out.println(ex.getMessage());
                 } catch (InterruptedException ex) {
                     System.out.println(ex.getMessage());
                 }
                 path="";
             }
                field.setText("");
              
		
            }
        });
        
        
        
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFileChooser chose = new JFileChooser();
                chose.showOpenDialog(file);
                path=chose.getSelectedFile().getAbsolutePath();
               field.setText(path);
                pw.println("true");
                pw.flush();

                
                
            }
        });
        
 
        
         
    }
    
      private void Write(String str) throws FileNotFoundException, IOException, InterruptedException
       { 
           File f = new File(str);
           //System.out.println("ici dans write");
          List<String> s=FileUtils.readLines(f, "utf-8");
          for (String line : s) {
               pw.println(line);
                pw.flush();
                System.out.println(line);
            }
          // System.out.println("ok2222222222");
          Thread.sleep(1000);
           pw.println("fin");
           pw.flush();
           //System.out.println("fin");
       }
      
        private void Read() throws FileNotFoundException, IOException
       { 
           File file = new File("/home/kingdragon/Desktop/test.txt");
          // System.out.println("read");
          
          
           String s="",s1="";
           while(!(s1=br.readLine()).equals("fin"))
           { 
             s+=s1;
             
 
           }
           FileUtils.writeStringToFile(file,s, "utf-8"); 
          
           //System.out.println("khraj");
          
       }
}
