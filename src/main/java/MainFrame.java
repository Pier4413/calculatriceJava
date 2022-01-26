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

        // Bouton 2
        buttons.add(new Button(center, topRow, BUTTON_WIDTH, BUTTON_HEIGHT, "2", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number1.addToEnd(2);
                screen.setText(number1.toString());
            }
        }));

        // Bouton 3
        buttons.add(new Button(right, topRow, BUTTON_WIDTH, BUTTON_HEIGHT, "3", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                number1.addToEnd(3);
                screen.setText(number1.toString());

            }
        }));

        // Bouton 4
        buttons.add(new Button(left, secondRow, BUTTON_WIDTH, BUTTON_HEIGHT, "4", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                number1.addToEnd(4);
                screen.setText(number1.toString());

            }
        }));

        // Bouton CE
        buttons.add(new Button(left, fourthRow, BUTTON_WIDTH, BUTTON_HEIGHT, "CE", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                number1.setValue(0);
                number2.setValue(0);
                screen.setText(number1.toString());

            }
        }));

        // Bouton 0
        buttons.add(new Button(center, fourthRow, BUTTON_WIDTH, BUTTON_HEIGHT, "0", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                number1.addToEnd(0);
                screen.setText(number1.toString());

            }
        }));

        // Bouton =
        buttons.add(new Button(right, fourthRow, BUTTON_WIDTH, BUTTON_HEIGHT, "=", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                System.out .println("Boo2");

            }
        }));

        // Bouton +
        buttons.add(new Button(rightConsole, topRow, BUTTON_WIDTH, BUTTON_HEIGHT, "+", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                number2 = number1.addition(number2);
                number1.setValue(0);
                screen.setText(number2.toString());

            }
        }));

        // Bouton -
        buttons.add(new Button(rightConsole, secondRow, BUTTON_WIDTH, BUTTON_HEIGHT, "-", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                number2 = number1.soustraction(number2);
                number1.setValue(0);
                screen.setText(number2.toString());

            }
        }));

        // Bouton /
        buttons.add(new Button(rightConsole, thirdRow, BUTTON_WIDTH, BUTTON_HEIGHT, "/", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                number2 = number1.division(number2);
                if(number2.getValue() == 0)
                {
                    screen.setText("ERR");
                    number1.setValue(0);
                    number2.setValue(0);


                } 
                number1.setValue(0);
                screen.setText(number2.toString());

            }
        }));

        // Bouton *
        buttons.add(new Button(rightConsole, fourthRow, BUTTON_WIDTH, BUTTON_HEIGHT, "*", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                System.out .println("Pour tester4");

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
