import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.DoubleToLongFunction;
import java.util.ResourceBundle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {
    public static void main(String[] args) {
        String endPoint = "https://filmarks.com/";
        String vod = "amazon_video";

        String url = endPoint + "list/vod/" + vod;

        var rb   = ResourceBundle.getBundle("config_keys");
        var line = new LineNotifyBot(rb.getString("LINE_ACCESS_TOKEN"));

        try {
            Document doc = Jsoup.connect(url).get();
            Elements contents = doc.getElementsByClass("p-content-cassette__info");
            Elements titles   = contents.select(".p-content-cassette__title");
            Elements rates    = contents.select(".c-rating__score");

            var it_t = titles.iterator();
            var it_r = rates.iterator();
            var videos = new HashMap<String, Double>();

            while(it_t.hasNext() && it_r.hasNext()) {
                String title = it_t.next().text();
                String rate  = it_r.next().text();

                line.notify("\n" + title + " " + rate);
                System.out.println(title + " " + rate);

                videos.put(title, Double.parseDouble(rate));
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
