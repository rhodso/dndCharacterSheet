package com.rhodso.app;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class weaponModifierUI extends javax.swing.JFrame {

        private Player p;
        private Weapon w;
        private boolean timeToSave = false;
        private boolean check = false;

        public weaponModifierUI() {
                // Override default close operation
                this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                this.addWindowListener(new WindowListener() {
                        public void windowClosing(WindowEvent e) {
                                save();
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
        }

        boolean getCheck() {
                return check;
        }

        /**
         * @param _p the player
         */
        public weaponModifierUI(Player _p) {
                p = _p;

                initComponents();
                setComponentValues();
        }

        /**
         * @param _p the player
         * @param _w the weapon to modify
         */
        public weaponModifierUI(Player _p, Weapon _w) {
                p = _p;
                w = _w;

                initComponents();
                setComponentValues(w);
        }

        /**
         * @param None
         */
        public void setComponentValues() {
                w = new Weapon();
                w.setName("Weapon Name");
                w.setHitDR("1d20");
                w.setDmgDR("0");
                w.setRange("0ft");
                w.setDamageType("None");
                w.setProficiency(p.getProf());
        }

        /**
         * @param _w the weapon to modify
         */
        public void setComponentValues(Weapon _w) {
                weaponNameInput.setText(_w.getName());
                weaponHitDRInput.setText(_w.getHitDR());
                weaponDmgDRInput.setText(_w.getDmgDR());
                weaponRangeInput.setText(_w.getRange());
                weaponDamageTypeInput.setText(_w.getDamageType());
                weaponProficiencyInput.setText(Integer.toString(_w.getProficiency()));
        }

        public void getComponentValues() {
                w.setName(weaponNameInput.getText());
                w.setHitDR(weaponHitDRInput.getText());
                w.setDmgDR(weaponDmgDRInput.getText());
                w.setRange(weaponRangeInput.getText());
                w.setDamageType(weaponDamageTypeInput.getText());
                w.setProficiency(Integer.parseInt(weaponProficiencyInput.getText()));
        }

        private void delete() {

        }

        private void cancel() {
                CharacterSheet c = new CharacterSheet();
                c.loadUI(p.getSheetFP());
                this.dispose();
        }

        private void save() {

                // Validation check
                boolean valid = true;

                /*
                 * if (!isNumeric(weaponProficiency.getText())) { valid = false; }
                 */

                // Check over
                if (valid) {
                        // Calculated fields
                        getComponentValues();
                        if (!w.getDmgDR().equals("0")) {
                                w.setDmg(new Dice(w.getDmgDR()));
                        }
                        w.setHit(new Dice(w.getHitDR()));

                        CharacterSheet c = new CharacterSheet();
                        c.loadUI(p);

                        // Dispose of the window
                        this.dispose();
                }
        }

        public static boolean isNumeric(String strNum) {
                if (strNum == null) {
                        return false;
                }
                try {
                        double d = Double.parseDouble(strNum);
                } catch (NumberFormatException nfe) {
                        return false;
                }
                return true;
        }

        /**
         * This method is called from within the constructor to initialize the form. WARNING: Do NOT
         * modify this code. The content of this method is always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                mainScrollPane = new javax.swing.JScrollPane();
                mainPanel = new javax.swing.JPanel();
                headerPanel = new javax.swing.JPanel();
                headerLabel = new javax.swing.JLabel();
                subheadingLabel = new javax.swing.JLabel();
                inputPanel = new javax.swing.JPanel();
                weaponNameLabel = new javax.swing.JLabel();
                weaponNameInput = new javax.swing.JTextField();
                weaponHitDRLabel = new javax.swing.JLabel();
                weaponHitDRInput = new javax.swing.JTextField();
                weaponRangeLabel = new javax.swing.JLabel();
                weaponRangeInput = new javax.swing.JTextField();
                weaponDmgDRLabel = new javax.swing.JLabel();
                weaponDmgDRInput = new javax.swing.JTextField();
                weaponProficiency = new javax.swing.JLabel();
                weaponProficiencyInput = new javax.swing.JTextField();
                weaponDamageTypeLabel = new javax.swing.JLabel();
                weaponDamageTypeInput = new javax.swing.JTextField();
                buttonPanel = new javax.swing.JPanel();
                saveButton = new javax.swing.JButton();
                cancelButton = new javax.swing.JButton();
                deleteButton = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                headerLabel.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
                headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                headerLabel.setText("DnD Character Sheet");
                headerLabel.setToolTipText("");
                headerLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                subheadingLabel.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
                subheadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                subheadingLabel.setText("But you don't have to pay for it");

                javax.swing.GroupLayout headerPanelLayout =
                                new javax.swing.GroupLayout(headerPanel);
                headerPanel.setLayout(headerPanelLayout);
                headerPanelLayout.setHorizontalGroup(headerPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(headerPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(headerLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                537, Short.MAX_VALUE)
                                                .addContainerGap())
                                .addGroup(headerPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(headerPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(subheadingLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                517,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(28,
                                                                                Short.MAX_VALUE))));
                headerPanelLayout.setVerticalGroup(headerPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(headerPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(headerLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                70,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(44, Short.MAX_VALUE))
                                .addGroup(headerPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(headerPanelLayout.createSequentialGroup()
                                                                .addGap(88, 88, 88)
                                                                .addComponent(subheadingLabel)
                                                                .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))));

                inputPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                weaponNameLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponNameLabel.setText("Name");

                weaponNameInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponNameInput.setText("weaponName");

                weaponHitDRLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponHitDRLabel.setText("Hit Dice");

                weaponHitDRInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponHitDRInput.setText("weaponHitDice");

                weaponRangeLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponRangeLabel.setText("Range");

                weaponRangeInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponRangeInput.setText("weaponRange");

                weaponDmgDRLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponDmgDRLabel.setText("Damage Dice");

                weaponDmgDRInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponDmgDRInput.setText("weaponDamageDice");

                weaponProficiency.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponProficiency.setText("Proficiency");

                weaponProficiencyInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponProficiencyInput.setText("weaponProficiency");

                weaponDamageTypeLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponDamageTypeLabel.setText("Damage Type");

                weaponDamageTypeInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponDamageTypeInput.setText("weaponDamageType");

                javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
                inputPanel.setLayout(inputPanelLayout);
                inputPanelLayout.setHorizontalGroup(inputPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(inputPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(inputPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(weaponNameLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(weaponNameInput))
                                                                .addGroup(inputPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(weaponHitDRLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(weaponHitDRInput))
                                                                .addGroup(inputPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(weaponDmgDRLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(weaponDmgDRInput))
                                                                .addGroup(inputPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(weaponRangeLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(weaponRangeInput))
                                                                .addGroup(inputPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(weaponDamageTypeLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(weaponDamageTypeInput))
                                                                .addGroup(inputPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(weaponProficiency,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(weaponProficiencyInput)))
                                                .addContainerGap()));
                inputPanelLayout.setVerticalGroup(inputPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(inputPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(weaponNameLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(weaponNameInput))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(weaponHitDRLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(weaponHitDRInput))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(weaponDmgDRLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(weaponDmgDRInput))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(weaponRangeLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(weaponRangeInput))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(weaponDamageTypeLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(weaponDamageTypeInput))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(weaponProficiency,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(weaponProficiencyInput))
                                                .addContainerGap()));

                buttonPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                saveButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                saveButton.setText("Save");
                saveButton.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                                save();
                        }
                });

                cancelButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                                cancel();
                        }
                });

                deleteButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                deleteButton.setText("Delete");
                deleteButton.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                                cancel();
                        }
                });

                javax.swing.GroupLayout buttonPanelLayout =
                                new javax.swing.GroupLayout(buttonPanel);
                buttonPanel.setLayout(buttonPanelLayout);
                buttonPanelLayout.setHorizontalGroup(buttonPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                buttonPanelLayout.createSequentialGroup()
                                                                .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(saveButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                129,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap())
                                .addGroup(buttonPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(buttonPanelLayout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addComponent(cancelButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                129,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(406,
                                                                                Short.MAX_VALUE))));
                buttonPanelLayout.setVerticalGroup(buttonPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(buttonPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(saveButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                78, Short.MAX_VALUE)
                                                .addContainerGap())
                                .addGroup(buttonPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(buttonPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(cancelButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                78, Short.MAX_VALUE)
                                                                .addContainerGap())));

                javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
                mainPanel.setLayout(mainPanelLayout);
                mainPanelLayout.setHorizontalGroup(mainPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(mainPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(inputPanel,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(headerPanel,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(buttonPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                mainPanelLayout.setVerticalGroup(mainPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(headerPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(inputPanel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(buttonPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap()));

                mainScrollPane.setViewportView(mainPanel);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addContainerGap()
                                                .addComponent(mainScrollPane).addContainerGap()));
                layout.setVerticalGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addContainerGap()
                                                .addComponent(mainScrollPane,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                643, Short.MAX_VALUE)
                                                .addContainerGap()));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel buttonPanel;
        private javax.swing.JButton cancelButton;
        private javax.swing.JButton deleteButton;
        private javax.swing.JLabel headerLabel;
        private javax.swing.JPanel headerPanel;
        private javax.swing.JPanel inputPanel;
        private javax.swing.JPanel mainPanel;
        private javax.swing.JScrollPane mainScrollPane;
        private javax.swing.JButton saveButton;
        private javax.swing.JLabel subheadingLabel;
        private javax.swing.JTextField weaponDamageTypeInput;
        private javax.swing.JLabel weaponDamageTypeLabel;
        private javax.swing.JTextField weaponDmgDRInput;
        private javax.swing.JLabel weaponDmgDRLabel;
        private javax.swing.JTextField weaponHitDRInput;
        private javax.swing.JLabel weaponHitDRLabel;
        private javax.swing.JTextField weaponNameInput;
        private javax.swing.JLabel weaponNameLabel;
        private javax.swing.JLabel weaponProficiency;
        private javax.swing.JTextField weaponProficiencyInput;
        private javax.swing.JTextField weaponRangeInput;
        private javax.swing.JLabel weaponRangeLabel;
        // End of variables declaration//GEN-END:variables
}
