package zp;

import java.io.IOException;
import java.sql.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class EditStaff extends javax.swing.JDialog {

    private Connect mdbc;
    private Statement stmt;
    private Connection conn;
    
    public EditStaff(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }


private void PCommand()
    {
        ResultSet rs;
        PositionCombo.removeAllItems();
        try
        {
          rs = stmt.executeQuery("SELECT DISTINCT position FROM otdelinfo WHERE Otdel = '" + OtdelCombo.getSelectedItem()+"';");
          while(rs.next())
          {
              PositionCombo.addItem(rs.getString("position"));
          }
        }
        catch(SQLException e)
        {
        }
    }
    
    private void OCommand()
    {
        ResultSet rs;
        OtdelCombo.removeAllItems();
        OtdelCombo.addItem("");
        try
        {
          rs = stmt.executeQuery("SELECT DISTINCT otdel FROM otdelinfo;");
          while(rs.next())
          {
              OtdelCombo.addItem(rs.getString("otdel"));
          }
        }
        catch(SQLException e)
        {
        }
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabNField = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();
        OtdelCombo = new javax.swing.JComboBox<>();
        PositionCombo = new javax.swing.JComboBox<>();
        FField = new javax.swing.JTextField();
        NField = new javax.swing.JTextField();
        OField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Изменение данных сотрудника");

        TabNField.setEnabled(false);

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        OtdelCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        OtdelCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                OtdelComboItemStateChanged(evt);
            }
        });

        jLabel1.setText("Табельный номер");

        jLabel2.setText("Фамилия");

        jLabel3.setText("Имя");

        jLabel4.setText("Отчество");

        jLabel5.setText("Отдел");

        jLabel6.setText("Должность");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OKButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OtdelCombo, 0, 300, Short.MAX_VALUE)
                            .addComponent(PositionCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(OField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(NField)
                            .addComponent(FField)
                            .addComponent(TabNField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TabNField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OtdelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PositionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OtdelComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_OtdelComboItemStateChanged
        PCommand();
    }//GEN-LAST:event_OtdelComboItemStateChanged

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        UpdateInfo();
        this.setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EditStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditStaff dialog = new EditStaff(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void setTabN(String TabN) throws ParserConfigurationException, SAXException, IOException
    {
        TabNField.setText(TabN);
        try
        {
          mdbc = new Connect();        
          mdbc.init();
          conn = mdbc.getMyConnect();
          stmt = conn.createStatement();
          OCommand();
        }
        catch(SQLException e)
        {
            System.out.println("Коннект ерорнулся: " +e);
        }
    } 
    public void setF(String F)
    {
        FField.setText(F);
    }
    public void setN(String N)
    {
        NField.setText(N);
    }
    public void setO(String O)
    {
        OField.setText(O);
    }
    public void setOtdel(String Otdel)
    {
        OtdelCombo.setSelectedItem(Otdel);
    }
    public void setPosition(String Position)
    {
        PositionCombo.setSelectedItem(Position);
    }
    
    private void UpdateInfo()
    {
        int done;
        String EditStr;
        try
        {
            EditStr = "UPDATE staff SET F ='"+FField.getText()+"' WHERE TabN="+ TabNField.getText();
            done = stmt.executeUpdate(EditStr);
            EditStr = "UPDATE staff SET I ='"+NField.getText()+"' WHERE TabN="+ TabNField.getText();
            done = stmt.executeUpdate(EditStr);
            EditStr = "UPDATE staff SET O ='"+OField.getText()+"' WHERE TabN="+ TabNField.getText();
            done = stmt.executeUpdate(EditStr);
            EditStr = "UPDATE staff SET Otdel ='"+OtdelCombo.getSelectedItem()+"' WHERE TabN="+ TabNField.getText();
            done = stmt.executeUpdate(EditStr);
            EditStr = "UPDATE staff SET Position ='"+PositionCombo.getSelectedItem()+"' WHERE TabN="+ TabNField.getText();
            done = stmt.executeUpdate(EditStr);
        }
        catch(SQLException e) 
        { 
        System.out.println("Error update: " + e);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FField;
    private javax.swing.JTextField NField;
    private javax.swing.JTextField OField;
    private javax.swing.JButton OKButton;
    private javax.swing.JComboBox<String> OtdelCombo;
    private javax.swing.JComboBox<String> PositionCombo;
    private javax.swing.JTextField TabNField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
