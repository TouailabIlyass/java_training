
package chatapp;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class Vue3 extends JFrame{
    private JPanel pan1= new JPanel();
    private JPanel panlist= new JPanel();
    private JPanel pan2= new JPanel();
    private JPanel pan3= new JPanel();
     private JPanel pan4= new JPanel();
    private JButton btn = new JButton("Entrer");
    private JTextField field= new JTextField("");
    private JLabel lbl= new JLabel("user  :  ");
    private JLabel lbl2= new JLabel("user  :  ");
    private DefaultListModel<String> model= new DefaultListModel<>();
    private JList<String>  Listclient = new JList<>(model);
     public JTabbedPane tab = new JTabbedPane();
  Socket s;
    public Vue3() throws IOException
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
        

        ////////////////
 
        JPanel p1 = new JPanel();
       
        p1.setBounds(0, 0, 200, 200);
        p1.setBackground(Color.red);
         p1.add(Listclient);
        tab.setSize(400, 400);
        JPanel p = new JPanel(new  GridLayout(1, 1));
       // p.setLayout(null);
        p.add(Listclient);
        p.setSize(390,390);
       
        
        
        
    
        
        
        
        
        
        
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(!field.getText().equals("")) {
                  remove(pan1);setSize(500, 500);
                  getContentPane().setLayout(null);
                       getContentPane().add(tab);
                       getContentPane().add(field);
                       getContentPane().add(btn); 
                        field.setBounds(0, 400, 200, 20);
                        btn.setBounds(250, 400, 100, 20);
                     
                           
                              tab.addTab("tab1",p);
                       validate();
                    // try {
                        //s = new Socket("127.0.0.1", 1111);
                          //PrintWriter pw = new PrintWriter(s.getOutputStream());
                          // pw.println(field.getText());
                          // pw.flush();
                   //  } catch (IOException ex) {
                       //  System.out.println(ex.getMessage());
                         
                   //  }
                   
                 }
            }
        });
        
        
        
        
         
    }
}
