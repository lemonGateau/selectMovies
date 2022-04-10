/*
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class FilmarksScraper {
    private String endPoint = "https://filmarks.com/";

    public Map fetch_vod_films(String vod) {
        String url = this.endPoint + "vod/" + vod;
        Document doc = Jsoup.connect(url).get();
        Elements titles = doc.getElementsByClass("p-content-cassette__info");

        for(Element title : titles) {
            System.out.println(title);
        }
    }

    public Map fetch_vod_films() {
        return fetch_vod_films("amaon_video");
    }

}
*/