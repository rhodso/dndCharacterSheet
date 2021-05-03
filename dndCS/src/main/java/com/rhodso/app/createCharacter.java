/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rhodso.app;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rhodso
 */
public class createCharacter extends javax.swing.JFrame implements ItemListener {

        // TODO: Rework UI to allow players to add weapons and spells

        Boolean[] checkBoxStates = new Boolean[18];
        int[] statRolls = new int[6];

        Player createPlayer(CharacterSheet c) {
                Player p = new Player();

                // Basics
                p.setName("name");
                p.setRace(raceEntry.getText());
                p.setAc(Integer.parseInt(ACEntry.getText()));
                p.setXp(0);
                p.setLvl(Integer.parseInt(levelEntry.getText()));
                p.setProf(Integer.parseInt(profEntry.getText()));
                p.setSpeed(Integer.parseInt(speedEntry.getText()));
                p.setWeaponResource(0);
                p.setcLevel(0);
                p.setSpellAttack(0);
                p.setSpellDC(0);
                p.setHitDieDR("1d" + hitDiceEntry.getText());

                // Other info
                p.setBackground(backgroundEntry.getText());
                p.setAlignment(alignmentEntry.getText());
                p.setNotes("");

                // Class
                String[] ClassArr = classEntry.getText().split("/");
                p.setChrClass(ClassArr[0].replace(" ", ""));
                p.setChrSubclass(ClassArr[1].replace(" ", ""));

                // Abilities
                p.setCha(Integer.parseInt(CHAEntry.getText()));
                p.setCon(Integer.parseInt(CONEntry.getText()));
                p.setDex(Integer.parseInt(DEXEntry.getText()));
                p.setIntl(Integer.parseInt(INTEntry.getText()));
                p.setWis(Integer.parseInt(WISEntry.getText()));
                p.setStr(Integer.parseInt(STREntry.getText()));

                // Modifiers
                p.setConMod(c.getModifier(p.getCon()));
                p.setStrMod(c.getModifier(p.getStr()));
                p.setChaMod(c.getModifier(p.getCha()));
                p.setIntlMod(c.getModifier(p.getIntl()));
                p.setDexMod(c.getModifier(p.getDex()));
                p.setWisMod(c.getModifier(p.getWis()));

                // Roll HP
                int hp = Integer.parseInt(hitDiceEntry.getText()) + p.getConMod();
                p.setHp(hp);
                p.setHpMax(hp);

                // Ability modifiers
                int[] abilityScores = new int[18];

                // Strength
                abilityScores[0] = p.getStrMod();

                // Dex
                for (int i = 1; i < 3; i++) {
                        abilityScores[i] = p.getDexMod();
                }

                // Intl
                for (int i = 3; i < 9; i++) {
                        abilityScores[i] = p.getIntlMod();
                }

                // Wis
                for (int i = 9; i < 14; i++) {
                        abilityScores[i] = p.getWisMod();
                }

                // Charisma
                for (int i = 14; i < 18; i++) {
                        abilityScores[i] = p.getChaMod();
                }

                // Add proficieny if prof is selected
                for (int i = 0; i < abilityScores.length; i++) {
                        if (checkBoxStates[i]) {
                                abilityScores[i] += p.getProf();
                        }
                }

                // Add it all together
                p.setAthletics(abilityScores[0]);
                p.setAcrobatics(abilityScores[1]);
                p.setSleightOfHand(abilityScores[2]);
                p.setStealth(abilityScores[3]);
                p.setArcana(abilityScores[4]);
                p.setHistory(abilityScores[5]);
                p.setInvestigation(abilityScores[6]);
                p.setNature(abilityScores[7]);
                p.setReligion(abilityScores[8]);
                p.setAnimalHandling(abilityScores[9]);
                p.setInsight(abilityScores[10]);
                p.setMedicine(abilityScores[11]);
                p.setPerception(abilityScores[12]);
                p.setSurvival(abilityScores[13]);
                p.setDeception(abilityScores[14]);
                p.setIntimidation(abilityScores[15]);
                p.setPerformance(abilityScores[16]);
                p.setPersuasion(abilityScores[17]);

                // Add shite to the lists
                p.setSpellsList(new ArrayList<Spell>(0));
                p.setWeaponsList(new ArrayList<Weapon>(0));

                p.setPP(Integer.parseInt(platEntry.getText()));
                p.setGP(Integer.parseInt(goldEntry.getText()));
                p.setSP(Integer.parseInt(silverEntry.getText()));
                p.setCP(Integer.parseInt(copperEntry.getText()));
                p.setEP(Integer.parseInt(electrumEntry.getText()));

                return p;
        }

