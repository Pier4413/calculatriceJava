import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Button extends JButton {
    
    /**
     * Constructeur
     * @param x : La position en x du coin en haut à gauche
     * @param y : La position en y du coin en haut à gauche
     * @param width : La hauteur
     * @param height : La largeur
     * @param symbol : Le symbole à afficher
     * @param action : L'action à effectuer au clic
     */
    Button(int x, int y, int width, int height, String symbol, ActionListener action) {
        this.setBounds(x, y, width, height);
        this.setText(symbol);

        if(action != null) {
            this.addActionListener(action);
        }
    }
}
