import java.util.ArrayList;
import java.util.List;

public class CheckoutCalculator {
    private final List<CostStrategy> strategies = new ArrayList<>();

    public void addStrategy(CostStrategy strategy) {
        strategies.add(strategy);
    }

    public double calculate(double baseAmount) {
        double amount = baseAmount;
        for (CostStrategy strategy : strategies) {
            amount = strategy.apply(amount);
        }
        return amount;
    }
}
