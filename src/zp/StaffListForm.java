package zp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class StaffListForm extends javax.swing.JFrame {
    
    public static int per = 0;
    private Connect mdbc;
    private Statement stmt;
    private AddStaff as;
    private EditStaff es;
    String sStr = "";
    public StaffListForm() throws ParserConfigurationException, SAXException, IOException 
    {
        try
        {
        mdbc = new Connect();
        mdbc.init();
        Connection con = mdbc.getMyConnect();
        stmt = con.createStatement();
        }
        catch(SQLException e)
        {
            System.out.println("Error comstruct: " + e);
        }
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        StaffTable = new javax.swing.JTable();
        AddButton = new javax.swing.JButton();
        InfoButton = new javax.swing.JButton();
        DellButton = new javax.swing.JButton();
        pInfoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Данные сотрудников");
        setPreferredSize(new java.awt.Dimension(1000, 700));

        BackButton.setText("Назад");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        ResultSet rs = getResultFromStaff();
        StaffTable.setModel(new StaffTableModel(rs));
        StaffTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mdbc.close(rs);
        StaffTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StaffTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(StaffTable);

        AddButton.setText("Добавить сотрудника");
        AddButton.setPreferredSize(new java.awt.Dimension(79, 40));
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        InfoButton.setText("Просмотреть информацию о сотруднике");
        InfoButton.setEnabled(false);
        InfoButton.setPreferredSize(new java.awt.Dimension(150, 40));
        InfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoButtonActionPerformed(evt);
            }
        });

        DellButton.setText("Удалить сотрудника");
        DellButton.setEnabled(false);
        DellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DellButtonActionPerformed(evt);
            }
        });

        pInfoButton.setText("Посмотреть информацию выплатах сотрудника");
        pInfoButton.setEnabled(false);
        pInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pInfoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                    .addComponent(BackButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pInfoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                            .addComponent(InfoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InfoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public ResultSet getResultFromStaff()
    {
        ResultSet rs = null;
        try
        {
            rs = stmt.executeQuery("SELECT * FROM staff;");
        }
        catch(SQLException e)
        {
        }
        return rs;
    }
    
    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
       dispose();
       new WorkMenuForm().setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void DellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DellButtonActionPerformed
        String TabN = (String)StaffTable.getValueAt(StaffTable.getSelectedRow(),0);
        String str = "";
        try
        {
            str = "DELETE FROM staff WHERE TabN=" + TabN;
            int done = stmt.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Запись успешно удалена!");
            getContentPane().removeAll();
            initComponents();
        }
        catch(SQLException e) {}
    }//GEN-LAST:event_DellButtonActionPerformed

    private void StaffTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StaffTableMouseClicked
        if(StaffTable.getSelectedRowCount() > 0)
        {
            DellButton.setEnabled(true);
            InfoButton.setEnabled(true);
            pInfoButton.setEnabled(true);
        }
        else
        {
            DellButton.setEnabled(false);
            InfoButton.setEnabled(false);
            pInfoButton.setEnabled(false);
        }
    }//GEN-LAST:event_StaffTableMouseClicked

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        per=1;
        as = new AddStaff(this,true);
        as.setVisible(true);
        getContentPane().removeAll();
        initComponents();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void InfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoButtonActionPerformed
        es = new EditStaff(this,true);
        try {
            es.setTabN((String)StaffTable.getValueAt(StaffTable.getSelectedRow(), 0));
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(StaffListForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(StaffListForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StaffListForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        es.setF((String)StaffTable.getValueAt(StaffTable.getSelectedRow(), 1));
        es.setN((String)StaffTable.getValueAt(StaffTable.getSelectedRow(), 2));
        es.setO((String)StaffTable.getValueAt(StaffTable.getSelectedRow(), 3));
        es.setOtdel((String)StaffTable.getValueAt(StaffTable.getSelectedRow(), 4));
        es.setPosition((String)StaffTable.getValueAt(StaffTable.getSelectedRow(), 5));
        es.setVisible(true);
        getContentPane().removeAll();
        initComponents();
    }//GEN-LAST:event_InfoButtonActionPerformed
    
    private void pInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pInfoButtonActionPerformed
        
        ZP.STabN = (String)StaffTable.getValueAt(StaffTable.getSelectedRow(), 0);
        ZP.FIO = ((String)StaffTable.getValueAt(StaffTable.getSelectedRow(), 1)+" "+ (String)StaffTable.getValueAt(StaffTable.getSelectedRow(), 2) +" "+ (String)StaffTable.getValueAt(StaffTable.getSelectedRow(), 3));
        dispose();
        try {
            new pHistoryForm().setVisible(true);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(StaffListForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(StaffListForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StaffListForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pInfoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StaffListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StaffListForm().setVisible(true);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(StaffListForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(StaffListForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(StaffListForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton DellButton;
    private javax.swing.JButton InfoButton;
    private javax.swing.JTable StaffTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pInfoButton;
    // End of variables declaration//GEN-END:variables
}
