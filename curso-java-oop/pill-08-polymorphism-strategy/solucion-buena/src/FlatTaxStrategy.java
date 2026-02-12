public class FlatTaxStrategy implements CostStrategy {
    private final double percentage;

    public FlatTaxStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double apply(double baseAmount) {
        return baseAmount + (baseAmount * percentage);
    }
}
