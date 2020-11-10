package com.rhodso.app;

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
