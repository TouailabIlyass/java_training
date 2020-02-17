/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author kingdragon
 */
public class Vue extends JFrame{
    
    public JTabbedPane tab = new JTabbedPane();
    public JLabel lbl = new JLabel();
    public JTextField txt = new JTextField();
    public JButton btn = new JButton("Send");
   
    public Vue() throws IOException
    {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.getContentPane().setLayout(null);
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        p1.setBounds(0, 0, 100, 500);
        p1.setBackground(Color.red);
        p2.setBounds(120, 0, 250, 500);
        p2.setBackground(Color.BLUE);
        tab.setSize(300, 300);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.add(p1);p.add(p2);
       //p.setLayout(null);
        p.setSize(100,100);
        txt.setBounds(0, 400, 200, 20);
        btn.setBounds(250, 400, 100, 20);
        
        
        
        lbl.setText("hhhhhhh");
       p1.add(lbl);
       lbl = new JLabel("bbbbbbb");
       p2.add(lbl);
        tab.addTab("tab1",p);
        this.getContentPane().add(tab);
        this.getContentPane().add(txt);
        this.getContentPane().add(btn);
        
        Socket s= new Socket("127.0.0.1", 1111);
        
        Thread t =new Thread(new Runnable() {
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			@Override
			public void run() {
                            String str="";
				while(true)
				{
					try {
						str=br.readLine();
                                                lbl=new  JLabel(str+"\n");
                                                p1.add(lbl);
                                               validate();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
				 
			}
		});
		t.start();
                
                
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                
                btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                pw.println(txt.getText());
                pw.flush();
                lbl=new JLabel(txt.getText());
                p2.add(lbl);
                txt.setText("");
                validate();
		
            }
        });
		
     
    }
    
}
