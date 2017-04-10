/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tazatel.gui;

import tazatel.dataStructure.OtazkyData;
import javax.swing.DefaultComboBoxModel;
import tazatel.dataStructure.PredmetData;

/**
 *
 * @author bleha
 */
public class VyberOkno extends javax.swing.JFrame {

    private final OtazkyData data;
    
    /**
     * Creates new form VyberOkno
     * @param data
     */
    public VyberOkno(OtazkyData data) {
        initComponents();
        
        this.data = data;
        init();
    }
    
    private void init() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = 0; i < data.getPocetPredmetu(); i++) {
            model.addElement(data.getPredmet(i));
        }
        predmetyVyber.setModel(model);
        setPocetOtazek();
    }
    
    public void setPocetOtazek() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) predmetyVyber.getModel();
        if(model.getSelectedItem() != null) {
            PredmetData predmet = (PredmetData) model.getSelectedItem();
            pocetOtazek.setText("Počet otázek: " + String.valueOf(predmet.getPocetOtazek()));
        }        
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        predmetyVyber = new javax.swing.JComboBox<>();
        pocetOtazek = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tazatel");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jButton1.setText("START");

        jLabel1.setText("Předmět:");

        predmetyVyber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        predmetyVyber.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                predmetyVyberItemStateChanged(evt);
            }
        });

        pocetOtazek.setText("Žádné předměty");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(predmetyVyber, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pocetOtazek))
                        .addGap(0, 167, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(predmetyVyber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pocetOtazek)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void predmetyVyberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_predmetyVyberItemStateChanged
        setPocetOtazek();
    }//GEN-LAST:event_predmetyVyberItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pocetOtazek;
    private javax.swing.JComboBox<String> predmetyVyber;
    // End of variables declaration//GEN-END:variables
}