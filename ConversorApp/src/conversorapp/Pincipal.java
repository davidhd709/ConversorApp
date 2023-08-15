
package conversorapp;


import javax.swing.*;

/**
 *
 * @author henry
 */
public class Pincipal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Conversor app = new Conversor();
            app.setVisible(true);
        });
    }
}