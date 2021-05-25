package zp;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class UserListForm extends javax.swing.JFrame {
    
    private AEUserForm aed;
    public static int per = 0;
    private Connect mdbc;
    private Statement stmt;
    
    public UserListForm() throws ParserConfigurationException, SAXException, IOException 
    {
        aed = new AEUserForm(this,true);
        try
        {
        mdbc = new Connect();
        mdbc.init();
        Connection con = mdbc.getMyConnect();
        stmt = con.createStatement();
        }
        catch(SQLException e)
        {
        }
        initComponents();
    }
    
    public ResultSet getResultFromUsers()
    {
        ResultSet rs = null;
        try
        {
            rs = stmt.executeQuery("SELECT * FROM users;");
        }
        catch(SQLException e)
        {
        }
        return rs;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();
        DellButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        UsersListTable = new javax.swing.JTable();
        EditButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Список пользователей");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        BackButton.setText("Назад");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        AddButton.setText("Добавить нового пользователя");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        DellButton.setText("Удалить пользователя");
        DellButton.setEnabled(false);
        DellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DellButtonActionPerformed(evt);
            }
        });

        ResultSet rs = getResultFromUsers();
        UsersListTable.setModel(new UsersTableModel(rs));
        UsersListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mdbc.close(rs);
        UsersListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsersListTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(UsersListTable);

        EditButton.setText("Данные пользоватей");
        EditButton.setEnabled(false);
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(DellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(EditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
       dispose();
       new WorkMenuForm().setVisible(true);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try 
        {
         mdbc.close(stmt.getResultSet());
         mdbc.destroy();
        } 
        catch (SQLException e)
        {
        }        
    }//GEN-LAST:event_formWindowClosing

    private void DellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DellButtonActionPerformed
        String UserID = (String)UsersListTable.getValueAt(UsersListTable.getSelectedRow(), 0);
        String str = "";
        try
        {
            str = "DELETE FROM users WHERE UserID=" + UserID;
            int done = stmt.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Запись успешно удалена!");
            getContentPane().removeAll();
            initComponents();
        }
        catch(SQLException e)
        {
            
        }
    }//GEN-LAST:event_DellButtonActionPerformed

    private void UsersListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersListTableMouseClicked
        if(UsersListTable.getSelectedRowCount() > 0)
        {
            DellButton.setEnabled(true);
            EditButton.setEnabled(true);
        }
        else
        {
            DellButton.setEnabled(false);
            EditButton.setEnabled(false);
        }
    }//GEN-LAST:event_UsersListTableMouseClicked

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        per = 1;
        aed.setVisible(true);
        try
        {
        String AddStr = "INSERT INTO users VALUES ('"
                +aed.getUserID()+"','"
                +aed.getUserName()+ "','"
                +aed.getUserPass() + "','"
                +aed.getUserLevel() + "');";
        int done = stmt.executeUpdate(AddStr);
        getContentPane().removeAll();
        initComponents();
        }
        catch(SQLException e)
        {
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        per = 2;
        aed.setUserID((String)UsersListTable.getValueAt(UsersListTable.getSelectedRow(), 0));
        aed.setUserName((String)UsersListTable.getValueAt(UsersListTable.getSelectedRow(), 1));
        aed.setUserPass((String)UsersListTable.getValueAt(UsersListTable.getSelectedRow(), 2));
        aed.setUserLvl(Integer.parseInt((String)UsersListTable.getValueAt(UsersListTable.getSelectedRow(), 3)));
        aed.setVisible(true);
        try
        {
            int done;
            String EditStr;
            EditStr = "UPDATE users SET UserID= '"
                    +aed.getUserID()+"' WHERE UserID=" +
                    (String)UsersListTable.getValueAt(UsersListTable.getSelectedRow(), 0);
            done = stmt.executeUpdate(EditStr);
            EditStr = "UPDATE users SET USerName= '"
                    +aed.getUserName()+"' WHERE UserID=" +
                    (String)UsersListTable.getValueAt(UsersListTable.getSelectedRow(), 0);
            done = stmt.executeUpdate(EditStr);
            EditStr = "UPDATE users SET UserPass= '"
                    +aed.getUserPass()+"' WHERE UserID=" +
                    (String)UsersListTable.getValueAt(UsersListTable.getSelectedRow(), 0);
            done = stmt.executeUpdate(EditStr);
            EditStr = "UPDATE users SET UserLevel= '"
                    +aed.getUserLevel()+"' WHERE UserID=" +
                    (String)UsersListTable.getValueAt(UsersListTable.getSelectedRow(), 0);
            done = stmt.executeUpdate(EditStr);
            getContentPane().removeAll();
            initComponents();            
        }
        catch (SQLException e)
        {
            
        }
    }//GEN-LAST:event_EditButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UserListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new UserListForm().setVisible(true);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(UserListForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(UserListForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(UserListForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton DellButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JTable UsersListTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
