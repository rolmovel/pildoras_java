public class NoTaxStrategy implements CostStrategy {
    @Override
    public double apply(double baseAmount) {
        return baseAmount;
    }
}
