/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Amy Zhang
 * Date: October 3, 2023
 * Modify an array from a JFrame
 */
public class SumElement extends javax.swing.JFrame {

    /**
     * Creates new form SumElement
     */
    
    int[] array = new int[20];
    int nextEmpty = 0;
    
    public SumElement() {
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

        lblTitle = new javax.swing.JLabel();
        lblInstructio = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtList = new javax.swing.JTextArea();
        btnSumAll = new javax.swing.JButton();
        btnSumEven = new javax.swing.JButton();
        btnSumOdd = new javax.swing.JButton();
        txtOutput = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        lblInputError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Old English Text MT", 0, 36)); // NOI18N
        lblTitle.setText("Integer Sums");

        lblInstructio.setText("Enter an Integer:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        txtList.setEditable(false);
        txtList.setColumns(20);
        txtList.setLineWrap(true);
        txtList.setRows(5);
        jScrollPane1.setViewportView(txtList);

        btnSumAll.setText("Sum All");
        btnSumAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumAllActionPerformed(evt);
            }
        });

        btnSumEven.setText("Sum Even");
        btnSumEven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumEvenActionPerformed(evt);
            }
        });

        btnSumOdd.setText("Sum Odd");
        btnSumOdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumOddActionPerformed(evt);
            }
        });

        txtOutput.setEditable(false);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblInputError.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblInstructio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnRemove))
                                    .addComponent(lblInputError, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnSumEven)
                                        .addComponent(btnSumOdd)
                                        .addComponent(btnSumAll)
                                        .addComponent(txtOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitle)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInstructio)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInputError, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnSumAll)
                        .addGap(18, 18, 18)
                        .addComponent(btnSumEven)
                        .addGap(18, 18, 18)
                        .addComponent(btnSumOdd)
                        .addGap(18, 18, 18)
                        .addComponent(txtOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit))
                    .addComponent(jScrollPane1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //returns 0 if not valid, else returns valid int
    public int validInteger(String value){
         try {
            int intValue = Integer.parseInt(value);
            if (intValue <= 0) {
                lblInputError.setText("Input not positive integer");
                return 0;
            }
            return intValue;
        } catch (NumberFormatException e) { 
            lblInputError.setText("Input not an integer");
            return 0;
        }
    }

    //Updates text in text area txtList 
    public void updateList(int divisor, int remainder){
        txtList.setText("");
        for (int num : array) {
            if (num == 0) break;
            if (num % divisor == remainder){
                txtList.append(num + "\n");
            }
        }
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        lblInputError.setText("");
        
        //Checks int validity
        int value = validInteger(txtInput.getText());
        if (value == 0) return;
        //Checks array range
        if (nextEmpty == 20) {
            lblInputError.setText("Array range exceeded");
            return;
        }

        //updates
        array[nextEmpty] = value;
        nextEmpty++;
        txtInput.setText("");
        updateList(1, 0);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        lblInputError.setText("");
        int getRid = 0, remove;
        
        //check int validity
        remove = validInteger(txtInput.getText());
        if (remove == 0) return;
        txtInput.setText("");   
        
        //find first appearance in array
        while (getRid < 20 && array[getRid] != remove){ 
            getRid++;
        }
        
        //returns, if int not found
        if (getRid == 20) {
            lblInputError.setText("Integer not found");
            return;
        }
        array[getRid] = 0;
        
        //goes through array, checks if term above is 0, moves zero down  
        for (int i = 1; i < 20; i++) {
            if (array[i - 1] == 0) {
                array[i - 1] = array[i];
                array[i] = 0;
            }
        }
        nextEmpty--;
        updateList(1, 0);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSumAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumAllActionPerformed
        int sum = 0;
        
        for (int num : array) {
            sum += num;
        }
        txtOutput.setText("The sum of all integers is : " + sum);
        
        updateList(1, 0);
    }//GEN-LAST:event_btnSumAllActionPerformed

    private void btnSumEvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumEvenActionPerformed
        int sum = 0;
        
        for (int num : array) {
            if (num % 2 == 0) sum += num;
        }
        txtOutput.setText("The sum of all even integers is : " + sum);

        updateList(2, 0);
    }//GEN-LAST:event_btnSumEvenActionPerformed

    private void btnSumOddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumOddActionPerformed
        int sum = 0;
        
        for (int num : array) {
            if (num % 2 == 1) sum += num;
        }
        txtOutput.setText("The sum of all odd integers is : " + sum);

        updateList(2, 1);
    }//GEN-LAST:event_btnSumOddActionPerformed

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
            java.util.logging.Logger.getLogger(SumElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SumElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SumElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SumElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SumElement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSumAll;
    private javax.swing.JButton btnSumEven;
    private javax.swing.JButton btnSumOdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInputError;
    private javax.swing.JLabel lblInstructio;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextArea txtList;
    private javax.swing.JTextField txtOutput;
    // End of variables declaration//GEN-END:variables
}