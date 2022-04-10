

public class Video {
    private String name;
    private double evaluation;

    public Video(String name, double evaluation) {
        this.name = name;
        this.evaluation = evaluation;
    }

    public Video(String name) {
        this(name, 3.0);
    }

    public String getName() {
        return this.name;
    }

    public double getEvaluation() {
        return this.evaluation;
    }
}
