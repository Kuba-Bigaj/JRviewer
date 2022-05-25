import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;

import javax.swing.*;
import java.net.URL;

public class Display {
    JFrame window;
    JLabel image;
    int index=0;
    Listing<Submission> posts;

    public Display(Listing<Submission> posts) {
        window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        image = new JLabel();
        window.add(image);

        this.posts=posts;
    }

    public void advance(){
        this.setTitle(posts.get(index).getTitle());
        this.show(posts.get(index).getUrl());
        index++;
    }

    public void setTitle(String title){
        window.setTitle(title);
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
