

public class FilmarksGateway {
    private String endPoint = "https://filmarks.com/";

    public List<Video> fetch_films_by_vod(String vod) {
        String url = this.endPoint + "list/vod/" + vod;
        return FilmarksScraper.fetchContentsInfo(url);
    }
}