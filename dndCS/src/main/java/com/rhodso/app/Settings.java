package com.rhodso.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class Settings {
    private static boolean critFailsIgnoreMods;
    private static boolean darkMode;

    /**
     * @return the critFailsIgnoreMods
     */
    public static boolean isCritFailsIgnoreMods() {
        return critFailsIgnoreMods;
    }

    /**
     * @return the lastFile
     */
    public static String getLastFile() {
        String lf = "";
        try {
            BufferedReader br =
                    new BufferedReader(new FileReader(new File("dndCS/settings/lastFile.txt")));
            // Try to read file
            String line = br.readLine();
            br.close();
            if (line == null || line.equals("")) {
                lf = ".";
            } else {
                lf = line;
            }
        } catch (Exception e) {
            System.out.println("Error lol");
            System.out.println(e.getMessage());
            lf = ".";
        }
        return lf;
    }

    /**
     * @param lastFile the lastFile to set
     */
    public static void setLastFile(String lastFile) {
        try {
            File f = new File("dndCS/settings/lastFile.txt");
            FileOutputStream os = new FileOutputStream(f.getAbsolutePath());
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
            byte[] strBytes = lastFile.getBytes();
            os.write(strBytes);
            os.close();
        } catch (Exception e) {
            System.out.println("Uh oh");
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the darkMode
     */
    public static boolean isDarkMode() {
        return darkMode;
    }

    /**
     * @param _darkMode the darkMode to set
     */
    public static void setDarkMode(boolean _darkMode) {
        darkMode = _darkMode;
    }

    /**
     * @param _critFailsIgnoreMods the critFailsIgnoreMods to set
     */
    public static void setCritFailsIgnoreMods(boolean _critFailsIgnoreMods) {
        critFailsIgnoreMods = _critFailsIgnoreMods;
    }
}
