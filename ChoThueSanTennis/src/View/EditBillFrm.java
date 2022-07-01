/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.BillDAO;
import Model.Bill;
import Model.UsedService;
import javax.swing.JOptionPane;

/**
 *
 * @author vvt
 */
public class EditBillFrm extends javax.swing.JFrame {
    private Bill bill;
    private UsedService usedService;
    /**
     * Creates new form EditBill
     */
    public EditBillFrm(Bill bill, UsedService usedService) {
        this.bill = bill;
        this.usedService = usedService;
        initComponents();
        
        User.setText(bill.getCreator().getName());
        
        SvName.setText(this.usedService.getService().getName());
        SvPrice.setText(this.usedService.getPrice() + "");
        SvAmount.setText(this.usedService.getAmount() + "");
        SvSaleoff.setText(this.usedService.getSaleoff() + "");
        SvNote.setText(this.usedService.getNote());
        SvTotal.setText(this.usedService.getTotal() + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Confirm = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        User = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SvName = new javax.swing.JTextField();
        SvAmount = new javax.swing.JTextField();
        SvPrice = new javax.swing.JTextField();
        SvNote = new javax.swing.JTextField();
        SvSaleoff = new javax.swing.JTextField();
        SvTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Confirm.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        Confirm.setText("Confirm");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });
        jPanel1.add(Confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 411, 105, -1));

        Cancel.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        jPanel1.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 105, -1));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Edit Bill");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 68, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_icon.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 11, -1, -1));

        User.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        User.setText("User's name");
        jPanel1.add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 19, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("Name Service");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 154, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 0));
        jLabel4.setText("Price");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 194, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setText("Amount");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 234, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("Saleoff");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 274, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 0));
        jLabel8.setText("Note");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 314, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setText("Total");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 354, -1, -1));

        SvName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SvName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SvName, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 154, 158, 22));

        SvAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SvAmount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SvAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 234, 158, 22));

        SvPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SvPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SvPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 194, 158, 22));

        SvNote.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SvNote.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SvNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 314, 158, 22));

        SvSaleoff.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SvSaleoff.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SvSaleoff, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 274, 158, 22));

        SvTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SvTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SvTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 354, 158, 22));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/receptionist_bg.jpg"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        new ConfirmFrm(bill).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelActionPerformed

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        if(SvName.getText().length() == 0 || SvPrice.getText().length() == 0 || SvAmount.getText().length() == 0 || SvSaleoff.getText().length() == 0 || SvTotal.getText().length() == 0)
            return;
        
        usedService.setPrice(Float.parseFloat(SvPrice.getText()));
        usedService.setAmount(Integer.parseInt(SvAmount.getText()));
        usedService.setSaleoff(Float.parseFloat(SvSaleoff.getText()));
        usedService.setNote(SvNote.getText());
        
        BillDAO bd = new BillDAO();
        if(bd.EditBill(usedService)){
            JOptionPane.showMessageDialog(this, "The bill is successfully changed!");
            new ConfirmFrm(bill).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_ConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(EditBillFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditBillFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditBillFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditBillFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EditBillFrm().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Confirm;
    private javax.swing.JTextField SvAmount;
    private javax.swing.JTextField SvName;
    private javax.swing.JTextField SvNote;
    private javax.swing.JTextField SvPrice;
    private javax.swing.JTextField SvSaleoff;
    private javax.swing.JTextField SvTotal;
    private javax.swing.JLabel User;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
