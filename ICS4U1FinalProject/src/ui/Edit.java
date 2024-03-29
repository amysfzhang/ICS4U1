package ui;

//from this package
import core.*;
//File IO related
import java.io.*;
import java.util.*;
//Display related
import java.text.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this templates
 */

/**
 * Edit a selected Entry's properties: contents, isBookmarked, date, attachments
 * @author Amy Zhang
 */
public class Edit extends javax.swing.JFrame {

    private final User user;
    private final Entry entry;
    ArrayList<File> templates = new ArrayList<>(); //stores templates in the order that is displayed. Easier to find File
    
    /**
     * Creates new form View
     * @param user The user that has logged in, only edits their entry
     * @param entry The entry that is currently being edited
     */
    public Edit(User user, Entry entry) {
        this.user = user;
        this.entry = entry;
        
        if (user == null) { //In case class is run as main class
            System.out.println("Run the Login class as the main class, no user is logged in");
            return;
        }
        
        initComponents();
        this.getRootPane().setDefaultButton(btnSave);
        
        //update components related to Entry
        for (String line : entry.getContent()) txaEntry.append(line + "\n");
        chkBookmark.setSelected(entry.isBookmarked());
        lblTitle.setText("Entry - " + DateFormat.getDateInstance().format(entry.getDate()));
        updateTemplateList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaEntry = new javax.swing.JTextArea();
        btnAttachment = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        chkBookmark = new javax.swing.JCheckBox();
        lblTitle = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstTemplate = new javax.swing.JList<>();
        lblDate = new javax.swing.JLabel();
        lblTemplates = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblError = new javax.swing.JLabel();

        fileChooser.setApproveButtonText("Select");
        fileChooser.setApproveButtonToolTipText("");
        fileChooser.setDialogTitle("Add an attachment");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txaEntry.setColumns(20);
        txaEntry.setRows(5);
        jScrollPane1.setViewportView(txaEntry);

        btnAttachment.setText("Add Attachment");
        btnAttachment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachmentActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        chkBookmark.setText("Bookmarked");

        lblTitle.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        lblTitle.setText("Entry - ");

        btnCancel.setText("Cancel Changes");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        dateChooser.setDate(entry.getDate());

        lstTemplate.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTemplateValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstTemplate);

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDate.setText("Date");

        lblTemplates.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTemplates.setText("Templates");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblError.setForeground(new java.awt.Color(255, 0, 51));
        lblError.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTemplates)
                    .addComponent(lblDate)
                    .addComponent(chkBookmark)
                    .addComponent(btnAttachment)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblTemplates)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(lblDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(btnAttachment)
                                .addGap(36, 36, 36)
                                .addComponent(chkBookmark))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCancel)
                                    .addComponent(btnSave)
                                    .addComponent(lblError))))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Update the items in lstTemplate entries
     */
    private void updateTemplateList() {
        //clears table and ArrayList of tempaltes
        DefaultListModel list = new DefaultListModel();
        templates.clear();
        //adds first element as original file
        list.addElement("<none>");
        templates.add(entry.getFile());
        
        //loops through each file in templates folder
        for (File file : new File("templates").listFiles()) {
            list.addElement(file.getName().substring(0, file.getName().indexOf("."))); //removed extension
            templates.add(file);
        }
        lstTemplate.setModel(list);
    }

    /**
     * Saves the changes made to the current file
     * @param evt When the "Save" button is pressed
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        lblError.setText(""); //resetting text
        
        //Gets the new date
        Date date = dateChooser.getDate();
        //Date changed
        if (user.getEntry(date) == null) {
            entry.setDate(date); //change file date
            user.removeEntry(entry); //remove old file from list
            user.addEntry(entry.getFile()); //add new entry to list
        //Date is taken
        } else if (!entry.getDate().equals(date)) { 
            lblError.setText("Unable to save, entry already exists");
            return;
        }
        
        //Save edits to bookmark and content
        entry.setBookmark(chkBookmark.isSelected());
        entry.setContent(txaEntry.getText().split("\n")); //Rewrites the content
        btnCancelActionPerformed(evt); //Close current, View Frame
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * Closes current frame, goes to View Frame
     * @param evt When the cancel changes button is pressed
     */
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
        new View(user, entry.getDate()).setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * Displays the template selected in lstTemplate
     * @param evt 
     */
    private void lstTemplateValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTemplateValueChanged
        int selected = lstTemplate.getSelectedIndex();
        
        //If <none> is selected, original entry is displayed
        if (selected == 0) {
            chkBookmark.setSelected(entry.isBookmarked());
            txaEntry.setText("");
            for (String line : entry.getContent()) txaEntry.append(line + "\n"); 
        
        //Displays selected template
        } else if (selected > 0) {
            try {
                txaEntry.read(new FileReader(templates.get(selected)), null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_lstTemplateValueChanged

    /**
     * Adds selected attachment from fileChooser to this Entry
     * @param evt When "Add Attachment" button is pressed
     */
    private void btnAttachmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachmentActionPerformed
        //Resource: https://netbeans.apache.org/tutorial/main/kb/docs/java/gui-filechooser/ 
        
        if (fileChooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) return; //no files approved
        File file = fileChooser.getSelectedFile(); //file selectedd

        //making new file to store attachment inside user's folder
        String fileName = "";
        fileName += DateFormat.getDateInstance().format(entry.getDate());
        fileName += "A!";
        fileName += file.getName();   
        try {
            fileName = user.getDirectory() + "\\" + HexFormat.of().formatHex(SecureUtil.encryptFileName(user.getPasswordKey(), fileName.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        File newFile = new File(fileName); //new file location and name

        //encrypts and adds attachment to entry
        SecureUtil.encryptFile(file, newFile, user.getPasswordKey());
        entry.addAttachment(new Attachment(newFile, user));
    }//GEN-LAST:event_btnAttachmentActionPerformed

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
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit(null, null).setVisible(true); //returns null when running as main class, no user logged in
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttachment;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JCheckBox chkBookmark;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblTemplates;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList<String> lstTemplate;
    private javax.swing.JTextArea txaEntry;
    // End of variables declaration//GEN-END:variables
}
