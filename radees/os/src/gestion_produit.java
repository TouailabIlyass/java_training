
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class gestion_produit extends javax.swing.JFrame {

    
     
        Connection cnx = null ; 
        
	PreparedStatement prepared = null ; 
	ResultSet resultat = null ; 
      Login l = new Login();
       void fermer()
	{
		dispose();
                
	}
   
    public gestion_produit() {
        initComponents();
        cnx = ConnexionMysql.ConnexionDB();
        UpdateTable();
       
    
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldRech = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        emailfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ideedield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ss_dslbl = new javax.swing.JLabel();
        idfield = new javax.swing.JTextField();
        dp_dslbl1 = new javax.swing.JLabel();
        ss_dslbl1 = new javax.swing.JLabel();
        ss_dslbl2 = new javax.swing.JLabel();
        dpfield = new javax.swing.JTextField();
        sdfield = new javax.swing.JTextField();
        tvafield = new javax.swing.JTextField();
        autrefield = new javax.swing.JTextField();
        societefield = new javax.swing.JTextField();
        telefield = new javax.swing.JTextField();
        btnRech = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        fieldRech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldRechActionPerformed(evt);
            }
        });
        fieldRech.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldRechKeyReleased(evt);
            }
        });
        getContentPane().add(fieldRech);
        fieldRech.setBounds(430, 110, 190, 30);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("Recherche:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(310, 110, 120, 30);

        emailfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailfieldActionPerformed(evt);
            }
        });
        getContentPane().add(emailfield);
        emailfield.setBounds(90, 280, 170, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("societe:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 190, 70, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("num tel:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 240, 65, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("email:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 290, 50, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("idee:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 330, 50, 20);

        ideedield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ideedieldActionPerformed(evt);
            }
        });
        getContentPane().add(ideedield);
        ideedield.setBounds(90, 330, 170, 28);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 150, 520, 370);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajouter.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 560, 70, 70);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modifier.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(390, 560, 70, 70);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/supprimer.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(680, 560, 70, 70);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("ID:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 140, 34, 17);

        ss_dslbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ss_dslbl.setForeground(new java.awt.Color(0, 0, 102));
        ss_dslbl.setText("SD:");
        getContentPane().add(ss_dslbl);
        ss_dslbl.setBounds(10, 430, 40, 20);

        idfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfieldActionPerformed(evt);
            }
        });
        getContentPane().add(idfield);
        idfield.setBounds(90, 130, 170, 30);

        dp_dslbl1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dp_dslbl1.setForeground(new java.awt.Color(0, 0, 102));
        dp_dslbl1.setText("DP:");
        getContentPane().add(dp_dslbl1);
        dp_dslbl1.setBounds(10, 380, 30, 20);

        ss_dslbl1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ss_dslbl1.setForeground(new java.awt.Color(0, 0, 102));
        ss_dslbl1.setText("TVA:");
        getContentPane().add(ss_dslbl1);
        ss_dslbl1.setBounds(10, 470, 120, 20);

        ss_dslbl2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ss_dslbl2.setForeground(new java.awt.Color(0, 0, 102));
        ss_dslbl2.setText("autre:");
        getContentPane().add(ss_dslbl2);
        ss_dslbl2.setBounds(10, 510, 60, 20);

        dpfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpfieldActionPerformed(evt);
            }
        });
        getContentPane().add(dpfield);
        dpfield.setBounds(90, 380, 170, 28);

        sdfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdfieldActionPerformed(evt);
            }
        });
        getContentPane().add(sdfield);
        sdfield.setBounds(90, 430, 170, 28);

        tvafield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvafieldActionPerformed(evt);
            }
        });
        getContentPane().add(tvafield);
        tvafield.setBounds(90, 470, 170, 28);

        autrefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autrefieldActionPerformed(evt);
            }
        });
        getContentPane().add(autrefield);
        autrefield.setBounds(90, 510, 170, 28);

        societefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                societefieldActionPerformed(evt);
            }
        });
        getContentPane().add(societefield);
        societefield.setBounds(90, 190, 170, 30);

        telefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefieldActionPerformed(evt);
            }
        });
        getContentPane().add(telefield);
        telefield.setBounds(90, 240, 170, 30);

        btnRech.setText("Suivant");
        btnRech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechActionPerformed(evt);
            }
        });
        getContentPane().add(btnRech);
        btnRech.setBounds(650, 110, 80, 31);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backg.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, -20, 890, 710);

        setSize(new java.awt.Dimension(866, 696));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        

       
