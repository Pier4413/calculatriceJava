import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    /**
     * Liste des boutons disponibles
     */
    private ArrayList<Button> buttons = new ArrayList<Button>();
    
    /**
     * La zone d'affichage
     */
    private Screen screen;

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
     * Les nombres
     */
    private Nombre number1 = new Nombre(0);
    private Nombre number2 = new Nombre(0);

    /**
     * Un enum pour gerer la derniere action fournie
     */
    enum LastAction {
        ADD,
        SUB,
        MUL,
        DIV,
        NONE
    };

    /**
     * La derniere action fournie
     */
    LastAction lastAction;

    /**
     * Constructeur
     */
    MainFrame() {
        this.addAllButtons();
        this.addScreen();

        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLayout(null);
        this.setVisible(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Méthode qui ajoute la partie qui gère l'affichage
     */
    private void addScreen() {
        this.screen = new Screen(MARGIN_LEFT, MARGIN_TOP, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.add(this.screen);
    }

    /**
     * Méthode qui ajoute les boutons
     */
    private void addAllButtons() {

        // Positionnement gauche-droite
        int left = MARGIN_LEFT;
        int center = left + BUTTON_WIDTH;
        int right = center + BUTTON_WIDTH;
        int rightConsole = right + BUTTON_WIDTH + 2*MARGIN_LEFT;
        
        // Positionnement haut-bas
        int top = MARGIN_TOP;
        int topRow = top + SCREEN_HEIGHT + 2*MARGIN_TOP;
        int secondRow = topRow + BUTTON_HEIGHT;
        int thirdRow = secondRow + BUTTON_HEIGHT;
        int fourthRow = thirdRow + BUTTON_HEIGHT;

        // Bouton 1
        buttons.add(new Button(left, topRow, BUTTON_WIDTH, BUTTON_HEIGHT, "1", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number1.addToEnd(1);
                screen.setText(number1.toString());
            }
        }));

        for(int i =0;i<buttons.size();i++) {
            this.add(buttons.get(i));
        }
    }

    /**
     * Renvoi les boutons
     * @return La liste des boutons
     */
    public ArrayList<Button> getButtons() {
        return this.buttons;
    }

    /**
     * Renvoi un bouton
     * @param index : L'index du bouton
     * @return Le bouton
     */
    public Button getOneButton(int index) {
        return this.buttons.get(index);
    }
}
