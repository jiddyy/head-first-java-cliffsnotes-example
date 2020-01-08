package app;

public class TestOPS {
    public static void main(String[] args) {
        TestOPS ops = new TestOPS();
        ops.addObpAndSlugging(.392f, .825f);
    }

    void addObpAndSlugging(Float obp, Float SluggingPct) {
        Float OBPS = obp + SluggingPct;
        System.out.printf("Your on base plus slugging is " + OBPS);
    }
}