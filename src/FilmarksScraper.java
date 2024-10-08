import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class FilmarksScraper {
    public static ArrayList<Video> fetchContentsInfo(String url) {
        try {
            Document doc = Jsoup.connect(url).get();

            Elements contents = doc.getElementsByClass("p-content-cassette__info");
            Elements titles   = contents.select(".p-content-cassette__title");
            Elements rates    = contents.select(".c-rating__score");

            return elementsListToVideos(titles, rates);
            }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static ArrayList<Video> elementsListToVideos(Elements titles, Elements rates) {
    	var t_it = titles.iterator();
        var r_it = rates.iterator();
        ArrayList<Video> videos = new ArrayList<>();

        while(t_it.hasNext() && r_it.hasNext()) {
            String title = t_it.next().text();
            String rate  = r_it.next().text();

            if (rate.equals("-")) {
                rate = "3.0";
            }

            videos.add(new Video(title, Double.parseDouble(rate)));
            }

        return videos;
    }
}
