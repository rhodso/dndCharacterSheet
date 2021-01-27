package com.rhodso.app;

public class App {
    public static void main(String[] args) {

        // Launch app
        try {

            // Set look and feel
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            // Catch erros and log them
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // Create instance of main menu
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainMenu m = new MainMenu();
                m.setVisible(true);
            }
        });
    }
}
