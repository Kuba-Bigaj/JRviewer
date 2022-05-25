import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AdvListener implements KeyListener {
    Display d;
    public AdvListener(Display d){
        this.d=d;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            System.out.println("Space!");
            d.advance();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}