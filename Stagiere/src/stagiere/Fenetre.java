/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stagiere;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kingdragon
 */
public class Fenetre extends JFrame{
    private JPanel pan = new JPanel();
    private JPanel pan1 = new JPanel();
    private JPanel pan2 = new JPanel();
    Object[][] data = {

      {"Cysboy", "28 ans", "1.80 m"},

      {"BZHHydde", "28 ans", "1.80 m"},

    };
    String  title[] = {"Pseudo", "Age", "Taille"};
    private JTabbedPane jTabbedPane1 = new JTabbedPane();
    private DefaultTableModel dm = new DefaultTableModel(data, title);
    private  JTable jTable1 = new  JTable(dm);
    
    
    public Fenetre()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBounds(100, 100, 500, 200);
        pan.setLayout(null);
      
        pan1.add(new JScrollPane(jTable1));
        //jTable1.setFillsViewportHeight(true);
        jTabbedPane1.addTab("Donnes", pan1);jTabbedPane1.addTab("Modifier", pan2);
        this.add(jTabbedPane1);
   
    }
    
}
