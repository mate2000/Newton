/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

/**
 *
 * @author Paulina
 */
public class About extends javax.swing.JFrame {

    /**
     * Creates new form About
     */
    public About() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textoIntro = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnHomeinAbout = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnContatcinAbout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setOpaque(false);

        textoIntro.setEditable(false);
        textoIntro.setBackground(new java.awt.Color(0, 0, 0));
        textoIntro.setColumns(20);
        textoIntro.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        textoIntro.setForeground(new java.awt.Color(255, 255, 255));
        textoIntro.setRows(5);
        textoIntro.setText("Esta página tiene como objetivo la divulgación, \nexpansión y difusión de las misiones e investigaciones que \nla NASA lleva acabo, como también se quiere proporcionar \na la comunidad de astrónomos aficionados una \nherramienta de posibles registros astronómicos ");
        textoIntro.setBorder(null);
        textoIntro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoIntro.setOpaque(false);
        textoIntro.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(textoIntro);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 520, 150));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ABOUT US");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        btnHomeinAbout.setBackground(new java.awt.Color(255, 255, 255));
        btnHomeinAbout.setForeground(new java.awt.Color(0, 0, 0));
        btnHomeinAbout.setText("Home");
        btnHomeinAbout.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHomeinAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeinAboutActionPerformed(evt);
            }
        });
        getContentPane().add(btnHomeinAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 70, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("About");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setEnabled(false);
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 70, 30));

        btnContatcinAbout.setBackground(new java.awt.Color(255, 255, 255));
        btnContatcinAbout.setForeground(new java.awt.Color(0, 0, 0));
        btnContatcinAbout.setText("Contact");
        btnContatcinAbout.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnContatcinAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContatcinAboutActionPerformed(evt);
            }
        });
        getContentPane().add(btnContatcinAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 70, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saturno bb.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 868, 429));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeinAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeinAboutActionPerformed
        // TODO add your handling code here:
        home home1 = new home();
        home1.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeinAboutActionPerformed

    private void btnContatcinAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContatcinAboutActionPerformed
        // TODO add your handling code here:
        Contact contact = new Contact();
        contact.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnContatcinAboutActionPerformed

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
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new About().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContatcinAbout;
    private javax.swing.JButton btnHomeinAbout;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea textoIntro;
    // End of variables declaration//GEN-END:variables
}
