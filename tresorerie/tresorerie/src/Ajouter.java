
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zakaria
 */
public class Ajouter extends javax.swing.JFrame {

    /**
     * Creates new form Ajouter
     */
     Connection con;
    public Ajouter() {
        initComponents();
        setTitle("Ajout");
        this.setVisible(true);
        con=BaseDonne.getInstance().getConnexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        fieldlsaisie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldcmd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxBanque = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxAgence = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxVille = new javax.swing.JComboBox<>();
        jComboBoxnumcompte = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fieldN_Order = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fieldArrive = new javax.swing.JTextField();
        btnaj = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Fournisseur");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 80, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 130, -1));

        jLabel2.setText("Code frs");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 70, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 130, -1));

        jLabel3.setText("SAISIE/ARRET");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 70, -1));
        getContentPane().add(fieldlsaisie, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 130, -1));

        jLabel4.setText("Commande/Marche");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 100, -1));
        getContentPane().add(fieldcmd, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 130, -1));

        jLabel5.setText("BANQUE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 50, -1));

        jComboBoxBanque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBoxBanque, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 130, -1));

        jLabel6.setText("Agence");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 60, -1));

        jComboBoxAgence.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBoxAgence, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 130, -1));

        jLabel7.setText("Ville");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 50, -1));

        jComboBoxVille.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVilleActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxVille, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 130, -1));

        jComboBoxnumcompte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBoxnumcompte, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 130, -1));

        jLabel8.setText("N Compte");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 80, -1));

        jLabel9.setText("N order");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 50, -1));
        getContentPane().add(fieldN_Order, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 130, -1));

        jLabel10.setText("Arrivee");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 60, -1));
        getContentPane().add(fieldArrive, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 130, -1));

        btnaj.setText("Valide");
        btnaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnajActionPerformed(evt);
            }
        });
        getContentPane().add(btnaj, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxVilleActionPerformed

    private void btnajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnajActionPerformed
        PreparedStatement state;
      
     
        System.out.println("hello");
         try {
             state=con.prepareStatement("select Fournisseur,Code_Frs from fournisseur");
             ResultSet result=state.executeQuery();
             this.jComboBox1.removeAllItems();
             this.jComboBox2.removeAllItems();
             while(result.next())
             {
                 this.jComboBox1.addItem(result.getString(1));
                 this.jComboBox2.addItem(result.getString(2));

             }
             state=con.prepareStatement("select Banque,N_Compte from banque");
             result=state.executeQuery();
             this.jComboBoxBanque.removeAllItems();
             this.jComboBoxnumcompte.removeAllItems();
             while(result.next())
             {
                 this.jComboBoxBanque.addItem(result.getString(1));
                 this.jComboBoxnumcompte.addItem(result.getString(2));

             }
             state=con.prepareStatement("select Ville,Agence from ville");
             result=state.executeQuery();
             this.jComboBoxAgence.removeAllItems();
             this.jComboBoxVille.removeAllItems();
             while(result.next())
             {
                 this.jComboBoxVille.addItem(result.getString(1));
                 this.jComboBoxAgence.addItem(result.getString(2));
//this.jComboBox1.addItem("id");
//this.jComboBox1.addItem("Nom");
             }
             
            
             
             state=con.prepareStatement("insert into attestation_rib values(?,?,?,?,?,?,?,?,?)");
             state.setInt(1, 0);
             state.setInt(2, Integer.valueOf(this.jComboBox2.getSelectedItem().toString()));
             state.setString(3,this.fieldlsaisie.getText());
             state.setString(4,this.fieldcmd.getText());
             state.setInt(5, Integer.valueOf(this.jComboBoxnumcompte.getSelectedItem().toString()));
             state.setString(6,this.jComboBoxAgence.getSelectedItem().toString());
             state.setString(7,this.jComboBoxVille.getSelectedItem().toString());
             state.setInt(8, Integer.valueOf(this.fieldN_Order.getText()));
             state.setString(9,this.fieldArrive.getText());

                   
             state.executeUpdate();
             System.out.println("bien");
             
         } catch (SQLException ex) {
             Logger.getLogger(PAcceuil.class.getName()).log(Level.SEVERE, null, ex);
         }
      
        System.out.println("ville" +this.jComboBoxVille.getSelectedItem());
    }//GEN-LAST:event_btnajActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ajouter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ajouter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaj;
    public javax.swing.JTextField fieldArrive;
    public javax.swing.JTextField fieldN_Order;
    public javax.swing.JTextField fieldcmd;
    public javax.swing.JTextField fieldlsaisie;
    private javax.swing.JButton jButton1;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JComboBox<String> jComboBox2;
    public javax.swing.JComboBox<String> jComboBoxAgence;
    public javax.swing.JComboBox<String> jComboBoxBanque;
    public javax.swing.JComboBox<String> jComboBoxVille;
    public javax.swing.JComboBox<String> jComboBoxnumcompte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
