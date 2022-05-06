// ジャンルなども追加予定

public class Video {
    private String title;
    private Double rate;

    public Video(String title, Double rate) {
        this.title = title;
        this.rate = rate;
    }

    public Video(String title) {
        this(title, 3.0);
    }

    public String getTitle() {
        return this.title;
    }

    public double getRate() {
        return this.rate;
    }
}