        private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_finishButtonActionPerformed
                String name = JOptionPane.showInputDialog(finishButton,
                                "Please enter a name for this character\nMust be a valid name on whatever filesystem you're using",
                                "Enter player name", JOptionPane.QUESTION_MESSAGE);
                if (!name.equals("")) {
                        // Test if we can make the name
                        File f;
                        int ext = 0;
                        // Try to create a file with the player's name to make sure it's valid
                        do {
                                String testfp = name;
                                for (int i = 0; i < ext; i++) {
                                        testfp += "i";
                                }
                                testfp += ".txt";
                                f = new File(testfp);
                        } while (f.exists());

                        // Once we've got a file that we know can exist, try to create it
                        boolean success = false;
                        try {
                                f.createNewFile();
                                f.delete();
                                success = true;
                        } catch (IOException e) {
                                JOptionPane.showMessageDialog(finishButton,
                                                "Could not create file. Are you sure the player's name is valid?",
                                                "Error creating player file", JOptionPane.ERROR_MESSAGE);
                        }

                        File chosenFP = new File(".");
                        if (success) {
                                // Tell the player to pick a place to save the sheet to
                                JFileChooser jfc = new JFileChooser();
                                jfc.setCurrentDirectory(new File("."));
                                jfc.setDialogTitle("");
                                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                                jfc.setAcceptAllFileFilterUsed(false);

                                // Show dialog
                                if (jfc.showOpenDialog(finishButton) == JFileChooser.APPROVE_OPTION) {
                                        chosenFP = jfc.getSelectedFile();
                                } else {
                                        success = false;
                                        JOptionPane.showMessageDialog(finishButton, "No selection", "No selection",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        }

                        // If success then save the sheet
                        if (success) {
                                File sheetFP = new File(chosenFP.getAbsolutePath() + "/" + name + ".json");
                                CharacterSheet c = new CharacterSheet(sheetFP.getAbsolutePath());
                                Player p = createPlayer(c);
                                p.setName(name);
                                c.SaveSheet(p);
                        }
                } else {
                        JOptionPane.showMessageDialog(finishButton, "Player name cannot be empty",
                                        "Player name invalid", JOptionPane.ERROR_MESSAGE);
                }
        }// GEN-LAST:event_finishButtonActionPerformed

        private void rerollButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rollButtonActionPerformed
                ArrayList<Integer> rollsList = new ArrayList<>();
                for (int i : statRolls) {
                        rollsList.add(i);
                }
                int option = (int) JOptionPane.showInputDialog(rerollButton,
                                "Select a roll to reroll\n(should only be done once)", "Reroll a stat",
                                JOptionPane.QUESTION_MESSAGE, null, rollsList.toArray(), rollsList.get(0));
                int selectedIdx = rollsList.indexOf(option);
                int newStat = rollStat();
                if (newStat > statRolls[selectedIdx]) {
                        JOptionPane.showMessageDialog(rerollButton, "Stat rerolled to " + newStat, "Reroll result",
                                        JOptionPane.INFORMATION_MESSAGE);
                        statRolls[selectedIdx] = newStat;
                        updateStatRollsTextArea();
                } else if (newStat < statRolls[selectedIdx]) {
                        JOptionPane.showMessageDialog(rerollButton,
                                        "Stat rerolled to " + newStat
                                                        + ", but as this is lower, I'm guessing you don't want it",
                                        "Reroll result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                        JOptionPane.showMessageDialog(rerollButton,
                                        "Stat rerolled to " + newStat
                                                        + ", but as this the same value, so no change needed",
                                        "Reroll result", JOptionPane.INFORMATION_MESSAGE);
                }

                updateStatRollsTextArea();
        }// GEN-LAST:event_rollButtonActionPerformed

