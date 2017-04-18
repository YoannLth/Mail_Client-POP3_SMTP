/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pop3_client;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import pop3_client.Model.Client;
import pop3_client.Model.ContextPOP3;
import pop3_client.Model.ContextSMTP;
import pop3_client.utils.utils;
import static pop3_client.utils.utils.*;

/**
 *
 * @author yoannlathuiliere
 */
public class POP3ClientMainFrame extends javax.swing.JFrame {
    /**
     * Creates new form Main
     */
    public POP3ClientMainFrame() {
        initComponents();
        
        mailsTableView.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                int id = mailsTableView.getSelectedRow() + 1;
                mailDetailsTextView.setText(mailsInfos.get("" + id));
                delButton.setEnabled(true);
            }
        });
        

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                launchQuit();
                System.exit(0);
            }
        });


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        connectButton = new javax.swing.JButton();
        serverTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        connectUserPasswordButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextView = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        mailsTableView = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        mailDetailsTextView = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        delButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        newMessageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        connectButton.setText("connexion");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        serverTextField.setMinimumSize(new java.awt.Dimension(100, 260));

        jLabel1.setText("Server");

        jLabel3.setText("User");

        userTextField.setEnabled(false);
        userTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Pass");

        passwordTextField.setEnabled(false);
        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });

        connectUserPasswordButton.setText("connexion");
        connectUserPasswordButton.setEnabled(false);
        connectUserPasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectUserPasswordButtonActionPerformed(evt);
            }
        });

        outputTextView.setEditable(false);
        outputTextView.setColumns(20);
        outputTextView.setRows(5);
        jScrollPane1.setViewportView(outputTextView);

        mailsTableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "From", "Object", "Details", "Date", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(mailsTableView);
        if (mailsTableView.getColumnModel().getColumnCount() > 0) {
            mailsTableView.getColumnModel().getColumn(4).setMinWidth(0);
            mailsTableView.getColumnModel().getColumn(4).setPreferredWidth(0);
            mailsTableView.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        mailDetailsTextView.setEditable(false);
        mailDetailsTextView.setColumns(20);
        mailDetailsTextView.setRows(5);
        jScrollPane3.setViewportView(mailDetailsTextView);

        delButton.setText("Delete");
        delButton.setEnabled(false);
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        resetButton.setLabel("Reset (0)");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        newMessageButton.setText("New Message");
        newMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMessageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(serverTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordTextField)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(connectUserPasswordButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addComponent(delButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newMessageButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(connectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectUserPasswordButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delButton)
                    .addComponent(resetButton)
                    .addComponent(newMessageButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        ContextPOP3.getInstance().setIp(serverTextField.getText());
        ContextPOP3.getInstance().setPort(1024);
        ContextPOP3.getInstance().connect();
        
        ContextSMTP.getInstance().setIp(serverTextField.getText());
        ContextSMTP.getInstance().setPort(1025);
        ContextSMTP.getInstance().connect();
        
        String responsePOP3 = ContextPOP3.getInstance().receiveCommand();
        String responseSMTP = ContextSMTP.getInstance().receiveCommand();        
        
        if(!utils.isErrorPOP3(responsePOP3) && !utils.isErrorSMTP(responseSMTP)) {
            serverTextField.setEnabled(false);
            connectButton.setEnabled(false);

            userTextField.setEnabled(true);
            passwordTextField.setEnabled(true);
            connectUserPasswordButton.setEnabled(true);
            ContextPOP3.getInstance().setTimestamp(utils.getTimestamp(responsePOP3));
        }
        
        writeServerResponse(responsePOP3);
    }//GEN-LAST:event_connectButtonActionPerformed

    public void writeServerResponse(String response) {
        outputTextView.append("[SERVER] : " + response + "\n\n\n");
    }
    
    private void writeError(String msg) {
        outputTextView.append("[ERROR] : " + msg + "\n\n\n");
    }
    
    private void writeClientCommand(String msg) {
        outputTextView.append("[CLIENT] : " + msg + "\n\n\n");
    }
    
    public void sendRequest(String command) {
        writeClientCommand(command);
        ContextPOP3.getInstance().sendCommand(command);
    }
    
    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

    private void userTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTextFieldActionPerformed

    private void connectUserPasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectUserPasswordButtonActionPerformed
        if ((!userTextField.getText().equals("")) && (!passwordTextField.getText().equals(""))) {
            String user = userTextField.getText();
            String pass = utils.getEncodedPassword(ContextPOP3.getInstance().getTimestamp(), passwordTextField.getText());
            
            sendRequest("APOP " + user + " " + pass);
            
            String response = ContextPOP3.getInstance().receiveCommand();
            
            writeServerResponse(response);
            
            if(!utils.isErrorPOP3(response)){
                userTextField.setEnabled(false);
                passwordTextField.setEnabled(false);
                connectUserPasswordButton.setEnabled(false);
                launchStat();
                launchList();
            }   
        }
    }//GEN-LAST:event_connectUserPasswordButtonActionPerformed

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) mailsTableView.getModel();

        int id = Integer.parseInt(mailsTableView.getValueAt(mailsTableView.getSelectedRow(), 4).toString());
        delButton.setEnabled(false);
        
        launchDel(id);
    }//GEN-LAST:event_delButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        launchReset();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void newMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMessageButtonActionPerformed
        NewMessageFrame2 frame = new NewMessageFrame2();
        frame.setVisible(true);
    }//GEN-LAST:event_newMessageButtonActionPerformed

    public void launchStat() {
        sendRequest("STAT");
            
        String response = ContextPOP3.getInstance().receiveCommand();
        writeServerResponse(response);
        
        if(!utils.isErrorPOP3(response)) {
            resetButton.setText("Reset (0)");
        }
    }
    
    public void launchList() {
        sendRequest("LIST");
            
        String response = ContextPOP3.getInstance().receiveCommand();
        writeServerResponse(response);

        if(!utils.isErrorPOP3(response)){
            int nbMessages = utils.getNbMessages(response);
            
            for(int i = 1; i <= nbMessages; i++) {
                launchRetr(i);
            } 
        }
    }
    
    public void launchRetr(int id) {
        sendRequest("RETR " + id);
        String response = ContextPOP3.getInstance().receiveRep();
        writeServerResponse(response);
        
        HashMap<String, String> infos = utils.parseRetr(id, response);
        fillMailsTV(infos);
        storeMailsInfos(id, response);
    }
    
    public void launchDel(int id) {
        sendRequest("DELE " + id);
        String response = ContextPOP3.getInstance().receiveRep();
        writeServerResponse(response);
        
        if(!utils.isErrorPOP3(response)) {
            DefaultTableModel model = (DefaultTableModel) mailsTableView.getModel();
            
            deletedMails.put("" + id, new HashMap<String, String>());
            deletedMails.get("" + id).put("Object", model.getValueAt(id -1, 1).toString());
            deletedMails.get("" + id).put("Date", model.getValueAt(id -1, 3).toString());
            deletedMails.get("" + id).put("Expeditor", model.getValueAt(id -1, 0).toString());
            deletedMails.get("" + id).put("Body", model.getValueAt(id -1, 2).toString());

            model.removeRow(id - 1);
            
            String numberOnly= resetButton.getText().replaceAll("[^0-9]", "");
            int nbOfDeletedMsg = Integer.parseInt(numberOnly) + 1;
            
            resetButton.setText("Reset (" + nbOfDeletedMsg + ")");
        }
    }
    
    public void launchQuit() {
        sendRequest("QUIT");
    }
    
    public void launchReset() {
        sendRequest("RSET");
        
        String response = ContextPOP3.getInstance().receiveRep();
        writeServerResponse(response);
        
        if(!utils.isErrorPOP3(response)) {
            DefaultTableModel model = (DefaultTableModel) mailsTableView.getModel();
            
            for(Map.Entry<String, HashMap<String, String>> entry : deletedMails.entrySet()) {
                String key = entry.getKey();
                HashMap value = entry.getValue();
                model.addRow(new Object[]{value.get("Expeditor"), value.get("Object"), value.get("Body"), value.get("Date"), key});
            }
            
        }
    }
    
    public void fillMailsTV(HashMap <String, String> infos) {
        DefaultTableModel model = (DefaultTableModel) mailsTableView.getModel();
        model.addRow(new Object[]{infos.get("Expeditor"), infos.get("Object"), infos.get("Body"), infos.get("Date"), infos.get("ID")});
    }
    
    public void storeMailsInfos(int id, String rep) {
        if(!utils.isErrorPOP3(rep)) {
            String lines[] = rep.split("\\r?\\n");
            String output = "";
            for(int i = 1; i<lines.length; i++) {
                output += lines[i] + "\n";
            }
            
            mailsInfos.put("" + id, output);
            //String out = rep.substring(rep.indexOf('\n')+1);
            
            //mailsInfos.put("" + id, rep);
        }
    }
    
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
            java.util.logging.Logger.getLogger(POP3ClientMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POP3ClientMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POP3ClientMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POP3ClientMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POP3ClientMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JButton connectUserPasswordButton;
    private javax.swing.JButton delButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea mailDetailsTextView;
    private javax.swing.JTable mailsTableView;
    private javax.swing.JButton newMessageButton;
    private javax.swing.JTextArea outputTextView;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField serverTextField;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
    private HashMap<String, String> mailsInfos = new HashMap<String, String>();
    private HashMap<String, HashMap<String, String>> deletedMails = new HashMap<String, HashMap<String, String>>();

}
