import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkAdapter;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.models.Listing;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.SubredditSort;
import net.dean.jraw.models.TimePeriod;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;
import net.dean.jraw.pagination.DefaultPaginator;
import net.dean.jraw.pagination.Paginator;

import java.util.UUID;

public class Core {
    public static void main(String[] args) {

        try {
            Credentials cred = Credentials.userlessApp("ybIMhGJzSDvEJ4ceKwkN-w", UUID.randomUUID());
            UserAgent agent = new UserAgent("Java", "JRviewer", "1.0", "dank_soil");
            NetworkAdapter net = new OkHttpNetworkAdapter(agent);
            RedditClient reddit = OAuthHelper.automatic(net, cred);
            DefaultPaginator<Submission> subredditSource = reddit.subreddit("Hentai").posts()
                    .limit(Paginator.RECOMMENDED_MAX_LIMIT)
                    .timePeriod(TimePeriod.MONTH)
                    .build();
            Listing<Submission> posts = subredditSource.next();
            Display d =new Display(posts);
            d.window.addKeyListener(new AdvListener(d));
            d.advance();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
