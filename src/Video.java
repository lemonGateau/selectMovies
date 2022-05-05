// ubuntu 2022-05-05

public class Video {
    private String name;
    private double rate;

    public Video(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public Video(String name) {
        this(name, 3.0);
    }

    public String getName() {
        return this.name;
    }

    public double getRate() {
        return this.rate;
    }
}
