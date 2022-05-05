import java.io.IOException;
import java.util.Map;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class FilmarksScraper {
    private String endPoint = "https://filmarks.com/";

    public Map fetch_vod_films(String vod) {
        String url = this.endPoint + "list/vod/" + vod;
    }

    private List<Elements> fetch_contents_info(String url) {
        try {
            Document doc = Jsoup.connect(url).get();

            Elements contents = doc.getElementsByClass("p-content-cassette__info");
            Elements titles   = contents.select(".p-content-cassette__title");
            Elements rates    = contents.select(".c-rating__score");

            return Map.of(titles, rates)
        }
        catch(IOException e) {
            e.printStackTrace();
            return
        }
    }
}
