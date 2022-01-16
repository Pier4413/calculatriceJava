import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private ArrayList<Button> buttons = new ArrayList<Button>();
    private Screen screen;

    private static final int BUTTON_WIDTH  = 50;
    private static final int BUTTON_HEIGHT = 50;

    private static final int SCREEN_WIDTH  = 380;
    private static final int SCREEN_HEIGHT = 40;

    private static final int MARGIN_LEFT = 50;
    private static final int MARGIN_TOP = 10;

    private static final int WINDOW_WIDTH  = MARGIN_LEFT + SCREEN_WIDTH + MARGIN_LEFT;
    private static final int WINDOW_HEIGHT = MARGIN_TOP + SCREEN_HEIGHT + 2*MARGIN_TOP + 5*BUTTON_HEIGHT + MARGIN_TOP;

    private Nombre number1 = new Nombre(0);
    private Nombre number2 = new Nombre(0);

    enum LastAction {
        ADD,
        SUB,
        MUL,
        DIV,
        NONE
    };

    LastAction lastAction;

    MainFrame() {
        this.addAllButtons();
        this.addScreen();

        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLayout(null);
        this.setVisible(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void addScreen() {
        this.screen = new Screen(MARGIN_LEFT, MARGIN_TOP, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.screen.setBackground(Color.CYAN);
        this.add(this.screen);
    }

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

        // 1
        buttons.add(new Button(left, topRow, BUTTON_WIDTH, BUTTON_HEIGHT, "1", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number1.addToEnd(1);
                screen.setText(number1.toString());
            }
        }));

        // 2
        buttons.add(new Button(center, topRow, BUTTON_WIDTH, BUTTON_HEIGHT, "2", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number1.addToEnd(2);
                screen.setText(number1.toString());
            }
        }));

        // 3
        buttons.add(new Button(right, topRow, BUTTON_WIDTH, BUTTON_HEIGHT, "3", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number1.addToEnd(3);
                screen.setText(number1.toString());
            }
        }));

        // 4
        buttons.add(new Button(left, secondRow, BUTTON_WIDTH, BUTTON_HEIGHT, "4", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number1.addToEnd(4);
                screen.setText(number1.toString());
            }
        }));

        // 5
        buttons.add(new Button(center, secondRow, BUTTON_WIDTH, BUTTON_HEIGHT, "5", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number1.addToEnd(5);
                screen.setText(number1.toString());
            }
        }));

        // 6
        buttons.add(new Button(right, secondRow, BUTTON_WIDTH, BUTTON_HEIGHT, "6", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number1.addToEnd(6);
                screen.setText(number1.toString());
            }
        }));

        // 7
        buttons.add(new Button(left, thirdRow, BUTTON_WIDTH, BUTTON_HEIGHT, "7", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number1.addToEnd(7);
                screen.setText(number1.toString());
            }
        }));

        // 8
        buttons.add(new Button(center,thirdRow, BUTTON_WIDTH, BUTTON_HEIGHT, "8", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number1.addToEnd(8);
                screen.setText(number1.toString());
            }
        }));

        // 9
        buttons.add(new Button(right,thirdRow, BUTTON_WIDTH, BUTTON_HEIGHT, "9", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number1.addToEnd(9);
                screen.setText(number1.toString());
            }
        }));

        // .
        buttons.add(new Button(left,fourthRow, BUTTON_WIDTH, BUTTON_HEIGHT, "CE", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number2.setValue(0);
                number1.setValue(0);
                screen.setText(number1.toString());
            }
        }));

        // 0
        buttons.add(new Button(center, fourthRow, BUTTON_WIDTH, BUTTON_HEIGHT, "0", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                number1.addToEnd(9);
                screen.setText(number1.toString());
            }
        }));

        // +
        buttons.add(new Button(rightConsole, topRow, BUTTON_WIDTH, BUTTON_HEIGHT, "+", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                lastAction = LastAction.ADD;
                number2 = number2.addition(number1);
                number1.setValue(0);
                screen.setText(number2.toString());
            }
        }));

        // -
        buttons.add(new Button(rightConsole, secondRow, BUTTON_WIDTH, BUTTON_HEIGHT, "-", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                lastAction = LastAction.SUB;
                number2 = number2.soustraction(number1);
                number1.setValue(0);
                screen.setText(number2.toString());
            }
        }));

        // *
        buttons.add(new Button(rightConsole, thirdRow, BUTTON_WIDTH, BUTTON_HEIGHT, "*", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                lastAction = LastAction.MUL;
                number2 = number2.multiplication(number1);
                number1.setValue(0);
                screen.setText(number2.toString());
            }
        }));

        // /
        buttons.add(new Button(rightConsole, fourthRow, BUTTON_WIDTH, BUTTON_HEIGHT, "/", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                lastAction = LastAction.DIV;
                number2 = number2.division(number1);
                number1.setValue(0);
                screen.setText(number2.toString());
            }
        }));

        // =
        buttons.add(new Button(right,fourthRow, BUTTON_WIDTH, BUTTON_HEIGHT, "=", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(lastAction == LastAction.ADD) {
                    number2 = number2.addition(number1);
                } else if(lastAction == LastAction.SUB) {
                    number2 = number2.soustraction(number1);
                } else if(lastAction == LastAction.MUL) {
                    number2 = number2.multiplication(number1);
                } else if(lastAction == LastAction.DIV) {
                    number2 = number2.division(number1);
                }
                number1.setValue(0);
                screen.setText(number2.toString());
            }
        }));

        for(int i =0;i<buttons.size();i++) {
            this.add(buttons.get(i));
        }
    }

    public ArrayList<Button> getButtons() {
        return this.buttons;
    }

    public Button getOneButton(int index) {
        return this.buttons.get(index);
    }
}
