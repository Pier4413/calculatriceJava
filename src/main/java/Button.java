import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Button extends JButton {
    
    Button(int x, int y, int width, int height, String symbol, ActionListener action) {
        this.setBounds(x, y, width, height);
        this.setText(symbol);

        if(action != null) {
            this.addActionListener(action);
        }
    }
}
