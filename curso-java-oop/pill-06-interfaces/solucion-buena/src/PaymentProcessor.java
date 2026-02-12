public class PaymentProcessor {
    public void process(double amount, PaymentMethod method) {
        method.pay(amount);
    }
}
