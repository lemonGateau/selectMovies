import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;


public class LineNotifyBot {
    private String token;

    public LineNotifyBot(String token) {
        this.token = token;
    }

    public void notify(String message) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL("https://notify-api.line.me/api/notify");

            conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.addRequestProperty("Authorization", "Bearer " + token);

            try (OutputStream os = conn.getOutputStream();
            PrintWriter writer = new PrintWriter(os)) {

                writer.append("message=").append(URLEncoder.encode(message, "UTF-8")).flush();

                try (InputStream is = conn.getInputStream();
                BufferedReader r = new BufferedReader(new InputStreamReader(is))) {
                    String res = r.lines().collect(Collectors.joining());

                    if (!res.contains("\"message\":\"ok\"")) {
                        System.out.println(res);
                        System.out.println("not");
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
