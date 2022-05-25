import javax.swing.*;
import java.net.URL;

public class Display {
    JFrame window;
    JLabel image;

    public Display(String title) {
        window = new JFrame(title);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        image = new JLabel();
        window.add(image);
    }

    public void show(String url) {
        try {
            image.setIcon(new ImageIcon(new URL(url)));
            window.pack();
            window.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
