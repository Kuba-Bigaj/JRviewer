import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.pagination.DefaultPaginator;
import javax.swing.*;
import java.net.URL;

public class Display {
    JFrame window;
    JLabel image;
    int index = 0;
    DefaultPaginator<Submission> subredditSource;
    Listing<Submission> posts;

    public Display(DefaultPaginator<Submission> subredditSource) {
        window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        image = new JLabel();
        window.add(new JScrollPane(image));
        this.subredditSource = subredditSource;
        this.posts = subredditSource.next();
        window.addKeyListener(new AdvListener(this));
    }

    public void advance() {
        Submission post = posts.get(index);
        this.setTitle(post.getTitle());
        this.show(post.getUrl());
        index++;
        if (index >= posts.size()) {
            index = 0;
            posts = subredditSource.next();
        }
    }

    private void setTitle(String title) {
        window.setTitle(title);
    }


    private void show(String url) {
        try {
            image.setIcon(new ImageIcon(new URL(url)));
            image.repaint();
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
