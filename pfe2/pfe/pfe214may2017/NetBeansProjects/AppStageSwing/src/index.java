
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kingdragon
 */
public class index extends javax.swing.JFrame {


    public index() {
        initComponents();
        con=ConBD.getInstance().getConnexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userlbl = new javax.swing.JLabel();
        userfield = new javax.swing.JTextField();
        passlbl = new javax.swing.JLabel();
        passfield = new javax.swing.JPasswordField();
        btncnx = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        lblincorrectPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(586, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userlbl.setText("Username :");
        getContentPane().add(userlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 210, -1));

        userfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userfieldActionPerformed(evt);
            }
        });
        getContentPane().add(userfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 210, 30));

        passlbl.setText("Password :");
        getContentPane().add(passlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 210, -1));

        passfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passfieldActionPerformed(evt);
            }
        });
        getContentPane().add(passfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 210, 30));

        btncnx.setText("Suivant");
        btncnx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncnxActionPerformed(evt);
            }
        });
        getContentPane().add(btncnx, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 110, 40));

        btncancel.setText("Cancel");
        getContentPane().add(btncancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 100, 40));

        lblincorrectPass.setForeground(new java.awt.Color(255, 0, 0));
        lblincorrectPass.setText("jLabel1");
        getContentPane().add(lblincorrectPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 230, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passfieldActionPerformed

    private void userfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userfieldActionPerformed

    private void btncnxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncnxActionPerformed
        
        PreparedStatement p;
        try {
            p=con.prepareStatement("select id from Admin where user = ? and pass = ?");
            p.setString(1, userfield.getText());
            char c []=passfield.getPassword();
            String str ="";
            
            for (char d : c) {
                str=str+d;
                
            }
            p.setString(2,str);
            System.out.println(""+userfield.getText()+" "+str);
            
            ResultSet result =p.executeQuery();
            if(result.next())
            {
                lblincorrectPass.setText("bien");
            }
            else
                lblincorrectPass.setText("incorrect user ou password !!!");
            
        } catch (SQLException ex) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btncnxActionPerformed

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
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
    }
    private Connection con;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btncnx;
    private javax.swing.JLabel lblincorrectPass;
    private javax.swing.JPasswordField passfield;
    private javax.swing.JLabel passlbl;
    private javax.swing.JTextField userfield;
    private javax.swing.JLabel userlbl;
    // End of variables declaration//GEN-END:variables
}
