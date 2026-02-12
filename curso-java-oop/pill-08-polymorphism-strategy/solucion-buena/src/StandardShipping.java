public class StandardShipping implements CostStrategy {
    private final double base;

    public StandardShipping(double base) {
        this.base = base;
    }

    @Override
    public double apply(double baseAmount) {
        return baseAmount + base;
    }
}
