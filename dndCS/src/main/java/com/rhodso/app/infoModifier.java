package com.rhodso.app;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author rhodso
 */
public class infoModifier extends javax.swing.JFrame {

    private static final long serialVersionUID = 8515026757606508142L;

    CharacterSheet c;
    Player p;

    public infoModifier(Player _p) {
        this.p = _p;
        initComponents();
        setComponentValues(p);

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

    public void setComponentValues(Player _p) {
        // Currency
        platinumInput.setText(Integer.toString(p.getPP()));
        goldInput.setText(Integer.toString(p.getGP()));
        silverInput.setText(Integer.toString(p.getSP()));
        copperInput.setText(Integer.toString(p.getCP()));
        electrumInput.setText(Integer.toString(p.getEP()));

        // Other info
        charClassInput.setText(p.getChrSubclass() + " " + p.getChrClass());
        charRaceInput.setText(p.getRace());
        charBackgroundInput.setText(p.getBackground());
        charAlignmentInput.setText(p.getAlignment());
        charLevelInput.setText(Integer.toString(p.getLvl()));

    }

    public void getComponentValues() throws Exception {
        String[] chrClassCheck = charClassInput.getText().split(" ");
        if (chrClassCheck.length == 2) { // Indicating subclass then class
            // Currency
            p.setPP(Integer.parseInt(platinumInput.getText()));
            p.setGP(Integer.parseInt(goldInput.getText()));
            p.setSP(Integer.parseInt(silverInput.getText()));
            p.setCP(Integer.parseInt(copperInput.getText()));
            p.setEP(Integer.parseInt(electrumInput.getText()));
            p.setChrSubclass(chrClassCheck[0].replace(" ", ""));
            p.setChrClass(chrClassCheck[1].replace(" ", ""));
            p.setRace(charRaceInput.getText());
            p.setBackground(charBackgroundInput.getText());
            p.setAlignment(charAlignmentInput.getText());
            p.setLvl(p.getLvl());
        } else {
            JOptionPane.showMessageDialog(mainPanel,
                    "Unable to parse class. Please enter your class as \"[subclass] [class]\"",
                    "Error parsing class", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
    }

    public void save() {
        try {
            getComponentValues();
            CharacterSheet c = new CharacterSheet();
            c.SaveSheet(p);
            c.loadUI(p);

            // Dispose of the window
            this.dispose();

        } catch (Exception e) {

        }
    }

    public void cancel() {
        CharacterSheet c = new CharacterSheet();
        c.SaveSheet(p);
        c.loadUI(p);

        // Dispose of the window
        this.dispose();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        mainScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        subheadingLabel = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        currencyPanel = new javax.swing.JPanel();
        platinumPanel = new javax.swing.JPanel();
        platinumLabel = new javax.swing.JLabel();
        platinumInput = new javax.swing.JTextField();
        goldPanel = new javax.swing.JPanel();
        goldLabel = new javax.swing.JLabel();
        goldInput = new javax.swing.JTextField();
        copperPanel = new javax.swing.JPanel();
        copperLabel = new javax.swing.JLabel();
        copperInput = new javax.swing.JTextField();
        silverPanel = new javax.swing.JPanel();
        silverLabel = new javax.swing.JLabel();
        silverInput = new javax.swing.JTextField();
        electrumPanel = new javax.swing.JPanel();
        electrumLabel = new javax.swing.JLabel();
        electrumInput = new javax.swing.JTextField();
        currencyLabel = new javax.swing.JLabel();
        charInfoPanel = new javax.swing.JPanel();
        charClassLabel = new javax.swing.JLabel();
        charClassInput = new javax.swing.JTextField();
        charRaceLabel = new javax.swing.JLabel();
        charRaceInput = new javax.swing.JTextField();
        charAlignmentLabel = new javax.swing.JLabel();
        charAlignmentInput = new javax.swing.JTextField();
        charBackgroundLabel = new javax.swing.JLabel();
        charBackgroundInput = new javax.swing.JTextField();
        charLevelLabel = new javax.swing.JLabel();
        charLevelInput = new javax.swing.JTextField();
        buttonPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerLabel.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("DnD Character Sheet");
        headerLabel.setToolTipText("");
        headerLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        subheadingLabel.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        subheadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subheadingLabel.setText("But you don't have to pay for it");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(headerPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(headerPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(headerPanelLayout.createSequentialGroup()
                                        .addComponent(headerLabel,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 492,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 68, Short.MAX_VALUE))
                                .addComponent(subheadingLabel,
                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap()));
        headerPanelLayout.setVerticalGroup(headerPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPanelLayout.createSequentialGroup().addContainerGap()
                        .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subheadingLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        currencyPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        platinumLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        platinumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        platinumLabel.setText("Platinum");

        platinumInput.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        platinumInput.setText("9999");

        javax.swing.GroupLayout platinumPanelLayout = new javax.swing.GroupLayout(platinumPanel);
        platinumPanel.setLayout(platinumPanelLayout);
        platinumPanelLayout.setHorizontalGroup(
                platinumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(platinumInput).addComponent(platinumLabel,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        platinumPanelLayout.setVerticalGroup(
                platinumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(platinumPanelLayout.createSequentialGroup()
                                .addComponent(platinumLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(platinumInput)));

        goldLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        goldLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        goldLabel.setText("Gold");

        goldInput.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        goldInput.setText("9998");

        javax.swing.GroupLayout goldPanelLayout = new javax.swing.GroupLayout(goldPanel);
        goldPanel.setLayout(goldPanelLayout);
        goldPanelLayout.setHorizontalGroup(
                goldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(goldInput).addComponent(goldLabel,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        goldPanelLayout.setVerticalGroup(
                goldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(goldPanelLayout.createSequentialGroup()
                                .addComponent(goldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(goldInput)));

        copperLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        copperLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copperLabel.setText("Copper");

        copperInput.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        copperInput.setText("9996");

        javax.swing.GroupLayout copperPanelLayout = new javax.swing.GroupLayout(copperPanel);
        copperPanel.setLayout(copperPanelLayout);
        copperPanelLayout.setHorizontalGroup(
                copperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(copperInput).addComponent(copperLabel,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        copperPanelLayout.setVerticalGroup(
                copperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(copperPanelLayout.createSequentialGroup()
                                .addComponent(copperLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(copperInput)));

        silverLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        silverLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        silverLabel.setText("Silver");

        silverInput.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        silverInput.setText("9997");

        javax.swing.GroupLayout silverPanelLayout = new javax.swing.GroupLayout(silverPanel);
        silverPanel.setLayout(silverPanelLayout);
        silverPanelLayout.setHorizontalGroup(
                silverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(silverInput).addComponent(silverLabel,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        silverPanelLayout.setVerticalGroup(
                silverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(silverPanelLayout.createSequentialGroup()
                                .addComponent(silverLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(silverInput)));

        electrumLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        electrumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        electrumLabel.setText("Electrum");

        electrumInput.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        electrumInput.setText("9995");

        javax.swing.GroupLayout electrumPanelLayout = new javax.swing.GroupLayout(electrumPanel);
        electrumPanel.setLayout(electrumPanelLayout);
        electrumPanelLayout.setHorizontalGroup(
                electrumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(electrumInput).addComponent(electrumLabel,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        electrumPanelLayout.setVerticalGroup(
                electrumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(electrumPanelLayout.createSequentialGroup()
                                .addComponent(electrumLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(electrumInput)));

        javax.swing.GroupLayout currencyPanelLayout = new javax.swing.GroupLayout(currencyPanel);
        currencyPanel.setLayout(currencyPanelLayout);
        currencyPanelLayout.setHorizontalGroup(currencyPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, currencyPanelLayout
                        .createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(platinumPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(goldPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(silverPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(copperPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(electrumPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)));
        currencyPanelLayout.setVerticalGroup(currencyPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(currencyPanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(currencyPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(electrumPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(copperPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(silverPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(goldPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(platinumPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        currencyLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        currencyLabel.setText("Currency");

        charInfoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        charClassLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        charClassLabel.setText("Class");

        charClassInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        charClassInput.setText("playerClass");

        charRaceLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        charRaceLabel.setText("Race");

        charRaceInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        charRaceInput.setText("playerRace");

        charAlignmentLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        charAlignmentLabel.setText("Alignment");

        charAlignmentInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        charAlignmentInput.setText("playerAlignment");

        charBackgroundLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        charBackgroundLabel.setText("Background");

        charBackgroundInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        charBackgroundInput.setText("playerBackground");

        charLevelLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        charLevelLabel.setText("Level");

        charLevelInput.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        charLevelInput.setText("playerLevel");

        javax.swing.GroupLayout charInfoPanelLayout = new javax.swing.GroupLayout(charInfoPanel);
        charInfoPanel.setLayout(charInfoPanelLayout);
        charInfoPanelLayout.setHorizontalGroup(charInfoPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(charInfoPanelLayout.createSequentialGroup().addGroup(charInfoPanelLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(charInfoPanelLayout.createSequentialGroup().addGap(23, 23, 23)
                                .addGroup(charInfoPanelLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(charClassLabel,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(charRaceLabel,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(charAlignmentLabel,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(charBackgroundLabel,
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(charLevelLabel, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(charInfoPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(charLevelInput).addComponent(charAlignmentInput)
                                .addComponent(charBackgroundInput).addComponent(charRaceInput)
                                .addComponent(charClassInput, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        343, Short.MAX_VALUE))
                        .addContainerGap()));
        charInfoPanelLayout.setVerticalGroup(charInfoPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(charInfoPanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(charInfoPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(charClassLabel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(charClassInput))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(charInfoPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(charRaceLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(charRaceInput))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(charInfoPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(charBackgroundLabel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(charBackgroundInput))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(charInfoPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(charAlignmentLabel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(charAlignmentInput))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(charInfoPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(charLevelLabel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(charLevelInput))
                        .addContainerGap()));

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(infoPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(infoPanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(infoPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(currencyLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(charInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(currencyPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
        infoPanelLayout.setVerticalGroup(infoPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(infoPanelLayout.createSequentialGroup().addContainerGap()
                        .addComponent(currencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currencyPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(charInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

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

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(buttonPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        buttonPanelLayout.createSequentialGroup().addContainerGap()
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        buttonPanelLayout.setVerticalGroup(buttonPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(buttonPanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(buttonPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 78,
                                        Short.MAX_VALUE)
                                .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap()));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(mainPanelLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup().addGroup(mainPanelLayout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup().addGroup(mainPanelLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        false)
                                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(headerPanel, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap()));
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup().addContainerGap()
                                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        mainScrollPane.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addContainerGap()
                                .addComponent(mainScrollPane).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addContainerGap()
                                .addComponent(mainScrollPane).addContainerGap()));

        pack();
    }// </editor-fold>

    // Variables declaration - do not modify
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField charAlignmentInput;
    private javax.swing.JLabel charAlignmentLabel;
    private javax.swing.JTextField charBackgroundInput;
    private javax.swing.JLabel charBackgroundLabel;
    private javax.swing.JTextField charClassInput;
    private javax.swing.JLabel charClassLabel;
    private javax.swing.JPanel charInfoPanel;
    private javax.swing.JTextField charLevelInput;
    private javax.swing.JLabel charLevelLabel;
    private javax.swing.JTextField charRaceInput;
    private javax.swing.JLabel charRaceLabel;
    private javax.swing.JTextField copperInput;
    private javax.swing.JLabel copperLabel;
    private javax.swing.JPanel copperPanel;
    private javax.swing.JLabel currencyLabel;
    private javax.swing.JPanel currencyPanel;
    private javax.swing.JTextField electrumInput;
    private javax.swing.JLabel electrumLabel;
    private javax.swing.JPanel electrumPanel;
    private javax.swing.JTextField goldInput;
    private javax.swing.JLabel goldLabel;
    private javax.swing.JPanel goldPanel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JTextField platinumInput;
    private javax.swing.JLabel platinumLabel;
    private javax.swing.JPanel platinumPanel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField silverInput;
    private javax.swing.JLabel silverLabel;
    private javax.swing.JPanel silverPanel;
    private javax.swing.JLabel subheadingLabel;
    // End of variables declaration
}
