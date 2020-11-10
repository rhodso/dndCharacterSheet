package com.rhodso.app;

public class CharacterSheet {
    private String sheetFP;
    private CharacterSheetUI ui;

    public Player loadSheet(String sheetFP) {
        System.out.println("Filepath = " + sheetFP);
        // Settings.setLastFile(sheetFP);
        ui = new CharacterSheetUI();
        ui.setVisible(true);

        Player p = new Player();

        // TODO populate player with data from JSON

        return null;
    }

    /**
     * @return the sheetFP
     */
    public String getSheetFP() {
        return sheetFP;
    }

    /**
     * @param sheetFP the sheetFP to set
     */
    public void setSheetFP(String sheetFP) {
        this.sheetFP = sheetFP;
    }

    /**
     * 
     */
    public CharacterSheet() {
    }

    /**
     * @param sheetFP
     */
    public CharacterSheet(String sheetFP) {
        this.sheetFP = sheetFP;
    }


}
