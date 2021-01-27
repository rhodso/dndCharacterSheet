package com.rhodso.app;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class spellModifierUI extends javax.swing.JFrame {

        /**
        *
        */
        private static final long serialVersionUID = 5218214444406739261L;
        private Player p;
        private Spell s;

        public spellModifierUI() {
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

        /**
         * @param _p the player
         */
        public spellModifierUI(Player _p) {
                p = _p;

                initComponents();
                setComponentValues();
        }

        /**
         * @param _p the player
         * @param _s the spell to modify
         */
        public spellModifierUI(Player _p, Spell _s) {
                p = _p;
                s = _s;

                initComponents();
                setComponentValues(s);
        }

        private void save() {
                // Validation check
                boolean valid = true;

                // Check over
                if (valid) {
                        // Calculated fields
                        getComponentValues();
                        if (!s.getDmgDR().equals("0")) {
                                s.setDmg(new Dice(s.getDmgDR()));
                        }
                        s.setHit(new Dice(s.getHitDR()));

                        CharacterSheet c = new CharacterSheet();
                        c.SaveSheet(p);
                        c.loadUI(p);

                        // Dispose of the window
                        this.dispose();
                }
        }

        private void delete() {
                int input = JOptionPane.showConfirmDialog(this,
                                "Are you sure you want to delete this spell?\n(This cannot be undone)",
                                "Delete " + s.getName() + "?", JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.WARNING_MESSAGE);

                if (input == 0) {
                        // Get list, delete this spell, set list, save sheet
                        CharacterSheet c = new CharacterSheet();
                        ArrayList<Spell> sList = p.getSpellsList();
                        sList.remove(s);
                        p.setSpellsList(sList);
                        c.SaveSheet(p);
                        c.loadUI(p);
                        this.dispose();
                }
        }

        private void cancel() {
                CharacterSheet c = new CharacterSheet();
                c.loadUI(p.getSheetFP());
                this.dispose();
        }

        /**
         * @param None
         */
        public void setComponentValues() {
                s = new Spell();
                s.setName("Spell Name");
                s.setHitDR("1d20");
                s.setDmgDR("0");
                s.setRange("0ft");
                s.setDamageType("None");
                s.setProficiency(p.getProf());
                s.setSpellLevel(0);
        }

        /**
         * @param _s the spell to modify
         */
        public void setComponentValues(Spell _s) {
                spellNameInput.setText(_s.getName());
                spellHitDRInput.setText(_s.getHitDR());
                spellDmgDRInput.setText(_s.getDmgDR());
                spellRangeInput.setText(_s.getRange());
                spellDamageTypeInput.setText(_s.getDamageType());
                spellProficiencyInput.setText(Integer.toString(_s.getProficiency()));
                spellLevelInput.setText(Integer.toString(_s.getSpellLevel()));
        }

        public void getComponentValues() {
                s.setName(spellNameInput.getText());
                s.setHitDR(spellHitDRInput.getText());
                s.setDmgDR(spellDmgDRInput.getText());
                s.setRange(spellRangeInput.getText());
                s.setDamageType(spellDamageTypeInput.getText());
                s.setProficiency(Integer.parseInt(spellProficiencyInput.getText()));
                s.setSpellLevel(Integer.parseInt(spellLevelInput.getText()));
        }

        /**
         * This method is called from within the constructor to initialize the form. WARNING: Do NOT
         * modify this code. The content of this method is always regenerated by the Form Editor.
         */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

                mainScrollPane = new javax.swing.JScrollPane();
                mainPanel = new javax.swing.JPanel();
                headerPanel = new javax.swing.JPanel();
                headerLabel = new javax.swing.JLabel();
                subheadingLabel = new javax.swing.JLabel();
                inputPanel = new javax.swing.JPanel();
                spellNameLabel = new javax.swing.JLabel();
                spellNameInput = new javax.swing.JTextField();
                spellHitDRLabel = new javax.swing.JLabel();
                spellHitDRInput = new javax.swing.JTextField();
                spellRangeLabel = new javax.swing.JLabel();
                spellRangeInput = new javax.swing.JTextField();
                spellDmgDRLabel = new javax.swing.JLabel();
                spellDmgDRInput = new javax.swing.JTextField();
                spellProficiency = new javax.swing.JLabel();
                spellProficiencyInput = new javax.swing.JTextField();
                spellDamageTypeLabel = new javax.swing.JLabel();
                spellDamageTypeInput = new javax.swing.JTextField();
                spellLevelLabel = new javax.swing.JLabel();
                spellLevelInput = new javax.swing.JTextField();
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

                spellNameLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellNameLabel.setText("Name");

                spellNameInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellNameInput.setText("spellName");

                spellHitDRLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellHitDRLabel.setText("Hit Dice");

                spellHitDRInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellHitDRInput.setText("spellHitDice");

                spellRangeLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellRangeLabel.setText("Range");

                spellRangeInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellRangeInput.setText("spellRange");

                spellDmgDRLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellDmgDRLabel.setText("Damage Dice");

                spellDmgDRInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellDmgDRInput.setText("spellDamageDice");

                spellProficiency.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellProficiency.setText("Proficiency");

                spellProficiencyInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellProficiencyInput.setText("spellProficiency");

                spellDamageTypeLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellDamageTypeLabel.setText("Damage Type");

                spellDamageTypeInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellDamageTypeInput.setText("spellDamageType");

                spellLevelLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellLevelLabel.setText("Spell Level");

                spellLevelInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellLevelInput.setText("spellLevel");

                javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
                inputPanel.setLayout(inputPanelLayout);
                inputPanelLayout.setHorizontalGroup(inputPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(inputPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(inputPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(spellNameLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(spellNameInput))
                                                                .addGroup(inputPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(spellHitDRLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(spellHitDRInput))
                                                                .addGroup(inputPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(spellDmgDRLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(spellDmgDRInput))
                                                                .addGroup(inputPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(spellRangeLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(spellRangeInput))
                                                                .addGroup(inputPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(spellDamageTypeLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(spellDamageTypeInput,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                343,
                                                                                                Short.MAX_VALUE))
                                                                .addGroup(inputPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(spellProficiency,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                172,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(spellProficiencyInput))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                inputPanelLayout.createSequentialGroup()
                                                                                                .addComponent(spellLevelLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                172,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(spellLevelInput)))
                                                .addContainerGap()));
                inputPanelLayout.setVerticalGroup(inputPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(inputPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(spellNameLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(spellNameInput))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(spellHitDRLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(spellHitDRInput))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(spellDmgDRLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(spellDmgDRInput))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(spellRangeLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(spellRangeInput))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(spellDamageTypeLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(spellDamageTypeInput))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(spellProficiency,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(spellProficiencyInput))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(inputPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(spellLevelLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                47,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(spellLevelInput))
                                                .addContainerGap()));

                buttonPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                saveButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                saveButton.setText("Save");
                saveButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                save();
                        }
                });

                cancelButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cancel();
                        }
                });

                deleteButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                deleteButton.setText("Delete");
                deleteButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                delete();
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
                                                                .addComponent(cancelButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                129,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(75, 75, 75)
                                                                .addComponent(saveButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                129,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap())
                                .addGroup(buttonPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(buttonPanelLayout.createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addComponent(deleteButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                129,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(396,
                                                                                Short.MAX_VALUE))));
                buttonPanelLayout.setVerticalGroup(buttonPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(buttonPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(buttonPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(saveButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                78, Short.MAX_VALUE)
                                                                .addComponent(cancelButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                78,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap())
                                .addGroup(buttonPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(buttonPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(deleteButton,
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
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(buttonPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(43, Short.MAX_VALUE)));

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
                                                .addComponent(mainScrollPane).addContainerGap()));

                pack();
        }// </editor-fold>

        // Variables declaration - do not modify
        private javax.swing.JPanel buttonPanel;
        private javax.swing.JButton cancelButton;
        private javax.swing.JButton deleteButton;
        private javax.swing.JLabel headerLabel;
        private javax.swing.JPanel headerPanel;
        private javax.swing.JPanel inputPanel;
        private javax.swing.JPanel mainPanel;
        private javax.swing.JScrollPane mainScrollPane;
        private javax.swing.JButton saveButton;
        private javax.swing.JTextField spellDamageTypeInput;
        private javax.swing.JLabel spellDamageTypeLabel;
        private javax.swing.JTextField spellDmgDRInput;
        private javax.swing.JLabel spellDmgDRLabel;
        private javax.swing.JTextField spellHitDRInput;
        private javax.swing.JLabel spellHitDRLabel;
        private javax.swing.JTextField spellLevelInput;
        private javax.swing.JLabel spellLevelLabel;
        private javax.swing.JTextField spellNameInput;
        private javax.swing.JLabel spellNameLabel;
        private javax.swing.JLabel spellProficiency;
        private javax.swing.JTextField spellProficiencyInput;
        private javax.swing.JTextField spellRangeInput;
        private javax.swing.JLabel spellRangeLabel;
        private javax.swing.JLabel subheadingLabel;
        // End of variables declaration
}
