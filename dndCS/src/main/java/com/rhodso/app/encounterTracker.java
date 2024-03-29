
package com.rhodso.app;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class encounterTracker extends javax.swing.JFrame {

        LinkedList<EncounterTrackerEntry> actionsList = new LinkedList<>();

        /**
         * Creates new form encounterTracker
         */
        public encounterTracker() {
                // Override default close operation
                this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                this.addWindowListener(new WindowListener() {
                        public void windowClosing(WindowEvent e) {
                                dispose();
                        }

                        @Override
                        public void windowActivated(WindowEvent arg0) {
                                ;
                        }

                        @Override
                        public void windowClosed(WindowEvent arg0) {
                                ;
                        }

                        @Override
                        public void windowDeactivated(WindowEvent arg0) {
                                ;
                        }

                        @Override
                        public void windowDeiconified(WindowEvent arg0) {
                                ;
                        }

                        @Override
                        public void windowIconified(WindowEvent arg0) {
                                ;
                        }

                        @Override
                        public void windowOpened(WindowEvent arg0) {
                                ;
                        }
                });
                initComponents();
        }

        void updateTextAreaAndStats() {
                ActionsTextArea.setText("");
                for (EncounterTrackerEntry e : actionsList) {
                        String s = e.toString();
                        ActionsTextArea.setText(ActionsTextArea.getText() + s + "\n");
                }

                if(actionsList.size() > 0){
                        EncounterTrackerEntry last = actionsList.getLast();
                        LowestHitLabel.setText("Lowest Hit: " + last.getLowestHit());
                        TotalDamageLabel.setText("Total Damage Done: " + last.getDmgTaken());
                        HighestMissLabel.setText("Highest Miss: " + last.getHighestMiss());
                } else {
                        LowestHitLabel.setText("Lowest Hit: 20");
                        TotalDamageLabel.setText("Total Damage Done: 0");
                        HighestMissLabel.setText("Highest Miss: 0");
                }
        }

        void updateList() {
                
                boolean process = false;
                boolean hit = false;
                // Check for errors / warnings
                if (HitRollBox.getText().equals("") && DMGRollBox.getText().equals("")) {
                        // No info entered, ignore
                        ;
                } else if (HitRollBox.getText().equals("")) {
                        // Throw error because we've got no hit data
                        JOptionPane.showMessageDialog(jPanel1, "Error: No Hit roll supplied", "No hit roll",
                                        JOptionPane.ERROR_MESSAGE);
                } else {
                        if (isHitCheckbox.isSelected()) {
                                if (DMGRollBox.getText().equals("")) {
                                        // Did the user mean to add something to DMG Roll Box
                                        JOptionPane.showMessageDialog(jPanel1,
                                                        "Warning: No DMG Roll supplied, but hit box is checked",
                                                        "No DMG roll", JOptionPane.WARNING_MESSAGE);
                                } else {
                                        process = true;
                                        hit = true;
                                }
                        } else {
                                if (DMGRollBox.getText().equals("")) {
                                        process = true;
                                        hit = false;
                                } else {
                                        // Did the user mean to check the hit box?
                                        JOptionPane.showMessageDialog(jPanel1,
                                                        "Warning: DMG Roll supplied, but hit box isn't checked",
                                                        "DMG inconsistency", JOptionPane.WARNING_MESSAGE);
                                }
                        }
                }

                // Try to parse the hit and dmg entered to ensure they're integers
                int currHit;
                int currDmg;

                try {
                        if (HitRollBox.getText().equals("")) {
                                currHit = 0;
                        } else {
                                currHit = Integer.parseInt(HitRollBox.getText());
                        }

                } catch (Exception e) {
                        JOptionPane.showMessageDialog(jPanel1, "Hit roll must be an integer", "Hit roll not valid",
                                        JOptionPane.WARNING_MESSAGE);
                        return;
                }
                try {
                        if (DMGRollBox.getText().equals("")) {
                                currDmg = 0;
                        } else {
                                currDmg = Integer.parseInt(DMGRollBox.getText());
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(jPanel1, "DMG roll must be an integer", "DMG roll not valid",
                                        JOptionPane.WARNING_MESSAGE);
                        return;
                }

                // Get the output from the current form because it fucks up and I don't know why
                // wheeee
                int theLowestHit = 20;
                int theHighestMiss = 0;
                int theTotalDMG = 0;
                try {
                        if(actionsList.size() > 0){
                                // Get current values from last entry in LL
                                EncounterTrackerEntry last = actionsList.getLast();
                                theLowestHit = last.getLowestHit();
                                theHighestMiss = last.getHighestMiss();
                                theTotalDMG = last.getDmgTaken();
                        }                        
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(jPanel1,
                                        "Error when adding to the tracker, no changes were saved",
                                        "Error adding to tracker", JOptionPane.WARNING_MESSAGE);
                        return;
                }

                // All is fine
                if (process) {
                        // Successful hit
                        if(hit){
                                if(theLowestHit > currHit){
                                        theLowestHit = currHit; 
                                }
                                theTotalDMG += currDmg;

                        // Miss
                        } else {
                                theHighestMiss = currHit;
                        }

                        // Now create the entry
                        EncounterTrackerEntry entry = new EncounterTrackerEntry(
                                theHighestMiss, theLowestHit, theTotalDMG, 
                                currHit, currDmg, hit);
                        actionsList.add(entry);
                }
        }

        private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {
                // Confirmation dialogue
                if(JOptionPane.showConfirmDialog(null, "Are you sue you want to reset the encounter tracker?\nThis can't be undone", "Reset encounter tracker?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        actionsList.clear();
                        updateTextAreaAndStats();        
                }
        }

        private void UndoButtonActionPerformed(java.awt.event.ActionEvent evt) {

                if(actionsList.size() > 0){
                        // Remove last action from list
                        actionsList.removeLast();
                }

                // Update text area
                updateTextAreaAndStats();
        }

        private void HitRollBoxActionPerformed(java.awt.event.ActionEvent evt) {
                ;
        }

        private void DMGRollBoxActionPerformed(java.awt.event.ActionEvent evt) {
                ;
        }

        private void AddToTrackerButtonActionPerformed(java.awt.event.ActionEvent evt) {
                // Update lists
                updateList();
                updateTextAreaAndStats();

                // Now clean up
                HitRollBox.setText("");
                DMGRollBox.setText("");
                isHitCheckbox.setSelected(false);
        }

        private void isHitCheckboxActionPerformed(java.awt.event.ActionEvent evt) {
                ;
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {
                jScrollPane1 = new javax.swing.JScrollPane();
                jPanel5 = new javax.swing.JPanel();
                jPanel6 = new javax.swing.JPanel();
                headerLabel = new javax.swing.JLabel();
                subheadingLabel = new javax.swing.JLabel();
                jPanel7 = new javax.swing.JPanel();
                jPanel8 = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                jPanel11 = new javax.swing.JPanel();
                jScrollPane3 = new javax.swing.JScrollPane();
                ActionsTextArea = new javax.swing.JTextPane();
                jPanel12 = new javax.swing.JPanel();
                UndoButton = new javax.swing.JButton();
                ResetButton = new javax.swing.JButton();
                jLabel2 = new javax.swing.JLabel();
                jPanel9 = new javax.swing.JPanel();
                jPanel13 = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                jPanel14 = new javax.swing.JPanel();
                LowestHitLabel = new javax.swing.JLabel();
                TotalDamageLabel = new javax.swing.JLabel();
                HighestMissLabel = new javax.swing.JLabel();
                jPanel10 = new javax.swing.JPanel();
                jPanel15 = new javax.swing.JPanel();
                jLabel4 = new javax.swing.JLabel();
                jPanel16 = new javax.swing.JPanel();
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                HitRollBox = new javax.swing.JTextField();
                jPanel3 = new javax.swing.JPanel();
                isHitCheckbox = new javax.swing.JCheckBox();
                jPanel2 = new javax.swing.JPanel();
                jLabel5 = new javax.swing.JLabel();
                DMGRollBox = new javax.swing.JTextField();
                jPanel4 = new javax.swing.JPanel();
                AddToTrackerButton = new javax.swing.JButton();

                jPanel5.setPreferredSize(new java.awt.Dimension(500, 600));

                headerLabel.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
                headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                headerLabel.setText("DnD Character Sheet");
                headerLabel.setToolTipText("");
                headerLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                subheadingLabel.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
                subheadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                subheadingLabel.setText("But you don't have to pay for it");

                javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel6Layout);
                jPanel6Layout.setHorizontalGroup(jPanel6Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(subheadingLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap()));
                jPanel6Layout.setVerticalGroup(jPanel6Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(subheadingLabel)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                jPanel11.setPreferredSize(new java.awt.Dimension(300, 300));

                jScrollPane3.setViewportView(ActionsTextArea);

                javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
                jPanel11.setLayout(jPanel11Layout);
                jPanel11Layout.setHorizontalGroup(jPanel11Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 413,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));
                jPanel11Layout.setVerticalGroup(jPanel11Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel11Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 356,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                jScrollPane2.setViewportView(jPanel11);

                UndoButton.setText("Undo");
                UndoButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                UndoButtonActionPerformed(evt);
                        }
                });

                ResetButton.setText("Reset");
                ResetButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ResetButtonActionPerformed(evt);
                        }
                });

                jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel2.setText("Actions");

                javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
                jPanel12.setLayout(jPanel12Layout);
                jPanel12Layout.setHorizontalGroup(jPanel12Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout
                                                .createSequentialGroup().addGap(104, 104, 104)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(UndoButton).addContainerGap())
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel12Layout.createSequentialGroup().addGap(10, 10, 10)
                                                                .addComponent(ResetButton)
                                                                .addContainerGap(357, Short.MAX_VALUE))));
                jPanel12Layout.setVerticalGroup(jPanel12Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel12Layout.createSequentialGroup().addContainerGap()
                                                .addGroup(jPanel12Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(UndoButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                60, Short.MAX_VALUE)
                                                                .addComponent(jLabel2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap())
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel12Layout.createSequentialGroup().addContainerGap()
                                                                .addComponent(ResetButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                60, Short.MAX_VALUE)
                                                                .addContainerGap())));

                javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
                jPanel8.setLayout(jPanel8Layout);
                jPanel8Layout.setHorizontalGroup(jPanel8Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440,
                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                jPanel8Layout.setVerticalGroup(jPanel8Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout
                                                .createSequentialGroup()
                                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 383,
                                                                Short.MAX_VALUE)
                                                .addGap(18, 18, 18)));

                jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel3.setText("Statistics");

                javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
                jPanel13.setLayout(jPanel13Layout);
                jPanel13Layout.setHorizontalGroup(jPanel13Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel13Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap()));
                jPanel13Layout.setVerticalGroup(jPanel13Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addComponent(jLabel3,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                                .addContainerGap()));

                LowestHitLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                LowestHitLabel.setText("Lowest Hit: 20");

                TotalDamageLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                TotalDamageLabel.setText("Total Damage Done: 0");

                HighestMissLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                HighestMissLabel.setText("Highest Miss: 0");

                javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
                jPanel14.setLayout(jPanel14Layout);
                jPanel14Layout.setHorizontalGroup(jPanel14Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel14Layout.createSequentialGroup().addContainerGap()
                                                .addGroup(jPanel14Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(LowestHitLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(HighestMissLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(TotalDamageLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                jPanel14Layout.setVerticalGroup(jPanel14Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel14Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(LowestHitLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(HighestMissLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(TotalDamageLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap()));

                javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
                jPanel9.setLayout(jPanel9Layout);
                jPanel9Layout.setHorizontalGroup(jPanel9Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel9Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap()));
                jPanel9Layout.setVerticalGroup(jPanel9Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap()));

                jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel4.setText("Input");

                javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
                jPanel15.setLayout(jPanel15Layout);
                jPanel15Layout.setHorizontalGroup(jPanel15Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addComponent(jLabel4,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                                .addContainerGap()));
                jPanel15Layout.setVerticalGroup(jPanel15Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addComponent(jLabel4,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                                .addContainerGap()));

                jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                jLabel1.setText("Hit Roll");

                HitRollBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                HitRollBox.setText("");
                HitRollBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                HitRollBoxActionPerformed(evt);
                        }
                });

                isHitCheckbox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                isHitCheckbox.setText("Sucessful Hit?");
                isHitCheckbox.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                isHitCheckbox.setIconTextGap(170);
                isHitCheckbox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                isHitCheckboxActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(jPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(isHitCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, 278,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
                                                                .addComponent(isHitCheckbox)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                jLabel5.setText("DMG Roll");

                DMGRollBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
                DMGRollBox.setText("");
                DMGRollBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                DMGRollBoxActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DMGRollBox).addContainerGap()));
                jPanel2Layout.setVerticalGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(DMGRollBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                33, Short.MAX_VALUE)
                                                                .addComponent(jLabel5,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))));

                AddToTrackerButton.setText("Add to tracker");
                AddToTrackerButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                AddToTrackerButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(jPanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(AddToTrackerButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap()));
                jPanel4Layout.setVerticalGroup(jPanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(AddToTrackerButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap()));

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 68,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(HitRollBox)))
                                                .addContainerGap()));
                jPanel1Layout.setVerticalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(HitRollBox, javax.swing.GroupLayout.DEFAULT_SIZE, 33,
                                                                Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
                jPanel16.setLayout(jPanel16Layout);
                jPanel16Layout.setHorizontalGroup(
                                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                jPanel16Layout.setVerticalGroup(jPanel16Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)));

                javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
                jPanel10.setLayout(jPanel10Layout);
                jPanel10Layout.setHorizontalGroup(jPanel10Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup().addContainerGap()
                                                .addGroup(jPanel10Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(jPanel10Layout.createSequentialGroup()
                                                                                .addComponent(jPanel16,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                                .addComponent(jPanel15,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                jPanel10Layout.setVerticalGroup(jPanel10Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap()));

                javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
                jPanel7.setLayout(jPanel7Layout);
                jPanel7Layout.setHorizontalGroup(jPanel7Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel7Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jPanel9,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel7Layout.createSequentialGroup()
                                                                                .addComponent(jPanel10,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap()));
                jPanel7Layout.setVerticalGroup(jPanel7Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel7Layout.createSequentialGroup()
                                                                .addComponent(jPanel9,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                0, Short.MAX_VALUE)))
                                                .addContainerGap()));

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(jPanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout
                                                .createSequentialGroup().addContainerGap()
                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jPanel6,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                                                .addComponent(jPanel7,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 11, Short.MAX_VALUE)))
                                                .addContainerGap()));
                jPanel5Layout.setVerticalGroup(jPanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap()));

                jScrollPane1.setViewportView(jPanel5);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 860,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE));

                pack();
        }// </editor-fold>

        // Variables declaration - do not modify
        private javax.swing.JTextPane ActionsTextArea;
        private javax.swing.JButton AddToTrackerButton;
        private javax.swing.JTextField DMGRollBox;
        private javax.swing.JLabel HighestMissLabel;
        private javax.swing.JTextField HitRollBox;
        private javax.swing.JLabel LowestHitLabel;
        private javax.swing.JButton ResetButton;
        private javax.swing.JLabel TotalDamageLabel;
        private javax.swing.JButton UndoButton;
        private javax.swing.JLabel headerLabel;
        private javax.swing.JCheckBox isHitCheckbox;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel10;
        private javax.swing.JPanel jPanel11;
        private javax.swing.JPanel jPanel12;
        private javax.swing.JPanel jPanel13;
        private javax.swing.JPanel jPanel14;
        private javax.swing.JPanel jPanel15;
        private javax.swing.JPanel jPanel16;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        private javax.swing.JPanel jPanel7;
        private javax.swing.JPanel jPanel8;
        private javax.swing.JPanel jPanel9;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JLabel subheadingLabel;
        // End of variables declaration
}
