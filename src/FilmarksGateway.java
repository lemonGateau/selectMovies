import java.util.List;
import java.util.ArrayList;


public class FilmarksGateway {
    private String endPoint = "https://filmarks.com/";

    public ArrayList<Video> fetchFilmsByVod(String vod) {
        String url = this.endPoint + "list/vod/" + vod;

        return FilmarksScraper.fetchContentsInfo(url);
    }

    public ArrayList<Video> fetchDramasByVod(String vod) {
        String url = this.endPoint + "list-drama/vod/" + vod;

        return FilmarksScraper.fetchContentsInfo(url);
    }

    public ArrayList<Video> fetchAnimesByVod(String vod) {
        String url = this.endPoint + "list-anime/vod/" + vod;

        return FilmarksScraper.fetchContentsInfo(url);
    }
}