import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        var filmarks = new FilmarksGateway();
        String[] vods = {"amazon_video", "unext", "abema", "disneyplus", "hulu", "netflix"};

        for (String vod : vods) {
            // List<Video> videos = filmarks.fetchFilmsByVod(vod);
            // List<Video> videos = filmarks.fetchDramasByVod(vod);
            List<Video> videos = filmarks.fetchAnimesByVod(vod);

            System.out.println("\n" + vod + "\n");

            for (Video video : videos) {
                System.out.println(video.getTitle() + " " + video.getRate());
            }
        }
    }
}
