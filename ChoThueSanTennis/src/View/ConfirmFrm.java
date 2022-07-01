/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.BillDAO;
import Model.Bill;
import Model.BookedCourt;
import Model.BookingTicket;
import Model.UseSession;
import Model.UsedService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vvt
 */
public class ConfirmFrm extends javax.swing.JFrame {
    private Bill bill;
    private String paymentMethod = "cash";
    private Date paymentDate = new Date(); 
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    private ArrayList<UsedService> listUS = new ArrayList<>();
    /**
     * Creates new form Confirm
     */
    public ConfirmFrm(Bill bill) {
        initComponents();
        this.bill = bill;
        User.setText(this.bill.getCreator().getName());
        
        // Hien thi thong tin Booking Ticket
        BookingTicket btk = this.bill.getBookingticket();
        String bookingDetail = "<html>ID Booking Ticket: " + btk.getId() + "<br>Booking Date: " + dateFormat.format(btk.getBookingDate()) + "<br>Saleoff: " + btk.getSaleoff() + "<br>Total: " + btk.getTotal() + "<br>Deposit: " + btk.getDeposit();
        if(btk.getNote() != null)
            bookingDetail += "<br>Note: " + btk.getNote();
        // Hien thi thong tin client
        bookingDetail += "<br><br>ID Client: " + btk.getClient().getId() + "<br>Name: " + btk.getClient().getName() + "<br>Address: " + btk.getClient().getAddress() + "<br>Mail: " + btk.getClient().getMail() + "<br>Tel: " + btk.getClient().getTel() + "<br>";
        if(btk.getClient().getNote() != null)
            bookingDetail += "<br>Note: " + btk.getClient().getNote();
        
        // Hien thi thong tin Booked Court
        for(BookedCourt bkc : btk.getBookedCourt()){
            bookingDetail += "<br>ID Court: "+ bkc.getTennisCourt().getId() + "<br>Start Date: " + dateFormat.format(bkc.getStartDate()) + "<br>End Date: " + dateFormat.format(bkc.getEndDate()) + "<br>Price: " + bkc.getPrice() + "<br>Saleoff: " + bkc.getSaleoff() + "<br>Subtotal: " + bkc.getSubtotal() + "<br>";
            if(bkc.getNote() != null)
                bookingDetail += "Note:" + bkc.getNote() + "<br>";
            for(UseSession uss : bkc.getUseSession()){
                for(UsedService us : uss.getUsedService())
                    listUS.add(us);
            }
        }
        
        BookingDetail.setText(bookingDetail + "</html>");
        
        // Hien thi thong tin Used Service
        String[] collumnUSNames = {"Id Service", "Name Service", "Amount", "Price", "Saleoff", "Total", "Note"};
        String[][] value = new String[listUS.size()][7];
        
        for(int i = 0;i < listUS.size();i++){
            value[i][0] = listUS.get(i).getService().getId() + "";
            value[i][1] = listUS.get(i).getService().getName();
            value[i][2] = listUS.get(i).getAmount() + "";
            value[i][3] = listUS.get(i).getPrice() + "";
            value[i][4] = listUS.get(i).getSaleoff() + "";
            value[i][5] = listUS.get(i).getTotal() + "";
            value[i][6] = listUS.get(i).getNote();
        }
        DefaultTableModel tableModel = new DefaultTableModel(value, collumnUSNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //unable to edit cells
		return false;
            }
	};
        SvTable.setModel(tableModel);
        // Hien thi thong tin hoa don + nhap thong tin
        PayDetail.setText("<html>Money have to pay: " + String.valueOf(bill.getBookingticket().getTotalLeft()) + "<br>Pay Method: " + paymentMethod + "<br>Pay Date: " + dateFormat.format(paymentDate) + "</html>");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        BookingDetail = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PayMoney = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        SvTable = new javax.swing.JTable();
        PayDetail = new javax.swing.JLabel();
        Note = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Confirm.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        Confirm.setText("Confirm");
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });
        jPanel1.add(Confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 109, -1));

        Cancel.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        jPanel1.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 109, -1));

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Bill Detail");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 57, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user_icon.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 11, -1, -1));

        User.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        User.setText("User's name");
        jPanel1.add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 19, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BookingDetail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        BookingDetail.setText("Bill infomation");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Pay money");

        PayMoney.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        PayMoney.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SvTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Service", "NameService", "Amount", "Price", "Saleoff", "Total", "note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        SvTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SvTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(SvTable);

        PayDetail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        PayDetail.setText("Bill infomation");

        Note.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Note.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Note");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                            .addComponent(BookingDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PayDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PayMoney, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(Note))))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(BookingDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PayDetail)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PayMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 101, 506, 300));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/receptionist_bg.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 705, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        new SearchBookingTicketFrm(bill.getCreator(), bill.getBookingticket().getClient()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelActionPerformed

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        if(PayMoney.getText().length() == 0 || Float.parseFloat(PayMoney.getText()) < 1000){
            JOptionPane.showMessageDialog(this, "The money pay is invalid!");
            return;
        }
        
        bill.setPaymentMethod(paymentMethod);
        bill.setPaymentDate(paymentDate);
        bill.setAmount(Float.parseFloat(PayMoney.getText()));
        if(Note.getText() != "")
            bill.setNote(Note.getText());
        
        BillDAO bd = new BillDAO();
        if(bd.AddBill(bill)){
            JOptionPane.showMessageDialog(this, "The bill is successfully added!");
            new ReceptionistHomeFrm(bill.getCreator()).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_ConfirmActionPerformed

    private void SvTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SvTableMouseClicked
        int index = SvTable.getSelectedRow();
        new EditBillFrm(bill, listUS.get(index)).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SvTableMouseClicked

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
            java.util.logging.Logger.getLogger(ConfirmFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConfirmFrm().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookingDetail;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Confirm;
    private javax.swing.JTextField Note;
    private javax.swing.JLabel PayDetail;
    private javax.swing.JTextField PayMoney;
    private javax.swing.JTable SvTable;
    private javax.swing.JLabel User;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}