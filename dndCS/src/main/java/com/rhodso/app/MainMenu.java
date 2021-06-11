package com.rhodso.app;
/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rhodso
 */
public class MainMenu extends javax.swing.JFrame {

        /**
        *
        */
        private static final long serialVersionUID = 6925195810284983510L;

        /**
         * Creates new form guiFrame
         */
        public MainMenu() {
                initComponents();
        }

        /**
         * This method is called from within the constructor to initialize the form. WARNING: Do NOT
         * modify this code. The content of this method is always regenerated by the Form Editor.
         */
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents

        private void encounterTrackerButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_encounterTrackerButtonActionPerformed
                encounterTracker e = new encounterTracker();
                e.setVisible(true);
        }// GEN-LAST:event_encounterTrackerButtonActionPerformed

        private void rollDiceButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rollDiceButtonActionPerformed
                DiceRoller d = new DiceRoller();
                d.setVisible(true);
        }// GEN-LAST:event_rollDiceButtonActionPerformed

        private void loadCharButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loadCharButtonActionPerformed
                // Create file choose, filter to JSON, and get the user to pick their JSON file
                JFileChooser jfc = new JFileChooser();
                jfc.addChoosableFileFilter(new FileNameExtensionFilter("json files", ".json"));
                // jfc.setCurrentDirectory(new File(Settings.getLastFile()));
                jfc.setCurrentDirectory(new File("."));
                int result = jfc.showOpenDialog(MainPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                        // If the user has chosen a file that fits, try to load it
                        File f = jfc.getSelectedFile();
                        // Settings.setLastFile(jfc.getSelectedFile().getParent());
                        CharacterSheet cs = new CharacterSheet(f.getAbsolutePath());
                        cs.loadUI(f.getAbsolutePath());
                }

        }// GEN-LAST:event_loadCharButtonActionPerformed

        private void createCharButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_createCharButtonActionPerformed
                createCharacter cc = new createCharacter();
                cc.setVisible(true);
        }// GEN-LAST:event_createCharButtonActionPerformed

        private void bingoButtonActionPerformed(java.awt.event.ActionEvent evt) {
                bingoForm bf = new bingoForm();
                bf.setVisible(true);
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel MainPanel;
        private javax.swing.JButton createCharButton;
        private javax.swing.JButton encounterTrackerButton;
        private javax.swing.JLabel headerLabel;
        private javax.swing.JButton loadCharButton;
        private javax.swing.JPanel menuPanel;
        private javax.swing.JButton rollDiceButton;
        private javax.swing.JLabel subheaderLabel;
        private javax.swing.JButton bingoButton;
        // End of variables declaration//GEN-END:variables

        private void initComponents() {

                MainPanel = new javax.swing.JPanel();
                headerLabel = new javax.swing.JLabel();
                subheaderLabel = new javax.swing.JLabel();
                menuPanel = new javax.swing.JPanel();
                rollDiceButton = new javax.swing.JButton();
                loadCharButton = new javax.swing.JButton();
                createCharButton = new javax.swing.JButton();
                encounterTrackerButton = new javax.swing.JButton();
                bingoButton = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("DCS - Main");

                headerLabel.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
                headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                headerLabel.setText("DnD Character Sheet");
                headerLabel.setToolTipText("");
                headerLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                subheaderLabel.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
                subheaderLabel.setText("But you don't have to pay for it");

                rollDiceButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                rollDiceButton.setText("Roll Dice");
                rollDiceButton.setToolTipText("");
                rollDiceButton.setActionCommand("diceRoller");
                rollDiceButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                rollDiceButtonActionPerformed(evt);
                        }
                });

                loadCharButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                loadCharButton.setText("Load Character");
                loadCharButton.setActionCommand("loadCharacter");
                loadCharButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                loadCharButtonActionPerformed(evt);
                        }
                });

                createCharButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                createCharButton.setText("Create Character");
                createCharButton.setActionCommand("createCharacter");
                createCharButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                createCharButtonActionPerformed(evt);
                        }
                });

                encounterTrackerButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                encounterTrackerButton.setText("Encounter Tracker");
                encounterTrackerButton.setToolTipText("");
                encounterTrackerButton.setActionCommand("diceRoller");
                encounterTrackerButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                encounterTrackerButtonActionPerformed(evt);
                        }
                });

                bingoButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                bingoButton.setText("Bingo");
                bingoButton.setToolTipText("");
                bingoButton.setActionCommand("diceRoller");
                bingoButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                bingoButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
                menuPanel.setLayout(menuPanelLayout);
                menuPanelLayout.setHorizontalGroup(menuPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(menuPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(menuPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(rollDiceButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(encounterTrackerButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(bingoButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap())
                                .addGroup(menuPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(menuPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(loadCharButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()))
                                .addGroup(menuPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(menuPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(createCharButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap())));
                menuPanelLayout.setVerticalGroup(menuPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                menuPanelLayout.createSequentialGroup()
                                                                .addContainerGap(165,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(rollDiceButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                57,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(encounterTrackerButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                57,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(bingoButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                57,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(48, 48, 48))
                                .addGroup(menuPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(menuPanelLayout.createSequentialGroup()
                                                                .addGap(21, 21, 21)
                                                                .addComponent(loadCharButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                57,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(260,
                                                                                Short.MAX_VALUE)))
                                .addGroup(menuPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(menuPanelLayout.createSequentialGroup()
                                                                .addGap(94, 94, 94)
                                                                .addComponent(createCharButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                57,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(187,
                                                                                Short.MAX_VALUE))));

                javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
                MainPanel.setLayout(MainPanelLayout);
                MainPanelLayout.setHorizontalGroup(MainPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(MainPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(MainPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(menuPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                MainPanelLayout.createSequentialGroup()
                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                .addComponent(subheaderLabel))
                                                                .addGroup(MainPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(headerLabel)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap()));
                MainPanelLayout.setVerticalGroup(MainPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(MainPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(headerLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                70,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(subheaderLabel)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(menuPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 509, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                layout.createSequentialGroup()
                                                                                .addContainerGap(
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(MainPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))));
                layout.setVerticalGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 531, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                layout.createSequentialGroup()
                                                                                .addContainerGap(27,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(MainPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(28,
                                                                                                Short.MAX_VALUE))));

                pack();
        }// </editor-fold>//GEN-END:initComponents

}