        private void rollButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rollButton1ActionPerformed
                for (int i = 0; i < statRolls.length; i++) {
                        statRolls[i] = rollStat();
                }
                updateStatRollsTextArea();
        }// GEN-LAST:event_rollButton1ActionPerformed

        // Roll 4d6, take the highest 3, add together
        int rollStat() {
                Dice d = new Dice("1d6");

                //
                int[] rolls = new int[4];
                for (int j = 0; j < 4; j++) {
                        rolls[j] = d.roll();
                }

                // Find smallest
                int minValIdx = 0;
                for (int j = 1; j < 4; j++) {
                        if (rolls[minValIdx] > rolls[j]) {
                                minValIdx = j;
                        }
                }

                // Add highest values
                int statVal = 0;
                for (int j = 0; j < 4; j++) {
                        if (j == minValIdx) {
                                continue;
                        }
                        statVal += rolls[j];
                }

                return statVal;
        }

        void updateStatRollsTextArea() {
                String s = "";
                for (int roll : statRolls) {
                        s += roll + "\n";
                }
                statRollsTextArea.setText(s.substring(0, s.length() - 1));
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
                Object source = e.getItemSelectable();

                if (source == athleticsCheckBox) {
                        checkBoxStates[0] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == acrobaticsCheckBox) {
                        checkBoxStates[1] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == sohCheckBox) {
                        checkBoxStates[2] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == stealthCheckBox) {
                        checkBoxStates[3] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == arcanaCheckBox) {
                        checkBoxStates[4] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == historyCheckBox) {
                        checkBoxStates[5] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == investigationCheckBox) {
                        checkBoxStates[6] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == natureCheckBox) {
                        checkBoxStates[7] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == religionCheckBox) {
                        checkBoxStates[8] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == animalHandlingCheckBox) {
                        checkBoxStates[9] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == insightCheckBox) {
                        checkBoxStates[10] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == medicineCheckBox) {
                        checkBoxStates[11] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == perceptionCheckBox) {
                        checkBoxStates[12] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == survivalCheckBox) {
                        checkBoxStates[13] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == deceptionCheckBox) {
                        checkBoxStates[14] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == intimidaionCheckBox) {
                        checkBoxStates[15] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == performanceCheckBox) {
                        checkBoxStates[16] = e.getStateChange() == ItemEvent.SELECTED;
                }
                if (source == persuasionCheckBox) {
                        checkBoxStates[17] = e.getStateChange() == ItemEvent.SELECTED;
                }
        }

        /**
         * Creates new form createCharacter
         */
        public createCharacter() {
                initComponents();

                for (int i = 0; i < checkBoxStates.length; i++) {
                        checkBoxStates[i] = false;
                }

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
                        public void windowIconified(WindowEvent arg0) {
                                ;
                        }

                        @Override
                        public void windowOpened(WindowEvent arg0) {
                                ;
                        }

                        @Override
                        public void windowDeiconified(WindowEvent arg0) {
                                ;
                        }
                });
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                scrollPane = new javax.swing.JScrollPane();
                mainPanel = new javax.swing.JPanel();
                HeaderPanel = new javax.swing.JPanel();
                headingLabel = new javax.swing.JLabel();
                subheadingLabel = new javax.swing.JLabel();
                contentPanel = new javax.swing.JPanel();
                stepsPanel = new javax.swing.JTabbedPane();
                Step1Panel = new javax.swing.JPanel();
                classLabel = new javax.swing.JLabel();
                classEntry = new javax.swing.JTextField();
                raceLabel = new javax.swing.JLabel();
                raceEntry = new javax.swing.JTextField();
                backgroundLabel = new javax.swing.JLabel();
                backgroundEntry = new javax.swing.JTextField();
                alignmentLable = new javax.swing.JLabel();
                alignmentEntry = new javax.swing.JTextField();
                levelLabel = new javax.swing.JLabel();
                levelEntry = new javax.swing.JTextField();
                profLabel = new javax.swing.JLabel();
                profEntry = new javax.swing.JTextField();
                hitDiceLabel = new javax.swing.JLabel();
                hitDiceEntry = new javax.swing.JTextField();
                speedLabel = new javax.swing.JLabel();
                speedEntry = new javax.swing.JTextField();
                jLabel1 = new javax.swing.JLabel();
                Step2Panel = new javax.swing.JPanel();
                STRPanel = new javax.swing.JPanel();
                STREntry = new javax.swing.JTextField();
                STRLabel = new javax.swing.JLabel();
                DEXPanel = new javax.swing.JPanel();
                DEXEntry = new javax.swing.JTextField();
                DEXLabel = new javax.swing.JLabel();
                CONPanel = new javax.swing.JPanel();
                CONEntry = new javax.swing.JTextField();
                CONLabel = new javax.swing.JLabel();
                INTPanel = new javax.swing.JPanel();
                INTEntry = new javax.swing.JTextField();
                INTLabel = new javax.swing.JLabel();
                WISPanel = new javax.swing.JPanel();
                WISEntry = new javax.swing.JTextField();
                WISLabel = new javax.swing.JLabel();
                CHAPanel = new javax.swing.JPanel();
                CHAEntry = new javax.swing.JTextField();
                CHALabel = new javax.swing.JLabel();
                rerollButton = new javax.swing.JButton();
                rollButton = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                statRollsTextArea = new javax.swing.JTextArea();
                jLabel2 = new javax.swing.JLabel();
                Step3Panel = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                strPanel = new javax.swing.JPanel();
                strLabel = new javax.swing.JLabel();
                athleticsCheckBox = new javax.swing.JCheckBox();
                dexPanel = new javax.swing.JPanel();
                dexLabel = new javax.swing.JLabel();
                acrobaticsCheckBox = new javax.swing.JCheckBox();
                sohCheckBox = new javax.swing.JCheckBox();
                stealthCheckBox = new javax.swing.JCheckBox();
                intPanel = new javax.swing.JPanel();
                intLabel = new javax.swing.JLabel();
                arcanaCheckBox = new javax.swing.JCheckBox();
                historyCheckBox = new javax.swing.JCheckBox();
                investigationCheckBox = new javax.swing.JCheckBox();
                natureCheckBox = new javax.swing.JCheckBox();
                religionCheckBox = new javax.swing.JCheckBox();
                wisPanel = new javax.swing.JPanel();
                wisLable = new javax.swing.JLabel();
                animalHandlingCheckBox = new javax.swing.JCheckBox();
                insightCheckBox = new javax.swing.JCheckBox();
                medicineCheckBox = new javax.swing.JCheckBox();
                perceptionCheckBox = new javax.swing.JCheckBox();
                survivalCheckBox = new javax.swing.JCheckBox();
                chaPanel = new javax.swing.JPanel();
                chaLabel = new javax.swing.JLabel();
                deceptionCheckBox = new javax.swing.JCheckBox();
                intimidaionCheckBox = new javax.swing.JCheckBox();
                performanceCheckBox = new javax.swing.JCheckBox();
                persuasionCheckBox = new javax.swing.JCheckBox();
                jPanel1 = new javax.swing.JPanel();
                jLabel4 = new javax.swing.JLabel();
                ACLabel = new javax.swing.JLabel();
                ACEntry = new javax.swing.JTextField();
                platLabel = new javax.swing.JLabel();
                platEntry = new javax.swing.JTextField();
                goldLabel = new javax.swing.JLabel();
                goldEntry = new javax.swing.JTextField();
                silverLabel = new javax.swing.JLabel();
                silverEntry = new javax.swing.JTextField();
                copperLabel = new javax.swing.JLabel();
                copperEntry = new javax.swing.JTextField();
                electrumLabel = new javax.swing.JLabel();
                electrumEntry = new javax.swing.JTextField();
                finishButton = new javax.swing.JButton();

                // Fucking item listeners for some fucking reason
                athleticsCheckBox.addItemListener(this);
                acrobaticsCheckBox.addItemListener(this);
                sohCheckBox.addItemListener(this);
                stealthCheckBox.addItemListener(this);
                arcanaCheckBox.addItemListener(this);
                historyCheckBox.addItemListener(this);
                investigationCheckBox.addItemListener(this);
                natureCheckBox.addItemListener(this);
                religionCheckBox.addItemListener(this);
                animalHandlingCheckBox.addItemListener(this);
                insightCheckBox.addItemListener(this);
                medicineCheckBox.addItemListener(this);
                perceptionCheckBox.addItemListener(this);
                survivalCheckBox.addItemListener(this);
                deceptionCheckBox.addItemListener(this);
                intimidaionCheckBox.addItemListener(this);
                performanceCheckBox.addItemListener(this);
                persuasionCheckBox.addItemListener(this);

                // imo this is dumb, but I didn't write the language
                // this makes it still dumb, but unavoidable dumb

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                headingLabel.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
                headingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                headingLabel.setText("DnD Character Sheet");

                subheadingLabel.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
                subheadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                subheadingLabel.setText("But you don't have to pay for it");

                javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
                HeaderPanel.setLayout(HeaderPanelLayout);
                HeaderPanelLayout.setHorizontalGroup(HeaderPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(subheadingLabel, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(headingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 807,
                                                Short.MAX_VALUE));
                HeaderPanelLayout.setVerticalGroup(HeaderPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(HeaderPanelLayout.createSequentialGroup()
                                                .addComponent(headingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(subheadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                34, javax.swing.GroupLayout.PREFERRED_SIZE)));

                classLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                classLabel.setText("Class (Enter as [Class]/[Subclass])");

                classEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                classEntry.setText("[Class]/[Subclass]");

                raceLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                raceLabel.setText("Race");

                raceEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

                backgroundLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                backgroundLabel.setText("Background");

                backgroundEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

                alignmentLable.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                alignmentLable.setText("Alignment");

                alignmentEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

                levelLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                levelLabel.setText("Level");

                levelEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                levelEntry.setText("1");

                profLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                profLabel.setText("Proficiency");

                profEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                profEntry.setText("2");

                hitDiceLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                hitDiceLabel.setText("Hit Dice (1dX)");

                hitDiceEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                hitDiceEntry.setText("8");

                speedLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                speedLabel.setText("Speed (ft)");

                speedEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                speedEntry.setText("30");

                jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                jLabel1.setText("Step 1 - Character Information");

                javax.swing.GroupLayout Step1PanelLayout = new javax.swing.GroupLayout(Step1Panel);
                Step1Panel.setLayout(Step1PanelLayout);
                Step1PanelLayout.setHorizontalGroup(Step1PanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(Step1PanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(Step1PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(Step1PanelLayout.createSequentialGroup()
                                                                                .addComponent(classLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(classEntry,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                434,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                Step1PanelLayout.createSequentialGroup()
                                                                                                .addComponent(raceLabel,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                332,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(raceEntry,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                434,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(Step1PanelLayout.createSequentialGroup()
                                                                                .addComponent(backgroundLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                332, Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(backgroundEntry,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                434,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(Step1PanelLayout.createSequentialGroup()
                                                                                .addComponent(alignmentLable,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                332, Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(alignmentEntry,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                434,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(Step1PanelLayout.createSequentialGroup()
                                                                                .addComponent(levelLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                332, Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(levelEntry,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                434,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                Step1PanelLayout.createSequentialGroup()
                                                                                                .addComponent(profLabel,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                332,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(profEntry,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                434,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(Step1PanelLayout.createSequentialGroup()
                                                                                .addComponent(hitDiceLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                332, Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(hitDiceEntry,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                434,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                Step1PanelLayout.createSequentialGroup()
                                                                                                .addComponent(speedLabel,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                332,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(speedEntry,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                434,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap()));
                Step1PanelLayout.setVerticalGroup(Step1PanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Step1PanelLayout
                                                .createSequentialGroup().addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 66,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(Step1PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(classLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(classEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(Step1PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(raceLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(raceEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(Step1PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(backgroundLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(backgroundEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(Step1PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(alignmentLable,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(alignmentEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(Step1PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(levelLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(levelEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(Step1PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(profLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(profEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(Step1PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(hitDiceLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(hitDiceEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(Step1PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(speedLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(speedEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap()));

                stepsPanel.addTab("Step 1", Step1Panel);

                STREntry.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
                STREntry.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                STREntry.setText("20");

                STRLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                STRLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                STRLabel.setText("STR");

                javax.swing.GroupLayout STRPanelLayout = new javax.swing.GroupLayout(STRPanel);
                STRPanel.setLayout(STRPanelLayout);
                STRPanelLayout.setHorizontalGroup(STRPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(STRPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(STRPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(STRLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(STREntry,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                130, Short.MAX_VALUE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                STRPanelLayout.setVerticalGroup(STRPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(STRPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(STREntry, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(STRLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 53,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                DEXPanel.setPreferredSize(new java.awt.Dimension(154, 164));

                DEXEntry.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
                DEXEntry.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                DEXEntry.setText("20");

                DEXLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                DEXLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                DEXLabel.setText("DEX");

                javax.swing.GroupLayout DEXPanelLayout = new javax.swing.GroupLayout(DEXPanel);
                DEXPanel.setLayout(DEXPanelLayout);
                DEXPanelLayout.setHorizontalGroup(DEXPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(DEXPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(DEXPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(DEXLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(DEXEntry,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                130, Short.MAX_VALUE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                DEXPanelLayout.setVerticalGroup(DEXPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(DEXPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(DEXEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DEXLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap()));

                CONPanel.setPreferredSize(new java.awt.Dimension(154, 164));

                CONEntry.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
                CONEntry.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                CONEntry.setText("20");

                CONLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                CONLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                CONLabel.setText("CON");

                javax.swing.GroupLayout CONPanelLayout = new javax.swing.GroupLayout(CONPanel);
                CONPanel.setLayout(CONPanelLayout);
                CONPanelLayout.setHorizontalGroup(CONPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(CONPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(CONPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(CONLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(CONEntry,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                130, Short.MAX_VALUE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                CONPanelLayout.setVerticalGroup(CONPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(CONPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(CONEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CONLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap()));

                INTPanel.setPreferredSize(new java.awt.Dimension(154, 164));

                INTEntry.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
                INTEntry.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                INTEntry.setText("20");

                INTLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                INTLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                INTLabel.setText("INT");

                javax.swing.GroupLayout INTPanelLayout = new javax.swing.GroupLayout(INTPanel);
                INTPanel.setLayout(INTPanelLayout);
                INTPanelLayout.setHorizontalGroup(INTPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(INTPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(INTPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(INTLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(INTEntry,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                130, Short.MAX_VALUE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                INTPanelLayout.setVerticalGroup(INTPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(INTPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(INTEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(INTLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 53,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                WISPanel.setPreferredSize(new java.awt.Dimension(154, 164));

                WISEntry.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
                WISEntry.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                WISEntry.setText("20");

                WISLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                WISLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                WISLabel.setText("WIS");

                javax.swing.GroupLayout WISPanelLayout = new javax.swing.GroupLayout(WISPanel);
                WISPanel.setLayout(WISPanelLayout);
                WISPanelLayout.setHorizontalGroup(WISPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(WISPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(WISPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(WISLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(WISEntry,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                130, Short.MAX_VALUE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                WISPanelLayout.setVerticalGroup(WISPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(WISPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(WISEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(WISLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 53,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                CHAPanel.setPreferredSize(new java.awt.Dimension(154, 164));

                CHAEntry.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
                CHAEntry.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                CHAEntry.setText("20");

                CHALabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                CHALabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                CHALabel.setText("CHA");

                javax.swing.GroupLayout CHAPanelLayout = new javax.swing.GroupLayout(CHAPanel);
                CHAPanel.setLayout(CHAPanelLayout);
                CHAPanelLayout.setHorizontalGroup(CHAPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(CHAPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(CHAPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(CHALabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(CHAEntry,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                130, Short.MAX_VALUE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                CHAPanelLayout.setVerticalGroup(CHAPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(CHAPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(CHAEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CHALabel, javax.swing.GroupLayout.DEFAULT_SIZE, 53,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                rerollButton.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
                rerollButton.setText("Re-Roll");
                rerollButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                rerollButtonActionPerformed(evt);
                        }
                });

                rollButton.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
                rollButton.setText("Roll");
                rollButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                rollButtonActionPerformed(evt);
                        }
                });

                statRollsTextArea.setColumns(2);
                statRollsTextArea.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
                statRollsTextArea.setRows(5);
                statRollsTextArea.setText("20\n20\n20\n20\n20\n20");
                jScrollPane2.setViewportView(statRollsTextArea);

                jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                jLabel2.setText("Step 2  - Ability Scores");

                javax.swing.GroupLayout Step2PanelLayout = new javax.swing.GroupLayout(Step2Panel);
                Step2Panel.setLayout(Step2PanelLayout);
                Step2PanelLayout.setHorizontalGroup(Step2PanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(Step2PanelLayout.createSequentialGroup().addGroup(Step2PanelLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(Step2PanelLayout.createSequentialGroup().addContainerGap()
                                                                .addComponent(jLabel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                474,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(Step2PanelLayout.createSequentialGroup().addGap(59, 59, 59)
                                                                .addGroup(Step2PanelLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addGroup(Step2PanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(STRPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(DEXPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(CONPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(Step2PanelLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(INTPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(WISPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(CHAPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(90, 90, 90)
                                                .addGroup(Step2PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane2)
                                                                .addComponent(rollButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(rerollButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGap(669, 669, 669)));
                Step2PanelLayout.setVerticalGroup(Step2PanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(Step2PanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(Step2PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(Step2PanelLayout.createSequentialGroup()
                                                                                .addComponent(rollButton,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jScrollPane2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                275,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(rerollButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                60,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                Step2PanelLayout.createSequentialGroup()
                                                                                                .addComponent(jLabel2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                60,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(Step2PanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(CONPanel,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(DEXPanel,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(STRPanel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addGroup(Step2PanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(INTPanel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(WISPanel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(CHAPanel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(48, Short.MAX_VALUE)));

                stepsPanel.addTab("Step 2", Step2Panel);

                jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                jLabel3.setText("Step 3 - Proficiencies");

                strPanel.setPreferredSize(new java.awt.Dimension(150, 100));

                strLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                strLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strLabel.setText("Strength");

                athleticsCheckBox.setText("Athletics");

                javax.swing.GroupLayout strPanelLayout = new javax.swing.GroupLayout(strPanel);
                strPanel.setLayout(strPanelLayout);
                strPanelLayout.setHorizontalGroup(strPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, strPanelLayout
                                                .createSequentialGroup().addContainerGap()
                                                .addGroup(strPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(athleticsCheckBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(strLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                strPanelLayout.setVerticalGroup(strPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(strLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18).addComponent(athleticsCheckBox)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                dexPanel.setPreferredSize(new java.awt.Dimension(150, 100));

                dexLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                dexLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                dexLabel.setText("Dexterity");

                acrobaticsCheckBox.setText("Acrobatics");

                sohCheckBox.setText("Sleight of Hand");

                stealthCheckBox.setText("Stealth");

                javax.swing.GroupLayout dexPanelLayout = new javax.swing.GroupLayout(dexPanel);
                dexPanel.setLayout(dexPanelLayout);
                dexPanelLayout.setHorizontalGroup(dexPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(dexPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(dexPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(acrobaticsCheckBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(dexLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(sohCheckBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(stealthCheckBox,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE))
                                                .addContainerGap()));
                dexPanelLayout.setVerticalGroup(dexPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(dexPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(dexLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18).addComponent(acrobaticsCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(sohCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(stealthCheckBox)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                intPanel.setPreferredSize(new java.awt.Dimension(150, 100));

                intLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                intLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                intLabel.setText("Intelligence");

                arcanaCheckBox.setText("Arcana");

                historyCheckBox.setText("History");

                investigationCheckBox.setText("Investigation");

                natureCheckBox.setText("Nature");

                religionCheckBox.setText("Religion");

                javax.swing.GroupLayout intPanelLayout = new javax.swing.GroupLayout(intPanel);
                intPanel.setLayout(intPanelLayout);
                intPanelLayout.setHorizontalGroup(intPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(arcanaCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
                                                Short.MAX_VALUE)
                                .addComponent(historyCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
                                                Short.MAX_VALUE)
                                .addComponent(investigationCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
                                                Short.MAX_VALUE)
                                .addGroup(intPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(intLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 126,
                                                                Short.MAX_VALUE)
                                                .addContainerGap())
                                .addComponent(natureCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
                                                Short.MAX_VALUE)
                                .addComponent(religionCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
                                                Short.MAX_VALUE));
                intPanelLayout.setVerticalGroup(intPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(intPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(intLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18).addComponent(arcanaCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(historyCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(investigationCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(natureCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(religionCheckBox).addContainerGap(192, Short.MAX_VALUE)));

                wisPanel.setPreferredSize(new java.awt.Dimension(150, 100));

                wisLable.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                wisLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                wisLable.setText("Wisdom");

                animalHandlingCheckBox.setText("Animal Handling");

                insightCheckBox.setText("Insight");

                medicineCheckBox.setText("Medicine");

                perceptionCheckBox.setText("Pereption");

                survivalCheckBox.setText("Survival");

                javax.swing.GroupLayout wisPanelLayout = new javax.swing.GroupLayout(wisPanel);
                wisPanel.setLayout(wisPanelLayout);
                wisPanelLayout.setHorizontalGroup(wisPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(wisPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(wisPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(wisLable,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(animalHandlingCheckBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(insightCheckBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(medicineCheckBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(perceptionCheckBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(survivalCheckBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE))
                                                .addContainerGap()));
                wisPanelLayout.setVerticalGroup(wisPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(wisPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(wisLable, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18).addComponent(animalHandlingCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(insightCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(medicineCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(perceptionCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(survivalCheckBox)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                chaPanel.setPreferredSize(new java.awt.Dimension(150, 100));

                chaLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
                chaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                chaLabel.setText("Charisma");

                deceptionCheckBox.setText("Deception");

                intimidaionCheckBox.setText("Intimidation");

                performanceCheckBox.setText("Performance");

                persuasionCheckBox.setText("Persuasion");

                javax.swing.GroupLayout chaPanelLayout = new javax.swing.GroupLayout(chaPanel);
                chaPanel.setLayout(chaPanelLayout);
                chaPanelLayout.setHorizontalGroup(chaPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(chaPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(chaPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(chaLabel,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(deceptionCheckBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(intimidaionCheckBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(performanceCheckBox,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE)
                                                                .addComponent(persuasionCheckBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                126, Short.MAX_VALUE))
                                                .addContainerGap()));
                chaPanelLayout.setVerticalGroup(chaPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(chaPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(chaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18).addComponent(deceptionCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(intimidaionCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(performanceCheckBox)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(persuasionCheckBox)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout Step3PanelLayout = new javax.swing.GroupLayout(Step3Panel);
                Step3Panel.setLayout(Step3PanelLayout);
                Step3PanelLayout.setHorizontalGroup(Step3PanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(Step3PanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(Step3PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(Step3PanelLayout.createSequentialGroup()
                                                                                .addComponent(strPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(dexPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(intPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(wisPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(chaPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 4, Short.MAX_VALUE)))
                                                .addContainerGap()));
                Step3PanelLayout.setVerticalGroup(Step3PanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(Step3PanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(Step3PanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(strPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                371, Short.MAX_VALUE)
                                                                .addComponent(dexPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                371, Short.MAX_VALUE)
                                                                .addComponent(intPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                371, Short.MAX_VALUE)
                                                                .addComponent(wisPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                371, Short.MAX_VALUE)
                                                                .addComponent(chaPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                371, Short.MAX_VALUE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                stepsPanel.addTab("Step3", Step3Panel);

                jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                jLabel4.setText("Step 4 - Finishing up");

                ACLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                ACLabel.setText("AC");

                ACEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                ACEntry.setText("10");

                platLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                platLabel.setText("Platinum");

                platEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                platEntry.setText("0");

                goldLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                goldLabel.setText("Gold");

                goldEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                goldEntry.setText("0");

                silverLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                silverLabel.setText("Silver");

                silverEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                silverEntry.setText("10");

                copperLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                copperLabel.setText("Copper");

                copperEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                copperEntry.setText("0");

                electrumLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                electrumLabel.setText("Electrum");

                electrumEntry.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                electrumEntry.setText("0");

                finishButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                finishButton.setText("Finish character creation");
                finishButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                finishButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 778,
                                                                Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createSequentialGroup().addComponent(ACLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(ACEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                434,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addComponent(platLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(platEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                434,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addComponent(goldLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(silverEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                434,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(silverLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(goldEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                434,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addComponent(copperLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(copperEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                434,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(electrumLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(electrumEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                434,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap())
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(226, 226, 226)
                                                .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 329,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(ACLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(ACEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(platLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(platEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(goldLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(silverEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(silverLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(goldEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(copperLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(copperEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(electrumLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(electrumEntry,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                41,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(finishButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                stepsPanel.addTab("Step 4", jPanel1);

                javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(contentPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(contentPanelLayout.createSequentialGroup().addComponent(stepsPanel,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addContainerGap()));
                contentPanelLayout.setVerticalGroup(
                                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(stepsPanel));

                javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
                mainPanel.setLayout(mainPanelLayout);
                mainPanelLayout.setHorizontalGroup(mainPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(mainPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(mainPanelLayout.createSequentialGroup()
                                                                                .addComponent(HeaderPanel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addContainerGap())
                                                                .addComponent(contentPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))));
                mainPanelLayout.setVerticalGroup(mainPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
                                                .addComponent(HeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap()));

                scrollPane.setViewportView(mainPanel);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scrollPane));
                layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scrollPane));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTextField ACEntry;
        private javax.swing.JLabel ACLabel;
        private javax.swing.JTextField CHAEntry;
        private javax.swing.JLabel CHALabel;
        private javax.swing.JPanel CHAPanel;
        private javax.swing.JTextField CONEntry;
        private javax.swing.JLabel CONLabel;
        private javax.swing.JPanel CONPanel;
        private javax.swing.JTextField DEXEntry;
        private javax.swing.JLabel DEXLabel;
        private javax.swing.JPanel DEXPanel;
        private javax.swing.JPanel HeaderPanel;
        private javax.swing.JTextField INTEntry;
        private javax.swing.JLabel INTLabel;
        private javax.swing.JPanel INTPanel;
        private javax.swing.JTextField STREntry;
        private javax.swing.JLabel STRLabel;
        private javax.swing.JPanel STRPanel;
        private javax.swing.JPanel Step1Panel;
        private javax.swing.JPanel Step2Panel;
        private javax.swing.JPanel Step3Panel;
        private javax.swing.JTextField WISEntry;
        private javax.swing.JLabel WISLabel;
        private javax.swing.JPanel WISPanel;
        private javax.swing.JCheckBox acrobaticsCheckBox;
        private javax.swing.JTextField alignmentEntry;
        private javax.swing.JLabel alignmentLable;
        private javax.swing.JCheckBox animalHandlingCheckBox;
        private javax.swing.JCheckBox arcanaCheckBox;
        private javax.swing.JCheckBox athleticsCheckBox;
        private javax.swing.JTextField backgroundEntry;
        private javax.swing.JLabel backgroundLabel;
        private javax.swing.JLabel chaLabel;
        private javax.swing.JPanel chaPanel;
        private javax.swing.JTextField classEntry;
        private javax.swing.JLabel classLabel;
        private javax.swing.JPanel contentPanel;
        private javax.swing.JTextField copperEntry;
        private javax.swing.JLabel copperLabel;
        private javax.swing.JCheckBox deceptionCheckBox;
        private javax.swing.JLabel dexLabel;
        private javax.swing.JPanel dexPanel;
        private javax.swing.JTextField electrumEntry;
        private javax.swing.JLabel electrumLabel;
        private javax.swing.JButton finishButton;
        private javax.swing.JTextField goldEntry;
        private javax.swing.JLabel goldLabel;
        private javax.swing.JLabel headingLabel;
        private javax.swing.JCheckBox historyCheckBox;
        private javax.swing.JTextField hitDiceEntry;
        private javax.swing.JLabel hitDiceLabel;
        private javax.swing.JCheckBox insightCheckBox;
        private javax.swing.JLabel intLabel;
        private javax.swing.JPanel intPanel;
        private javax.swing.JCheckBox intimidaionCheckBox;
        private javax.swing.JCheckBox investigationCheckBox;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JTextArea statRollsTextArea;
        private javax.swing.JTextField levelEntry;
        private javax.swing.JLabel levelLabel;
        private javax.swing.JPanel mainPanel;
        private javax.swing.JCheckBox medicineCheckBox;
        private javax.swing.JCheckBox natureCheckBox;
        private javax.swing.JCheckBox perceptionCheckBox;
        private javax.swing.JCheckBox performanceCheckBox;
        private javax.swing.JCheckBox persuasionCheckBox;
        private javax.swing.JTextField platEntry;
        private javax.swing.JLabel platLabel;
        private javax.swing.JTextField profEntry;
        private javax.swing.JLabel profLabel;
        private javax.swing.JTextField raceEntry;
        private javax.swing.JLabel raceLabel;
        private javax.swing.JCheckBox religionCheckBox;
        private javax.swing.JButton rerollButton;
        private javax.swing.JButton rollButton;
        private javax.swing.JScrollPane scrollPane;
        private javax.swing.JTextField silverEntry;
        private javax.swing.JLabel silverLabel;
        private javax.swing.JCheckBox sohCheckBox;
        private javax.swing.JTextField speedEntry;
        private javax.swing.JLabel speedLabel;
        private javax.swing.JCheckBox stealthCheckBox;
        private javax.swing.JTabbedPane stepsPanel;
        private javax.swing.JLabel strLabel;
        private javax.swing.JPanel strPanel;
        private javax.swing.JLabel subheadingLabel;
        private javax.swing.JCheckBox survivalCheckBox;
        private javax.swing.JLabel wisLable;
        private javax.swing.JPanel wisPanel;
        // End of variables declaration//GEN-END:variables
}
