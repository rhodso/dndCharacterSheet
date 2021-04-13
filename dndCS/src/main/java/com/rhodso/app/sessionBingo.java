/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rhodso.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;

/**
 *
 * @author rhodso
 */
public class sessionBingo extends javax.swing.JPanel {

    private javax.swing.JButton buttonArray[];
    private int buttonState[];

    /** Creates new form sessionBingo */
    public sessionBingo() {
        // Setup button arrays
        buttonArray = new javax.swing.JButton[26];
        buttonState = new int[26];

        // Init components
        initComponents();

        // Set states
        for (int i = 1; i < buttonArray.length; i++) {
            buttonArray[i].setMaximumSize(new Dimension(100, 100));
            setButtonState(i);
        }

        // Get button text
        String lines[] = { "" };

        // Get list
        ArrayList<String> tmp = new ArrayList<>();
        String[] l = bingoLines.getLines();

        // Shuffle and convert
        for (String s : l) {
            tmp.add(s);
        }
        Collections.shuffle(tmp);
        lines = new String[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            lines[i] = tmp.get(i);
        }

        // I wanted to do this with a text file but it wasn't
        // working very well

        // Set text
        Font f = buttonArray[1].getFont();
        for (int i = 1; i < buttonArray.length; i++) {

            String buttonText = "<html><center>";

            if (i == 12) {
                buttonText += "Free Space";
            } else {
                buttonText += lines[i];
            }

            if (lines[i].length() > 25) {
                buttonArray[i].setFont(new Font(f.getName(), f.getStyle(), 8));
            } else {
                buttonArray[i].setFont(new Font(f.getName(), f.getStyle(), 10));
            }

            buttonText += "</center></html>";
            buttonArray[i].setText(buttonText);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents

    private void jbutton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbutton2ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jbutton2ActionPerformed

    private void jbutton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbutton3ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jbutton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton4ActionPerformed

    private void jbutton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbutton1ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jbutton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton7ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton8ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton9ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton6ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton10ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton11ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton12ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton13ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton14ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton15ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton16ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton17ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton18ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton19ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton20ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton21ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton22ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton23ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton24ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton25ActionPerformed
        incrementButtonState((JButton) evt.getSource());
    }// GEN-LAST:event_jButton25ActionPerformed

    // Increment the state of the button
    void incrementButtonState(JButton _sender) {

        // Get index of button in the array
        int idx = 0;
        for (JButton b : buttonArray) {
            if (b == _sender) {
                break;
            } else {
                idx++;
            }
        }

        // Increment but not over 4
        if (buttonState[idx] == 3) {
            buttonState[idx] = 0;
        } else {
            buttonState[idx]++;
        }

        // Set state
        setButtonState(idx);

        // JOptionPane.showMessageDialog(mainPanel, "Test " + _sender.getText() + "
        // index " + idx);
    }

    // Change state of button
    // 0 - Set the button colour scheme to White background, Black text
    // 1 - Set the button colour scheme to Red background, White text
    // 2 - Set the button colour scheme to Orange background, White text
    // 3 - Set the button colour scheme to Greed background, Black text
    void setButtonState(int idx) {
        // Set button colours
        switch (buttonState[idx]) {
        case 0:
            buttonArray[idx].setBackground(Color.WHITE);
            buttonArray[idx].setForeground(Color.BLACK);
            break;
        case 1:
            buttonArray[idx].setBackground(Color.RED);
            buttonArray[idx].setForeground(Color.WHITE);
            break;
        case 2:
            buttonArray[idx].setBackground(Color.ORANGE);
            buttonArray[idx].setForeground(Color.WHITE);
            break;
        case 3:
            buttonArray[idx].setBackground(Color.GREEN);
            buttonArray[idx].setForeground(Color.BLACK);
            break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JLabel HeaderLabel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

    private void initComponents() {

        ScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        HeaderPanel = new javax.swing.JPanel();
        HeaderLabel = new javax.swing.JLabel();
        ButtonPanel = new javax.swing.JPanel();
        buttonArray[1] = new javax.swing.JButton();
        buttonArray[2] = new javax.swing.JButton();
        buttonArray[3] = new javax.swing.JButton();
        buttonArray[4] = new javax.swing.JButton();
        buttonArray[5] = new javax.swing.JButton();
        buttonArray[6] = new javax.swing.JButton();
        buttonArray[7] = new javax.swing.JButton();
        buttonArray[8] = new javax.swing.JButton();
        buttonArray[9] = new javax.swing.JButton();
        buttonArray[10] = new javax.swing.JButton();
        buttonArray[11] = new javax.swing.JButton();
        buttonArray[12] = new javax.swing.JButton();
        buttonArray[13] = new javax.swing.JButton();
        buttonArray[14] = new javax.swing.JButton();
        buttonArray[15] = new javax.swing.JButton();
        buttonArray[16] = new javax.swing.JButton();
        buttonArray[17] = new javax.swing.JButton();
        buttonArray[18] = new javax.swing.JButton();
        buttonArray[19] = new javax.swing.JButton();
        buttonArray[20] = new javax.swing.JButton();
        buttonArray[21] = new javax.swing.JButton();
        buttonArray[22] = new javax.swing.JButton();
        buttonArray[23] = new javax.swing.JButton();
        buttonArray[24] = new javax.swing.JButton();
        buttonArray[25] = new javax.swing.JButton();

        for (int i = 1; i < buttonArray.length; i++) {
            buttonArray[i].setMaximumSize(new Dimension(100, 100));
            buttonArray[i].setMinimumSize(new Dimension(100, 100));
            buttonArray[i].setPreferredSize(new Dimension(100, 100));
            buttonArray[i].setMargin(new Insets(1, 1, 1, 1));
        }

        HeaderLabel.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        HeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeaderLabel.setText("DnD Session Bingo");

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(HeaderPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HeaderPanelLayout.createSequentialGroup().addContainerGap().addComponent(HeaderLabel,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()));
        HeaderPanelLayout
                .setVerticalGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HeaderPanelLayout.createSequentialGroup().addContainerGap()
                                .addComponent(HeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                .addContainerGap()));

        buttonArray[1].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton1ActionPerformed(evt);
            }
        });