String sql = " insert into bank values (? ,? ,? , ? ,?,? ,? , ? ,?) ";
     
        try {
 

            prepared = cnx.prepareStatement(sql);
            prepared.setInt(1, 0);
            prepared.setString(2, societefield.getText());
            prepared.setString(3, telefield.getText());
            prepared.setString(4, emailfield.getText());
            prepared.setString(5, ideedield.getText());
            prepared.setInt(6,Integer.valueOf(dpfield.getText()));
            prepared.setString(7, sdfield.getText());
            prepared.setDouble(8,Double.valueOf(tvafield.getText()));
            prepared.setString(9, autrefield.getText());

            if(!societefield.getText().equals("")&& !telefield.getText().equals("")&& !emailfield.getText().equals("")&& !ideedield.getText().equals("") && !dpfield.getText().equals("") && !sdfield.getText().equals("") && !tvafield.getText().equals("") && !autrefield.getText().equals(""))
            {

                prepared.execute();
                
               
                JOptionPane.showMessageDialog(null, "Ligne Ajoutée .");
               
                UpdateTable();
            }else
            {
                JOptionPane.showMessageDialog(null, "Remplissez Les Champs Vides !!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void copieLigne(int ligne)
    {
               if(ligne==-1){
                idfield.setText("");
                emailfield.setText("");
                ideedield.setText("");
                societefield.setText("");
                telefield.setText("");
                dpfield.setText("");
                sdfield.setText("");
                tvafield.setText("");
                autrefield.setText("");
               }
               else
               {
                idfield.setText(table.getModel().getValueAt(ligne , 0).toString());  
                emailfield.setText(table.getModel().getValueAt(ligne , 1).toString());
                ideedield.setText(table.getModel().getValueAt(ligne , 2).toString());
                societefield.setText(table.getModel().getValueAt(ligne , 3).toString());
                telefield.setText(table.getModel().getValueAt(ligne , 4).toString());
                dpfield.setText(table.getModel().getValueAt(ligne , 5).toString());
                sdfield.setText(table.getModel().getValueAt(ligne , 6).toString());
                tvafield.setText(table.getModel().getValueAt(ligne , 7).toString());
                autrefield.setText(table.getModel().getValueAt(ligne , 8).toString());
               }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int ligne = table.getSelectedRow();

        if(ligne == -1 )
        {
            JOptionPane.showMessageDialog(null, "Séléctionnez un ligne !");
        }
        else
        {       
            String id2 = table.getModel().getValueAt(ligne , 0).toString();
            String sql = " Update bank set id = ?, societe = ? , num_tel = ?  ,email= ? , idee= ? , depot_ds= ?, saisi_ds= ? , tva= ?, autre= ? where id = '"+id2+"'" ;
              
            try {

                prepared = cnx.prepareStatement(sql);
            prepared.setInt(1, 0);
            prepared.setString(2, societefield.getText());
            prepared.setString(3, telefield.getText());
            prepared.setString(4, emailfield.getText());
            prepared.setString(5, ideedield.getText());
            prepared.setInt(6,Integer.valueOf(dpfield.getText()));
            prepared.setString(7, sdfield.getText());
            prepared.setDouble(8,Double.valueOf(tvafield.getText()));
            prepared.setString(9, autrefield.getText());

                prepared.execute();
                JOptionPane.showMessageDialog(null, "Ligne bien  Modifié :D");
                UpdateTable();
            
                copieLigne(-1);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    int ligne = table.getSelectedRow();

        if(ligne == -1 )
        {
            JOptionPane.showMessageDialog(null, "Séléctionnez un ligne !");
        }
        else
        {
            String id2 = table.getModel().getValueAt(ligne , 0).toString();

        String sql =" delete from bank where id= "+id2;

        try {
                prepared = cnx.prepareStatement(sql);
                
                prepared.execute();
                JOptionPane.showMessageDialog(null, "Ligne  Supprimé");

                UpdateTable();
            
                 copieLigne(-1);
            
              } catch (SQLException e) {
                  System.out.println(e.getMessage());
                     }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int ligne = table.getSelectedRow();

        String id2 = table.getModel().getValueAt(ligne , 0).toString();

        String sql = " Select * from bank  where id = '"+id2+"'";

        copieLigne(ligne);
    }//GEN-LAST:event_tableMouseClicked

    private void ideedieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ideedieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ideedieldActionPerformed

    private void emailfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailfieldActionPerformed

    private void fieldRechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldRechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRechActionPerformed

    private void fieldRechKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldRechKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRechKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
    }//GEN-LAST:event_formWindowOpened

    private void idfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idfieldActionPerformed

    private void dpfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dpfieldActionPerformed

    private void sdfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdfieldActionPerformed

    private void tvafieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvafieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tvafieldActionPerformed

    private void autrefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autrefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autrefieldActionPerformed

    private void societefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_societefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_societefieldActionPerformed

    private void telefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefieldActionPerformed

    private void btnRechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechActionPerformed
        
        String sql = "select * from bank  where id = ?";
         
     
 

            try {
                PreparedStatement prepared = cnx.prepareStatement(sql);
                prepared.setInt(1, Integer.valueOf(fieldRech.getText()));
                
                ResultSet result=prepared.executeQuery();
                if(result.next())
                {
                idfield.setText(fieldRech.getText());
                emailfield.setText(result.getString(4));
                ideedield.setText(result.getString(5));
                societefield.setText(result.getString(2));
                telefield.setText(result.getString(3));
                dpfield.setText(result.getString(6));
                sdfield.setText(result.getString(7));
                tvafield.setText(result.getString(8));
                autrefield.setText(result.getString(9));
                fieldRech.setText("");
                }else
                {
                    JOptionPane.showMessageDialog(null, "Non Trouve !!");
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        
        
    }//GEN-LAST:event_btnRechActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField autrefield;
    private javax.swing.JButton btnRech;
    private javax.swing.JLabel dp_dslbl1;
    private javax.swing.JTextField dpfield;
    private javax.swing.JTextField emailfield;
    private javax.swing.JTextField fieldRech;
    private javax.swing.JTextField ideedield;
    private javax.swing.JTextField idfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sdfield;
    private javax.swing.JTextField societefield;
    private javax.swing.JLabel ss_dslbl;
    private javax.swing.JLabel ss_dslbl1;
    private javax.swing.JLabel ss_dslbl2;
    private javax.swing.JTable table;
    private javax.swing.JTextField telefield;
    private javax.swing.JTextField tvafield;
    // End of variables declaration//GEN-END:variables

public void UpdateTable()
	{
		String sql = " Select * from bank ";
		
		try {
			prepared = cnx.prepareStatement(sql);
			resultat = prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
			                
		} catch (SQLException e) {
		}
		
		
	}

        }


