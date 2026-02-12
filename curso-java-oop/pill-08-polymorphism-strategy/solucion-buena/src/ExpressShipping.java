public class ExpressShipping implements CostStrategy {
    private final double surcharge;

    public ExpressShipping(double surcharge) {
        this.surcharge = surcharge;
    }

    @Override
    public double apply(double baseAmount) {
        return baseAmount + surcharge;
    }
}