        buttonArray[2].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton2ActionPerformed(evt);
            }
        });

        buttonArray[3].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton3ActionPerformed(evt);
            }
        });

        buttonArray[4].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buttonArray[5].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        buttonArray[6].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        buttonArray[7].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        buttonArray[8].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        buttonArray[9].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        buttonArray[10].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        buttonArray[11].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        buttonArray[12].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        buttonArray[13].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        buttonArray[14].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        buttonArray[15].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        buttonArray[16].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        buttonArray[17].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        buttonArray[18].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        buttonArray[19].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        buttonArray[20].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        buttonArray[21].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        buttonArray[22].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        buttonArray[23].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        buttonArray[24].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        buttonArray[25].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonPanelLayout = new javax.swing.GroupLayout(ButtonPanel);
        ButtonPanel.setLayout(ButtonPanelLayout);
        ButtonPanelLayout.setHorizontalGroup(ButtonPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ButtonPanelLayout.createSequentialGroup().addContainerGap().addGroup(ButtonPanelLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonPanelLayout.createSequentialGroup()
                                .addGap(0, 0,
                                        Short.MAX_VALUE)
                                .addGroup(ButtonPanelLayout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonPanelLayout
                                                .createSequentialGroup()
                                                .addComponent(buttonArray[14], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[13], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[12], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[15], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[11], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonPanelLayout
                                                .createSequentialGroup()
                                                .addComponent(buttonArray[20], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[19], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[17], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[16], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[18], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(ButtonPanelLayout.createSequentialGroup()
                                .addGroup(ButtonPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ButtonPanelLayout.createSequentialGroup()
                                                .addComponent(buttonArray[2], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[3], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[4], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[1], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[5], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(ButtonPanelLayout.createSequentialGroup()
                                                .addComponent(buttonArray[7], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[8], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[9], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[6], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[10], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(ButtonPanelLayout.createSequentialGroup()
                                                .addComponent(buttonArray[25], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[24], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[22], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[21], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonArray[23], javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap()));
        ButtonPanelLayout.setVerticalGroup(ButtonPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ButtonPanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonArray[2], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[3], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[4], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[1], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[5], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonArray[7], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[8], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[9], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[6], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[10], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonArray[14], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[13], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[12], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[15], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[11], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonArray[20], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[19], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[17], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[16], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[18], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buttonArray[25], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[24], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[22], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[21], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonArray[23], javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(mainPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(HeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
                        .addComponent(HeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        ScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

}
