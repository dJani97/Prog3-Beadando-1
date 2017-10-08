/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feluletek;

import adatkezeles.AdatInput;
import adatkezeles.EmberFajlbolInput;
import adatkezeles.KutyuFajlbolInput;
import javax.swing.DefaultListModel;
import alaposztalyok.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author djani
 */
public class MobilJPanel extends javax.swing.JPanel {

    public static final String EMBER_FILE = "emberek.txt";
    public static final String KUTYU_FILE = "kutyuk.txt";
    DefaultListModel<Ember> emberekModel = new DefaultListModel<>();
    DefaultComboBoxModel<Kutyu> kutyukModel = new DefaultComboBoxModel<>();
    Random rand = new Random();
    
    
    // Feladat fájlból:
    private final int MAX_TELEFON_DB = 20; // kiválasztáskor max ennyi ember vásárol
    private final int HASZNALAT_SZAM =100; // ennyiszer fut le a használat
    private final int MAX_UZENETHOSSZ = 200;
    private final double SZAZALEK = 0.6; // ekkora eséllyel kapcsolódik az internethez
    private final int MAX_INTERNET_IDO = 200;
    private final double MOBIL_BILLENTYU_ERO = 0.5;
    private final double OKOS_TEL_BILLENTYU_ERO = 0.3;
    private final int FUGGOSEG_HATAR = 1000;
    private final int SEJT_HATAR = 200;

    /**
     * Creates new form MobilJPanel
     */
    public MobilJPanel() {
        this.setSize(MainFrame.MAGASSAG, MainFrame.SZELESSEG);
        initComponents();
    }
    
    void fixFajlbol() {
        try {
            emberekModel = new EmberFajlbolInput(EMBER_FILE).adatModel();
            emberJList.setModel(emberekModel);
            
            kutyukModel = new KutyuFajlbolInput(KUTYU_FILE).adatModel();
            kutyuJComboBox.setModel(kutyukModel);
        } catch (Exception ex) {
            Logger.getLogger(MobilJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        printModels();
    }
    
    void printModels(){
        for(int i=0; i < emberekModel.size(); i++){
            System.out.println(emberekModel.get(i));
        }
        
        for(int i=0; i < kutyukModel.getSize(); i++){
            System.out.println(kutyukModel.getElementAt(i));
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

        kutyuJComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        emberJList = new javax.swing.JList();

        kutyuJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        kutyuJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kutyuJComboBoxActionPerformed(evt);
            }
        });

        emberJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(emberJList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(kutyuJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kutyuJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(305, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kutyuJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kutyuJComboBoxActionPerformed
        
        Kutyu valasztottKutyu = (Kutyu) kutyuJComboBox.getSelectedItem();
        
        for (int i = 0; i < rand.nextInt((int) MAX_TELEFON_DB); i++) {
            
            int randomEmberIndex = rand.nextInt(emberekModel.getSize());
            Ember randomEmber = emberekModel.getElementAt(randomEmberIndex);
            
            randomEmber.kutyutVesz(valasztottKutyu.masolat());
            
        }
        
    }//GEN-LAST:event_kutyuJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList emberJList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox kutyuJComboBox;
    // End of variables declaration//GEN-END:variables
}
