import javax.swing.JFrame;

public class MainFrame extends JFrame {

    /**
     * La hauteur et la largeur des boutons
     */
    private static final int BUTTON_WIDTH  = 50;
    private static final int BUTTON_HEIGHT = 50;

    /**
     * La hauteur et la largeur de la zone d'affichage
     */
    private static final int SCREEN_WIDTH  = 380;
    private static final int SCREEN_HEIGHT = 40;

    /**
     * Les marges hautes et gauche (on part du principe que les marges droites et basses sont les memes)
     */
    private static final int MARGIN_LEFT = 50;
    private static final int MARGIN_TOP = 10;

    /**
     * Calcul de la taille de la fenetre
     */
    private static final int WINDOW_WIDTH  = MARGIN_LEFT + SCREEN_WIDTH + MARGIN_LEFT;
    private static final int WINDOW_HEIGHT = MARGIN_TOP + SCREEN_HEIGHT + 2*MARGIN_TOP + 5*BUTTON_HEIGHT + MARGIN_TOP;

    /**
     * Constructeur
     */
    MainFrame() {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLayout(null);
        this.setVisible(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
