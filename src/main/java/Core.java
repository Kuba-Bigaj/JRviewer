import net.dean.jraw.RedditClient;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
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
            RedditClient reddit = OAuthHelper.automatic(new OkHttpNetworkAdapter(new UserAgent("Java", "JRviewer", "1.0", "dank_soil")), Credentials.userlessApp("ybIMhGJzSDvEJ4ceKwkN-w", UUID.randomUUID()));
            DefaultPaginator<Submission> subredditSource = reddit.subreddit("pics").posts().limit(Paginator.RECOMMENDED_MAX_LIMIT).sorting(SubredditSort.TOP).timePeriod(TimePeriod.DAY).build();

            Display d = new Display(subredditSource);
            d.advance();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
