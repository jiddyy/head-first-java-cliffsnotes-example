package app;

public class TestOPS {
    public static void main(String[] args) {
        TestOPS ops = new TestOPS();
        ops.addObpAndSlugging(.392f, .825f);
    }

    // Adds a baseball players on base percentage and slugging percentage together
    // to get OPS
    void addObpAndSlugging(Float obp, Float SluggingPct) {
        Float OBPS = obp + SluggingPct;
        System.out.printf("Your on base plus slugging is " + OBPS);
    }
}