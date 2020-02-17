

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class attestation_RIB extends javax.swing.JFrame {

       
    DefaultTableModel model;
    Connection con;
    public attestation_RIB() {
        initComponents();
        setVisible(true);
        this.setSize(900, 300);
       con=BaseDonne.getInstance().getConnexion();
         model=(DefaultTableModel) jTable1.getModel();
        try {
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(attestation_RIB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Code Frs", "Fournisseur", "Saisie/Arret", "Commande/Marche", "Ville", "Agence", "Banque", "N°Compte", "Date Ecrit", "Date MAJ", "N_Ordre", "Arrivee"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 169, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
DefaultTableModel dts = new DefaultTableModel();
        
private void afficher() throws SQLException    
{
    PreparedStatement state;
    state=con.prepareStatement("SELECT attestation_rib.ID,attestation_rib.Code_Frs,fournisseur.Fournisseur,attestation_rib.Saisie_Arret,attestation_rib.Commande_Marche,ville.Ville,ville.Agence,banque.Banque,banque.N_Compte,attestation_rib.Date_Ecrit,attestation_rib.Dte_MAJ,attestation_rib.N_Ordre,attestation_rib.Arrivee FROM attestation_rib,fournisseur,ville,banque WHERE attestation_rib.Code_Frs=fournisseur.Code_Frs && attestation_rib.Banque=ville.id && banque.id_Ville=ville.id");
    
    ResultSet result=state.executeQuery();
    model.setRowCount(0);
    while(result.next())
    {
        int id=result.getInt(1);
        int codef=result.getInt(2);
        String s=result.getString(3);
        String c=result.getString(4);
        String cc=result.getString(5);
        String v=result.getString(6);
        String ag=result.getString(7);
        String bq=result.getString(8);
        int ncp=result.getInt(9);
        String d=result.getString(10);
        String d2=result.getString(11);
        String norder=result.getString(12);
        String ar=result.getString(13);
        Object[] obj={id,codef,s,c,cc,v,ag,bq,ncp,d,d2,norder,ar};
        model.addRow(obj);
    }
    jTable1.setModel(model);
}
    




}
