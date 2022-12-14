package cpe20181041;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Cpe20181041 extends javax.swing.JFrame {

   
    Connection con;
    Statement st;
    ArrayList<Clients> students = new ArrayList<>();
    
   //constructor
    public Cpe20181041() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        txtFname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLname = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CPE 2018 1041 (Phone Directory Project)");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11));
        jLabel1.setText("NAME : ");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); 
        jLabel2.setText("EMAIL : ");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); 
        jLabel3.setText("PHONE NUMBER : ");

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "EMAIL ADDRESS", "PHONE NUMBER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudents.setCellSelectionEnabled(true);
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudents);
        if (tblStudents.getColumnModel().getColumnCount() > 0) {
            tblStudents.getColumnModel().getColumn(2).setResizable(false);
        }

        btnSave.setText("SAVE RECORD");
        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.setIconTextGap(0);
        btnSave.setInheritsPopupMenu(true);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE RECORD");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete1.setText("DELETE RECORD");
        btnDelete1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 20)); 
        jLabel4.setText("PHONE DIRECTORY APPLICATION BY AREMU VICTOR DAVID [ CPE / 2018 /1041 ]");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// end of layout design
    
   //Save button method
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
    
        String fname = txtFname.getText().trim();
        String lname = txtLname.getText().trim();
        String id = txtId.getText().trim();
        
        if (!fname.isEmpty() && !lname.isEmpty() && !id.isEmpty()) {
        saveUser(fname, lname, id);
                    DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
                     Object[] row = new Object[4];
                    row[0] = fname;
                    row[1] = lname;
                    row[2] = id;
                    model.addRow(row);
                    clear();
        } 
      
        else {
            alert("please fill in all the details");
        }
    }

   // Update button method 
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        String fname = txtFname.getText().trim();
        String lname = txtLname.getText().trim();
        String id = txtId.getText().trim();
        if (!fname.isEmpty() && !lname.isEmpty() && !id.isEmpty()) {
                    update(fname, lname, id);
                    DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
                     Object[] row = new Object[4];
                    row[0] = fname;
                    row[1] = lname;
                    row[2] = id;
                    model.setRowCount(0); 
                    model.addRow(row);                  
                    alert("Update was successful");
                    clear();
        } else {
            alert("There is nothing to update :(","No row selected");
        }
    }

    //set the values of a row to the textfields
    private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {
        int i = tblStudents.getSelectedRow();
        TableModel model = tblStudents.getModel();
        txtFname.setText(model.getValueAt(i, 0).toString());
        txtLname.setText(model.getValueAt(i, 1).toString());
        txtId.setText(model.getValueAt(i, 2).toString());
    }

    //delete button method 
    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {
        int i = tblStudents.getSelectedRow();
        if (i >= 0) {
            int option = JOptionPane.showConfirmDialog(rootPane,
                    "Are you sure you want to Delete?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                TableModel model = tblStudents.getModel();

                String id = model.getValueAt(i, 2).toString();
                if (tblStudents.getSelectedRows().length == 1) {
                    delete(id);
                    DefaultTableModel model1 = (DefaultTableModel) tblStudents.getModel();
                    model1.setRowCount(0);
                    clear();
                }
            }
        } else {
            alert("Please select a row to delete");
        }
    }

    //method to show an info alert
    public void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

    //method to show an error alert
    public void alert(String msg, String title) {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    //method to save user to the db
    public void saveUser(String fname, String lname, String id) {
      clear();
    }

    //update the db
    public void update(String fname, String lname, String id) {
    clear();
  
    }

    //delete details in the db
    public void delete(String id) {
        clear();
    }

    //method to clear the txt fields
    private void clear() {
        txtFname.setText("");
        txtLname.setText("");
        txtId.setText("");
    }

   
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cpe20181041.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cpe20181041.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cpe20181041.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cpe20181041.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Cpe20181041().setVisible(true);
        });
    }

    // Variables declaration 
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLname;
 
}
