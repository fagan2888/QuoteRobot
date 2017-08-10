/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ib.gui;

import com.ib.api.IBClient;
import com.ib.client.EReader;
import com.ib.client.EReaderSignal;
import org.apache.log4j.Logger;
import com.ib.engine.MainQuoteEngineForGUI;
import com.ib.thread.ExecutorPool;
import java.util.concurrent.TimeUnit;
import java.util.List;
import com.ib.config.ConfigReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Siteng Jin
 */
public class QuoteRobotFrame extends javax.swing.JFrame {
    public static final Logger LOG = Logger.getLogger(QuoteRobotFrame.class);
    
    private Thread traderThread = null;
    
    private ConfigFrame m_configFrame = null;
    
    /**
     * Creates new form MorganStanleyCFDFrame
     */
    public QuoteRobotFrame() {
        initComponents();
        setLoc();
        initConfigs();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        activeOrdersTable = new javax.swing.JTable(null, OrderTableModel.m_colNames);
        actionPane = new javax.swing.JPanel();
        pauseBtn = new javax.swing.JButton();
        configBtn = new javax.swing.JButton();
        startBtn = new javax.swing.JButton();
        positionPane = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        positionTable = new javax.swing.JTable(null, PositionTableModel.m_colNames);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Quoting Robot");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        orderPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Active Orders"));

        activeOrdersTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        activeOrdersTable.setModel(OrderTableModel.getInstance());
        jScrollPane1.setViewportView(activeOrdersTable);

        javax.swing.GroupLayout orderPaneLayout = new javax.swing.GroupLayout(orderPane);
        orderPane.setLayout(orderPaneLayout);
        orderPaneLayout.setHorizontalGroup(
            orderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        orderPaneLayout.setVerticalGroup(
            orderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
        );

        actionPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Actions"));

        pauseBtn.setText("Pause");
        pauseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseBtnActionPerformed(evt);
            }
        });

        configBtn.setText("Configurations");
        configBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configBtnActionPerformed(evt);
            }
        });

        startBtn.setText("Start");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout actionPaneLayout = new javax.swing.GroupLayout(actionPane);
        actionPane.setLayout(actionPaneLayout);
        actionPaneLayout.setHorizontalGroup(
            actionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPaneLayout.createSequentialGroup()
                .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pauseBtn)
                .addGap(18, 18, 18)
                .addComponent(configBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        actionPaneLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {configBtn, pauseBtn, startBtn});

        actionPaneLayout.setVerticalGroup(
            actionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(actionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pauseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(startBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(configBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        positionPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Position"));

        positionTable.setModel(PositionTableModel.getInstance());
        jScrollPane2.setViewportView(positionTable);

        javax.swing.GroupLayout positionPaneLayout = new javax.swing.GroupLayout(positionPane);
        positionPane.setLayout(positionPaneLayout);
        positionPaneLayout.setHorizontalGroup(
            positionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
        );
        positionPaneLayout.setVerticalGroup(
            positionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(positionPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actionPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(positionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void initConfigs(){
        ConfigReader.getInstance().assignProperties();
        LOG.debug("Finished assigning configs");
    }
    
    private void setLoc(){
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getPreferredSize().width/2, dim.height/2-getPreferredSize().height/2);
    }
    
    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                LOG.debug("Starting trader thread");
                //traderThread = new Thread(new MainQuoteEngineForGUI(), "trader");
                //traderThread.start();
                if(IBClient.getInstance().getSocket().isConnected()){
                    IBClient.getInstance().setPauseExecution(false);
                } else {
                    ExecutorPool.getPool().execute(new MainQuoteEngineForGUI());
                }
            }
        });
    }//GEN-LAST:event_startBtnActionPerformed

    private void pauseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBtnActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                IBClient.getInstance().setPauseExecution(true);
            }
        });
    }//GEN-LAST:event_pauseBtnActionPerformed

    private void configBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configBtnActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(m_configFrame == null){
                    m_configFrame = ConfigFrame.getInstance();
                }
                m_configFrame.backupConfigs();
                m_configFrame.setVisible(true);
            }
        });
    }//GEN-LAST:event_configBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int reply = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to close the program?");
        if(reply == javax.swing.JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(QuoteRobotFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuoteRobotFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuoteRobotFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuoteRobotFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuoteRobotFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPane;
    private javax.swing.JTable activeOrdersTable;
    private javax.swing.JButton configBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel orderPane;
    private javax.swing.JButton pauseBtn;
    private javax.swing.JPanel positionPane;
    private javax.swing.JTable positionTable;
    private javax.swing.JButton startBtn;
    // End of variables declaration//GEN-END:variables
}
