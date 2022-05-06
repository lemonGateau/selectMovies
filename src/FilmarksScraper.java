import java.io.IOException;
import java.util.Map;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class FilmarksScraper {
    public static List<Video> fetchContentsInfo(String url) {
        try {
            Document doc = Jsoup.connect(url).get();

            Elements contents = doc.getElementsByClass("p-content-cassette__info");
            Elements titles   = contents.select(".p-content-cassette__title");
            Elements rates    = contents.select(".c-rating__score");

            return elementsListToVideo(titles, rates);
            }
        catch (IOException e) {
            e.printStackTrace();
            }
        }

    private List<Video> elementsListToVideo(Object titles, Object rates) {
    	 var t_it = titles.iterator();
        var r_it = rates.iterator();
        HashList<Video> videos = new HashList<Video>();

        while(t_it.hasNext() && r_it.hasNext()) {
            String title = t_it.next().text();
            String rate  = r_it.next().text();

            System.out.println(title + " " + rate);

            videos.put(new Video(title, Double.parseDouble(rate)));
            }
        return videos;
    }
}
