/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import nqueens.*;

/**
 *
 * @author khc
 */
public class NqueensGUI2 extends javax.swing.JFrame {

    /**
     * Creates new form NqueensGUI2
     */
    private int n,c=0;
    private javax.swing.JLabel[][] board;
    ArrayList<int[][]> allBoards;
    
    public void setN(int n){
        this.n=n;
    }
    
    private void panelManager(int[][] b){
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if((i+j)%2==0){
                    if(b[i][j]==1){
                        ImageIcon ic = new ImageIcon(getClass().getResource("blackQ.png"));
                        Image im = ic.getImage();
                        im=im.getScaledInstance(300/n, 300/n,Image.SCALE_SMOOTH);
                        ImageIcon icon = new ImageIcon(im);
                        board[i][j].setIcon(icon);
                    }
                }
                else{
                    if(b[i][j]==1){
                        ImageIcon ic = new ImageIcon(getClass().getResource("whiteQ.png"));
                        Image im = ic.getImage();
                        im=im.getScaledInstance(300/n, 300/n,Image.SCALE_SMOOTH);
                        ImageIcon icon = new ImageIcon(im);
                        board[i][j].setIcon(icon);
                    }
                }
            }
        jLabel3.setText(c+1+"");
    }
    
    public NqueensGUI2() {
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

        panel1 = new java.awt.Panel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setPreferredSize(new java.awt.Dimension(300, 300));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jButton1.setText("<<back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("next>>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Solution no.:");

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(44, 44, 44)
                        .addComponent(jButton2)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        // TODO add your handling code here:
        cleanBoard();
        if(c<n-1) panelManager(allBoards.get(++c));
        else panelManager(allBoards.get(0));
    }//GEN-LAST:event_panel1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cleanBoard();
        if(c>0) panelManager(allBoards.get(--c));
        else{
            c=allBoards.size()-1;
            panelManager(allBoards.get(c));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cleanBoard();
        if(c<n-1) panelManager(allBoards.get(++c));
        else{
            c=0;
            panelManager(allBoards.get(c));
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void cleanBoard(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j].setIcon(null);
            }
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public void open(int n) {
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
            java.util.logging.Logger.getLogger(NqueensGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NqueensGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NqueensGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NqueensGUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        setN(n);
        this.setBounds(0, 0, 80*n, 80*n);
        panel1.setPreferredSize(new java.awt.Dimension(60*n, 60*n));
        panel1.setLayout(new GridLayout(n,n));
        board = new javax.swing.JLabel[n][n];
        ChessBoard nq = new ChessBoard(n);
        nq.solveNQ();
        allBoards = nq.getAllBoards();
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                board[i][j] = new javax.swing.JLabel();
                panel1.add(board[i][j]);
            }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if((i+j)%2==0){
                    board[i][j].setBackground(Color.white);
                }
                else board[i][j].setBackground(Color.black);
                board[i][j].setOpaque(true);
            }
        panelManager(allBoards.get(c));
        setResizable(true);
        setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables

}
