/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.henriqueborba.fwcalbumapp.frontend.pages.register;

import org.springframework.stereotype.Component;

/**
 *
 * @author henrique
 */
@Component
public class RegisterView extends javax.swing.JFrame {

    /**
     * Creates new form RegsterView
     */
    public RegisterView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JLabel();
        arrowBack = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        emailTF = new javax.swing.JTextField();
        passwordTF = new javax.swing.JTextField();
        passwordConfirmationTf = new javax.swing.JTextField();
        registerUser = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordConfirmationLabel = new javax.swing.JLabel();
        entryButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(375, 812));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setIcon(new javax.swing.ImageIcon("/home/henrique/projects/java/POO/fwcalbumapp/assets/images/bola.png")); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        arrowBack.setIcon(new javax.swing.ImageIcon("/home/henrique/projects/java/POO/fwcalbumapp/assets/images/arrow_back.png")); // NOI18N
        getContentPane().add(arrowBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 30, 20));

        nameTF.setToolTipText("Nome completo *");
        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });
        getContentPane().add(nameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 300, 40));

        emailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTFActionPerformed(evt);
            }
        });
        getContentPane().add(emailTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 300, 40));

        passwordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTFActionPerformed(evt);
            }
        });
        getContentPane().add(passwordTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 300, 40));

        passwordConfirmationTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordConfirmationTfActionPerformed(evt);
            }
        });
        getContentPane().add(passwordConfirmationTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 300, 40));

        registerUser.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        registerUser.setText("Cadastrar Usuário");
        getContentPane().add(registerUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        nameLabel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(102, 102, 102));
        nameLabel.setText("Nome Completo *");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        emailLabel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(102, 102, 102));
        emailLabel.setText("Email *");
        getContentPane().add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        passwordLabel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(102, 102, 102));
        passwordLabel.setText("Senha *");
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        passwordConfirmationLabel.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        passwordConfirmationLabel.setForeground(new java.awt.Color(102, 102, 102));
        passwordConfirmationLabel.setText("Confirmar Senha *");
        getContentPane().add(passwordConfirmationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        entryButton.setBackground(new java.awt.Color(121, 20, 53));
        entryButton.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        entryButton.setForeground(new java.awt.Color(253, 206, 80));
        entryButton.setText("Cadastrar");
        entryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(entryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 300, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTFActionPerformed

    private void passwordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTFActionPerformed

    private void emailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTFActionPerformed

    private void passwordConfirmationTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordConfirmationTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordConfirmationTfActionPerformed

    private void entryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryButtonActionPerformed
        
    }//GEN-LAST:event_entryButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arrowBack;
    private javax.swing.JLabel background;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTF;
    private javax.swing.JButton entryButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTF;
    private javax.swing.JLabel passwordConfirmationLabel;
    private javax.swing.JTextField passwordConfirmationTf;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordTF;
    private javax.swing.JLabel registerUser;
    // End of variables declaration//GEN-END:variables
}
