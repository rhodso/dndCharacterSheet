package com.rhodso.app;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CharacterSheetUI extends javax.swing.JFrame {

        Player p;
        CharacterSheet c;
        ArrayList<JPanel> weaponsList;
        /**
        *
        */
        private static final long serialVersionUID = 5268660238048446430L;

        /**
         * Creates new form characterSheetForm
         */
        public CharacterSheetUI(Player _p, String _fp) {
                this.p = _p;
                this.c = new CharacterSheet(_fp);
                initComponents();
                setComponentValues(p);

                // Override default close operation
                this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

                this.addWindowListener(new WindowListener() {
                        public void windowClosing(WindowEvent e) {
                                saveNotes();
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
        }

        public void saveNotes() {
                p.setNotes(infoNotes.getText());
                c.SaveSheet(p);
        }

        public JPanel buildWeaponsListPanel(ArrayList<JPanel> _weaponsList) {
                JPanel panel = new JPanel();

                panel.setLayout(new java.awt.GridLayout(_weaponsList.size(), 1));

                for (JPanel wpnPanel : _weaponsList) {
                        panel.add(wpnPanel, c);
                }

                return panel;
        }

        public JPanel buildSpellsListPanel(ArrayList<JPanel> _spellsList) {
                JPanel panel = new JPanel();

                // Convert list of all known spells into spell slots
                ArrayList<ArrayList<JPanel>> actualSpellsList;



                panel.setLayout(new java.awt.GridLayout(_spellsList.size() + 9, 1));



                return panel;
        }

        /*
         * @return the number formatted as a string
         */
        public String formatStr(int i) {
                if (i > 0) {
                        return "+" + Integer.toString(i);
                } else {
                        return Integer.toString(i);
                }
        }

        private void setComponentValues(Player p) {
                // The stuff that appears on all pages
                statsCharacterName.setText(p.getName());
                abilitiesCharacterName.setText(p.getName());
                weaponsCharacterName.setText(p.getName());
                spellsCharacterName.setText(p.getName());
                informationCharacterName.setText(p.getName());

                statsCharacterClass.setText(p.getChrSubclass() + " " + p.getChrClass());
                abilitiesCharacterClass.setText(p.getChrSubclass() + " " + p.getChrClass());
                weaponsCharacterClass.setText(p.getChrSubclass() + " " + p.getChrClass());
                spellsCharacterClass.setText(p.getChrSubclass() + " " + p.getChrClass());
                informationCharacterClass.setText(p.getChrSubclass() + " " + p.getChrClass());

                statsCharacterLevel.setText(Integer.toString(p.getLvl()));
                abilitiesCharacterLevel.setText(Integer.toString(p.getLvl()));
                weaponsCharacterLevel.setText(Integer.toString(p.getLvl()));
                spellsCharacterLevel.setText(Integer.toString(p.getLvl()));
                informationCharacterLevel.setText(Integer.toString(p.getLvl()));

                HPValueLabel.setText(p.getHp() + "/" + p.getHpMax());

                // Low health representation
                double d = p.getHp();
                if ((d / p.getHpMax()) <= 0.25) {
                        HPValueLabel.setForeground(Color.red);
                } else {
                        HPValueLabel.setForeground(Color.black);
                }

                ACValueLabel.setText(Integer.toString(p.getAc()));
                SpeedValueLabel.setText(Integer.toString(p.getSpeed()) + " ft");
                HitDiceValueLabel.setText(p.getHitDieDR());

                // Set score values
                strengthScoreValueLabel.setText(Integer.toString(p.getStr()));
                strengthModifierValueLabel.setText(formatStr(p.getStrMod()));
                strengthSaveValueLabel.setText(formatStr(p.getStrSave()));

                dexterityScoreValueLabel.setText(Integer.toString(p.getDex()));
                dexterityModifierValueLabel.setText(formatStr(p.getDexMod()));
                dexteritySaveValueLabel.setText(formatStr(p.getDexSave()));

                constitutionScoreValueLabel.setText(Integer.toString(p.getCon()));
                constitutionModifierValueLabel.setText(formatStr(p.getConMod()));
                constitutionSaveValueLabel.setText(formatStr(p.getConSave()));

                intelligenceScoreValueLabel.setText(Integer.toString(p.getIntl()));
                intelligenceModifierValueLabel.setText(formatStr(p.getIntlMod()));
                intelligenceSaveValueLabel.setText(formatStr(p.getIntlSave()));

                wisdomScoreValueLabel.setText(Integer.toString(p.getWis()));
                wisdomModifierValueLabel.setText(formatStr(p.getWisMod()));
                wisdomSaveValueLabel.setText(formatStr(p.getWisSave()));

                charismaScoreValueLabel.setText(Integer.toString(p.getCha()));
                charismaModifierValueLabel.setText(formatStr(p.getChaMod()));
                charismaSaveValueLabel.setText(formatStr(p.getChaSave()));

                // ability scores
                charStrengthValueLabel.setText(formatStr(p.getStrMod()));
                charAthleticsValueLabel.setText(formatStr(p.getAthletics()));
                charDexterityValueLabel.setText(formatStr(p.getDexMod()));
                charAcrobaticsValueLabel.setText(formatStr(p.getAcrobatics()));
                charSoHValueLabel.setText(formatStr(p.getSleightOfHand()));
                charStealthValueLabel.setText(formatStr(p.getStealth()));
                charIntelligenceValueLabel.setText(formatStr(p.getIntlMod()));
                charArcanaValueLabel.setText(formatStr(p.getArcana()));
                charHistoryValueLabel.setText(formatStr(p.getHistory()));
                charInvestigationValueLabel.setText(formatStr(p.getInvestigation()));
                charNatureValueLabel.setText(formatStr(p.getNature()));
                charReligionValueLabel.setText(formatStr(p.getReligion()));
                charWisdomValueLabel.setText(formatStr(p.getWisMod()));
                charAnimalHandlingValueLabel.setText(formatStr(p.getAnimalHandling()));
                charInsightValueLabel.setText(formatStr(p.getInsight()));
                charMedicineValueLabel.setText(formatStr(p.getMedicine()));
                charPerceptionValueLabel.setText(formatStr(p.getPerception()));
                charSurvivalValueLabel.setText(formatStr(p.getSurvival()));
                charCharismaValueLabel.setText(formatStr(p.getChaMod()));
                charDeceptionValueLabel.setText(formatStr(p.getDeception()));
                charIntimidationValueLabel.setText(formatStr(p.getIntimidation()));
                charPerformanceValueLabel.setText(formatStr(p.getPerformance()));
                charPersuasionValueLabel.setText(formatStr(p.getPersuasion()));

                proficiencyValueLabel.setText(formatStr(p.getProf()));

                // weapon info
                weaponProficiencyValueLabel.setText(formatStr(p.getProf()));
                weaponStrengthValueLable.setText(Integer.toString(p.getStr()));
                weaponResourceValueLabel.setText(Integer.toString(p.getWeaponResource()));

                // spell info
                spellsCLevelValueLabel.setText(Integer.toString(p.getcLevel()));
                spellsAttackValueLabel.setText(formatStr(p.getSpellAttack()));
                spellsDCValueLabel.setText(Integer.toString(p.getSpellDC()));

                // info panel
                infoCharacterClassTextBox.setText(p.getChrSubclass() + " " + p.getChrClass());
                infoCharacterRaceTextBox.setText(p.getRace());
                infoCharacterBackgroundTextBox.setText(p.getBackground());
                infoCharacterAlignmentTextBox.setText(p.getAlignment());
                infoCharacterXPTextBox.setText(Integer.toString(p.getXp()));

                // Currecy
                infoPPValueLabel.setText(Integer.toString(p.getPP()));
                infoGPValueLabel.setText(Integer.toString(p.getGP()));
                infoSPValueLabel.setText(Integer.toString(p.getSP()));
                infoCPValueLabel.setText(Integer.toString(p.getCP()));
                infoEPValueLabel.setText(Integer.toString(p.getEP()));

                // Other info
                infoNotes.setText(p.getNotes());

                // weaponList
                weaponsList = buildWeaponList();
                JPanel weaponsListPanel = buildWeaponsListPanel(weaponsList);

                weaponsListScrollPane.setViewportView(weaponsListPanel);

        }

        String abilityCheck(int mod) {
                // Create default string
                String msg = "Rolled a ";

                // Roll dice
                int res = Dice.roll(20);

                if (res == 1) {
                        msg += "1, Critical Fail";
                } else if (res == 20) {
                        msg += "20 , Critical Success";
                } else {
                        msg += (res + " + " + mod + " makes " + (res + mod));
                }
                return msg;
        }

        private void updateStrengthButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateStrengthButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new strength value\nCurrent value is " + p.getStr(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setStr(newVal);
                        p.setStrMod(c.getModifier(newVal));
                        p.setStrSave(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }

        // GEN-LAST:event_updateStrengthButtonActionPerformed

        private void proficiencyUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_proficiencyUpdateButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new proficiency value\nCurrent value is "
                                                + p.getProf(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setProf(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_proficiencyUpdateButtonActionPerformed

        private void HitDiceUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_HitDiceUpdateButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new hit dice value\nCurrent value is "
                                                + p.getHitDieDR(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                if (newVal == null || newVal == "") {
                        newVal = p.getHitDieDR();
                        fail = true;
                }

                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setHitDieDR(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_HitDiceUpdateButtonActionPerformed

        private void SpeedUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SpeedUpdateButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new speed value\nCurrent value is " + p.getSpeed(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setSpeed(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_SpeedUpdateButtonActionPerformed

        private void ACUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ACUpdateButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new AC value\nCurrent value is " + p.getAc(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setAc(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_ACUpdateButtonActionPerformed

        private void HPUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_HPUpdateButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;
                boolean affectMax = false;
                boolean resetHP = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new hp value\nCurrent value is " + p.getHp()
                                                + " and your max HP is " + p.getHpMax()
                                                + ".\nIf you enter a negative value, that will be removed from the current value"
                                                + ".\nIf you don't enter a value, your HP will be set to you current max HP"
                                                + ".\nType \"max\" after the value to affect the maximum HP instead (Current HP will not be modified)",
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                /*
                 * String[] buttons = {"Set current hp", "Take from hp", "give to hp",
                 * "set to max hp"}; Object s = JOptionPane.showInputDialog(updateStrengthButton,
                 * "Please enter new hp value\nCurrent value is " + p.getHp() +
                 * " and your max HP is " + p.getHpMax(), "Enter new value",
                 * JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
                 */
                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        if (newVal_S.equals("")) {
                                resetHP = true;
                        } else if (newVal_S.indexOf("max") == -1) {
                                // Don't affect the max HP
                                newVal = Integer.parseInt(newVal_S);
                        } else {
                                affectMax = true;
                                newVal_S = newVal_S.replace("max", "");
                                newVal_S = newVal_S.replace(" ", "");
                                newVal = Integer.parseInt(newVal_S);
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        if (resetHP) {
                                // resetHP
                                p.setHp(p.getHpMax());
                        } else if (affectMax) {
                                // Affect Max HP
                                if (newVal > 0) {
                                        p.setHpMax(newVal);
                                } else {
                                        p.setHpMax(p.getHpMax() + newVal);
                                }
                        } else {
                                // Affect actual HP
                                if (newVal > 0) {
                                        p.setHp(newVal);
                                } else {
                                        p.setHp(p.getHp() + newVal);
                                }
                        }
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_HPUpdateButtonActionPerformed

        private void updateIntelligenceButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateIntelligenceButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new intelligence value\nCurrent value is "
                                                + p.getIntl(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setIntl(newVal);
                        p.setIntlMod(c.getModifier(newVal));
                        p.setIntlSave(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_updateIntelligenceButtonActionPerformed

        private void updateDexterityButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateDexterityButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new dexterity value\nCurrent value is " + p.getDex(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setDex(newVal);
                        p.setDexMod(c.getModifier(newVal));
                        p.setDexSave(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_updateDexterityButtonActionPerformed

        private void updateWisdomButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateWisdomButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new wisdom value\nCurrent value is " + p.getWis(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setWis(newVal);
                        p.setWisMod(c.getModifier(newVal));
                        p.setWisSave(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_updateWisdomButtonActionPerformed

        private void updateConstitutionButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateConstitutionButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new constitution value\nCurrent value is "
                                                + p.getCon(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setCon(newVal);
                        p.setConMod(c.getModifier(newVal));
                        p.setConSave(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_updateConstitutionButtonActionPerformed

        private void updateCharismaButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateCharismaButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new charisma value\nCurrent value is " + p.getCha(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setCha(newVal);
                        p.setChaMod(c.getModifier(newVal));
                        p.setChaSave(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_updateCharismaButtonActionPerformed

        private void strengthCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_strengthCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getStrMod()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_strengthCheckButtonActionPerformed

        private void athleticsCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_athleticsCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getAthletics()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_athleticsCheckButtonActionPerformed

        private void dexterityCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_dexterityCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getDexMod()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_dexterityCheckButtonActionPerformed

        private void acrobaticsCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_acrobaticsCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getAcrobatics()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_acrobaticsCheckButtonActionPerformed

        private void SoHCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_SoHCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton,
                                abilityCheck(p.getSleightOfHand()), "Roll result",
                                JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_SoHCheckButtonActionPerformed

        private void stealthCheckActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_stealthCheckActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getStealth()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_stealthCheckActionPerformed

        private void intelligenceCheckActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_intelligenceCheckActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getIntlMod()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_intelligenceCheckActionPerformed

        private void arcanaCheckActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_arcanaCheckActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getArcana()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_arcanaCheckActionPerformed

        private void historyCheckActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_historyCheckActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getHistory()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_historyCheckActionPerformed

        private void investigationCheckActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_investigationCheckActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton,
                                abilityCheck(p.getInvestigation()), "Roll result",
                                JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_investigationCheckActionPerformed

        private void natureCheckActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_natureCheckActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getNature()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_natureCheckActionPerformed

        private void religionCheckActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_religionCheckActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getReligion()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_religionCheckActionPerformed

        private void wisdomCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_wisdomCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getWisMod()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_wisdomCheckButtonActionPerformed

        private void animalHandlingCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_animalHandlingCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton,
                                abilityCheck(p.getAnimalHandling()), "Roll result",
                                JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_animalHandlingCheckButtonActionPerformed

        private void insightCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_insightCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getInsight()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_insightCheckButtonActionPerformed

        private void medicineCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_medicineCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getMedicine()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_medicineCheckButtonActionPerformed

        private void perceptionCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_perceptionCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getPerception()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_perceptionCheckButtonActionPerformed

        private void survivalCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_survivalCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getSurvival()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_survivalCheckButtonActionPerformed

        private void charismaCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_charismaCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getChaMod()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_charismaCheckButtonActionPerformed

        private void deceptionCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deceptionCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getDeception()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_deceptionCheckButtonActionPerformed

        private void intimidationCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_intimidationCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton,
                                abilityCheck(p.getIntimidation()), "Roll result",
                                JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_intimidationCheckButtonActionPerformed

        private void performanceCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_performanceCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getPerformance()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_performanceCheckButtonActionPerformed

        private void persuasionCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_persuasionCheckButtonActionPerformed
                JOptionPane.showMessageDialog(strengthCheckButton, abilityCheck(p.getPersuasion()),
                                "Roll result", JOptionPane.PLAIN_MESSAGE);
        }// GEN-LAST:event_persuasionCheckButtonActionPerformed

        private void weaponProficiencyUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_weaponProficiencyUpdateButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new proficiency value\nCurrent value is "
                                                + p.getProf(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setProf(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_weaponProficiencyUpdateButtonActionPerformed

        private void weaponStrengthUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_weaponStrengthUpdateButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new strength value\nCurrent value is " + p.getStr(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setStr(newVal);
                        p.setStrMod(c.getModifier(newVal));
                        p.setStrSave(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_weaponStrengthUpdateButtonActionPerformed

        private void weaponResourceUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_weaponResourceUpdateButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new weapon resource value\nCurrent value is "
                                                + p.getStr(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setWeaponResource(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_weaponResourceUpdateButtonActionPerformed

        private void weaponsUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_weaponsUpdateButtonActionPerformed
                JOptionPane.showMessageDialog(updateStrengthButton,
                                "This feature is not yet implimented"); // TODO
        }// GEN-LAST:event_weaponsUpdateButtonActionPerformed

        private void exampleWeaponRollHitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exampleWeaponRollHitActionPerformed
                JOptionPane.showMessageDialog(updateStrengthButton,
                                "This feature is not yet implimented"); // TODO
        }// GEN-LAST:event_exampleWeaponRollHitActionPerformed

        private void exampleWeaponRollDamageActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exampleWeaponRollDamageActionPerformed
                JOptionPane.showMessageDialog(updateStrengthButton,
                                "This feature is not yet implimented"); // TODO
        }// GEN-LAST:event_exampleWeaponRollDamageActionPerformed

        private void spellsCLevelUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_spellsCLevelUpdateButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new C Level value\nCurrent value is " + p.getcLevel(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setcLevel(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_spellsCLevelUpdateButtonActionPerformed

        private void spellsAttackValueUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_spellsAttackValueUpdateButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new spell attack value\nCurrent value is "
                                                + p.getSpellAttack(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setSpellAttack(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_spellsAttackValueUpdateButtonActionPerformed

        private void spellsDCUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_spellsDCUpdateButtonActionPerformed
                // Set flag in case the user can't enter a number
                boolean fail = false;

                // Show input dialog
                String newVal_S = JOptionPane.showInputDialog(updateStrengthButton,
                                "Please enter new spell DC value\nCurrent value is "
                                                + p.getSpellDC(),
                                "Enter new value", JOptionPane.QUESTION_MESSAGE);

                // Create int to parse string to
                int newVal = 0;
                try {
                        // Try to parse string
                        newVal = Integer.parseInt(newVal_S);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton, "Please enter a number",
                                        "Input error", JOptionPane.ERROR_MESSAGE);
                        fail = true;
                }
                // If it didn't mess up, then set the stat, mod, and save, then update form and
                // update the sheet
                if (!fail) {
                        p.setSpellDC(newVal);
                        try {
                                setComponentValues(p);
                                c.SaveSheet(p);
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }
        }// GEN-LAST:event_spellsDCUpdateButtonActionPerformed

        private void spellsUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_spellsUpdateButtonActionPerformed
                JOptionPane.showMessageDialog(updateStrengthButton,
                                "This feature is not yet implimented"); // TODO
        }// GEN-LAST:event_spellsUpdateButtonActionPerformed

        private void exampleSpellRollButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exampleSpellRollButtonActionPerformed
                JOptionPane.showMessageDialog(updateStrengthButton,
                                "This feature is not yet implimented"); // TODO
        }// GEN-LAST:event_exampleSpellRollButtonActionPerformed

        private void cantripsUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cantripsUpdateButtonActionPerformed
                JOptionPane.showMessageDialog(updateStrengthButton,
                                "This feature is not yet implimented"); // TODO
        }// GEN-LAST:event_cantripsUpdateButtonActionPerformed

        private void exampleSpellRollButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exampleSpellRollButton1ActionPerformed
                JOptionPane.showMessageDialog(updateStrengthButton,
                                "This feature is not yet implimented"); // TODO
        }// GEN-LAST:event_exampleSpellRollButton1ActionPerformed

        private void Lvl1UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_Lvl1UpdateButtonActionPerformed
                JOptionPane.showMessageDialog(updateStrengthButton,
                                "This feature is not yet implimented"); // TODO
        }// GEN-LAST:event_Lvl1UpdateButtonActionPerformed

        private void infoCharacterClassTextBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_infoCharacterClassTextBox1ActionPerformed
                String[] s = infoCharacterClassTextBox.getText().split(" ");
                String[] bkp = {p.getChrSubclass(), p.getChrClass()};
                try {
                        p.setChrSubclass(s[0]);
                        p.setChrClass(s[1]);
                        JOptionPane.showMessageDialog(updateStrengthButton, "Class set");
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(updateStrengthButton,
                                        "Error, class should be set as \"[subClass] [class]\"\nNo changed made",
                                        "Error setting value", JOptionPane.ERROR_MESSAGE);
                        p.setChrSubclass(bkp[0]);
                        p.setChrClass(bkp[1]);
                }
                try {
                        setComponentValues(p);
                        c.SaveSheet(p);
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
        }// GEN-LAST:event_infoCharacterClassTextBox1ActionPerformed

        private void infoCharacterClassTextBox3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_infoCharacterClassTextBox3ActionPerformed
                p.setRace(infoCharacterRaceTextBox.getText());
                JOptionPane.showMessageDialog(updateStrengthButton, "Race set");
                try {
                        setComponentValues(p);
                        c.SaveSheet(p);
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
        }// GEN-LAST:event_infoCharacterClassTextBox3ActionPerformed

        private void infoCharacterClassTextBox4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_infoCharacterClassTextBox4ActionPerformed
                p.setBackground(infoCharacterBackgroundTextBox.getText());
                JOptionPane.showMessageDialog(updateStrengthButton, "Background set");
                try {
                        setComponentValues(p);
                        c.SaveSheet(p);
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
        }// GEN-LAST:event_infoCharacterClassTextBox4ActionPerformed

        private void infoCharacterClassTextBox5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_infoCharacterClassTextBox5ActionPerformed
                p.setAlignment(infoCharacterAlignmentTextBox.getText());
                JOptionPane.showMessageDialog(updateStrengthButton, "Alignment set");
                try {
                        setComponentValues(p);
                        c.SaveSheet(p);
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
        }// GEN-LAST:event_infoCharacterClassTextBox5ActionPerformed

        private void infoCharacterClassTextBox6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_infoCharacterClassTextBox6ActionPerformed
                p.setXp(Integer.parseInt(infoCharacterXPTextBox.getText()));
                JOptionPane.showMessageDialog(updateStrengthButton, "Experience set");
                try {
                        setComponentValues(p);
                        c.SaveSheet(p);
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
        }// GEN-LAST:event_infoCharacterClassTextBox6ActionPerformed

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
                JOptionPane.showMessageDialog(updateStrengthButton,
                                "This feature is not yet implimented"); // TODO
        }// GEN-LAST:event_jButton1ActionPerformed

        public ArrayList<JPanel> buildWeaponList() {
                ArrayList<JPanel> weaponPanelList = new ArrayList<>();
                for (Weapon w : p.getWeaponsList()) {
                        // System.out.println("WeaponName = " + w.getName());
                        JPanel wpnPanel = new JPanel();
                        JLabel wpnName = new JLabel();
                        JLabel wpnRange = new JLabel();
                        JLabel wpnProficiency = new JLabel();
                        JLabel wpnDamageType = new JLabel();
                        JLabel wpnDamageRoll = new JLabel();
                        JButton wpnRollHit = new JButton();
                        JButton wpnRollDamage = new JButton();

                        wpnPanel.setBorder(javax.swing.BorderFactory
                                        .createLineBorder(new java.awt.Color(0, 0, 0)));

                        wpnName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                        wpnName.setText(w.getName());

                        wpnRange.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                        wpnRange.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                        wpnRange.setText(w.getRange() + "ft");
                        wpnRange.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                        wpnProficiency.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                        wpnProficiency.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                        wpnProficiency.setText("+99");
                        wpnProficiency.setVerticalAlignment(javax.swing.SwingConstants.TOP);

                        wpnDamageType.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                        wpnDamageType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                        wpnDamageType.setText(w.getDamageType());
                        wpnDamageType.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                        wpnDamageRoll.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                        wpnDamageRoll.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                        wpnDamageRoll.setText(w.getDmgDR());
                        wpnDamageRoll.setVerticalAlignment(javax.swing.SwingConstants.TOP);

                        wpnRollHit.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                        wpnRollHit.setText("HIT\n");
                        wpnRollHit.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        Dice d = new Dice(20); //TODO: Need to find a way of keeping a copy of the weapon object
                                        JOptionPane.showMessageDialog(strengthCheckButton,
                                                        "Rolled: " + d.roll(), "Rolling to hit",
                                                        JOptionPane.OK_OPTION);
                                }
                        });

                        wpnRollDamage.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                        wpnRollDamage.setText("DMG");
                        wpnRollDamage.addActionListener(new java.awt.event.ActionListener() {
                                public void actionPerformed(java.awt.event.ActionEvent evt) {
                                        Dice d = new Dice(20); //TODO: Need to find a way of keeping a copy of the weapon object
                                        JOptionPane.showMessageDialog(strengthCheckButton,
                                                        "Rolled: " + d.roll(), "Rolling to hit",
                                                        JOptionPane.OK_OPTION);
                                }
                        });

                        javax.swing.GroupLayout wpnPanelLayout =
                                        new javax.swing.GroupLayout(wpnPanel);
                        wpnPanel.setLayout(wpnPanelLayout);
                        wpnPanelLayout.setHorizontalGroup(wpnPanelLayout
                                        .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(wpnPanelLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(wpnName,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        260,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(wpnPanelLayout
                                                                        .createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        false)
                                                                        .addComponent(wpnProficiency,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                        .addComponent(wpnRange,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE))
                                                        .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(wpnPanelLayout
                                                                        .createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(wpnDamageType,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        162,
                                                                                        Short.MAX_VALUE)
                                                                        .addComponent(wpnDamageRoll,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE))
                                                        .addGap(53, 53, 53)
                                                        .addComponent(wpnRollHit,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        78,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(9, 9, 9).addComponent(wpnRollDamage)
                                                        .addContainerGap()));
                        wpnPanelLayout.setVerticalGroup(wpnPanelLayout
                                        .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                        wpnPanelLayout.createSequentialGroup()
                                                                        .addContainerGap()
                                                                        .addGroup(wpnPanelLayout
                                                                                        .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(wpnRollDamage,
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)

                                                                                        .addComponent(wpnRollHit,
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING))
                                                                        .addContainerGap())
                                        .addGroup(wpnPanelLayout.createSequentialGroup()
                                                        .addGap(4, 4, 4)
                                                        .addGroup(wpnPanelLayout
                                                                        .createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(wpnName,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                        .addGroup(wpnPanelLayout
                                                                                        .createSequentialGroup()
                                                                                        .addGroup(wpnPanelLayout
                                                                                                        .createParallelGroup(
                                                                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                        .addComponent(wpnRange,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        29,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(wpnDamageType,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        29,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addPreferredGap(
                                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addGroup(wpnPanelLayout
                                                                                                        .createParallelGroup(
                                                                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                        .addComponent(wpnProficiency,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        20,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addComponent(wpnDamageRoll,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                        20,
                                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGap(6, 12, Short.MAX_VALUE)))));
                        weaponPanelList.add(wpnPanel);
                }
                return weaponPanelList;
        }


        /**
         * This method is called from within the constructor to initialize the form. WARNING: Do NOT
         * modify this code. The content of this method is always regenerated by the Form Editor.
         */
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                CSMainPanel = new javax.swing.JPanel();
                headerLabel = new javax.swing.JLabel();
                subheadingLabel = new javax.swing.JLabel();
                SheetTabs = new javax.swing.JTabbedPane();
                StatsPanel = new javax.swing.JPanel();
                statsCharacterName = new javax.swing.JLabel();
                statsCharacterClass = new javax.swing.JLabel();
                statsCharacterLevel = new javax.swing.JLabel();
                levellabelLabel = new javax.swing.JLabel();
                characterStatsPanel = new javax.swing.JPanel();
                strengthPanel = new javax.swing.JPanel();
                strengthLabel = new javax.swing.JLabel();
                strengthSavePanel = new javax.swing.JPanel();
                strengthSaveLabel = new javax.swing.JLabel();
                strengthSaveValueLabel = new javax.swing.JLabel();
                strengthModifierPanel = new javax.swing.JPanel();
                strengthModifierLabel = new javax.swing.JLabel();
                strengthModifierValueLabel = new javax.swing.JLabel();
                strengthScorePanel = new javax.swing.JPanel();
                strengthScoreLabel = new javax.swing.JLabel();
                strengthScoreValueLabel = new javax.swing.JLabel();
                updateStrengthButton = new javax.swing.JButton();
                charicterAttributesPanel = new javax.swing.JPanel();
                ProficiencyPanel = new javax.swing.JPanel();
                proficiencyLabel = new javax.swing.JLabel();
                proficiencyValueLabel = new javax.swing.JLabel();
                proficiencyUpdateButton = new javax.swing.JButton();
                HitDicePanel = new javax.swing.JPanel();
                HitDiceLabel = new javax.swing.JLabel();
                HitDiceValueLabel = new javax.swing.JLabel();
                HitDiceUpdateButton = new javax.swing.JButton();
                SpeedPanel = new javax.swing.JPanel();
                SpeedLabel = new javax.swing.JLabel();
                SpeedValueLabel = new javax.swing.JLabel();
                SpeedUpdateButton = new javax.swing.JButton();
                ACPanel = new javax.swing.JPanel();
                ACLabel = new javax.swing.JLabel();
                ACValueLabel = new javax.swing.JLabel();
                ACUpdateButton = new javax.swing.JButton();
                HPPanel = new javax.swing.JPanel();
                HPLabel = new javax.swing.JLabel();
                HPValueLabel = new javax.swing.JLabel();
                HPUpdateButton = new javax.swing.JButton();
                intelligencePanel = new javax.swing.JPanel();
                strengthLabel2 = new javax.swing.JLabel();
                strengthSavePanel2 = new javax.swing.JPanel();
                strengthSaveLabel2 = new javax.swing.JLabel();
                intelligenceSaveValueLabel = new javax.swing.JLabel();
                strengthModifierPanel1 = new javax.swing.JPanel();
                strengthModifierLabel1 = new javax.swing.JLabel();
                intelligenceModifierValueLabel = new javax.swing.JLabel();
                strengthScorePanel1 = new javax.swing.JPanel();
                strengthScoreLabel1 = new javax.swing.JLabel();
                intelligenceScoreValueLabel = new javax.swing.JLabel();
                updateIntelligenceButton = new javax.swing.JButton();
                dexterityPanel = new javax.swing.JPanel();
                strengthLabel4 = new javax.swing.JLabel();
                strengthSavePanel4 = new javax.swing.JPanel();
                strengthSaveLabel4 = new javax.swing.JLabel();
                dexteritySaveValueLabel = new javax.swing.JLabel();
                strengthModifierPanel3 = new javax.swing.JPanel();
                strengthModifierLabel3 = new javax.swing.JLabel();
                dexterityModifierValueLabel = new javax.swing.JLabel();
                strengthScorePanel3 = new javax.swing.JPanel();
                strengthScoreLabel3 = new javax.swing.JLabel();
                dexterityScoreValueLabel = new javax.swing.JLabel();
                updateDexterityButton = new javax.swing.JButton();
                wisdomPanel = new javax.swing.JPanel();
                strengthLabel3 = new javax.swing.JLabel();
                strengthSavePanel3 = new javax.swing.JPanel();
                strengthSaveLabel3 = new javax.swing.JLabel();
                wisdomSaveValueLabel = new javax.swing.JLabel();
                strengthModifierPanel2 = new javax.swing.JPanel();
                strengthModifierLabel2 = new javax.swing.JLabel();
                wisdomModifierValueLabel = new javax.swing.JLabel();
                strengthScorePanel2 = new javax.swing.JPanel();
                strengthScoreLabel2 = new javax.swing.JLabel();
                wisdomScoreValueLabel = new javax.swing.JLabel();
                updateWisdomButton = new javax.swing.JButton();
                constitutionPanel = new javax.swing.JPanel();
                strengthLabel6 = new javax.swing.JLabel();
                strengthSavePanel6 = new javax.swing.JPanel();
                strengthSaveLabel6 = new javax.swing.JLabel();
                constitutionSaveValueLabel = new javax.swing.JLabel();
                strengthModifierPanel5 = new javax.swing.JPanel();
                strengthModifierLabel5 = new javax.swing.JLabel();
                constitutionModifierValueLabel = new javax.swing.JLabel();
                strengthScorePanel5 = new javax.swing.JPanel();
                strengthScoreLabel5 = new javax.swing.JLabel();
                constitutionScoreValueLabel = new javax.swing.JLabel();
                updateConstitutionButton = new javax.swing.JButton();
                charismaPanel = new javax.swing.JPanel();
                strengthLabel5 = new javax.swing.JLabel();
                strengthSavePanel5 = new javax.swing.JPanel();
                strengthSaveLabel5 = new javax.swing.JLabel();
                charismaSaveValueLabel = new javax.swing.JLabel();
                strengthModifierPanel4 = new javax.swing.JPanel();
                strengthModifierLabel4 = new javax.swing.JLabel();
                charismaModifierValueLabel = new javax.swing.JLabel();
                strengthScorePanel4 = new javax.swing.JPanel();
                strengthScoreLabel4 = new javax.swing.JLabel();
                charismaScoreValueLabel = new javax.swing.JLabel();
                updateCharismaButton = new javax.swing.JButton();
                abilitiesPanel = new javax.swing.JPanel();
                abilitiesCharacterName = new javax.swing.JLabel();
                abilitiesCharacterClass = new javax.swing.JLabel();
                abilitiesCharacterLevel = new javax.swing.JLabel();
                levellabelLabel2 = new javax.swing.JLabel();
                abilitiesSection = new javax.swing.JPanel();
                abilitiesStrengthSectionPanel = new javax.swing.JPanel();
                abilitiesStrengthPanel = new javax.swing.JPanel();
                charStrengthValueLabel = new javax.swing.JLabel();
                charStrengthLabel = new javax.swing.JLabel();
                strengthCheckButton = new javax.swing.JButton();
                abilitiesAthleticsPanel = new javax.swing.JPanel();
                charAthleticsValueLabel = new javax.swing.JLabel();
                charAthleticsLabel = new javax.swing.JLabel();
                athleticsCheckButton = new javax.swing.JButton();
                abilitiesDexteritySectionPanel = new javax.swing.JPanel();
                abilitiesDexterityPanel = new javax.swing.JPanel();
                charDexterityValueLabel = new javax.swing.JLabel();
                charDexterityLabel = new javax.swing.JLabel();
                dexterityCheckButton = new javax.swing.JButton();
                abilitiesAcrobaticsPanel = new javax.swing.JPanel();
                charAcrobaticsValueLabel = new javax.swing.JLabel();
                charAcrobaticsLabel = new javax.swing.JLabel();
                acrobaticsCheckButton = new javax.swing.JButton();
                abilitiesSoHPanel = new javax.swing.JPanel();
                charSoHValueLabel = new javax.swing.JLabel();
                charSoHLabel = new javax.swing.JLabel();
                SoHCheckButton = new javax.swing.JButton();
                abilitiesStealthPanel = new javax.swing.JPanel();
                charStealthValueLabel = new javax.swing.JLabel();
                charStealthLabel = new javax.swing.JLabel();
                stealthCheck = new javax.swing.JButton();
                abilitiesIntelligenceSectionPanel = new javax.swing.JPanel();
                abilitiesIntelligencePanel = new javax.swing.JPanel();
                charIntelligenceValueLabel = new javax.swing.JLabel();
                charIntelligenceLabel = new javax.swing.JLabel();
                intelligenceCheck = new javax.swing.JButton();
                abilitiesArcanaPanel = new javax.swing.JPanel();
                charArcanaValueLabel = new javax.swing.JLabel();
                charArcanaLabel = new javax.swing.JLabel();
                arcanaCheck = new javax.swing.JButton();
                abilitiesHistoryPanel = new javax.swing.JPanel();
                charHistoryValueLabel = new javax.swing.JLabel();
                charHistoryLabel = new javax.swing.JLabel();
                historyCheck = new javax.swing.JButton();
                abilitiesInvestigationPanel = new javax.swing.JPanel();
                charInvestigationValueLabel = new javax.swing.JLabel();
                charInvestigationLabel = new javax.swing.JLabel();
                investigationCheck = new javax.swing.JButton();
                abilitiesNaturePanel = new javax.swing.JPanel();
                charNatureValueLabel = new javax.swing.JLabel();
                charNatureLabel = new javax.swing.JLabel();
                natureCheck = new javax.swing.JButton();
                abilitesReligionPanel = new javax.swing.JPanel();
                charReligionValueLabel = new javax.swing.JLabel();
                charReligionLabel = new javax.swing.JLabel();
                religionCheck = new javax.swing.JButton();
                abilitiesWisdomSectionPanel = new javax.swing.JPanel();
                abilitiesWisdomPanel = new javax.swing.JPanel();
                charWisdomValueLabel = new javax.swing.JLabel();
                charWisdomLabel = new javax.swing.JLabel();
                wisdomCheckButton = new javax.swing.JButton();
                abilitiesAnimalHandlingPanel = new javax.swing.JPanel();
                charAnimalHandlingValueLabel = new javax.swing.JLabel();
                charAnimalHandlingLabel = new javax.swing.JLabel();
                animalHandlingCheckButton = new javax.swing.JButton();
                abilitiesInsightPanel = new javax.swing.JPanel();
                charInsightValueLabel = new javax.swing.JLabel();
                charInsightLabel = new javax.swing.JLabel();
                insightCheckButton = new javax.swing.JButton();
                abilitiesMedicinePanel = new javax.swing.JPanel();
                charMedicineValueLabel = new javax.swing.JLabel();
                charMedicineLabel = new javax.swing.JLabel();
                medicineCheckButton = new javax.swing.JButton();
                abilitiesPerceptionPanel = new javax.swing.JPanel();
                charPerceptionValueLabel = new javax.swing.JLabel();
                charPerceptionLabel = new javax.swing.JLabel();
                perceptionCheckButton = new javax.swing.JButton();
                abilitiesSurvivalPanel = new javax.swing.JPanel();
                charSurvivalValueLabel = new javax.swing.JLabel();
                charSurvivalLabel = new javax.swing.JLabel();
                survivalCheckButton = new javax.swing.JButton();
                abilitiesCharismaSectionPanel = new javax.swing.JPanel();
                abilitiesCharismaPanel = new javax.swing.JPanel();
                charCharismaValueLabel = new javax.swing.JLabel();
                charCharismaLabel = new javax.swing.JLabel();
                charismaCheckButton = new javax.swing.JButton();
                abilitiesDeceptionPanel = new javax.swing.JPanel();
                charDeceptionValueLabel = new javax.swing.JLabel();
                charDeceptionLabel = new javax.swing.JLabel();
                deceptionCheckButton = new javax.swing.JButton();
                abilitiesIntimidationPanel = new javax.swing.JPanel();
                charIntimidationValueLabel = new javax.swing.JLabel();
                charIntimidationLabel = new javax.swing.JLabel();
                intimidationCheckButton = new javax.swing.JButton();
                abilitiesPerformancePanel = new javax.swing.JPanel();
                charPerformanceValueLabel = new javax.swing.JLabel();
                charPerformanceLabel = new javax.swing.JLabel();
                performanceCheckButton = new javax.swing.JButton();
                abilitiesPersuasion = new javax.swing.JPanel();
                charPersuasionValueLabel = new javax.swing.JLabel();
                charPersuasionLabel = new javax.swing.JLabel();
                persuasionCheckButton = new javax.swing.JButton();
                weaponsPanel = new javax.swing.JPanel();
                weaponsCharacterName = new javax.swing.JLabel();
                weaponsCharacterClass = new javax.swing.JLabel();
                weaponsCharacterLevel = new javax.swing.JLabel();
                levellabelLabel3 = new javax.swing.JLabel();
                characterWeaponsPanel = new javax.swing.JPanel();
                weaponsHeaderPanel = new javax.swing.JPanel();
                weaponProficiencyPanel = new javax.swing.JPanel();
                weaponProficienctLabel = new javax.swing.JLabel();
                weaponProficiencyValueLabel = new javax.swing.JLabel();
                weaponProficiencyUpdateButton = new javax.swing.JButton();
                weaponStrengthPanel = new javax.swing.JPanel();
                weaponStrengthLabel = new javax.swing.JLabel();
                weaponStrengthValueLable = new javax.swing.JLabel();
                weaponStrengthUpdateButton = new javax.swing.JButton();
                weaponResourcePanel = new javax.swing.JPanel();
                weaponResourceLabel = new javax.swing.JLabel();
                weaponResourceValueLabel = new javax.swing.JLabel();
                weaponResourceUpdateButton = new javax.swing.JButton();
                weaponsUpdateButton = new javax.swing.JButton();
                weaponsListScrollPane = new javax.swing.JScrollPane();
                weaponsListPanel = new javax.swing.JPanel();
                exampleWeaponPanel = new javax.swing.JPanel();
                exampleWeaponName = new javax.swing.JLabel();
                exampleWeaponRange = new javax.swing.JLabel();
                exampleWeaponProficiency = new javax.swing.JLabel();
                exampleWeaponDamageType = new javax.swing.JLabel();
                exampleWeaponDamageRoll = new javax.swing.JLabel();
                exampleWeaponRollHit = new javax.swing.JButton();
                exampleWeaponRollDamage = new javax.swing.JButton();
                spellsPanel = new javax.swing.JPanel();
                spellsCharacterName = new javax.swing.JLabel();
                spellsCharacterClass = new javax.swing.JLabel();
                spellsCharacterLevel = new javax.swing.JLabel();
                levellabelLabel4 = new javax.swing.JLabel();
                characterSpellsPanel = new javax.swing.JPanel();
                spellsHeaderPanel = new javax.swing.JPanel();
                spellsCLevelPanle = new javax.swing.JPanel();
                spellsCLevelLabel = new javax.swing.JLabel();
                spellsCLevelValueLabel = new javax.swing.JLabel();
                spellsCLevelUpdateButton = new javax.swing.JButton();
                spellsAttackPanel = new javax.swing.JPanel();
                spellsAttackLabel = new javax.swing.JLabel();
                spellsAttackValueLabel = new javax.swing.JLabel();
                spellsAttackValueUpdateButton = new javax.swing.JButton();
                spellsDCPanel = new javax.swing.JPanel();
                spellsDCLabel = new javax.swing.JLabel();
                spellsDCValueLabel = new javax.swing.JLabel();
                spellsDCUpdateButton = new javax.swing.JButton();
                spellsUpdateButton = new javax.swing.JButton();
                SpellsListScrollPane1 = new javax.swing.JScrollPane();
                spellsListPanel = new javax.swing.JPanel();
                cantripsKnownSpellsPanel = new javax.swing.JPanel();
                exampleCantripsSpellPanel = new javax.swing.JPanel();
                exampleSpellName1 = new javax.swing.JLabel();
                exampleSpellHitLabel = new javax.swing.JLabel();
                exampleSpellRollButton = new javax.swing.JButton();
                cantripsHeaderPanel = new javax.swing.JPanel();
                cantripsHeaderLabel = new javax.swing.JLabel();
                cantripsSpellSlotAvailableLabel = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                cantripsSpellMaxLabel = new javax.swing.JLabel();
                cantripsUpdateButton = new javax.swing.JButton();
                levelOneKnownSpellsPanel = new javax.swing.JPanel();
                exampleCantripsSpellPanel1 = new javax.swing.JPanel();
                exampleSpellName2 = new javax.swing.JLabel();
                exampleSpellHitLabel1 = new javax.swing.JLabel();
                exampleSpellRollButton1 = new javax.swing.JButton();
                Lvl1HeaderPanel = new javax.swing.JPanel();
                Lvl1HeaderLabel = new javax.swing.JLabel();
                Lvl1SpellSlotAvailableLabel = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                Lvl1SpellMaxLabel = new javax.swing.JLabel();
                Lvl1UpdateButton = new javax.swing.JButton();
                informationPanel = new javax.swing.JPanel();
                informationCharacterName = new javax.swing.JLabel();
                informationCharacterClass = new javax.swing.JLabel();
                informationCharacterLevel = new javax.swing.JLabel();
                levellabelLabel5 = new javax.swing.JLabel();
                characterInformationPanel = new javax.swing.JPanel();
                infoHeaderPanel = new javax.swing.JPanel();
                infoCharacterClassPanel1 = new javax.swing.JPanel();
                infoCharacterClassLabel1 = new javax.swing.JLabel();
                infoCharacterClassTextBox = new javax.swing.JTextField();
                infoCharacterClassPanel3 = new javax.swing.JPanel();
                infoCharacterClassLabel3 = new javax.swing.JLabel();
                infoCharacterRaceTextBox = new javax.swing.JTextField();
                infoCharacterClassPanel4 = new javax.swing.JPanel();
                infoCharacterClassLabel4 = new javax.swing.JLabel();
                infoCharacterBackgroundTextBox = new javax.swing.JTextField();
                infoCharacterClassPanel5 = new javax.swing.JPanel();
                infoCharacterClassLabel5 = new javax.swing.JLabel();
                infoCharacterAlignmentTextBox = new javax.swing.JTextField();
                infoCharacterClassPanel6 = new javax.swing.JPanel();
                infoCharacterClassLabel6 = new javax.swing.JLabel();
                infoCharacterXPTextBox = new javax.swing.JTextField();
                jPanel2 = new javax.swing.JPanel();
                jPanel3 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                infoPPValueLabel = new javax.swing.JLabel();
                jPanel4 = new javax.swing.JPanel();
                jLabel5 = new javax.swing.JLabel();
                infoGPValueLabel = new javax.swing.JLabel();
                jPanel5 = new javax.swing.JPanel();
                jLabel7 = new javax.swing.JLabel();
                infoSPValueLabel = new javax.swing.JLabel();
                jPanel6 = new javax.swing.JPanel();
                jLabel9 = new javax.swing.JLabel();
                infoCPValueLabel = new javax.swing.JLabel();
                jPanel7 = new javax.swing.JPanel();
                jLabel11 = new javax.swing.JLabel();
                infoEPValueLabel = new javax.swing.JLabel();
                jButton1 = new javax.swing.JButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                infoNotes = new javax.swing.JTextArea();
                statsScrollPane = new javax.swing.JScrollPane();
                abilitiesScrollPane = new javax.swing.JScrollPane();
                weaponsScrollPane = new javax.swing.JScrollPane();
                spellsScrollPane = new javax.swing.JScrollPane();
                infoScrollPane = new javax.swing.JScrollPane();

                infoNotes.addKeyListener(new KeyListener() {
                        @Override
                        public void keyPressed(KeyEvent e) {

                                p.setNotes(infoNotes.getText());
                                c.SaveSheet(p);
                        }

                        @Override
                        public void keyTyped(KeyEvent e) {
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                        }
                });

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("dndCS - Character Sheet - " + p.getName());

                headerLabel.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
                headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                headerLabel.setText("DnD Character Sheet");
                headerLabel.setToolTipText("");
                headerLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                subheadingLabel.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
                subheadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                subheadingLabel.setText("But you don't have to pay for it  ");

                SheetTabs.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

                statsCharacterName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                statsCharacterName.setText("CharacterName");

                statsCharacterClass.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                statsCharacterClass.setText("CharacterClass");

                statsCharacterLevel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                statsCharacterLevel.setText("999");

                levellabelLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                levellabelLabel.setText("Level: ");

                strengthPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                strengthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthLabel.setText("Strength");

                strengthSavePanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthSaveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthSaveLabel.setText("Save");

                strengthSaveValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                strengthSaveValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthSaveValueLabel.setText("999");

                javax.swing.GroupLayout strengthSavePanelLayout =
                                new javax.swing.GroupLayout(strengthSavePanel);
                strengthSavePanel.setLayout(strengthSavePanelLayout);
                strengthSavePanelLayout.setHorizontalGroup(strengthSavePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthSavePanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthSavePanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(strengthSaveValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthSaveLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthSavePanelLayout.setVerticalGroup(strengthSavePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthSavePanelLayout.createSequentialGroup()
                                                .addContainerGap().addComponent(strengthSaveLabel)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(strengthSaveValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                strengthModifierPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthModifierLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthModifierLabel.setText("Modifer");

                strengthModifierValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                strengthModifierValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthModifierValueLabel.setText("999");

                javax.swing.GroupLayout strengthModifierPanelLayout =
                                new javax.swing.GroupLayout(strengthModifierPanel);
                strengthModifierPanel.setLayout(strengthModifierPanelLayout);
                strengthModifierPanelLayout.setHorizontalGroup(strengthModifierPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthModifierPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthModifierPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(strengthModifierValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                74,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthModifierLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthModifierPanelLayout.setVerticalGroup(strengthModifierPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthModifierPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(strengthModifierLabel)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(strengthModifierValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                strengthScorePanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthScoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthScoreLabel.setText("Score");

                strengthScoreValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                strengthScoreValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthScoreValueLabel.setText("999");

                javax.swing.GroupLayout strengthScorePanelLayout =
                                new javax.swing.GroupLayout(strengthScorePanel);
                strengthScorePanel.setLayout(strengthScorePanelLayout);
                strengthScorePanelLayout.setHorizontalGroup(strengthScorePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthScorePanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthScorePanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(strengthScoreValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                74,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthScoreLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthScorePanelLayout.setVerticalGroup(strengthScorePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthScorePanelLayout.createSequentialGroup()
                                                .addContainerGap().addComponent(strengthScoreLabel)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(strengthScoreValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                updateStrengthButton.setText("Update");
                updateStrengthButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updateStrengthButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout strengthPanelLayout =
                                new javax.swing.GroupLayout(strengthPanel);
                strengthPanel.setLayout(strengthPanelLayout);
                strengthPanelLayout.setHorizontalGroup(strengthPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(strengthPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(strengthPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(strengthScorePanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(strengthModifierPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(strengthLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                174,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(strengthPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                                .addComponent(updateStrengthButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                100,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(strengthSavePanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGap(0, 10, Short.MAX_VALUE)));
                strengthPanelLayout.setVerticalGroup(strengthPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthPanelLayout.createSequentialGroup()
                                                .addContainerGap(
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addGroup(strengthPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(strengthLabel)
                                                                .addComponent(updateStrengthButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                24,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(strengthPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(strengthSavePanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(strengthModifierPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(strengthScorePanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)));

                ProficiencyPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                proficiencyLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                proficiencyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                proficiencyLabel.setText("Proficiency");

                proficiencyValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                proficiencyValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                proficiencyValueLabel.setText("999");

                proficiencyUpdateButton.setText("Update");
                proficiencyUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                proficiencyUpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout ProficiencyPanelLayout =
                                new javax.swing.GroupLayout(ProficiencyPanel);
                ProficiencyPanel.setLayout(ProficiencyPanelLayout);
                ProficiencyPanelLayout.setHorizontalGroup(ProficiencyPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ProficiencyPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(ProficiencyPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(proficiencyLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                70, Short.MAX_VALUE)
                                                                .addGroup(ProficiencyPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(ProficiencyPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(proficiencyValueLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                69,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(proficiencyUpdateButton))
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap()));
                ProficiencyPanelLayout.setVerticalGroup(ProficiencyPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ProficiencyPanelLayout.createSequentialGroup()
                                                .addComponent(proficiencyLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                26,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(proficiencyValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(proficiencyUpdateButton)
                                                .addContainerGap()));

                HitDicePanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                HitDiceLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                HitDiceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                HitDiceLabel.setText("Hit Dice");

                HitDiceValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                HitDiceValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                HitDiceValueLabel.setText("9d99");

                HitDiceUpdateButton.setText("Update");
                HitDiceUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                HitDiceUpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout HitDicePanelLayout =
                                new javax.swing.GroupLayout(HitDicePanel);
                HitDicePanel.setLayout(HitDicePanelLayout);
                HitDicePanelLayout.setHorizontalGroup(HitDicePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(HitDicePanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(HitDicePanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(HitDiceLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(HitDicePanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(HitDicePanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(HitDiceValueLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                69,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(HitDiceUpdateButton))
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap()));
                HitDicePanelLayout.setVerticalGroup(HitDicePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(HitDicePanelLayout.createSequentialGroup().addComponent(
                                                HitDiceLabel,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(HitDiceValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(HitDiceUpdateButton)
                                                .addContainerGap()));

                SpeedPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                SpeedLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                SpeedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                SpeedLabel.setText("Speed");

                SpeedValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                SpeedValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                SpeedValueLabel.setText("999");

                SpeedUpdateButton.setText("Update");
                SpeedUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                SpeedUpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout SpeedPanelLayout = new javax.swing.GroupLayout(SpeedPanel);
                SpeedPanel.setLayout(SpeedPanelLayout);
                SpeedPanelLayout.setHorizontalGroup(SpeedPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(SpeedPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(SpeedPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(SpeedLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(SpeedPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(SpeedPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(SpeedValueLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                69,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(SpeedUpdateButton))
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap()));
                SpeedPanelLayout.setVerticalGroup(SpeedPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(SpeedPanelLayout.createSequentialGroup().addComponent(
                                                SpeedLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SpeedValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SpeedUpdateButton)
                                                .addContainerGap()));

                ACPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                ACLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                ACLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                ACLabel.setText("AC");

                ACValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                ACValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                ACValueLabel.setText("999");

                ACUpdateButton.setText("Update");
                ACUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ACUpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout ACPanelLayout = new javax.swing.GroupLayout(ACPanel);
                ACPanel.setLayout(ACPanelLayout);
                ACPanelLayout.setHorizontalGroup(ACPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ACPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(ACPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(ACLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(ACPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(ACPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(ACValueLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                69,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(ACUpdateButton))
                                                                                .addGap(0, 1, Short.MAX_VALUE)))
                                                .addContainerGap()));
                ACPanelLayout.setVerticalGroup(ACPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ACPanelLayout.createSequentialGroup().addComponent(
                                                ACLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ACValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ACUpdateButton).addContainerGap()));

                HPPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                HPLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                HPLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                HPLabel.setText("HP");

                HPValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                HPValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                HPValueLabel.setText("999");

                HPUpdateButton.setText("Update");
                HPUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                HPUpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout HPPanelLayout = new javax.swing.GroupLayout(HPPanel);
                HPPanel.setLayout(HPPanelLayout);
                HPPanelLayout.setHorizontalGroup(HPPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(HPPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(HPPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(HPLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(HPPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(HPPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(HPValueLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                69,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(HPUpdateButton))
                                                                                .addGap(0, 1, Short.MAX_VALUE)))
                                                .addContainerGap()));
                HPPanelLayout.setVerticalGroup(HPPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(HPPanelLayout.createSequentialGroup().addComponent(
                                                HPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(HPValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(HPUpdateButton).addContainerGap()));

                javax.swing.GroupLayout charicterAttributesPanelLayout =
                                new javax.swing.GroupLayout(charicterAttributesPanel);
                charicterAttributesPanel.setLayout(charicterAttributesPanelLayout);
                charicterAttributesPanelLayout.setHorizontalGroup(charicterAttributesPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(charicterAttributesPanelLayout.createSequentialGroup()
                                                .addGap(135, 135, 135)
                                                .addComponent(HPPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ACPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(SpeedPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(HitDicePanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ProficiencyPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(134, Short.MAX_VALUE)));
                charicterAttributesPanelLayout.setVerticalGroup(charicterAttributesPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(charicterAttributesPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(charicterAttributesPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(SpeedPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                104,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ACPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                104,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(HPPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                104,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(HitDicePanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                104,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ProficiencyPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                104,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                intelligencePanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                strengthLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthLabel2.setText("Intelligence");

                strengthSavePanel2.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthSaveLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthSaveLabel2.setText("Save");

                intelligenceSaveValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                intelligenceSaveValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                intelligenceSaveValueLabel.setText("999");

                javax.swing.GroupLayout strengthSavePanel2Layout =
                                new javax.swing.GroupLayout(strengthSavePanel2);
                strengthSavePanel2.setLayout(strengthSavePanel2Layout);
                strengthSavePanel2Layout.setHorizontalGroup(strengthSavePanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthSavePanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthSavePanel2Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(intelligenceSaveValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthSaveLabel2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthSavePanel2Layout.setVerticalGroup(strengthSavePanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthSavePanel2Layout.createSequentialGroup()
                                                .addContainerGap().addComponent(strengthSaveLabel2)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(intelligenceSaveValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                strengthModifierPanel1.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthModifierLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthModifierLabel1.setText("Modifer");

                intelligenceModifierValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                intelligenceModifierValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                intelligenceModifierValueLabel.setText("999");

                javax.swing.GroupLayout strengthModifierPanel1Layout =
                                new javax.swing.GroupLayout(strengthModifierPanel1);
                strengthModifierPanel1.setLayout(strengthModifierPanel1Layout);
                strengthModifierPanel1Layout.setHorizontalGroup(strengthModifierPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthModifierPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthModifierPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(intelligenceModifierValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                74,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthModifierLabel1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthModifierPanel1Layout.setVerticalGroup(strengthModifierPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthModifierPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(strengthModifierLabel1)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(intelligenceModifierValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                strengthScorePanel1.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthScoreLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthScoreLabel1.setText("Score");

                intelligenceScoreValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                intelligenceScoreValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                intelligenceScoreValueLabel.setText("999");

                javax.swing.GroupLayout strengthScorePanel1Layout =
                                new javax.swing.GroupLayout(strengthScorePanel1);
                strengthScorePanel1.setLayout(strengthScorePanel1Layout);
                strengthScorePanel1Layout.setHorizontalGroup(strengthScorePanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthScorePanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthScorePanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(intelligenceScoreValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                74,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthScoreLabel1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthScorePanel1Layout.setVerticalGroup(strengthScorePanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthScorePanel1Layout.createSequentialGroup()
                                                .addContainerGap().addComponent(strengthScoreLabel1)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(intelligenceScoreValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                updateIntelligenceButton.setText("Update");
                updateIntelligenceButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updateIntelligenceButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout intelligencePanelLayout =
                                new javax.swing.GroupLayout(intelligencePanel);
                intelligencePanel.setLayout(intelligencePanelLayout);
                intelligencePanelLayout.setHorizontalGroup(intelligencePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(intelligencePanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(intelligencePanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(intelligencePanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(strengthScorePanel1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(strengthModifierPanel1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(strengthLabel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                174,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(intelligencePanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                .addComponent(updateIntelligenceButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                100,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(strengthSavePanel2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGap(0, 10, Short.MAX_VALUE)));
                intelligencePanelLayout.setVerticalGroup(intelligencePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(intelligencePanelLayout.createSequentialGroup()
                                                .addContainerGap(
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addGroup(intelligencePanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(strengthLabel2)
                                                                .addComponent(updateIntelligenceButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                24,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(intelligencePanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(strengthSavePanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(strengthModifierPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(strengthScorePanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)));

                dexterityPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                strengthLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthLabel4.setText("Dexterity");

                strengthSavePanel4.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthSaveLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthSaveLabel4.setText("Save");

                dexteritySaveValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                dexteritySaveValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                dexteritySaveValueLabel.setText("999");

                javax.swing.GroupLayout strengthSavePanel4Layout =
                                new javax.swing.GroupLayout(strengthSavePanel4);
                strengthSavePanel4.setLayout(strengthSavePanel4Layout);
                strengthSavePanel4Layout.setHorizontalGroup(strengthSavePanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthSavePanel4Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthSavePanel4Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(dexteritySaveValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthSaveLabel4,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthSavePanel4Layout.setVerticalGroup(strengthSavePanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthSavePanel4Layout.createSequentialGroup()
                                                .addContainerGap().addComponent(strengthSaveLabel4)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dexteritySaveValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                strengthModifierPanel3.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthModifierLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthModifierLabel3.setText("Modifer");

                dexterityModifierValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                dexterityModifierValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                dexterityModifierValueLabel.setText("999");

                javax.swing.GroupLayout strengthModifierPanel3Layout =
                                new javax.swing.GroupLayout(strengthModifierPanel3);
                strengthModifierPanel3.setLayout(strengthModifierPanel3Layout);
                strengthModifierPanel3Layout.setHorizontalGroup(strengthModifierPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthModifierPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthModifierPanel3Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(dexterityModifierValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                74,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthModifierLabel3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthModifierPanel3Layout.setVerticalGroup(strengthModifierPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthModifierPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(strengthModifierLabel3)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dexterityModifierValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                strengthScorePanel3.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthScoreLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthScoreLabel3.setText("Score");

                dexterityScoreValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                dexterityScoreValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                dexterityScoreValueLabel.setText("999");

                javax.swing.GroupLayout strengthScorePanel3Layout =
                                new javax.swing.GroupLayout(strengthScorePanel3);
                strengthScorePanel3.setLayout(strengthScorePanel3Layout);
                strengthScorePanel3Layout.setHorizontalGroup(strengthScorePanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthScorePanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthScorePanel3Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(dexterityScoreValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                74,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthScoreLabel3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthScorePanel3Layout.setVerticalGroup(strengthScorePanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthScorePanel3Layout.createSequentialGroup()
                                                .addContainerGap().addComponent(strengthScoreLabel3)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dexterityScoreValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                updateDexterityButton.setText("Update");
                updateDexterityButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updateDexterityButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout dexterityPanelLayout =
                                new javax.swing.GroupLayout(dexterityPanel);
                dexterityPanel.setLayout(dexterityPanelLayout);
                dexterityPanelLayout.setHorizontalGroup(dexterityPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(dexterityPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(dexterityPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(dexterityPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(strengthScorePanel3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(strengthModifierPanel3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(strengthLabel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                174,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(dexterityPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                                .addComponent(updateDexterityButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                100,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(strengthSavePanel4,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGap(0, 10, Short.MAX_VALUE)));
                dexterityPanelLayout.setVerticalGroup(dexterityPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(dexterityPanelLayout.createSequentialGroup()
                                                .addContainerGap(
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addGroup(dexterityPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(strengthLabel4)
                                                                .addComponent(updateDexterityButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                24,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(dexterityPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(strengthSavePanel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(strengthModifierPanel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(strengthScorePanel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)));

                wisdomPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                strengthLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthLabel3.setText("Wisdom");

                strengthSavePanel3.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthSaveLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthSaveLabel3.setText("Save");

                wisdomSaveValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                wisdomSaveValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                wisdomSaveValueLabel.setText("999");

                javax.swing.GroupLayout strengthSavePanel3Layout =
                                new javax.swing.GroupLayout(strengthSavePanel3);
                strengthSavePanel3.setLayout(strengthSavePanel3Layout);
                strengthSavePanel3Layout.setHorizontalGroup(strengthSavePanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthSavePanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthSavePanel3Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(wisdomSaveValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthSaveLabel3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthSavePanel3Layout.setVerticalGroup(strengthSavePanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthSavePanel3Layout.createSequentialGroup()
                                                .addContainerGap().addComponent(strengthSaveLabel3)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wisdomSaveValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                strengthModifierPanel2.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthModifierLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthModifierLabel2.setText("Modifer");

                wisdomModifierValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                wisdomModifierValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                wisdomModifierValueLabel.setText("999");

                javax.swing.GroupLayout strengthModifierPanel2Layout =
                                new javax.swing.GroupLayout(strengthModifierPanel2);
                strengthModifierPanel2.setLayout(strengthModifierPanel2Layout);
                strengthModifierPanel2Layout.setHorizontalGroup(strengthModifierPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthModifierPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthModifierPanel2Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(wisdomModifierValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                74,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthModifierLabel2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthModifierPanel2Layout.setVerticalGroup(strengthModifierPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthModifierPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(strengthModifierLabel2)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wisdomModifierValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                strengthScorePanel2.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthScoreLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthScoreLabel2.setText("Score");

                wisdomScoreValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                wisdomScoreValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                wisdomScoreValueLabel.setText("999");

                javax.swing.GroupLayout strengthScorePanel2Layout =
                                new javax.swing.GroupLayout(strengthScorePanel2);
                strengthScorePanel2.setLayout(strengthScorePanel2Layout);
                strengthScorePanel2Layout.setHorizontalGroup(strengthScorePanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthScorePanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthScorePanel2Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(wisdomScoreValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                74,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthScoreLabel2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthScorePanel2Layout.setVerticalGroup(strengthScorePanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthScorePanel2Layout.createSequentialGroup()
                                                .addContainerGap().addComponent(strengthScoreLabel2)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wisdomScoreValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                updateWisdomButton.setText("Update");
                updateWisdomButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updateWisdomButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout wisdomPanelLayout =
                                new javax.swing.GroupLayout(wisdomPanel);
                wisdomPanel.setLayout(wisdomPanelLayout);
                wisdomPanelLayout.setHorizontalGroup(wisdomPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(wisdomPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(wisdomPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(wisdomPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(strengthScorePanel2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(strengthModifierPanel2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(strengthLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                174,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(wisdomPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                                .addComponent(updateWisdomButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                100,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(strengthSavePanel3,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGap(0, 10, Short.MAX_VALUE)));
                wisdomPanelLayout.setVerticalGroup(wisdomPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(wisdomPanelLayout.createSequentialGroup().addContainerGap(
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                                .addGroup(wisdomPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(strengthLabel3)
                                                                .addComponent(updateWisdomButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                24,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(wisdomPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(strengthSavePanel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(strengthModifierPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(strengthScorePanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)));

                constitutionPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                strengthLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthLabel6.setText("Constitution");

                strengthSavePanel6.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthSaveLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthSaveLabel6.setText("Save");

                constitutionSaveValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                constitutionSaveValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                constitutionSaveValueLabel.setText("999");

                javax.swing.GroupLayout strengthSavePanel6Layout =
                                new javax.swing.GroupLayout(strengthSavePanel6);
                strengthSavePanel6.setLayout(strengthSavePanel6Layout);
                strengthSavePanel6Layout.setHorizontalGroup(strengthSavePanel6Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthSavePanel6Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthSavePanel6Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(constitutionSaveValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthSaveLabel6,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthSavePanel6Layout.setVerticalGroup(strengthSavePanel6Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthSavePanel6Layout.createSequentialGroup()
                                                .addContainerGap().addComponent(strengthSaveLabel6)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(constitutionSaveValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                strengthModifierPanel5.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthModifierLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthModifierLabel5.setText("Modifer");

                constitutionModifierValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                constitutionModifierValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                constitutionModifierValueLabel.setText("999");

                javax.swing.GroupLayout strengthModifierPanel5Layout =
                                new javax.swing.GroupLayout(strengthModifierPanel5);
                strengthModifierPanel5.setLayout(strengthModifierPanel5Layout);
                strengthModifierPanel5Layout.setHorizontalGroup(strengthModifierPanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthModifierPanel5Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthModifierPanel5Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(constitutionModifierValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                74,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthModifierLabel5,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthModifierPanel5Layout.setVerticalGroup(strengthModifierPanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthModifierPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(strengthModifierLabel5)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(constitutionModifierValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                strengthScorePanel5.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthScoreLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthScoreLabel5.setText("Score");

                constitutionScoreValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                constitutionScoreValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                constitutionScoreValueLabel.setText("999");

                javax.swing.GroupLayout strengthScorePanel5Layout =
                                new javax.swing.GroupLayout(strengthScorePanel5);
                strengthScorePanel5.setLayout(strengthScorePanel5Layout);
                strengthScorePanel5Layout.setHorizontalGroup(strengthScorePanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthScorePanel5Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthScorePanel5Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(constitutionScoreValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                74,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthScoreLabel5,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthScorePanel5Layout.setVerticalGroup(strengthScorePanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthScorePanel5Layout.createSequentialGroup()
                                                .addContainerGap().addComponent(strengthScoreLabel5)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(constitutionScoreValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                updateConstitutionButton.setText("Update");
                updateConstitutionButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updateConstitutionButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout constitutionPanelLayout =
                                new javax.swing.GroupLayout(constitutionPanel);
                constitutionPanel.setLayout(constitutionPanelLayout);
                constitutionPanelLayout.setHorizontalGroup(constitutionPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(constitutionPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(constitutionPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(constitutionPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(strengthScorePanel5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(strengthModifierPanel5,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(strengthLabel6,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                174,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(constitutionPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                .addComponent(updateConstitutionButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                100,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(strengthSavePanel6,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGap(0, 10, Short.MAX_VALUE)));
                constitutionPanelLayout.setVerticalGroup(constitutionPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(constitutionPanelLayout.createSequentialGroup()
                                                .addContainerGap(
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addGroup(constitutionPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(strengthLabel6)
                                                                .addComponent(updateConstitutionButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                24,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(constitutionPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(strengthSavePanel6,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(strengthModifierPanel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(strengthScorePanel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)));

                charismaPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                strengthLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthLabel5.setText("Charisma");

                strengthSavePanel5.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthSaveLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthSaveLabel5.setText("Save");

                charismaSaveValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                charismaSaveValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charismaSaveValueLabel.setText("999");

                javax.swing.GroupLayout strengthSavePanel5Layout =
                                new javax.swing.GroupLayout(strengthSavePanel5);
                strengthSavePanel5.setLayout(strengthSavePanel5Layout);
                strengthSavePanel5Layout.setHorizontalGroup(strengthSavePanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthSavePanel5Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthSavePanel5Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(charismaSaveValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthSaveLabel5,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthSavePanel5Layout.setVerticalGroup(strengthSavePanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthSavePanel5Layout.createSequentialGroup()
                                                .addContainerGap().addComponent(strengthSaveLabel5)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(charismaSaveValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                strengthModifierPanel4.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthModifierLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthModifierLabel4.setText("Modifer");

                charismaModifierValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                charismaModifierValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charismaModifierValueLabel.setText("999");

                javax.swing.GroupLayout strengthModifierPanel4Layout =
                                new javax.swing.GroupLayout(strengthModifierPanel4);
                strengthModifierPanel4.setLayout(strengthModifierPanel4Layout);
                strengthModifierPanel4Layout.setHorizontalGroup(strengthModifierPanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthModifierPanel4Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthModifierPanel4Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(charismaModifierValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                74,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthModifierLabel4,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthModifierPanel4Layout.setVerticalGroup(strengthModifierPanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthModifierPanel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(strengthModifierLabel4)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(charismaModifierValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                strengthScorePanel4.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                strengthScoreLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                strengthScoreLabel4.setText("Score");

                charismaScoreValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                charismaScoreValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charismaScoreValueLabel.setText("999");

                javax.swing.GroupLayout strengthScorePanel4Layout =
                                new javax.swing.GroupLayout(strengthScorePanel4);
                strengthScorePanel4.setLayout(strengthScorePanel4Layout);
                strengthScorePanel4Layout.setHorizontalGroup(strengthScorePanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                strengthScorePanel4Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(strengthScorePanel4Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(charismaScoreValueLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                74,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(strengthScoreLabel4,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap()));
                strengthScorePanel4Layout.setVerticalGroup(strengthScorePanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(strengthScorePanel4Layout.createSequentialGroup()
                                                .addContainerGap().addComponent(strengthScoreLabel4)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(charismaScoreValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                54, Short.MAX_VALUE)
                                                .addContainerGap()));

                updateCharismaButton.setText("Update");
                updateCharismaButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updateCharismaButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout charismaPanelLayout =
                                new javax.swing.GroupLayout(charismaPanel);
                charismaPanel.setLayout(charismaPanelLayout);
                charismaPanelLayout.setHorizontalGroup(charismaPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(charismaPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(charismaPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(charismaPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(strengthScorePanel4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(strengthModifierPanel4,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(strengthLabel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                174,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(charismaPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                                .addComponent(updateCharismaButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                100,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(strengthSavePanel5,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGap(0, 10, Short.MAX_VALUE)));
                charismaPanelLayout.setVerticalGroup(charismaPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(charismaPanelLayout.createSequentialGroup()
                                                .addContainerGap(
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addGroup(charismaPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(strengthLabel5)
                                                                .addComponent(updateCharismaButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                24,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(charismaPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(strengthSavePanel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(strengthModifierPanel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(strengthScorePanel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)));

                javax.swing.GroupLayout characterStatsPanelLayout =
                                new javax.swing.GroupLayout(characterStatsPanel);
                characterStatsPanel.setLayout(characterStatsPanelLayout);
                characterStatsPanelLayout.setHorizontalGroup(characterStatsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(characterStatsPanelLayout.createSequentialGroup()
                                                .addGroup(characterStatsPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(characterStatsPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(characterStatsPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(strengthPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(dexterityPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(constitutionPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                147,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(characterStatsPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(intelligencePanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(wisdomPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(charismaPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addComponent(charicterAttributesPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                characterStatsPanelLayout.setVerticalGroup(characterStatsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(characterStatsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(charicterAttributesPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(characterStatsPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(strengthPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                157,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(intelligencePanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                157,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(characterStatsPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(dexterityPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                157,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(wisdomPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                157,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(characterStatsPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(constitutionPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                157,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(charismaPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                157,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout StatsPanelLayout = new javax.swing.GroupLayout(StatsPanel);
                StatsPanel.setLayout(StatsPanelLayout);
                StatsPanelLayout.setHorizontalGroup(StatsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(StatsPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(StatsPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(characterStatsPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(StatsPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(statsCharacterName,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(statsCharacterClass,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                175,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(levellabelLabel)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(statsCharacterLevel)))
                                                .addContainerGap()));
                StatsPanelLayout.setVerticalGroup(StatsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(StatsPanelLayout.createSequentialGroup().addContainerGap()
                                                .addGroup(StatsPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(statsCharacterName,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(statsCharacterClass,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(statsCharacterLevel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(levellabelLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(characterStatsPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)));

                SheetTabs.addTab("Stats", StatsPanel);

                abilitiesCharacterName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                abilitiesCharacterName.setText("CharacterName");

                abilitiesCharacterClass.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                abilitiesCharacterClass.setText("CharacterClass");

                abilitiesCharacterLevel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                abilitiesCharacterLevel.setText("999");

                levellabelLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                levellabelLabel2.setText("Level: ");

                abilitiesSection.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                abilitiesStrengthPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charStrengthValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charStrengthValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charStrengthValueLabel.setText("99");

                charStrengthLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charStrengthLabel.setText("Strength");

                strengthCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                strengthCheckButton.setText("Roll");
                strengthCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                strengthCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesStrengthPanelLayout =
                                new javax.swing.GroupLayout(abilitiesStrengthPanel);
                abilitiesStrengthPanel.setLayout(abilitiesStrengthPanelLayout);
                abilitiesStrengthPanelLayout.setHorizontalGroup(abilitiesStrengthPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesStrengthPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charStrengthLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charStrengthValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(strengthCheckButton)
                                                                .addContainerGap()));
                abilitiesStrengthPanelLayout.setVerticalGroup(abilitiesStrengthPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesStrengthPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charStrengthLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charStrengthValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(strengthCheckButton)));

                abilitiesAthleticsPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charAthleticsValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charAthleticsValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charAthleticsValueLabel.setText("99");

                charAthleticsLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charAthleticsLabel.setText("Athletics");

                athleticsCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                athleticsCheckButton.setText("Roll");
                athleticsCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                athleticsCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesAthleticsPanelLayout =
                                new javax.swing.GroupLayout(abilitiesAthleticsPanel);
                abilitiesAthleticsPanel.setLayout(abilitiesAthleticsPanelLayout);
                abilitiesAthleticsPanelLayout.setHorizontalGroup(abilitiesAthleticsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesAthleticsPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charAthleticsLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charAthleticsValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(athleticsCheckButton)
                                                                .addContainerGap()));
                abilitiesAthleticsPanelLayout.setVerticalGroup(abilitiesAthleticsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesAthleticsPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charAthleticsLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charAthleticsValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(athleticsCheckButton)));

                javax.swing.GroupLayout abilitiesStrengthSectionPanelLayout =
                                new javax.swing.GroupLayout(abilitiesStrengthSectionPanel);
                abilitiesStrengthSectionPanel.setLayout(abilitiesStrengthSectionPanelLayout);
                abilitiesStrengthSectionPanelLayout.setHorizontalGroup(
                                abilitiesStrengthSectionPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(abilitiesStrengthSectionPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(abilitiesStrengthSectionPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(abilitiesStrengthPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesAthleticsPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                abilitiesStrengthSectionPanelLayout.setVerticalGroup(
                                abilitiesStrengthSectionPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(abilitiesStrengthSectionPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(abilitiesStrengthPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitiesAthleticsPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                abilitiesDexterityPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charDexterityValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charDexterityValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charDexterityValueLabel.setText("99");

                charDexterityLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charDexterityLabel.setText("Dexterity");

                dexterityCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                dexterityCheckButton.setText("Roll");
                dexterityCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                dexterityCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesDexterityPanelLayout =
                                new javax.swing.GroupLayout(abilitiesDexterityPanel);
                abilitiesDexterityPanel.setLayout(abilitiesDexterityPanelLayout);
                abilitiesDexterityPanelLayout.setHorizontalGroup(abilitiesDexterityPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesDexterityPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charDexterityLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charDexterityValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(dexterityCheckButton)
                                                                .addContainerGap()));
                abilitiesDexterityPanelLayout.setVerticalGroup(abilitiesDexterityPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesDexterityPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charDexterityLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charDexterityValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dexterityCheckButton)));

                abilitiesAcrobaticsPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charAcrobaticsValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charAcrobaticsValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charAcrobaticsValueLabel.setText("99");

                charAcrobaticsLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charAcrobaticsLabel.setText("Acrobatics");

                acrobaticsCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                acrobaticsCheckButton.setText("Roll");
                acrobaticsCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                acrobaticsCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesAcrobaticsPanelLayout =
                                new javax.swing.GroupLayout(abilitiesAcrobaticsPanel);
                abilitiesAcrobaticsPanel.setLayout(abilitiesAcrobaticsPanelLayout);
                abilitiesAcrobaticsPanelLayout.setHorizontalGroup(abilitiesAcrobaticsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesAcrobaticsPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charAcrobaticsLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charAcrobaticsValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(acrobaticsCheckButton)
                                                                .addContainerGap()));
                abilitiesAcrobaticsPanelLayout.setVerticalGroup(abilitiesAcrobaticsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesAcrobaticsPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charAcrobaticsLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charAcrobaticsValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(acrobaticsCheckButton)));

                abilitiesSoHPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charSoHValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charSoHValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charSoHValueLabel.setText("99");

                charSoHLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charSoHLabel.setText("Sleight of Hand");

                SoHCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                SoHCheckButton.setText("Roll");
                SoHCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                SoHCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesSoHPanelLayout =
                                new javax.swing.GroupLayout(abilitiesSoHPanel);
                abilitiesSoHPanel.setLayout(abilitiesSoHPanelLayout);
                abilitiesSoHPanelLayout.setHorizontalGroup(abilitiesSoHPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesSoHPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charSoHLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charSoHValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(SoHCheckButton)
                                                                .addContainerGap()));
                abilitiesSoHPanelLayout.setVerticalGroup(abilitiesSoHPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesSoHPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charSoHLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charSoHValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(SoHCheckButton)));

                abilitiesStealthPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charStealthValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charStealthValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charStealthValueLabel.setText("99");

                charStealthLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charStealthLabel.setText("Stealth");

                stealthCheck.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                stealthCheck.setText("Roll");
                stealthCheck.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                stealthCheckActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesStealthPanelLayout =
                                new javax.swing.GroupLayout(abilitiesStealthPanel);
                abilitiesStealthPanel.setLayout(abilitiesStealthPanelLayout);
                abilitiesStealthPanelLayout.setHorizontalGroup(abilitiesStealthPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesStealthPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charStealthLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charStealthValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(stealthCheck)
                                                                .addContainerGap()));
                abilitiesStealthPanelLayout.setVerticalGroup(abilitiesStealthPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesStealthPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charStealthLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charStealthValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(stealthCheck)));

                javax.swing.GroupLayout abilitiesDexteritySectionPanelLayout =
                                new javax.swing.GroupLayout(abilitiesDexteritySectionPanel);
                abilitiesDexteritySectionPanel.setLayout(abilitiesDexteritySectionPanelLayout);
                abilitiesDexteritySectionPanelLayout.setHorizontalGroup(
                                abilitiesDexteritySectionPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(abilitiesDexteritySectionPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(abilitiesDexteritySectionPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(abilitiesDexterityPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesSoHPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesStealthPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesAcrobaticsPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                abilitiesDexteritySectionPanelLayout.setVerticalGroup(
                                abilitiesDexteritySectionPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(abilitiesDexteritySectionPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(abilitiesDexterityPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitiesAcrobaticsPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitiesSoHPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitiesStealthPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                abilitiesIntelligencePanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charIntelligenceValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charIntelligenceValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charIntelligenceValueLabel.setText("99");

                charIntelligenceLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charIntelligenceLabel.setText("Intelligence");

                intelligenceCheck.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                intelligenceCheck.setText("Roll");
                intelligenceCheck.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                intelligenceCheckActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesIntelligencePanelLayout =
                                new javax.swing.GroupLayout(abilitiesIntelligencePanel);
                abilitiesIntelligencePanel.setLayout(abilitiesIntelligencePanelLayout);
                abilitiesIntelligencePanelLayout.setHorizontalGroup(abilitiesIntelligencePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesIntelligencePanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charIntelligenceLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charIntelligenceValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(intelligenceCheck)
                                                                .addContainerGap()));
                abilitiesIntelligencePanelLayout.setVerticalGroup(abilitiesIntelligencePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesIntelligencePanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charIntelligenceLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charIntelligenceValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(intelligenceCheck)));

                abilitiesArcanaPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charArcanaValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charArcanaValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charArcanaValueLabel.setText("99");

                charArcanaLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charArcanaLabel.setText("Arcana");

                arcanaCheck.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                arcanaCheck.setText("Roll");
                arcanaCheck.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                arcanaCheckActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesArcanaPanelLayout =
                                new javax.swing.GroupLayout(abilitiesArcanaPanel);
                abilitiesArcanaPanel.setLayout(abilitiesArcanaPanelLayout);
                abilitiesArcanaPanelLayout.setHorizontalGroup(abilitiesArcanaPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesArcanaPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charArcanaLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charArcanaValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(arcanaCheck)
                                                                .addContainerGap()));
                abilitiesArcanaPanelLayout.setVerticalGroup(abilitiesArcanaPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesArcanaPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charArcanaLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charArcanaValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(arcanaCheck)));

                abilitiesHistoryPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charHistoryValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charHistoryValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charHistoryValueLabel.setText("99");

                charHistoryLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charHistoryLabel.setText("History");

                historyCheck.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                historyCheck.setText("Roll");
                historyCheck.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                historyCheckActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesHistoryPanelLayout =
                                new javax.swing.GroupLayout(abilitiesHistoryPanel);
                abilitiesHistoryPanel.setLayout(abilitiesHistoryPanelLayout);
                abilitiesHistoryPanelLayout.setHorizontalGroup(abilitiesHistoryPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesHistoryPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charHistoryLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charHistoryValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(historyCheck)
                                                                .addContainerGap()));
                abilitiesHistoryPanelLayout.setVerticalGroup(abilitiesHistoryPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesHistoryPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charHistoryLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charHistoryValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(historyCheck)));

                abilitiesInvestigationPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charInvestigationValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charInvestigationValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charInvestigationValueLabel.setText("99");

                charInvestigationLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charInvestigationLabel.setText("Investigation");

                investigationCheck.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                investigationCheck.setText("Roll");
                investigationCheck.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                investigationCheckActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesInvestigationPanelLayout =
                                new javax.swing.GroupLayout(abilitiesInvestigationPanel);
                abilitiesInvestigationPanel.setLayout(abilitiesInvestigationPanelLayout);
                abilitiesInvestigationPanelLayout.setHorizontalGroup(
                                abilitiesInvestigationPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                abilitiesInvestigationPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(charInvestigationLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                174,
                                                                                                Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(charInvestigationValueLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                37,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(investigationCheck)
                                                                                .addContainerGap()));
                abilitiesInvestigationPanelLayout.setVerticalGroup(abilitiesInvestigationPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesInvestigationPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charInvestigationLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charInvestigationValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(investigationCheck)));

                abilitiesNaturePanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charNatureValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charNatureValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charNatureValueLabel.setText("99");

                charNatureLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charNatureLabel.setText("Nature");

                natureCheck.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                natureCheck.setText("Roll");
                natureCheck.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                natureCheckActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesNaturePanelLayout =
                                new javax.swing.GroupLayout(abilitiesNaturePanel);
                abilitiesNaturePanel.setLayout(abilitiesNaturePanelLayout);
                abilitiesNaturePanelLayout.setHorizontalGroup(abilitiesNaturePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesNaturePanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charNatureLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charNatureValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(natureCheck)
                                                                .addContainerGap()));
                abilitiesNaturePanelLayout.setVerticalGroup(abilitiesNaturePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesNaturePanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charNatureLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charNatureValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(natureCheck)));

                abilitesReligionPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charReligionValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charReligionValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charReligionValueLabel.setText("99");

                charReligionLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charReligionLabel.setText("Religion");

                religionCheck.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                religionCheck.setText("Roll");
                religionCheck.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                religionCheckActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitesReligionPanelLayout =
                                new javax.swing.GroupLayout(abilitesReligionPanel);
                abilitesReligionPanel.setLayout(abilitesReligionPanelLayout);
                abilitesReligionPanelLayout.setHorizontalGroup(abilitesReligionPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitesReligionPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charReligionLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charReligionValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(religionCheck)
                                                                .addContainerGap()));
                abilitesReligionPanelLayout.setVerticalGroup(abilitesReligionPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitesReligionPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charReligionLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charReligionValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(religionCheck)));

                javax.swing.GroupLayout abilitiesIntelligenceSectionPanelLayout =
                                new javax.swing.GroupLayout(abilitiesIntelligenceSectionPanel);
                abilitiesIntelligenceSectionPanel
                                .setLayout(abilitiesIntelligenceSectionPanelLayout);
                abilitiesIntelligenceSectionPanelLayout.setHorizontalGroup(
                                abilitiesIntelligenceSectionPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(abilitiesIntelligenceSectionPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(abilitiesIntelligenceSectionPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(abilitiesIntelligencePanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesHistoryPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesInvestigationPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesNaturePanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitesReligionPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesArcanaPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                abilitiesIntelligenceSectionPanelLayout.setVerticalGroup(
                                abilitiesIntelligenceSectionPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(abilitiesIntelligenceSectionPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(abilitiesIntelligencePanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitiesArcanaPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitiesHistoryPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitiesInvestigationPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitiesNaturePanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitesReligionPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                abilitiesWisdomPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charWisdomValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charWisdomValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charWisdomValueLabel.setText("99");

                charWisdomLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charWisdomLabel.setText("Wisdom");

                wisdomCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                wisdomCheckButton.setText("Roll");
                wisdomCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                wisdomCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesWisdomPanelLayout =
                                new javax.swing.GroupLayout(abilitiesWisdomPanel);
                abilitiesWisdomPanel.setLayout(abilitiesWisdomPanelLayout);
                abilitiesWisdomPanelLayout.setHorizontalGroup(abilitiesWisdomPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesWisdomPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charWisdomLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charWisdomValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(wisdomCheckButton)
                                                                .addContainerGap()));
                abilitiesWisdomPanelLayout.setVerticalGroup(abilitiesWisdomPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesWisdomPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charWisdomLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charWisdomValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(wisdomCheckButton)));

                abilitiesAnimalHandlingPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charAnimalHandlingValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charAnimalHandlingValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charAnimalHandlingValueLabel.setText("99");

                charAnimalHandlingLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charAnimalHandlingLabel.setText("Animal Handling");

                animalHandlingCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                animalHandlingCheckButton.setText("Roll");
                animalHandlingCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                animalHandlingCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesAnimalHandlingPanelLayout =
                                new javax.swing.GroupLayout(abilitiesAnimalHandlingPanel);
                abilitiesAnimalHandlingPanel.setLayout(abilitiesAnimalHandlingPanelLayout);
                abilitiesAnimalHandlingPanelLayout.setHorizontalGroup(
                                abilitiesAnimalHandlingPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                abilitiesAnimalHandlingPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(charAnimalHandlingLabel,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                174,
                                                                                                Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(charAnimalHandlingValueLabel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                37,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(animalHandlingCheckButton)
                                                                                .addContainerGap()));
                abilitiesAnimalHandlingPanelLayout.setVerticalGroup(
                                abilitiesAnimalHandlingPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(abilitiesAnimalHandlingPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(charAnimalHandlingLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(charAnimalHandlingValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(animalHandlingCheckButton)));

                abilitiesInsightPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charInsightValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charInsightValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charInsightValueLabel.setText("99");

                charInsightLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charInsightLabel.setText("Insight");

                insightCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                insightCheckButton.setText("Roll");
                insightCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                insightCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesInsightPanelLayout =
                                new javax.swing.GroupLayout(abilitiesInsightPanel);
                abilitiesInsightPanel.setLayout(abilitiesInsightPanelLayout);
                abilitiesInsightPanelLayout.setHorizontalGroup(abilitiesInsightPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesInsightPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charInsightLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charInsightValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(insightCheckButton)
                                                                .addContainerGap()));
                abilitiesInsightPanelLayout.setVerticalGroup(abilitiesInsightPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesInsightPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charInsightLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charInsightValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(insightCheckButton)));

                abilitiesMedicinePanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charMedicineValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charMedicineValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charMedicineValueLabel.setText("99");

                charMedicineLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charMedicineLabel.setText("Medicine");

                medicineCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                medicineCheckButton.setText("Roll");
                medicineCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                medicineCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesMedicinePanelLayout =
                                new javax.swing.GroupLayout(abilitiesMedicinePanel);
                abilitiesMedicinePanel.setLayout(abilitiesMedicinePanelLayout);
                abilitiesMedicinePanelLayout.setHorizontalGroup(abilitiesMedicinePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesMedicinePanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charMedicineLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charMedicineValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(medicineCheckButton)
                                                                .addContainerGap()));
                abilitiesMedicinePanelLayout.setVerticalGroup(abilitiesMedicinePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesMedicinePanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charMedicineLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charMedicineValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(medicineCheckButton)));

                abilitiesPerceptionPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charPerceptionValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charPerceptionValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charPerceptionValueLabel.setText("99");

                charPerceptionLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charPerceptionLabel.setText("Perception");

                perceptionCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                perceptionCheckButton.setText("Roll");
                perceptionCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                perceptionCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesPerceptionPanelLayout =
                                new javax.swing.GroupLayout(abilitiesPerceptionPanel);
                abilitiesPerceptionPanel.setLayout(abilitiesPerceptionPanelLayout);
                abilitiesPerceptionPanelLayout.setHorizontalGroup(abilitiesPerceptionPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesPerceptionPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charPerceptionLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charPerceptionValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(perceptionCheckButton)
                                                                .addContainerGap()));
                abilitiesPerceptionPanelLayout.setVerticalGroup(abilitiesPerceptionPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesPerceptionPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charPerceptionLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charPerceptionValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(perceptionCheckButton)));

                abilitiesSurvivalPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charSurvivalValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charSurvivalValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charSurvivalValueLabel.setText("99");

                charSurvivalLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charSurvivalLabel.setText("Survival");

                survivalCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                survivalCheckButton.setText("Roll");
                survivalCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                survivalCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesSurvivalPanelLayout =
                                new javax.swing.GroupLayout(abilitiesSurvivalPanel);
                abilitiesSurvivalPanel.setLayout(abilitiesSurvivalPanelLayout);
                abilitiesSurvivalPanelLayout.setHorizontalGroup(abilitiesSurvivalPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesSurvivalPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charSurvivalLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charSurvivalValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(survivalCheckButton)
                                                                .addContainerGap()));
                abilitiesSurvivalPanelLayout.setVerticalGroup(abilitiesSurvivalPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesSurvivalPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charSurvivalLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charSurvivalValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(survivalCheckButton)));

                javax.swing.GroupLayout abilitiesWisdomSectionPanelLayout =
                                new javax.swing.GroupLayout(abilitiesWisdomSectionPanel);
                abilitiesWisdomSectionPanel.setLayout(abilitiesWisdomSectionPanelLayout);
                abilitiesWisdomSectionPanelLayout.setHorizontalGroup(
                                abilitiesWisdomSectionPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(abilitiesWisdomSectionPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(abilitiesWisdomSectionPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(abilitiesWisdomPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesInsightPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesMedicinePanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesPerceptionPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesSurvivalPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesAnimalHandlingPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(61,
                                                                                Short.MAX_VALUE)));
                abilitiesWisdomSectionPanelLayout.setVerticalGroup(abilitiesWisdomSectionPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesWisdomSectionPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(abilitiesWisdomPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(abilitiesAnimalHandlingPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(abilitiesInsightPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(abilitiesMedicinePanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(abilitiesPerceptionPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(abilitiesSurvivalPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                abilitiesCharismaPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charCharismaValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charCharismaValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charCharismaValueLabel.setText("99");

                charCharismaLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charCharismaLabel.setText("Charisma");

                charismaCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charismaCheckButton.setText("Roll");
                charismaCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                charismaCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesCharismaPanelLayout =
                                new javax.swing.GroupLayout(abilitiesCharismaPanel);
                abilitiesCharismaPanel.setLayout(abilitiesCharismaPanelLayout);
                abilitiesCharismaPanelLayout.setHorizontalGroup(abilitiesCharismaPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesCharismaPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charCharismaLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charCharismaValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charismaCheckButton)
                                                                .addContainerGap()));
                abilitiesCharismaPanelLayout.setVerticalGroup(abilitiesCharismaPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesCharismaPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charCharismaLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charCharismaValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charismaCheckButton)));

                abilitiesDeceptionPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charDeceptionValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charDeceptionValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charDeceptionValueLabel.setText("99");

                charDeceptionLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charDeceptionLabel.setText("Deception");

                deceptionCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                deceptionCheckButton.setText("Roll");
                deceptionCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                deceptionCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesDeceptionPanelLayout =
                                new javax.swing.GroupLayout(abilitiesDeceptionPanel);
                abilitiesDeceptionPanel.setLayout(abilitiesDeceptionPanelLayout);
                abilitiesDeceptionPanelLayout.setHorizontalGroup(abilitiesDeceptionPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesDeceptionPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charDeceptionLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charDeceptionValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(deceptionCheckButton)
                                                                .addContainerGap()));
                abilitiesDeceptionPanelLayout.setVerticalGroup(abilitiesDeceptionPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesDeceptionPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charDeceptionLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charDeceptionValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(deceptionCheckButton)));

                abilitiesIntimidationPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charIntimidationValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charIntimidationValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charIntimidationValueLabel.setText("99");

                charIntimidationLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charIntimidationLabel.setText("Intimidation");

                intimidationCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                intimidationCheckButton.setText("Roll");
                intimidationCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                intimidationCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesIntimidationPanelLayout =
                                new javax.swing.GroupLayout(abilitiesIntimidationPanel);
                abilitiesIntimidationPanel.setLayout(abilitiesIntimidationPanelLayout);
                abilitiesIntimidationPanelLayout.setHorizontalGroup(abilitiesIntimidationPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesIntimidationPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charIntimidationLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charIntimidationValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(intimidationCheckButton)
                                                                .addContainerGap()));
                abilitiesIntimidationPanelLayout.setVerticalGroup(abilitiesIntimidationPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesIntimidationPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charIntimidationLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charIntimidationValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(intimidationCheckButton)));

                abilitiesPerformancePanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charPerformanceValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charPerformanceValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charPerformanceValueLabel.setText("99");

                charPerformanceLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charPerformanceLabel.setText("Performance");

                performanceCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                performanceCheckButton.setText("Roll");
                performanceCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                performanceCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesPerformancePanelLayout =
                                new javax.swing.GroupLayout(abilitiesPerformancePanel);
                abilitiesPerformancePanel.setLayout(abilitiesPerformancePanelLayout);
                abilitiesPerformancePanelLayout.setHorizontalGroup(abilitiesPerformancePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesPerformancePanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charPerformanceLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charPerformanceValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(performanceCheckButton)
                                                                .addContainerGap()));
                abilitiesPerformancePanelLayout.setVerticalGroup(abilitiesPerformancePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesPerformancePanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charPerformanceLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charPerformanceValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(performanceCheckButton)));

                abilitiesPersuasion.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                charPersuasionValueLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charPersuasionValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                charPersuasionValueLabel.setText("99");

                charPersuasionLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                charPersuasionLabel.setText("Persuasion");

                persuasionCheckButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                persuasionCheckButton.setText("Roll");
                persuasionCheckButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                persuasionCheckButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout abilitiesPersuasionLayout =
                                new javax.swing.GroupLayout(abilitiesPersuasion);
                abilitiesPersuasion.setLayout(abilitiesPersuasionLayout);
                abilitiesPersuasionLayout.setHorizontalGroup(abilitiesPersuasionLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                abilitiesPersuasionLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(charPersuasionLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                174,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(charPersuasionValueLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(persuasionCheckButton)
                                                                .addContainerGap()));
                abilitiesPersuasionLayout.setVerticalGroup(abilitiesPersuasionLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesPersuasionLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(charPersuasionLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(charPersuasionValueLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(persuasionCheckButton)));

                javax.swing.GroupLayout abilitiesCharismaSectionPanelLayout =
                                new javax.swing.GroupLayout(abilitiesCharismaSectionPanel);
                abilitiesCharismaSectionPanel.setLayout(abilitiesCharismaSectionPanelLayout);
                abilitiesCharismaSectionPanelLayout.setHorizontalGroup(
                                abilitiesCharismaSectionPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(abilitiesCharismaSectionPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(abilitiesCharismaSectionPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(abilitiesCharismaPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesIntimidationPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesPerformancePanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesPersuasion,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(abilitiesDeceptionPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                abilitiesCharismaSectionPanelLayout.setVerticalGroup(
                                abilitiesCharismaSectionPanelLayout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(abilitiesCharismaSectionPanelLayout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(abilitiesCharismaPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitiesDeceptionPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitiesIntimidationPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitiesPerformancePanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(abilitiesPersuasion,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout abilitiesSectionLayout =
                                new javax.swing.GroupLayout(abilitiesSection);
                abilitiesSection.setLayout(abilitiesSectionLayout);
                abilitiesSectionLayout.setHorizontalGroup(abilitiesSectionLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesSectionLayout.createSequentialGroup()
                                                .addContainerGap(65, Short.MAX_VALUE)
                                                .addGroup(abilitiesSectionLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                .addComponent(abilitiesDexteritySectionPanel,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(abilitiesStrengthSectionPanel,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(abilitiesIntelligenceSectionPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(abilitiesSectionLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                .addComponent(abilitiesWisdomSectionPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(abilitiesCharismaSectionPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                abilitiesSectionLayout.setVerticalGroup(abilitiesSectionLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesSectionLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(abilitiesSectionLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(abilitiesSectionLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(abilitiesStrengthSectionPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(abilitiesDexteritySectionPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(abilitiesIntelligenceSectionPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(abilitiesSectionLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(abilitiesWisdomSectionPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(abilitiesCharismaSectionPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(41, Short.MAX_VALUE)));

                javax.swing.GroupLayout abilitiesPanelLayout =
                                new javax.swing.GroupLayout(abilitiesPanel);
                abilitiesPanel.setLayout(abilitiesPanelLayout);
                abilitiesPanelLayout.setHorizontalGroup(abilitiesPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(abilitiesPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(abilitiesPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(abilitiesSection,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                .addGroup(abilitiesPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(abilitiesCharacterName,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(abilitiesCharacterClass,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                175,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(levellabelLabel2)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(abilitiesCharacterLevel)))
                                                .addContainerGap()));
                abilitiesPanelLayout.setVerticalGroup(abilitiesPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(abilitiesPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(abilitiesPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(abilitiesCharacterName,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(abilitiesCharacterClass,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(abilitiesCharacterLevel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(levellabelLabel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(abilitiesSection,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                SheetTabs.addTab("Abilities", abilitiesPanel);

                weaponsCharacterName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponsCharacterName.setText("CharacterName");

                weaponsCharacterClass.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponsCharacterClass.setText("CharacterClass");

                weaponsCharacterLevel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponsCharacterLevel.setText("999");

                levellabelLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                levellabelLabel3.setText("Level: ");

                weaponProficiencyPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                weaponProficienctLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                weaponProficienctLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                weaponProficienctLabel.setText("Proficiency");

                weaponProficiencyValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponProficiencyValueLabel
                                .setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                weaponProficiencyValueLabel.setText("+999");

                weaponProficiencyUpdateButton.setText("Update");
                weaponProficiencyUpdateButton
                                .addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(
                                                        java.awt.event.ActionEvent evt) {
                                                weaponProficiencyUpdateButtonActionPerformed(evt);
                                        }
                                });

                javax.swing.GroupLayout weaponProficiencyPanelLayout =
                                new javax.swing.GroupLayout(weaponProficiencyPanel);
                weaponProficiencyPanel.setLayout(weaponProficiencyPanelLayout);
                weaponProficiencyPanelLayout.setHorizontalGroup(weaponProficiencyPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(weaponProficiencyPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(weaponProficiencyPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(weaponProficienctLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(weaponProficiencyPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(weaponProficiencyPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(weaponProficiencyValueLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                69,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(weaponProficiencyUpdateButton))
                                                                                .addGap(0, 1, Short.MAX_VALUE)))
                                                .addContainerGap()));
                weaponProficiencyPanelLayout.setVerticalGroup(weaponProficiencyPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(weaponProficiencyPanelLayout.createSequentialGroup()
                                                .addComponent(weaponProficienctLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                26,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(weaponProficiencyValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(weaponProficiencyUpdateButton)
                                                .addContainerGap()));

                weaponStrengthPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                weaponStrengthLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                weaponStrengthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                weaponStrengthLabel.setText("Strength");

                weaponStrengthValueLable.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponStrengthValueLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                weaponStrengthValueLable.setText("999");

                weaponStrengthUpdateButton.setText("Update");
                weaponStrengthUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                weaponStrengthUpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout weaponStrengthPanelLayout =
                                new javax.swing.GroupLayout(weaponStrengthPanel);
                weaponStrengthPanel.setLayout(weaponStrengthPanelLayout);
                weaponStrengthPanelLayout.setHorizontalGroup(weaponStrengthPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(weaponStrengthPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(weaponStrengthPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(weaponStrengthLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(weaponStrengthPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(weaponStrengthPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(weaponStrengthValueLable,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                69,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(weaponStrengthUpdateButton))
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap()));
                weaponStrengthPanelLayout.setVerticalGroup(weaponStrengthPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(weaponStrengthPanelLayout.createSequentialGroup()
                                                .addComponent(weaponStrengthLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                26,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(weaponStrengthValueLable,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(weaponStrengthUpdateButton)
                                                .addContainerGap()));

                weaponResourcePanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                weaponResourceLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                weaponResourceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                weaponResourceLabel.setText("Resource");

                weaponResourceValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                weaponResourceValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                weaponResourceValueLabel.setText("999");

                weaponResourceUpdateButton.setText("Update");
                weaponResourceUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                weaponResourceUpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout weaponResourcePanelLayout =
                                new javax.swing.GroupLayout(weaponResourcePanel);
                weaponResourcePanel.setLayout(weaponResourcePanelLayout);
                weaponResourcePanelLayout.setHorizontalGroup(weaponResourcePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(weaponResourcePanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(weaponResourcePanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(weaponResourceLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(weaponResourcePanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(weaponResourcePanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(weaponResourceValueLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                69,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(weaponResourceUpdateButton))
                                                                                .addGap(0, 1, Short.MAX_VALUE)))
                                                .addContainerGap()));
                weaponResourcePanelLayout.setVerticalGroup(weaponResourcePanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(weaponResourcePanelLayout.createSequentialGroup()
                                                .addComponent(weaponResourceLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                26,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(weaponResourceValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(weaponResourceUpdateButton)
                                                .addContainerGap()));

                weaponsUpdateButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                weaponsUpdateButton.setText("Update");
                weaponsUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                weaponsUpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout weaponsHeaderPanelLayout =
                                new javax.swing.GroupLayout(weaponsHeaderPanel);
                weaponsHeaderPanel.setLayout(weaponsHeaderPanelLayout);
                weaponsHeaderPanelLayout.setHorizontalGroup(weaponsHeaderPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(weaponsHeaderPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(weaponProficiencyPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(weaponStrengthPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(weaponResourcePanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addComponent(weaponsUpdateButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                101,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap()));
                weaponsHeaderPanelLayout.setVerticalGroup(weaponsHeaderPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(weaponsHeaderPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(weaponsHeaderPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                .addComponent(weaponsUpdateButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(weaponResourcePanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                104,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(weaponStrengthPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                104,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(weaponProficiencyPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                104,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));

                weaponsListPanel.setPreferredSize(new java.awt.Dimension(856, 576));

                exampleWeaponPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                exampleWeaponName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                exampleWeaponName.setText("characterWeaponName");

                exampleWeaponRange.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                exampleWeaponRange.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                exampleWeaponRange.setText("999/99999");
                exampleWeaponRange.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                exampleWeaponProficiency.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                exampleWeaponProficiency.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                exampleWeaponProficiency.setText("+99");
                exampleWeaponProficiency.setVerticalAlignment(javax.swing.SwingConstants.TOP);

                exampleWeaponDamageType.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                exampleWeaponDamageType.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                exampleWeaponDamageType.setText("exampleDamageType");
                exampleWeaponDamageType.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                exampleWeaponDamageRoll.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                exampleWeaponDamageRoll.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                exampleWeaponDamageRoll.setText("999d99999");
                exampleWeaponDamageRoll.setVerticalAlignment(javax.swing.SwingConstants.TOP);

                exampleWeaponRollHit.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                exampleWeaponRollHit.setText("HIT\n");
                exampleWeaponRollHit.setMaximumSize(new java.awt.Dimension(76, 33));
                exampleWeaponRollHit.setMinimumSize(new java.awt.Dimension(76, 33));
                exampleWeaponRollHit.setPreferredSize(new java.awt.Dimension(76, 33));
                exampleWeaponRollHit.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                exampleWeaponRollHitActionPerformed(evt);
                        }
                });

                exampleWeaponRollDamage.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                exampleWeaponRollDamage.setText("DMG");
                exampleWeaponRollDamage.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                exampleWeaponRollDamageActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout exampleWeaponPanelLayout =
                                new javax.swing.GroupLayout(exampleWeaponPanel);
                exampleWeaponPanel.setLayout(exampleWeaponPanelLayout);
                exampleWeaponPanelLayout.setHorizontalGroup(exampleWeaponPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(exampleWeaponPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(exampleWeaponName,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                260,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(exampleWeaponPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                .addComponent(exampleWeaponProficiency,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(exampleWeaponRange,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(exampleWeaponPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(exampleWeaponDamageType,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                162,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(exampleWeaponDamageRoll,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGap(53, 53, 53)
                                                .addComponent(exampleWeaponRollHit,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                78,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)
                                                .addComponent(exampleWeaponRollDamage)
                                                .addContainerGap()));
                exampleWeaponPanelLayout.setVerticalGroup(exampleWeaponPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                exampleWeaponPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(exampleWeaponPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(exampleWeaponRollDamage,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(exampleWeaponRollHit,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap())
                                .addGroup(exampleWeaponPanelLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(exampleWeaponPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(exampleWeaponName,
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(exampleWeaponPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(exampleWeaponPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(exampleWeaponRange,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                29,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(exampleWeaponDamageType,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                29,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(exampleWeaponPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(exampleWeaponProficiency,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                20,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(exampleWeaponDamageRoll,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                20,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(6, 12, Short.MAX_VALUE)))));

                javax.swing.GroupLayout weaponsListPanelLayout =
                                new javax.swing.GroupLayout(weaponsListPanel);
                weaponsListPanel.setLayout(weaponsListPanelLayout);
                weaponsListPanelLayout.setHorizontalGroup(weaponsListPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(weaponsListPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(exampleWeaponPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(89, Short.MAX_VALUE)));
                weaponsListPanelLayout.setVerticalGroup(weaponsListPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(weaponsListPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(exampleWeaponPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(491, Short.MAX_VALUE)));

                weaponsListScrollPane.setViewportView(weaponsListPanel);

                javax.swing.GroupLayout characterWeaponsPanelLayout =
                                new javax.swing.GroupLayout(characterWeaponsPanel);
                characterWeaponsPanel.setLayout(characterWeaponsPanelLayout);
                characterWeaponsPanelLayout.setHorizontalGroup(characterWeaponsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(characterWeaponsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(characterWeaponsPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(weaponsHeaderPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(characterWeaponsPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(weaponsListScrollPane,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                0,
                                                                                                Short.MAX_VALUE)
                                                                                .addContainerGap()))));
                characterWeaponsPanelLayout.setVerticalGroup(characterWeaponsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(characterWeaponsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(weaponsHeaderPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(weaponsListScrollPane,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                487, Short.MAX_VALUE)
                                                .addContainerGap()));

                javax.swing.GroupLayout weaponsPanelLayout =
                                new javax.swing.GroupLayout(weaponsPanel);
                weaponsPanel.setLayout(weaponsPanelLayout);
                weaponsPanelLayout.setHorizontalGroup(weaponsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(weaponsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(weaponsPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(characterWeaponsPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(weaponsPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(weaponsCharacterName,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                511,
                                                                                                Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(weaponsCharacterClass,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                175,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(levellabelLabel3)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(weaponsCharacterLevel)))
                                                .addContainerGap()));
                weaponsPanelLayout.setVerticalGroup(weaponsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(weaponsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(weaponsPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(weaponsCharacterName,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(weaponsCharacterClass,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(weaponsCharacterLevel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(levellabelLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(characterWeaponsPanel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                SheetTabs.addTab("Weapons", weaponsPanel);

                spellsCharacterName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellsCharacterName.setText("CharacterName");

                spellsCharacterClass.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellsCharacterClass.setText("CharacterClass");

                spellsCharacterLevel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellsCharacterLevel.setText("999");

                levellabelLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                levellabelLabel4.setText("Level: ");

                spellsCLevelPanle.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                spellsCLevelLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                spellsCLevelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                spellsCLevelLabel.setText("C Level");

                spellsCLevelValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellsCLevelValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                spellsCLevelValueLabel.setText("+999");

                spellsCLevelUpdateButton.setText("Update");
                spellsCLevelUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                spellsCLevelUpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout spellsCLevelPanleLayout =
                                new javax.swing.GroupLayout(spellsCLevelPanle);
                spellsCLevelPanle.setLayout(spellsCLevelPanleLayout);
                spellsCLevelPanleLayout.setHorizontalGroup(spellsCLevelPanleLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(spellsCLevelPanleLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(spellsCLevelPanleLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(spellsCLevelLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(spellsCLevelPanleLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(spellsCLevelPanleLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(spellsCLevelValueLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                69,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(spellsCLevelUpdateButton))
                                                                                .addGap(0, 1, Short.MAX_VALUE)))
                                                .addContainerGap()));
                spellsCLevelPanleLayout.setVerticalGroup(spellsCLevelPanleLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(spellsCLevelPanleLayout.createSequentialGroup()
                                                .addComponent(spellsCLevelLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                26,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spellsCLevelValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spellsCLevelUpdateButton)
                                                .addContainerGap()));

                spellsAttackPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                spellsAttackLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                spellsAttackLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                spellsAttackLabel.setText("Spell Attack");

                spellsAttackValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellsAttackValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                spellsAttackValueLabel.setText("999");

                spellsAttackValueUpdateButton.setText("Update");
                spellsAttackValueUpdateButton
                                .addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(
                                                        java.awt.event.ActionEvent evt) {
                                                spellsAttackValueUpdateButtonActionPerformed(evt);
                                        }
                                });

                javax.swing.GroupLayout spellsAttackPanelLayout =
                                new javax.swing.GroupLayout(spellsAttackPanel);
                spellsAttackPanel.setLayout(spellsAttackPanelLayout);
                spellsAttackPanelLayout.setHorizontalGroup(spellsAttackPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(spellsAttackPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(spellsAttackPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(spellsAttackLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(spellsAttackPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(spellsAttackPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(spellsAttackValueLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                69,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(spellsAttackValueUpdateButton))
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap()));
                spellsAttackPanelLayout.setVerticalGroup(spellsAttackPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(spellsAttackPanelLayout.createSequentialGroup()
                                                .addComponent(spellsAttackLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                26,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spellsAttackValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spellsAttackValueUpdateButton)
                                                .addContainerGap()));

                spellsDCPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                spellsDCLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                spellsDCLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                spellsDCLabel.setText("Spell DC");

                spellsDCValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                spellsDCValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                spellsDCValueLabel.setText("999");

                spellsDCUpdateButton.setText("Update");
                spellsDCUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                spellsDCUpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout spellsDCPanelLayout =
                                new javax.swing.GroupLayout(spellsDCPanel);
                spellsDCPanel.setLayout(spellsDCPanelLayout);
                spellsDCPanelLayout.setHorizontalGroup(spellsDCPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(spellsDCPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(spellsDCPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(spellsDCLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(spellsDCPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addGroup(spellsDCPanelLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(spellsDCValueLabel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                69,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(spellsDCUpdateButton))
                                                                                .addGap(0, 1, Short.MAX_VALUE)))
                                                .addContainerGap()));
                spellsDCPanelLayout.setVerticalGroup(spellsDCPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(spellsDCPanelLayout.createSequentialGroup().addComponent(
                                                spellsDCLabel,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spellsDCValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(spellsDCUpdateButton)
                                                .addContainerGap()));

                spellsUpdateButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                spellsUpdateButton.setText("Update");
                spellsUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                spellsUpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout spellsHeaderPanelLayout =
                                new javax.swing.GroupLayout(spellsHeaderPanel);
                spellsHeaderPanel.setLayout(spellsHeaderPanelLayout);
                spellsHeaderPanelLayout.setHorizontalGroup(spellsHeaderPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(spellsHeaderPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(spellsCLevelPanle,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(spellsAttackPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(spellsDCPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addComponent(spellsUpdateButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                101,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap()));
                spellsHeaderPanelLayout.setVerticalGroup(spellsHeaderPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                spellsHeaderPanelLayout.createSequentialGroup()
                                                                .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(spellsHeaderPanelLayout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(spellsUpdateButton,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                spellsHeaderPanelLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(spellsDCPanel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                104,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(spellsAttackPanel,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                104,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(spellsCLevelPanle,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                104,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap()));

                cantripsKnownSpellsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                exampleCantripsSpellPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                exampleSpellName1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                exampleSpellName1.setText("characterSpellName");

                exampleSpellHitLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                exampleSpellHitLabel.setText("99d999");

                exampleSpellRollButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                exampleSpellRollButton.setText("DMG");
                exampleSpellRollButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                exampleSpellRollButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout exampleCantripsSpellPanelLayout =
                                new javax.swing.GroupLayout(exampleCantripsSpellPanel);
                exampleCantripsSpellPanel.setLayout(exampleCantripsSpellPanelLayout);
                exampleCantripsSpellPanelLayout.setHorizontalGroup(exampleCantripsSpellPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(exampleCantripsSpellPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(exampleSpellName1,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                506, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(exampleSpellHitLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                102,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(exampleSpellRollButton)
                                                .addContainerGap()));
                exampleCantripsSpellPanelLayout.setVerticalGroup(exampleCantripsSpellPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(exampleCantripsSpellPanelLayout.createSequentialGroup()
                                                .addGroup(exampleCantripsSpellPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(exampleSpellName1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                65,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(exampleSpellHitLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                65,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(exampleCantripsSpellPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(exampleSpellRollButton,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                cantripsHeaderPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                cantripsHeaderLabel.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
                cantripsHeaderLabel.setText("Cantrips");
                cantripsHeaderLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                cantripsSpellSlotAvailableLabel.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
                cantripsSpellSlotAvailableLabel.setText("99");
                cantripsSpellSlotAvailableLabel
                                .setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                jLabel3.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
                jLabel3.setText("/");
                jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                cantripsSpellMaxLabel.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
                cantripsSpellMaxLabel.setText("99");
                cantripsSpellMaxLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                cantripsUpdateButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                cantripsUpdateButton.setText("Update");
                cantripsUpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cantripsUpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout cantripsHeaderPanelLayout =
                                new javax.swing.GroupLayout(cantripsHeaderPanel);
                cantripsHeaderPanel.setLayout(cantripsHeaderPanelLayout);
                cantripsHeaderPanelLayout.setHorizontalGroup(cantripsHeaderPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(cantripsHeaderPanelLayout.createSequentialGroup()
                                                .addComponent(cantripsHeaderLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cantripsSpellSlotAvailableLabel)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cantripsSpellMaxLabel)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cantripsUpdateButton)
                                                .addContainerGap()));
                cantripsHeaderPanelLayout.setVerticalGroup(cantripsHeaderPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cantripsHeaderLabel,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                .addComponent(cantripsSpellSlotAvailableLabel,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                .addComponent(cantripsSpellMaxLabel,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                cantripsHeaderPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(cantripsUpdateButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                37, Short.MAX_VALUE)
                                                                .addContainerGap()));

                javax.swing.GroupLayout cantripsKnownSpellsPanelLayout =
                                new javax.swing.GroupLayout(cantripsKnownSpellsPanel);
                cantripsKnownSpellsPanel.setLayout(cantripsKnownSpellsPanelLayout);
                cantripsKnownSpellsPanelLayout.setHorizontalGroup(cantripsKnownSpellsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(cantripsKnownSpellsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(cantripsKnownSpellsPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(cantripsHeaderPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(exampleCantripsSpellPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                cantripsKnownSpellsPanelLayout.setVerticalGroup(cantripsKnownSpellsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                cantripsKnownSpellsPanelLayout
                                                                .createSequentialGroup()
                                                                .addComponent(cantripsHeaderPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(exampleCantripsSpellPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));

                levelOneKnownSpellsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                exampleCantripsSpellPanel1.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                exampleSpellName2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                exampleSpellName2.setText("characterSpellName");

                exampleSpellHitLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                exampleSpellHitLabel1.setText("99d999");

                exampleSpellRollButton1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                exampleSpellRollButton1.setText("DMG");
                exampleSpellRollButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                exampleSpellRollButton1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout exampleCantripsSpellPanel1Layout =
                                new javax.swing.GroupLayout(exampleCantripsSpellPanel1);
                exampleCantripsSpellPanel1.setLayout(exampleCantripsSpellPanel1Layout);
                exampleCantripsSpellPanel1Layout.setHorizontalGroup(exampleCantripsSpellPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(exampleCantripsSpellPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(exampleSpellName2,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                506, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(exampleSpellHitLabel1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                102,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(exampleSpellRollButton1)
                                                .addContainerGap()));
                exampleCantripsSpellPanel1Layout.setVerticalGroup(exampleCantripsSpellPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(exampleCantripsSpellPanel1Layout.createSequentialGroup()
                                                .addGroup(exampleCantripsSpellPanel1Layout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(exampleSpellName2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                65,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(exampleSpellHitLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                65,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(exampleCantripsSpellPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(exampleSpellRollButton1,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                Lvl1HeaderPanel.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));

                Lvl1HeaderLabel.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
                Lvl1HeaderLabel.setText("Level 1");
                Lvl1HeaderLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                Lvl1SpellSlotAvailableLabel.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
                Lvl1SpellSlotAvailableLabel.setText("99");
                Lvl1SpellSlotAvailableLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                jLabel4.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
                jLabel4.setText("/");
                jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                Lvl1SpellMaxLabel.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
                Lvl1SpellMaxLabel.setText("99");
                Lvl1SpellMaxLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

                Lvl1UpdateButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                Lvl1UpdateButton.setText("Update");
                Lvl1UpdateButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                Lvl1UpdateButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout Lvl1HeaderPanelLayout =
                                new javax.swing.GroupLayout(Lvl1HeaderPanel);
                Lvl1HeaderPanel.setLayout(Lvl1HeaderPanelLayout);
                Lvl1HeaderPanelLayout.setHorizontalGroup(Lvl1HeaderPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(Lvl1HeaderPanelLayout.createSequentialGroup()
                                                .addComponent(Lvl1HeaderLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Lvl1SpellSlotAvailableLabel)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Lvl1SpellMaxLabel)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Lvl1UpdateButton).addContainerGap()));
                Lvl1HeaderPanelLayout.setVerticalGroup(Lvl1HeaderPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lvl1HeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                .addComponent(Lvl1SpellSlotAvailableLabel,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                .addComponent(Lvl1SpellMaxLabel,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                Lvl1HeaderPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(Lvl1UpdateButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                37, Short.MAX_VALUE)
                                                                .addContainerGap()));

                javax.swing.GroupLayout levelOneKnownSpellsPanelLayout =
                                new javax.swing.GroupLayout(levelOneKnownSpellsPanel);
                levelOneKnownSpellsPanel.setLayout(levelOneKnownSpellsPanelLayout);
                levelOneKnownSpellsPanelLayout.setHorizontalGroup(levelOneKnownSpellsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(levelOneKnownSpellsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(levelOneKnownSpellsPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(Lvl1HeaderPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(exampleCantripsSpellPanel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                levelOneKnownSpellsPanelLayout.setVerticalGroup(levelOneKnownSpellsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                levelOneKnownSpellsPanelLayout
                                                                .createSequentialGroup()
                                                                .addComponent(Lvl1HeaderPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(exampleCantripsSpellPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));

                javax.swing.GroupLayout spellsListPanelLayout =
                                new javax.swing.GroupLayout(spellsListPanel);
                spellsListPanel.setLayout(spellsListPanelLayout);
                spellsListPanelLayout.setHorizontalGroup(spellsListPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(spellsListPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(spellsListPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(cantripsKnownSpellsPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(levelOneKnownSpellsPanel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(63, Short.MAX_VALUE)));
                spellsListPanelLayout.setVerticalGroup(spellsListPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(spellsListPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(cantripsKnownSpellsPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(levelOneKnownSpellsPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(334, Short.MAX_VALUE)));

                SpellsListScrollPane1.setViewportView(spellsListPanel);

                javax.swing.GroupLayout characterSpellsPanelLayout =
                                new javax.swing.GroupLayout(characterSpellsPanel);
                characterSpellsPanel.setLayout(characterSpellsPanelLayout);
                characterSpellsPanelLayout.setHorizontalGroup(characterSpellsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(characterSpellsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(characterSpellsPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(spellsHeaderPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(SpellsListScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                0,
                                                                                Short.MAX_VALUE))));
                characterSpellsPanelLayout.setVerticalGroup(characterSpellsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(characterSpellsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(spellsHeaderPanel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(SpellsListScrollPane1,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                487, Short.MAX_VALUE)
                                                .addContainerGap()));

                javax.swing.GroupLayout spellsPanelLayout =
                                new javax.swing.GroupLayout(spellsPanel);
                spellsPanel.setLayout(spellsPanelLayout);
                spellsPanelLayout.setHorizontalGroup(spellsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(spellsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(spellsPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(characterSpellsPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(spellsPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(spellsCharacterName,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                511,
                                                                                                Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(spellsCharacterClass,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                175,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(levellabelLabel4)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(spellsCharacterLevel)))
                                                .addContainerGap()));
                spellsPanelLayout.setVerticalGroup(spellsPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(spellsPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(spellsPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(spellsCharacterName,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(spellsCharacterClass,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(spellsCharacterLevel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(levellabelLabel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(characterSpellsPanel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                SheetTabs.addTab("Spells", spellsPanel);

                informationCharacterName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                informationCharacterName.setText("CharacterName");

                informationCharacterClass.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                informationCharacterClass.setText("CharacterClass");

                informationCharacterLevel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                informationCharacterLevel.setText("999");

                levellabelLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                levellabelLabel5.setText("Level: ");

                javax.swing.GroupLayout characterInformationPanelLayout =
                                new javax.swing.GroupLayout(characterInformationPanel);
                characterInformationPanel.setLayout(characterInformationPanelLayout);
                characterInformationPanelLayout.setHorizontalGroup(characterInformationPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 0, Short.MAX_VALUE));
                characterInformationPanelLayout.setVerticalGroup(characterInformationPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 651, Short.MAX_VALUE));

                infoCharacterClassPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                infoCharacterClassPanel1.setPreferredSize(new java.awt.Dimension(150, 150));

                infoCharacterClassLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                infoCharacterClassLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoCharacterClassLabel1.setText("Class");

                infoCharacterClassTextBox.setText("CharacterClass");
                infoCharacterClassTextBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                infoCharacterClassTextBox1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout infoCharacterClassPanel1Layout =
                                new javax.swing.GroupLayout(infoCharacterClassPanel1);
                infoCharacterClassPanel1.setLayout(infoCharacterClassPanel1Layout);
                infoCharacterClassPanel1Layout.setHorizontalGroup(infoCharacterClassPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoCharacterClassPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(infoCharacterClassPanel1Layout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(infoCharacterClassLabel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(infoCharacterClassTextBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                122,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                infoCharacterClassPanel1Layout.setVerticalGroup(infoCharacterClassPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoCharacterClassPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(infoCharacterClassLabel1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                27,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(infoCharacterClassTextBox)
                                                .addContainerGap()));

                infoCharacterClassPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                infoCharacterClassPanel3.setPreferredSize(new java.awt.Dimension(150, 79));

                infoCharacterClassLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                infoCharacterClassLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoCharacterClassLabel3.setText("Race");

                infoCharacterRaceTextBox.setText("characterRace");
                infoCharacterRaceTextBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                infoCharacterClassTextBox3ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout infoCharacterClassPanel3Layout =
                                new javax.swing.GroupLayout(infoCharacterClassPanel3);
                infoCharacterClassPanel3.setLayout(infoCharacterClassPanel3Layout);
                infoCharacterClassPanel3Layout.setHorizontalGroup(infoCharacterClassPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoCharacterClassPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(infoCharacterClassPanel3Layout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(infoCharacterClassLabel3,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(infoCharacterRaceTextBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                122,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                infoCharacterClassPanel3Layout.setVerticalGroup(infoCharacterClassPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoCharacterClassPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(infoCharacterClassLabel3,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                27,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(infoCharacterRaceTextBox,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                115, Short.MAX_VALUE)
                                                .addContainerGap()));

                infoCharacterClassPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                infoCharacterClassPanel4.setPreferredSize(new java.awt.Dimension(150, 79));

                infoCharacterClassLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                infoCharacterClassLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoCharacterClassLabel4.setText("Background");

                infoCharacterBackgroundTextBox.setText("characterBackground");
                infoCharacterBackgroundTextBox
                                .addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(
                                                        java.awt.event.ActionEvent evt) {
                                                infoCharacterClassTextBox4ActionPerformed(evt);
                                        }
                                });

                javax.swing.GroupLayout infoCharacterClassPanel4Layout =
                                new javax.swing.GroupLayout(infoCharacterClassPanel4);
                infoCharacterClassPanel4.setLayout(infoCharacterClassPanel4Layout);
                infoCharacterClassPanel4Layout.setHorizontalGroup(infoCharacterClassPanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoCharacterClassPanel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(infoCharacterClassPanel4Layout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(infoCharacterClassLabel4,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(infoCharacterBackgroundTextBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                122,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                infoCharacterClassPanel4Layout.setVerticalGroup(infoCharacterClassPanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoCharacterClassPanel4Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(infoCharacterClassLabel4,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                27,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(infoCharacterBackgroundTextBox,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                115, Short.MAX_VALUE)
                                                .addContainerGap()));

                infoCharacterClassPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                infoCharacterClassPanel5.setPreferredSize(new java.awt.Dimension(150, 79));

                infoCharacterClassLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                infoCharacterClassLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoCharacterClassLabel5.setText("Alignment");

                infoCharacterAlignmentTextBox.setText("characterAlignment");
                infoCharacterAlignmentTextBox
                                .addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(
                                                        java.awt.event.ActionEvent evt) {
                                                infoCharacterClassTextBox5ActionPerformed(evt);
                                        }
                                });

                javax.swing.GroupLayout infoCharacterClassPanel5Layout =
                                new javax.swing.GroupLayout(infoCharacterClassPanel5);
                infoCharacterClassPanel5.setLayout(infoCharacterClassPanel5Layout);
                infoCharacterClassPanel5Layout.setHorizontalGroup(infoCharacterClassPanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoCharacterClassPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(infoCharacterClassPanel5Layout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(infoCharacterClassLabel5,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(infoCharacterAlignmentTextBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                122,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                infoCharacterClassPanel5Layout.setVerticalGroup(infoCharacterClassPanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoCharacterClassPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(infoCharacterClassLabel5,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                27,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(infoCharacterAlignmentTextBox,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                115, Short.MAX_VALUE)
                                                .addContainerGap()));

                infoCharacterClassPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                infoCharacterClassPanel6.setPreferredSize(new java.awt.Dimension(150, 79));

                infoCharacterClassLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
                infoCharacterClassLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoCharacterClassLabel6.setText("Experience");

                infoCharacterXPTextBox.setText("characterExperience");
                infoCharacterXPTextBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                infoCharacterClassTextBox6ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout infoCharacterClassPanel6Layout =
                                new javax.swing.GroupLayout(infoCharacterClassPanel6);
                infoCharacterClassPanel6.setLayout(infoCharacterClassPanel6Layout);
                infoCharacterClassPanel6Layout.setHorizontalGroup(infoCharacterClassPanel6Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoCharacterClassPanel6Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(infoCharacterClassPanel6Layout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(infoCharacterClassLabel6,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(infoCharacterXPTextBox,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                122,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                infoCharacterClassPanel6Layout.setVerticalGroup(infoCharacterClassPanel6Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(infoCharacterClassPanel6Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(infoCharacterClassLabel6,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                27,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(infoCharacterXPTextBox,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                115, Short.MAX_VALUE)
                                                .addContainerGap()));

                javax.swing.GroupLayout infoHeaderPanelLayout =
                                new javax.swing.GroupLayout(infoHeaderPanel);
                infoHeaderPanel.setLayout(infoHeaderPanelLayout);
                infoHeaderPanelLayout.setHorizontalGroup(infoHeaderPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                infoHeaderPanelLayout.createSequentialGroup()
                                                                .addContainerGap(
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(infoCharacterClassPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(infoCharacterClassPanel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(infoCharacterClassPanel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(infoCharacterClassPanel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(infoCharacterClassPanel6,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(20, 20, 20)));
                infoHeaderPanelLayout.setVerticalGroup(infoHeaderPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(infoCharacterClassPanel1,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 176,
                                                Short.MAX_VALUE)
                                .addComponent(infoCharacterClassPanel3,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 176,
                                                Short.MAX_VALUE)
                                .addComponent(infoCharacterClassPanel4,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 176,
                                                Short.MAX_VALUE)
                                .addComponent(infoCharacterClassPanel5,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 176,
                                                Short.MAX_VALUE)
                                .addComponent(infoCharacterClassPanel6,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 176,
                                                Short.MAX_VALUE));

                jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

                jPanel3.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));
                jPanel3.setPreferredSize(new java.awt.Dimension(130, 96));

                jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("Platinum");

                infoPPValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                infoPPValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoPPValueLabel.setText("999");

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(jPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout
                                                .createSequentialGroup().addContainerGap()
                                                .addGroup(jPanel3Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(infoPPValueLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                104,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                jPanel3Layout.setVerticalGroup(jPanel3Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jLabel1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                44,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(infoPPValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                jPanel4.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));
                jPanel4.setPreferredSize(new java.awt.Dimension(130, 144));

                jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel5.setText("Gold");

                infoGPValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                infoGPValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoGPValueLabel.setText("999");

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(jPanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout
                                                .createSequentialGroup().addContainerGap()
                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(infoGPValueLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                104,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel5,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                jPanel4Layout.setVerticalGroup(jPanel4Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jLabel5,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                44,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(infoGPValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                jPanel5.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));
                jPanel5.setPreferredSize(new java.awt.Dimension(130, 144));

                jLabel7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel7.setText("Silver");

                infoSPValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                infoSPValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoSPValueLabel.setText("999");

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(jPanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout
                                                .createSequentialGroup().addContainerGap()
                                                .addGroup(jPanel5Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(infoSPValueLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                104,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel7,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                jPanel5Layout.setVerticalGroup(jPanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jLabel7,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                44,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(infoSPValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                62, Short.MAX_VALUE)
                                                .addContainerGap()));

                jPanel6.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));
                jPanel6.setPreferredSize(new java.awt.Dimension(130, 144));

                jLabel9.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel9.setText("Copper");

                infoCPValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                infoCPValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoCPValueLabel.setText("999");

                javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel6Layout);
                jPanel6Layout.setHorizontalGroup(jPanel6Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout
                                                .createSequentialGroup().addContainerGap()
                                                .addGroup(jPanel6Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(infoCPValueLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                104,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel9,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                jPanel6Layout.setVerticalGroup(jPanel6Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jLabel9,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                44,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(infoCPValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                62, Short.MAX_VALUE)
                                                .addContainerGap()));

                jPanel7.setBorder(javax.swing.BorderFactory
                                .createLineBorder(new java.awt.Color(0, 0, 0)));
                jPanel7.setPreferredSize(new java.awt.Dimension(130, 144));

                jLabel11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel11.setText("Electrum");

                infoEPValueLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                infoEPValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infoEPValueLabel.setText("999");

                javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
                jPanel7.setLayout(jPanel7Layout);
                jPanel7Layout.setHorizontalGroup(jPanel7Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout
                                                .createSequentialGroup().addContainerGap()
                                                .addGroup(jPanel7Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(infoEPValueLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                104,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabel11,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                jPanel7Layout.setVerticalGroup(jPanel7Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jLabel11,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                44,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(infoEPValueLabel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                62, Short.MAX_VALUE)
                                                .addContainerGap()));

                jButton1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
                jButton1.setText("Update");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jPanel3,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel4,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel5,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel6,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel7,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));
                jPanel2Layout.setVerticalGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 144,
                                                Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
                                                .addComponent(jButton1,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addContainerGap()));

                infoNotes.setColumns(20);
                infoNotes.setRows(5);
                jScrollPane1.setViewportView(infoNotes);

                javax.swing.GroupLayout informationPanelLayout =
                                new javax.swing.GroupLayout(informationPanel);
                informationPanel.setLayout(informationPanelLayout);
                informationPanelLayout.setHorizontalGroup(informationPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(informationPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(characterInformationPanel,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(informationPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(informationPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(informationCharacterName,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(informationCharacterClass,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                175,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(levellabelLabel5)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(informationCharacterLevel))
                                                                .addComponent(infoHeaderPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jScrollPane1))
                                                .addContainerGap()));
                informationPanelLayout.setVerticalGroup(informationPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(informationPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(informationPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(informationCharacterName,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(informationCharacterClass,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(informationCharacterLevel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(levellabelLabel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                46,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(informationPanelLayout
                                                                .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(characterInformationPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(informationPanelLayout
                                                                                .createSequentialGroup()
                                                                                .addComponent(infoHeaderPanel,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jPanel2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jScrollPane1)))
                                                .addContainerGap()));

                SheetTabs.addTab("Information", informationPanel);

                javax.swing.GroupLayout CSMainPanelLayout =
                                new javax.swing.GroupLayout(CSMainPanel);
                CSMainPanel.setLayout(CSMainPanelLayout);
                CSMainPanelLayout.setHorizontalGroup(CSMainPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(CSMainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(CSMainPanelLayout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(headerLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(SheetTabs,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                860,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(subheadingLabel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addContainerGap()));
                CSMainPanelLayout.setVerticalGroup(CSMainPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(CSMainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(headerLabel,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                70,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(subheadingLabel)
                                                .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SheetTabs).addContainerGap()));


                javax.swing.JScrollPane contentScroll = new javax.swing.JScrollPane(CSMainPanel);
                setContentPane(contentScroll);
                pack();



        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel ACLabel;
        private javax.swing.JPanel ACPanel;
        private javax.swing.JButton ACUpdateButton;
        private javax.swing.JLabel ACValueLabel;
        private javax.swing.JPanel CSMainPanel;
        private javax.swing.JLabel HPLabel;
        private javax.swing.JPanel HPPanel;
        private javax.swing.JButton HPUpdateButton;
        private javax.swing.JLabel HPValueLabel;
        private javax.swing.JLabel HitDiceLabel;
        private javax.swing.JPanel HitDicePanel;
        private javax.swing.JButton HitDiceUpdateButton;
        private javax.swing.JLabel HitDiceValueLabel;
        private javax.swing.JLabel Lvl1HeaderLabel;
        private javax.swing.JPanel Lvl1HeaderPanel;
        private javax.swing.JLabel Lvl1SpellMaxLabel;
        private javax.swing.JLabel Lvl1SpellSlotAvailableLabel;
        private javax.swing.JButton Lvl1UpdateButton;
        private javax.swing.JPanel ProficiencyPanel;
        private javax.swing.JTabbedPane SheetTabs;
        private javax.swing.JButton SoHCheckButton;
        private javax.swing.JLabel SpeedLabel;
        private javax.swing.JPanel SpeedPanel;
        private javax.swing.JButton SpeedUpdateButton;
        private javax.swing.JLabel SpeedValueLabel;
        private javax.swing.JScrollPane SpellsListScrollPane1;
        private javax.swing.JPanel StatsPanel;
        private javax.swing.JPanel abilitesReligionPanel;
        private javax.swing.JPanel abilitiesAcrobaticsPanel;
        private javax.swing.JPanel abilitiesAnimalHandlingPanel;
        private javax.swing.JPanel abilitiesArcanaPanel;
        private javax.swing.JPanel abilitiesAthleticsPanel;
        private javax.swing.JLabel abilitiesCharacterClass;
        private javax.swing.JLabel abilitiesCharacterLevel;
        private javax.swing.JLabel abilitiesCharacterName;
        private javax.swing.JPanel abilitiesCharismaPanel;
        private javax.swing.JPanel abilitiesCharismaSectionPanel;
        private javax.swing.JPanel abilitiesDeceptionPanel;
        private javax.swing.JPanel abilitiesDexterityPanel;
        private javax.swing.JPanel abilitiesDexteritySectionPanel;
        private javax.swing.JPanel abilitiesHistoryPanel;
        private javax.swing.JPanel abilitiesInsightPanel;
        private javax.swing.JPanel abilitiesIntelligencePanel;
        private javax.swing.JPanel abilitiesIntelligenceSectionPanel;
        private javax.swing.JPanel abilitiesIntimidationPanel;
        private javax.swing.JPanel abilitiesInvestigationPanel;
        private javax.swing.JPanel abilitiesMedicinePanel;
        private javax.swing.JPanel abilitiesNaturePanel;
        private javax.swing.JPanel abilitiesPanel;
        private javax.swing.JPanel abilitiesPerceptionPanel;
        private javax.swing.JPanel abilitiesPerformancePanel;
        private javax.swing.JPanel abilitiesPersuasion;
        private javax.swing.JPanel abilitiesSection;
        private javax.swing.JPanel abilitiesSoHPanel;
        private javax.swing.JPanel abilitiesStealthPanel;
        private javax.swing.JPanel abilitiesStrengthPanel;
        private javax.swing.JPanel abilitiesStrengthSectionPanel;
        private javax.swing.JPanel abilitiesSurvivalPanel;
        private javax.swing.JPanel abilitiesWisdomPanel;
        private javax.swing.JPanel abilitiesWisdomSectionPanel;
        private javax.swing.JButton acrobaticsCheckButton;
        private javax.swing.JButton animalHandlingCheckButton;
        private javax.swing.JButton arcanaCheck;
        private javax.swing.JButton athleticsCheckButton;
        private javax.swing.JLabel cantripsHeaderLabel;
        private javax.swing.JPanel cantripsHeaderPanel;
        private javax.swing.JPanel cantripsKnownSpellsPanel;
        private javax.swing.JLabel cantripsSpellMaxLabel;
        private javax.swing.JLabel cantripsSpellSlotAvailableLabel;
        private javax.swing.JButton cantripsUpdateButton;
        private javax.swing.JLabel charAcrobaticsLabel;
        private javax.swing.JLabel charAcrobaticsValueLabel;
        private javax.swing.JLabel charAnimalHandlingLabel;
        private javax.swing.JLabel charAnimalHandlingValueLabel;
        private javax.swing.JLabel charArcanaLabel;
        private javax.swing.JLabel charArcanaValueLabel;
        private javax.swing.JLabel charAthleticsLabel;
        private javax.swing.JLabel charAthleticsValueLabel;
        private javax.swing.JLabel charCharismaLabel;
        private javax.swing.JLabel charCharismaValueLabel;
        private javax.swing.JLabel charDeceptionLabel;
        private javax.swing.JLabel charDeceptionValueLabel;
        private javax.swing.JLabel charDexterityLabel;
        private javax.swing.JLabel charDexterityValueLabel;
        private javax.swing.JLabel charHistoryLabel;
        private javax.swing.JLabel charHistoryValueLabel;
        private javax.swing.JLabel charInsightLabel;
        private javax.swing.JLabel charInsightValueLabel;
        private javax.swing.JLabel charIntelligenceLabel;
        private javax.swing.JLabel charIntelligenceValueLabel;
        private javax.swing.JLabel charIntimidationLabel;
        private javax.swing.JLabel charIntimidationValueLabel;
        private javax.swing.JLabel charInvestigationLabel;
        private javax.swing.JLabel charInvestigationValueLabel;
        private javax.swing.JLabel charMedicineLabel;
        private javax.swing.JLabel charMedicineValueLabel;
        private javax.swing.JLabel charNatureLabel;
        private javax.swing.JLabel charNatureValueLabel;
        private javax.swing.JLabel charPerceptionLabel;
        private javax.swing.JLabel charPerceptionValueLabel;
        private javax.swing.JLabel charPerformanceLabel;
        private javax.swing.JLabel charPerformanceValueLabel;
        private javax.swing.JLabel charPersuasionLabel;
        private javax.swing.JLabel charPersuasionValueLabel;
        private javax.swing.JLabel charReligionLabel;
        private javax.swing.JLabel charReligionValueLabel;
        private javax.swing.JLabel charSoHLabel;
        private javax.swing.JLabel charSoHValueLabel;
        private javax.swing.JLabel charStealthLabel;
        private javax.swing.JLabel charStealthValueLabel;
        private javax.swing.JLabel charStrengthLabel;
        private javax.swing.JLabel charStrengthValueLabel;
        private javax.swing.JLabel charSurvivalLabel;
        private javax.swing.JLabel charSurvivalValueLabel;
        private javax.swing.JLabel charWisdomValueLabel;
        private javax.swing.JLabel charWisdomLabel;
        private javax.swing.JPanel characterInformationPanel;
        private javax.swing.JPanel characterSpellsPanel;
        private javax.swing.JPanel characterStatsPanel;
        private javax.swing.JPanel characterWeaponsPanel;
        private javax.swing.JPanel charicterAttributesPanel;
        private javax.swing.JButton charismaCheckButton;
        private javax.swing.JPanel charismaPanel;
        private javax.swing.JPanel constitutionPanel;
        private javax.swing.JButton deceptionCheckButton;
        private javax.swing.JButton dexterityCheckButton;
        private javax.swing.JPanel dexterityPanel;
        private javax.swing.JPanel exampleCantripsSpellPanel;
        private javax.swing.JPanel exampleCantripsSpellPanel1;
        private javax.swing.JLabel exampleSpellHitLabel;
        private javax.swing.JLabel exampleSpellHitLabel1;
        private javax.swing.JLabel exampleSpellName1;
        private javax.swing.JLabel exampleSpellName2;
        private javax.swing.JButton exampleSpellRollButton;
        private javax.swing.JButton exampleSpellRollButton1;
        private javax.swing.JLabel exampleWeaponDamageRoll;
        private javax.swing.JLabel exampleWeaponDamageType;
        private javax.swing.JLabel exampleWeaponName;
        private javax.swing.JPanel exampleWeaponPanel;
        private javax.swing.JLabel exampleWeaponProficiency;
        private javax.swing.JButton exampleWeaponRollDamage;
        private javax.swing.JButton exampleWeaponRollHit;
        private javax.swing.JLabel exampleWeaponRange;
        private javax.swing.JLabel headerLabel;
        private javax.swing.JButton historyCheck;
        private javax.swing.JLabel infoCharacterClassLabel1;
        private javax.swing.JLabel infoCharacterClassLabel3;
        private javax.swing.JLabel infoCharacterClassLabel4;
        private javax.swing.JLabel infoCharacterClassLabel5;
        private javax.swing.JLabel infoCharacterClassLabel6;
        private javax.swing.JPanel infoCharacterClassPanel1;
        private javax.swing.JPanel infoCharacterClassPanel3;
        private javax.swing.JPanel infoCharacterClassPanel4;
        private javax.swing.JPanel infoCharacterClassPanel5;
        private javax.swing.JPanel infoCharacterClassPanel6;
        private javax.swing.JTextField infoCharacterClassTextBox;
        private javax.swing.JTextField infoCharacterRaceTextBox;
        private javax.swing.JTextField infoCharacterBackgroundTextBox;
        private javax.swing.JTextField infoCharacterAlignmentTextBox;
        private javax.swing.JTextField infoCharacterXPTextBox;
        private javax.swing.JPanel infoHeaderPanel;
        private javax.swing.JLabel informationCharacterName;
        private javax.swing.JLabel informationCharacterClass;
        private javax.swing.JLabel informationCharacterLevel;
        private javax.swing.JPanel informationPanel;
        private javax.swing.JButton insightCheckButton;
        private javax.swing.JButton intelligenceCheck;
        private javax.swing.JPanel intelligencePanel;
        private javax.swing.JButton intimidationCheckButton;
        private javax.swing.JButton investigationCheck;
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel infoCPValueLabel;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel infoEPValueLabel;
        private javax.swing.JLabel infoPPValueLabel;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel infoGPValueLabel;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel infoSPValueLabel;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        private javax.swing.JPanel jPanel7;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextArea infoNotes;
        private javax.swing.JPanel levelOneKnownSpellsPanel;
        private javax.swing.JLabel levellabelLabel;
        private javax.swing.JLabel levellabelLabel2;
        private javax.swing.JLabel levellabelLabel3;
        private javax.swing.JLabel levellabelLabel4;
        private javax.swing.JLabel levellabelLabel5;
        private javax.swing.JButton medicineCheckButton;
        private javax.swing.JButton natureCheck;
        private javax.swing.JButton perceptionCheckButton;
        private javax.swing.JButton performanceCheckButton;
        private javax.swing.JButton persuasionCheckButton;
        private javax.swing.JLabel proficiencyLabel;
        private javax.swing.JButton proficiencyUpdateButton;
        private javax.swing.JLabel proficiencyValueLabel;
        private javax.swing.JButton religionCheck;
        private javax.swing.JLabel spellsAttackLabel;
        private javax.swing.JPanel spellsAttackPanel;
        private javax.swing.JLabel spellsAttackValueLabel;
        private javax.swing.JButton spellsAttackValueUpdateButton;
        private javax.swing.JLabel spellsCLevelLabel;
        private javax.swing.JPanel spellsCLevelPanle;
        private javax.swing.JButton spellsCLevelUpdateButton;
        private javax.swing.JLabel spellsCLevelValueLabel;
        private javax.swing.JLabel spellsCharacterClass;
        private javax.swing.JLabel spellsCharacterLevel;
        private javax.swing.JLabel spellsCharacterName;
        private javax.swing.JLabel spellsDCLabel;
        private javax.swing.JPanel spellsDCPanel;
        private javax.swing.JButton spellsDCUpdateButton;
        private javax.swing.JLabel spellsDCValueLabel;
        private javax.swing.JPanel spellsHeaderPanel;
        private javax.swing.JPanel spellsListPanel;
        private javax.swing.JPanel spellsPanel;
        private javax.swing.JButton spellsUpdateButton;
        private javax.swing.JLabel statsCharacterClass;
        private javax.swing.JLabel statsCharacterLevel;
        private javax.swing.JLabel statsCharacterName;
        private javax.swing.JButton stealthCheck;
        private javax.swing.JButton strengthCheckButton;
        private javax.swing.JLabel strengthLabel;
        private javax.swing.JLabel strengthLabel2;
        private javax.swing.JLabel strengthLabel3;
        private javax.swing.JLabel strengthLabel4;
        private javax.swing.JLabel strengthLabel5;
        private javax.swing.JLabel strengthLabel6;
        private javax.swing.JLabel strengthModifierLabel;
        private javax.swing.JLabel strengthModifierLabel1;
        private javax.swing.JLabel strengthModifierLabel2;
        private javax.swing.JLabel strengthModifierLabel3;
        private javax.swing.JLabel strengthModifierLabel4;
        private javax.swing.JLabel strengthModifierLabel5;
        private javax.swing.JPanel strengthModifierPanel;
        private javax.swing.JPanel strengthModifierPanel1;
        private javax.swing.JPanel strengthModifierPanel2;
        private javax.swing.JPanel strengthModifierPanel3;
        private javax.swing.JPanel strengthModifierPanel4;
        private javax.swing.JPanel strengthModifierPanel5;
        private javax.swing.JLabel strengthModifierValueLabel;
        private javax.swing.JLabel intelligenceModifierValueLabel;
        private javax.swing.JLabel wisdomModifierValueLabel;
        private javax.swing.JLabel dexterityModifierValueLabel;
        private javax.swing.JLabel charismaModifierValueLabel;
        private javax.swing.JLabel constitutionModifierValueLabel;
        private javax.swing.JPanel strengthPanel;
        private javax.swing.JLabel strengthSaveLabel;
        private javax.swing.JLabel strengthSaveLabel2;
        private javax.swing.JLabel strengthSaveLabel3;
        private javax.swing.JLabel strengthSaveLabel4;
        private javax.swing.JLabel strengthSaveLabel5;
        private javax.swing.JLabel strengthSaveLabel6;
        private javax.swing.JPanel strengthSavePanel;
        private javax.swing.JPanel strengthSavePanel2;
        private javax.swing.JPanel strengthSavePanel3;
        private javax.swing.JPanel strengthSavePanel4;
        private javax.swing.JPanel strengthSavePanel5;
        private javax.swing.JPanel strengthSavePanel6;
        private javax.swing.JLabel strengthSaveValueLabel;
        private javax.swing.JLabel intelligenceSaveValueLabel;
        private javax.swing.JLabel wisdomSaveValueLabel;
        private javax.swing.JLabel dexteritySaveValueLabel;
        private javax.swing.JLabel charismaSaveValueLabel;
        private javax.swing.JLabel constitutionSaveValueLabel;
        private javax.swing.JLabel strengthScoreLabel;
        private javax.swing.JLabel strengthScoreLabel1;
        private javax.swing.JLabel strengthScoreLabel2;
        private javax.swing.JLabel strengthScoreLabel3;
        private javax.swing.JLabel strengthScoreLabel4;
        private javax.swing.JLabel strengthScoreLabel5;
        private javax.swing.JPanel strengthScorePanel;
        private javax.swing.JPanel strengthScorePanel1;
        private javax.swing.JPanel strengthScorePanel2;
        private javax.swing.JPanel strengthScorePanel3;
        private javax.swing.JPanel strengthScorePanel4;
        private javax.swing.JPanel strengthScorePanel5;
        private javax.swing.JLabel strengthScoreValueLabel;
        private javax.swing.JLabel intelligenceScoreValueLabel;
        private javax.swing.JLabel wisdomScoreValueLabel;
        private javax.swing.JLabel dexterityScoreValueLabel;
        private javax.swing.JLabel charismaScoreValueLabel;
        private javax.swing.JLabel constitutionScoreValueLabel;
        private javax.swing.JLabel subheadingLabel;
        private javax.swing.JButton survivalCheckButton;
        private javax.swing.JButton updateCharismaButton;
        private javax.swing.JButton updateConstitutionButton;
        private javax.swing.JButton updateDexterityButton;
        private javax.swing.JButton updateIntelligenceButton;
        private javax.swing.JButton updateStrengthButton;
        private javax.swing.JButton updateWisdomButton;
        private javax.swing.JLabel weaponProficienctLabel;
        private javax.swing.JPanel weaponProficiencyPanel;
        private javax.swing.JButton weaponProficiencyUpdateButton;
        private javax.swing.JLabel weaponProficiencyValueLabel;
        private javax.swing.JLabel weaponResourceValueLabel;
        private javax.swing.JLabel weaponResourceLabel;
        private javax.swing.JPanel weaponResourcePanel;
        private javax.swing.JButton weaponResourceUpdateButton;
        private javax.swing.JLabel weaponStrengthLabel;
        private javax.swing.JPanel weaponStrengthPanel;
        private javax.swing.JButton weaponStrengthUpdateButton;
        private javax.swing.JLabel weaponStrengthValueLable;
        private javax.swing.JLabel weaponsCharacterClass;
        private javax.swing.JLabel weaponsCharacterLevel;
        private javax.swing.JLabel weaponsCharacterName;
        private javax.swing.JPanel weaponsHeaderPanel;
        private javax.swing.JPanel weaponsListPanel;
        private javax.swing.JScrollPane weaponsListScrollPane;
        private javax.swing.JPanel weaponsPanel;
        private javax.swing.JButton weaponsUpdateButton;
        private javax.swing.JButton wisdomCheckButton;
        private javax.swing.JPanel wisdomPanel;
        private javax.swing.JScrollPane statsScrollPane;
        private javax.swing.JScrollPane abilitiesScrollPane;
        private javax.swing.JScrollPane weaponsScrollPane;
        private javax.swing.JScrollPane spellsScrollPane;
        private javax.swing.JScrollPane infoScrollPane;
        // End of variables declaration//GEN-END:variables
}
